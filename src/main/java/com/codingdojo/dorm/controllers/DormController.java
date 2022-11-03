package com.codingdojo.dorm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.dorm.models.Course;
import com.codingdojo.dorm.models.Dorm;
import com.codingdojo.dorm.models.Student;
import com.codingdojo.dorm.services.CourseService;
import com.codingdojo.dorm.services.DormService;
import com.codingdojo.dorm.services.StudentService;

@Controller
public class DormController {

	@Autowired
	private CourseService cServ;
	@Autowired
	private DormService dServ;
	@Autowired
	private StudentService sServ;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String dormBoard(
			@ModelAttribute("dorm") Dorm dorm, Model model) {
		model.addAttribute("dorms", dServ.allDorms());
		return "dormdash.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String dormPage(
			@ModelAttribute("dorm") Dorm newDorm) {
		return "addDorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String dormCreate(
			@Valid @ModelAttribute("dorm") Dorm newDorm, BindingResult result) {
		if (result.hasErrors()) {
			return "addDorm.jsp";
		}
		dServ.addDorm(newDorm);
		return "redirect:/";
	}
	
	@GetMapping("/dorms/{id}")
	public String showDormStudents(
			@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dServ.findById(id));
		model.addAttribute("students", sServ.assignedDorm(id));
		model.addAttribute("allStudents", sServ.allStudents());
		return "showDorm.jsp";
	}
	
	@PostMapping("/dorms/{id}")
	public String addStudentToDorm(
			@PathVariable("id") Long id,
			@RequestParam(value="studentId", required=false) Long studentID) {	
		
		Student student = sServ.findStudent(studentID);
		sServ.addToDorm(student, dServ.findById(id));
		
		return "redirect:/dorms/" + id;
	}
	
	@GetMapping("/students/new")
	public String studentCreatePage(
			@ModelAttribute("student") Student newStudent, Model model) {
		List<Student> s = sServ.allStudents();
		model.addAttribute("students", s);
		model.addAttribute("dorms", dServ.allDorms());
		return "addStudent.jsp";
	}
	
	@PostMapping("/students/new")
	public String studentCreate(
			@Valid @ModelAttribute("student") Student newStudent, BindingResult result,
			@RequestParam("dorm") Long dormId, Model model) {
		if (result.hasErrors()) {
			return "addStudent.jsp";
		} 
		
		if (dormId.equals(0)) {
			model.addAttribute("error", "Please chooose any of the following, besides Choose one!");
			return "addStudent.jsp";
		}
		sServ.addStudent(newStudent);
		return "redirect:/dorms";
	}
	
	@GetMapping("/students/{id}")
	public String showStudentPage(
			@PathVariable("id") Long id, Model model){
		model.addAttribute("students", sServ.findStudent(id));
		model.addAttribute("aCourses", cServ.assignedStudent(sServ.findStudent(id)));
		model.addAttribute("uCourses", cServ.unassignedStuden(sServ.findStudent(id)));
		return "allStudents.jsp";
	}
	
	@PostMapping("/students/{id}")
	public String editStudent(
			@PathVariable("id") Long id,
			@RequestParam(value="courseId") Long courseId, Model model) {
		
		Student student = sServ.findStudent(id);
		Course course = cServ.findById(courseId);
		
		student.getCourses().add(course);
		sServ.updateStudent(student);
		model.addAttribute("aCourses", cServ.assignedStudent(sServ.findStudent(id)));
		model.addAttribute("uCourses", cServ.unassignedStuden(sServ.findStudent(id)));
		
		return "redirect:/students/" + id;
	}
	
	@GetMapping("/courses")
	public String courseIndex(
			@ModelAttribute("course") Course newCourse, Model model) {
		model.addAttribute("courses", cServ.allCourse());
		return "allCourse.jsp";
	}
	
	@GetMapping("/courses/new")
	public String coursePage(
			@ModelAttribute("course") Course newCourse, Model model) {
		List<Course> c = cServ.allCourse();
		model.addAttribute("courses", c);
		return "addCourse.jsp";
	}
	
	@PostMapping("/courses/new")
	public String courseCreate(
			@Valid @ModelAttribute("course") Course newCourse, BindingResult result) {
		if (result.hasErrors()) {
			return "addCourse.jsp";
		}
		cServ.addCourse(newCourse);
		return "redirect:/dorms";
	}
	
	
	@GetMapping("/courses/{id}")
	public String studentShowCourse(
			@PathVariable("id") Long id, Model model){
		model.addAttribute("courses", cServ.findById(id));
		model.addAttribute("aStudents", sServ.assignedClass(cServ.findById(id)));
		return "showCourse.jsp";
	}
	
	@RequestMapping("/courses/remove/{id}/{courseId}")
	public String dropCourse(
			@PathVariable("id") Long id, @PathVariable("courseId") Long courseId, Model model) {
		Student student = sServ.findStudent(id);
		student.getCourses().remove(cServ.findById(courseId));
		sServ.updateStudent(student);
		model.addAttribute("students", student);
		model.addAttribute("allCourses", cServ.unassignedStuden(student));
		
		return "redirect:/students/" + id;
	}
	
	@RequestMapping("/students/remove/{id}")
	public String removeStudent(
			@PathVariable("id") Long id, Model model) {
		Student student = sServ.findStudent(id);
		Long dormId = student.getDorm().getId();
		sServ.removeFromDorm(student);
		return "redirect:/dorms/" + dormId;
	}
	
}

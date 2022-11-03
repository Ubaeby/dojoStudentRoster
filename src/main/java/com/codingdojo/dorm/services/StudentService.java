package com.codingdojo.dorm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dorm.models.Course;
import com.codingdojo.dorm.models.Dorm;
import com.codingdojo.dorm.models.Student;
import com.codingdojo.dorm.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired 
	private StudentRepository studentRep;
	
	public List<Student> allStudents() {
		return studentRep.findAll();
	}
	
	public Student addStudent(Student s) {
		return studentRep.save(s);
	}
	
	public Student updateStudent(Student s) {
		return studentRep.save(s);
	}
	
	public Student findStudent(Long id) {
		Optional<Student> option = studentRep.findById(id);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	} 
	
	public List<Student> assignedDorm(Long  id) {
		return studentRep.findAllByDormIdIs(id);
	}
	
	
	public List<Student> assignedClass(Course c) {
		return studentRep.findAllByCourses(c);
	}
	
	public List<Student> unassignedClass(Course c) {
		return studentRep.findByCoursesNotContains(c);
	}
	
	public void addToDorm(Student s, Dorm d) {
		s.setDorm(d);
		studentRep.save(s);
	}
	
	public void removeFromDorm(Student s) {
		studentRep.delete(s);
	}
	
}

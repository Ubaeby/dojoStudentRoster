package com.codingdojo.dorm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dorm.models.Course;
import com.codingdojo.dorm.models.Student;
import com.codingdojo.dorm.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository cRep;
	
	public List<Course> allCourse() {
		return cRep.findAll();
	}
	
	public List<Course> assignedStudent(Student s) {
		return cRep.findAllByStudents(s);
	}
	
	public List<Course> unassignedStuden(Student s) {
		return cRep.findByStudentsNotContains(s);
	}
	
	public Course findById(Long id) {
		Optional<Course> option = cRep.findById(id);
		if (option.isPresent()) {
			return option.get();
		}
		return null;
	}
	
	public Course findByCourseName(String c) {
		return cRep.findByCourseName(c);
	}
	
	public Course addCourse(Course c) {
		return cRep.save(c);
	}
}

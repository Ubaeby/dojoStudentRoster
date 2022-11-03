package com.codingdojo.dorm.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dorm.models.Course;
import com.codingdojo.dorm.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();
	List<Student> findAllByCourses(Course course);
	List<Student> findByCoursesNotContains(Course course);
	List<Student> findAllByDormIdIs(Long dormId);
}

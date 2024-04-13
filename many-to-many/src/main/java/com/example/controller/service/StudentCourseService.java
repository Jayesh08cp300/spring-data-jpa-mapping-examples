package com.example.controller.service;

import com.example.entity.Course;
import com.example.entity.Student;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCourseService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	public Student saveStudentWithCourse(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> findALlStudents() {
		return studentRepository.findAll();
	}

	public Student findStudent(Long studentId) {
		return studentRepository.findById(studentId)
				.orElse(null);
	}

	public List<Student> findStudentsContainingByName(String name) {
		return studentRepository.findByNameContaining(name);
	}

	public List<Course> findCourseLessThanPrice(double price) {
		return courseRepository.findByFeeLessThan(price);
	}
}

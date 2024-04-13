package com.example.controller;

import com.example.controller.service.StudentCourseService;
import com.example.entity.Course;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentCourseController {

	@Autowired
	private StudentCourseService studentCourseService;

	@PostMapping("/")
	public Student saveStudentWithCourse(@RequestBody Student student) {
		return studentCourseService.saveStudentWithCourse(student);
	}

	@GetMapping("/")
	public List<Student> findALlStudents() {
		return studentCourseService.findALlStudents();
	}

	@GetMapping("/{studentId}")
	public Student findStudent(@PathVariable Long studentId) {
		return studentCourseService.findStudent(studentId);
	}

	@GetMapping("/find/{name}")
	public List<Student> findStudentsContainingByName(@PathVariable String name) {
		return studentCourseService.findStudentsContainingByName(name);
	}

	@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price) {
		return studentCourseService.findCourseLessThanPrice(price);
	}
}

package com.example.repository;

import com.example.entity.Course;
import com.example.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ManyToManyMappingTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void testSaveStudentWithCourses() {
		// Create courses
		Course course1 = new Course();
		course1.setName("Math");
		Course course2 = new Course();
		course2.setName("Science");

		courseRepository.save(course1);
		courseRepository.save(course2);

		// Create students
		Student student1 = new Student();
		student1.setName("John Doe");
		Student student2 = new Student();
		student2.setName("Jane Smith");

		student1.setCourses(new ArrayList<>());
		student2.setCourses(new ArrayList<>());

		student1.getCourses()
				.add(course1);
		student1.getCourses()
				.add(course2);

		student2.getCourses()
				.add(course2);

		studentRepository.save(student1);
		studentRepository.save(student2);

		//studentRepository.flush();
		//courseRepository.flush();

		// Retrieve students and verify courses
		Student retrievedStudent1 = studentRepository.findById(student1.getId())
				.orElse(null);
		Assertions.assertNotNull(retrievedStudent1);
		Assertions.assertEquals(2, retrievedStudent1.getCourses()
				.size());

		Student retrievedStudent2 = studentRepository.findById(student2.getId())
				.orElse(null);
		Assertions.assertNotNull(retrievedStudent2);
		Assertions.assertEquals(1, retrievedStudent2.getCourses()
				.size());
	}
}
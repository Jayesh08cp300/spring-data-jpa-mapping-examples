package com.example.repository;

import com.example.entity.Department;
import com.example.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTest {
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void testEmployeeDepartmentMapping() {
		// Create a department
		Department department = new Department();
		department.setName("IT");
		departmentRepository.save(department);

		// Create employees
		Employee employee1 = new Employee();
		employee1.setName("John");
		employee1.setDepartment(department);

		Employee employee2 = new Employee();
		employee2.setName("Jane");
		employee2.setDepartment(department);

		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);

		department.setEmployees(employees);

		// Persist the employees
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);

		// Retrieve the department from the database
		Department persistedDepartment = departmentRepository.findById(department.getId());

		Assertions.assertNotNull(persistedDepartment);

		Assertions.assertEquals(2, persistedDepartment.getEmployees()
				.size());
		Assertions.assertEquals("IT", persistedDepartment.getName());
		Assertions.assertEquals("John", persistedDepartment.getEmployees()
				.get(0)
				.getName());
		Assertions.assertEquals("Jane", persistedDepartment.getEmployees()
				.get(1)
				.getName());
	}


	@Test
	public void testEmployeeDepartmentMappingAgain() {
		// Create a department
		Department department = new Department();
		department.setName("HR");


		// Create employees
		Employee employee1 = new Employee();
		employee1.setName("Johny");
		employee1.setDepartment(department);

		Employee employee2 = new Employee();
		employee2.setName("Janey");
		employee2.setDepartment(department);

		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);

		department.setEmployees(employees);

		//save
		departmentRepository.save(department);

		// Retrieve the department from the database
		Department persistedDepartment = departmentRepository.findById(department.getId());

		Assertions.assertNotNull(persistedDepartment);

		Assertions.assertEquals(2, persistedDepartment.getEmployees()
				.size());
		Assertions.assertEquals("HR", persistedDepartment.getName());
		Assertions.assertEquals("Johny", persistedDepartment.getEmployees()
				.get(0)
				.getName());
		Assertions.assertEquals("Janey", persistedDepartment.getEmployees()
				.get(1)
				.getName());
	}
}

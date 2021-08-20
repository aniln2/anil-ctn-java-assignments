package com.springbootpractice.examples.employeemanagement.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springbootpractice.examples.employeemanagement.dao.EmployeeRepository;
import com.springbootpractice.examples.employeemanagement.data.Employee;
import com.springbootpractice.examples.employeemanagement.service.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeServiceImpl.class)
public class EmployeeServiceImplTest {
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	@MockBean
	private EmployeeRepository employeeRepository;
	private Employee employee;
	private String id;
	private Employee employee1;

	@BeforeEach
	private void init() throws JsonMappingException, JsonProcessingException {
		employee = Employee.builder().id("101").name("Daniel").dept("IT").build();
		id = "101";
		when(employeeRepository.findById(id))
				.thenReturn(Optional.of(Employee.builder().id("101").name("Daniel").dept("IT").build()));
		employeeService.setEmployeeRepository(employeeRepository);
	}

	@Test
	public void testAddEmployees() throws Exception {
		assertEquals(201, employeeService.saveEmployees(employee).getStatusCodeValue());
	}

	@Test
	public void testGetEmployees() throws Exception {
		employeeService.getAllEmployees();
		// assertEquals(empList, employeeService.getAllEmployees());
	}

	@Test
	public void testGetEMployeeById() throws Exception {
		assertEquals("Daniel", employeeService.getEmployeeById(id).getBody().getName());
	}

	@Test
	public void testGetEMployeeByIdNotPresent() throws Exception {
		assertNull(employeeService.getEmployeeById("2525").getBody());
	}

	@Test
	public void testUpdateEMployeeById() throws Exception {
		ResponseEntity<Employee> empResponseEntity = employeeService.updateEmployees(id, employee1);
		assertEquals(200, empResponseEntity.getStatusCodeValue());
	}

	@Test
	public void testDeleteEMployeeById() throws Exception {
		assertEquals(204, employeeService.deleteEmployeeById(id).getStatusCode().value());
	}

	@Test
	public void testDeleteEMployeeByIdNotPresent() throws Exception {
		// when(employeeRepository.deleteById(id);
		/*
		 * doThrow(Exception.class) .when(employeeRepository) .add(anyString());
		 */
		// doThrow().when(employeeRepository).deleteById(ArgumentMatchers.isNull());
		// EmployeeRepository employeeRepository= mock(EmployeeRepository.class);
		// doThrow(Exception.class) .when(employeeRepository)
		// .deleteById(ArgumentMatchers.anyString());
		// Mockito.when(employeeRepository.deleteById(id)).thenThrow(new
		// RuntimeException("exception thrown"));
		// employeeRepository.deleteById("111");
		// Mockito.mock(null)
		employeeService.deleteEmployeeById(null);
		// when(employeeService.deleteEmployeeById(null)).thenThrow(Exception.class);
		// assertEquals(204,
		// employeeService.deleteEmployeeById("100").getStatusCode().value());
	}

	@Test
	public void testGetEmployeeRepository() throws Exception {
		employeeService.getEmployeeRepository();
	}
}

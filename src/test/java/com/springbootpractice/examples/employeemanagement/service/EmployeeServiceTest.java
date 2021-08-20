package com.springbootpractice.examples.employeemanagement.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springbootpractice.examples.employeemanagement.dao.EmployeeRepository;
import com.springbootpractice.examples.employeemanagement.data.Employee;
import com.springbootpractice.examples.employeemanagement.service.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeServiceImpl.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	@MockBean
	private EmployeeRepository employeeRepository;
	private Employee employee;

	@Test
	@Ignore
	private void getEmployeeByIdTest() {
		employee = Employee.builder().id("101").name("Daniel").dept("IT").build();
		when(employeeRepository.findById("101")).thenReturn(Optional.of(employee));
		assertEquals(employeeServiceImpl.getEmployeeById("101").getBody().getName(), "Daniel");
	}
}

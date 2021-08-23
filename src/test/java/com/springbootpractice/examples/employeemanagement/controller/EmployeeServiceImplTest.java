package com.springbootpractice.examples.employeemanagement.controller;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.springbootpractice.examples.employeemanagement.dao.EmployeeRepository;
import com.springbootpractice.examples.employeemanagement.data.Employee;
import com.springbootpractice.examples.employeemanagement.service.EmployeeService;
import com.springbootpractice.examples.employeemanagement.service.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeService.class)
@Ignore
public class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	@MockBean
	private EmployeeRepository employeeRepository;
	private Employee employee;

	@BeforeEach
	public void init() throws JsonMappingException, JsonProcessingException {
		employee = Employee.builder().id("101").name("Daniel").dept("IT").build();
	}

	@Test
	public void getEmployeeByIdTest() {
		employee = Employee.builder().id("101").name("Daniel").dept("IT").build();
		when(employeeRepository.findById("101")).thenReturn(Optional.of(employee));
	}
}

package com.springbootpractice.examples.employeemanagement.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootpractice.examples.employeemanagement.dao.EmployeeRepository;
import com.springbootpractice.examples.employeemanagement.data.Employee;
import com.springbootpractice.examples.employeemanagement.service.EmployeeService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	private static final String GET = "get";
	private static final String POST = "post";
	private static final String PUT = "put";
	private static final String DELETE = "delete";
	@Autowired
	private MockMvc mockMvc;
	@InjectMocks
	private EmployeeController employeeController;
	@MockBean
	private EmployeeService employeeService;
	@MockBean
	private EmployeeRepository employeeRepository;
	@Autowired
	private ObjectMapper objMapper;
	private Employee employee;
	private String expected;
	private List<Employee> empList;
	private Employee expectedEmp;
	private List<Employee> expectedEmpList;
	String oneZeroOne = "/101";

	@BeforeEach
	private void init() throws JsonMappingException, JsonProcessingException {
		employee = Employee.builder().id("101").name("Daniel").dept("IT").build();
		expected = "{\"id\":\"101\",\"name\":\"Daniel\",\"dept\":\"IT\"}";
		expectedEmp = objMapper.readValue(expected, Employee.class);
		empList = new ArrayList<>();
		empList.add(employee);
		expectedEmpList = new ArrayList<>();
		expectedEmpList.add(expectedEmp);
	}

	@Test
	public void testAddEMployee() throws Exception {
		RequestBuilder requestBuilder = mockServiceURL(POST, "addemployees");
		prepareMockTestData(requestBuilder);
	}

	@Test
	public void testgetAllEmployee() throws Exception {
		RequestBuilder requestBuilder = mockServiceURL(GET, "getallemployees");
		prepareMockTestData(requestBuilder);
	}

	@Test
	public void testGetEMployeeById() throws Exception {
		RequestBuilder requestBuilder = mockServiceURL(GET, "getemployee" + oneZeroOne);
		prepareMockTestData(requestBuilder);
	}

	@Test
	public void testUpdateEMployeeById() throws Exception {
		RequestBuilder requestBuilder = mockServiceURL(PUT, "updateemployees" + oneZeroOne);
		prepareMockTestData(requestBuilder);
	}

	@Test
	public void testDeleteEMployeeById() throws Exception {
		RequestBuilder requestBuilder = mockServiceURL(DELETE, "deleteemployees" + oneZeroOne);
		prepareMockTestData(requestBuilder);
	}

	private void prepareMockTestData(RequestBuilder requestBuilder)
			throws Exception, UnsupportedEncodingException, JsonProcessingException {
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String outPutInJson = mvcResult.getRequest().getContentAsString();
		final String inputJsonString = objMapper.writeValueAsString(employee);
		Assert.assertEquals(inputJsonString, outPutInJson);
	}

	private RequestBuilder mockServiceURL(String serviceType, String serviceURL) {
		switch (serviceType) {
		case GET:
			return MockMvcRequestBuilders.get("/" + serviceURL).accept(MediaType.APPLICATION_JSON).content(expected)
					.contentType(MediaType.APPLICATION_JSON);
		case POST:
			return MockMvcRequestBuilders.post("/" + serviceURL).accept(MediaType.APPLICATION_JSON).content(expected)
					.contentType(MediaType.APPLICATION_JSON);
		case PUT:
			return MockMvcRequestBuilders.put("/" + serviceURL).accept(MediaType.APPLICATION_JSON).content(expected)
					.contentType(MediaType.APPLICATION_JSON);

		case DELETE:
			return MockMvcRequestBuilders.delete("/" + serviceURL).accept(MediaType.APPLICATION_JSON).content(expected)
					.contentType(MediaType.APPLICATION_JSON);

		default:
			throw new IllegalArgumentException("Invalid service type: " + serviceType);

		}
	}
}

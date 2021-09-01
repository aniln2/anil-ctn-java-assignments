package com.springbootpractice.examples.employeemanagement.integrationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.springbootpractice.examples.employeemanagement.data.Employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeBDD extends SpringIntegrationTest {

	private final RestTemplate restTemplate = new RestTemplate();

	private Employee employee = new Employee();

	private Employee emp;

	@Given("a valid employee object")
	public void employee_is_json_record() {
		employee.setId("1001");
		employee.setName("Robert");
		employee.setDept("IT");
	}

	@When("employee id is given as {int}")
	public void getEmployeeById(Integer id) {
		restTemplate.getForObject("http://localhost:8080/employee/"+id, Employee.class);
	}

	@Then("it should return the employee record")
	public void checkForAnEmployeeRecord() {
		assertEquals(employee.getName(), "Charlie");
	}

	@Then("it should return all the employees")
	public void getAllEmployees() {
		List<Employee> empList= (List<Employee>)restTemplate.getForObject("http://localhost:8080/allemployees", List.class);
		assertEquals(1, empList.size());
	}

	@When("employee object is matched with an existing id {int}")
	public void passing_latest_employee_with_valid_id(Integer id) {

		emp= restTemplate.postForEntity("http://localhost:8080/employee/"+id, employee, Employee.class).getBody();
		emp.setDept("Finance");
	}

	@Then("it should update with the employee with new values")
	public void it_should_update_with_latest_employee() {
		assertEquals("Finance", emp.getDept());
	}
}

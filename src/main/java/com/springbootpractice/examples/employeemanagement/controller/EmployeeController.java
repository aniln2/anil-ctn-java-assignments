package com.springbootpractice.examples.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.examples.employeemanagement.data.Employee;
import com.springbootpractice.examples.employeemanagement.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getallemployees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getemployee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping("/addemployees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployees(employee);
	}

	@PutMapping("/updateemployees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id, @RequestBody Employee emp) {
		return employeeService.updateEmployees(id, emp);
	}

	@DeleteMapping("/deleteemployees/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		return employeeService.deleteEmployeeById(id);

	}

}

package com.springbootpractice.examples.employeemanagement.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootpractice.examples.employeemanagement.data.Employee;

@Service
public interface EmployeeService {

	public ResponseEntity<Employee> getEmployeeById(String id);

	public ResponseEntity<Employee> saveEmployees(Employee employee);

	public ResponseEntity<Employee> updateEmployees(String id, Employee emp);

	List<Employee> getAllEmployees();

	public ResponseEntity<HttpStatus> deleteEmployeeById(String id);

}

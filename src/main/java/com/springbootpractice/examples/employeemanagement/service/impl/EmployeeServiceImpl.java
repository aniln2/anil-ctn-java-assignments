package com.springbootpractice.examples.employeemanagement.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootpractice.examples.employeemanagement.dao.EmployeeRepository;
import com.springbootpractice.examples.employeemanagement.data.Employee;
import com.springbootpractice.examples.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public ResponseEntity<Employee> getEmployeeById(String id) {
		Optional<Employee> employeeFromDBData = employeeRepository.findById(id);
		if (employeeFromDBData.isPresent()) {
			return new ResponseEntity<Employee>(employeeFromDBData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public ResponseEntity<Employee> saveEmployees(Employee employee) {
		return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Employee> updateEmployees(String id, Employee employee) {
		Optional<Employee> employeeFromDBData = employeeRepository.findById(id);
		if (employeeFromDBData.isPresent()) {
			return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteEmployeeById(String id) {
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

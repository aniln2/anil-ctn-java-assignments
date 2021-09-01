package com.springbootpractice.examples.employeemanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpractice.examples.employeemanagement.data.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

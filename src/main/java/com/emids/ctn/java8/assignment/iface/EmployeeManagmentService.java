package com.emids.ctn.java8.assignment.iface;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.emids.ctn.java8.assignment.data.Employee;

@Repository
public interface EmployeeManagmentService {

	List<Employee> getEmployeesWithDept(String dept);

	Double getTotalSalary();

	Employee getEmployeesByHighestSal();

	List<Employee> sortEmployeeByDeptDecreasingSal();

	Map<String, List<Employee>> getEmployeesGroupByDept();

	Map<String, Long> getTotalEmployeePerDept();

	Map<String, Double> getAvgSalaryPerDept();

	List<Employee> getFirstFiveEmployees();

	List<Employee> getEmployeesInRange();
}

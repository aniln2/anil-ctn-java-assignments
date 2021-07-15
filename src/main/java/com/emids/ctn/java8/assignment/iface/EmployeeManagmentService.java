package com.emids.ctn.java8.assignment.iface;

import java.util.List;
import java.util.Map;

import com.emids.ctn.java8.assignment.data.Employee;

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

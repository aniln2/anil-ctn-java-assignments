package com.emids.ctn.java8.assignment.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.emids.ctn.java8.assignment.data.Employee;
import com.emids.ctn.java8.assignment.iface.EmployeeManagmentService;

public class EmployeeManagmentServiceImpl implements EmployeeManagmentService {

	private static List<Employee> employeeList = null;
	static {
		employeeList = Arrays.asList(new Employee("Ross", "Geller", 60000, "IT"),
				new Employee("Chandler", "Bing", 30000, "Sales"),
				new Employee("Joey", "Tribbiani", 80000, "Enginering"),
				new Employee("Rachel", "Green", 100000, "Finance"), new Employee("Monica", "Geller", 15000, "IT"),
				new Employee("Phoeba", "Buffay", 15000, "Finance"));

	}

	@Override
	public List<Employee> getEmployeesWithDept(String dept) {
		System.out.println("Create a method with one parameter department and print the list of employees in that department ");
		return employeeList.stream().filter(emp -> emp.getDepartment().equals(dept)).collect(Collectors.toList());
	}
	
	@Override
	public Double getTotalSalary() {
		System.out.println("Create a method to print the total Salaries of all employees ");
		return employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
	}

	@Override
	public Employee getEmployeesByHighestSal() {
		System.out.println("Create a method to print the employee with the highest salary ");
		return employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
	}

	@Override
	public List<Employee> sortEmployeeByDeptDecreasingSal() {
		System.out.println("Create a method to sort and Print the List of employees by Department and then sort based on the decreasing order of their salaries  ");
		List<Employee> empListGrpByDept = employeeList.stream().sorted(Comparator.comparing(Employee::getDepartment))
				.toList();
		System.out.println("empListGrpByDept " + empListGrpByDept);
		List<Employee> empListGrpByDeptSal = employeeList.stream()
				.sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary).reversed())
				.toList();
		System.out.println("empListGrpByDeptSal "
				+ empListGrpByDeptSal.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList());
		return empListGrpByDeptSal;

	}


	@Override
	public Map<String, List<Employee>> getEmployeesGroupByDept() {
		System.out.println("Create a method to print the list of employees per department in a Map structure ");
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
	}
	
	@Override
	public Map<String, Long> getTotalEmployeePerDept() {
		System.out.println("Create a method to count total employees per department ");
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}

	@Override
	public Map<String, Double> getAvgSalaryPerDept() {
		System.out.println("Create a method to print average salaries per department ");
		return employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}

	@Override
	public List<Employee> getFirstFiveEmployees() {
		System.out.println("Create a method to print the first 5 employees of the list ");
		return employeeList.stream().limit(5).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesInRange() {
		System.out.println("Create a method to print the employees from 2nd index to 5th index  ");
		System.out.println("The complete list .."+employeeList);
		return employeeList.stream().skip(2).limit(3).collect(Collectors.toList());
	}


}

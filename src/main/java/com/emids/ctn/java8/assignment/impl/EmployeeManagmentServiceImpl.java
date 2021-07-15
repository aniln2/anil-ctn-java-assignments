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
	public Map<String, List<Employee>> getEmployeesGroupByDept() {
		System.out.println("getEmployeesGroupByDept ");
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
	}

	@Override
	public Double getTotalSalary() {
		System.out.println("getTotalSalary ");
		return employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
	}

	@Override
	public Employee getEmployeesByHighestSal() {
		System.out.println("getEmployeesByHighestSal ");
		return employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
	}

	@Override
	public List<Employee> sortEmployeeByDeptDecreasingSal() {
		System.out.println("sortEmployeeByDeptDecreasingSal ");
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
	public Map<String, Long> getTotalEmployeePerDept() {
		System.out.println("getTotalEmployeePerDept ");
		return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}

	@Override
	public Map<String, Double> getAvgSalaryPerDept() {
		System.out.println("getAvgSalaryPerDept ");
		return employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}

	@Override
	public List<Employee> getFirstFiveEmployees() {
		System.out.println("getFirstFiveEmployees ");
		return employeeList.stream().limit(3).collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesInRange() {
		System.out.println("getEmployeesInRange ");
		return employeeList.stream().filter(emp -> employeeList.indexOf(emp) >= 2 && employeeList.indexOf(emp) < 5)
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> getEmployeesWithDept(String dept) {
		System.out.println("getEmployeesWithDept ");
		return employeeList.stream().filter(emp -> emp.getDepartment().equals(dept)).collect(Collectors.toList());
	}

}

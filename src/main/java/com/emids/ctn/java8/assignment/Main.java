package com.emids.ctn.java8.assignment;

import java.util.List;
import java.util.Map;

import com.emids.ctn.java8.assignment.data.Employee;
import com.emids.ctn.java8.assignment.iface.EmployeeManagmentService;
import com.emids.ctn.java8.assignment.impl.EmployeeManagmentServiceImpl;

public class Main {

	private static EmployeeManagmentService employeeManagmentService = new EmployeeManagmentServiceImpl();

	public static void main(String[] args) {
		List<Employee> employeePerDept = employeeManagmentService.getEmployeesWithDept("IT");
		System.out.println(employeePerDept);

		Map<String, List<Employee>> employeeGrpByDept = employeeManagmentService.getEmployeesGroupByDept();
		System.out.println(employeeGrpByDept);

		Map<String, Long> totalEmployeesPerDept = employeeManagmentService.getTotalEmployeePerDept();
		System.out.println(totalEmployeesPerDept);

		Map<String, Double> avgSalaryPerDept = employeeManagmentService.getAvgSalaryPerDept();
		System.out.println(avgSalaryPerDept);

		List<Employee> firstFiveEmpList = employeeManagmentService.getFirstFiveEmployees();
		System.out.println(firstFiveEmpList);

		List<Employee> ftwoFiveRangeEmpList = employeeManagmentService.getEmployeesInRange();
		System.out.println(ftwoFiveRangeEmpList);

		List<Employee> empByDeptDecOrder = employeeManagmentService.sortEmployeeByDeptDecreasingSal();
		System.out.println(empByDeptDecOrder);
	}

}

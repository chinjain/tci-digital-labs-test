package com.tci.coding.test.TciDigitalLabsTest.model;

import java.util.List;

import com.tci.coding.test.TciDigitalLabsTest.entity.Employee;

public class EmployeeRequest {

	private List<Employee> employees;

	public EmployeeRequest() {

	}

	public EmployeeRequest(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}

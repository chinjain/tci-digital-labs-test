package com.tci.coding.test.TciDigitalLabsTest.model;

import java.util.List;

public class EmployeeBonusResponse {

	private String currency;
	private List<EmployeeDtoResponse> employees;

	public EmployeeBonusResponse(String currency, List<EmployeeDtoResponse> employees) {
		super();
		this.currency = currency;
		this.employees = employees;
	}

	public EmployeeBonusResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<EmployeeDtoResponse> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDtoResponse> employees) {
		this.employees = employees;
	}

}

package com.tci.coding.test.TciDigitalLabsTest.model;

public class EmployeeDtoResponse {

	private String empName;
	private int amount;

	public EmployeeDtoResponse(String empName, int amount) {
		super();
		this.empName = empName;
		this.amount = amount;
	}

	public EmployeeDtoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}

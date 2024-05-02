package com.tci.coding.test.TciDigitalLabsTest.model;

import java.util.List;

public class ApiResponse {

	private String errorMessage;
	private List<EmployeeBonusResponse> data;

	public ApiResponse(String errorMessage, List<EmployeeBonusResponse> data) {
		super();
		this.errorMessage = errorMessage;
		this.data = data;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<EmployeeBonusResponse> getData() {
		return data;
	}

	public void setData(List<EmployeeBonusResponse> data) {
		this.data = data;
	}

}

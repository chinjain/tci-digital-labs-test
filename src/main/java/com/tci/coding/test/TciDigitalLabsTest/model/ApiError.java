package com.tci.coding.test.TciDigitalLabsTest.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiError {

	private HttpStatus status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ApiValidationError> errors = new ArrayList<>();

	public ApiError(HttpStatus status, String message, Throwable ex) {
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public List<ApiValidationError> getErrors() {
		return errors;
	}

	public void setErrors(List<ApiValidationError> errors) {
		this.errors = errors;
	}

	public void addValidationError(ApiValidationError error) {
		errors.add(error);
	}

	public void addValidationErrors(List<FieldError> fieldErrors) {

		fieldErrors.forEach(error -> {
			String field = error.getField();
			String message = error.getDefaultMessage();
			ApiValidationError apiValidationError = new ApiValidationError(field, message);
			this.addValidationError(apiValidationError);
		});

	}

}

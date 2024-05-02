package com.tci.coding.test.TciDigitalLabsTest.gloablException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tci.coding.test.TciDigitalLabsTest.model.ApiError;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		List<Map<String, String>> errorResponse = new ArrayList<Map<String, String>>();

		ex.getBindingResult().getFieldErrors().stream().forEach(error -> {
			Map<String, String> map = new HashMap<>();
			map.put(error.getField(), error.getDefaultMessage());

			errorResponse.add(map);
		});
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Object> handleEntityException(EntityNotFoundException ex, WebRequest req) {

		String errorMessage = "Resource Not found";
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage, ex));

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	protected ResponseEntity<Object> handleAllExceptions(Exception ex) {
		String errorMessage = "An internal server error occurred";
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage, ex);
		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<Object>(apiError, apiError.getStatus());
	}
}

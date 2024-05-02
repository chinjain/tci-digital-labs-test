package com.tci.coding.test.TciDigitalLabsTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tci.coding.test.TciDigitalLabsTest.Services.EmployeeService;
import com.tci.coding.test.TciDigitalLabsTest.model.ApiResponse;
import com.tci.coding.test.TciDigitalLabsTest.model.EmployeeRequest;

@RestController
@RequestMapping("/tci")
public class EmployeeController {

	private EmployeeService empService;

	public EmployeeController(EmployeeService empService) {
		this.empService = empService;
	}

	@PostMapping("/employee-bonus")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {

		empService.saveAll(employeeRequest);
		return ResponseEntity.ok("Employee save successfully");
	}

	@GetMapping("/employee-bonus")
	public ResponseEntity<ApiResponse> getEligibleEmploye(@RequestParam(name = "date") String date) {

		ApiResponse apiResponse = new ApiResponse();

		try {
			
			apiResponse.setData(empService.getBonusEligibilEmployee(date));
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

		} catch (Exception e) {

			apiResponse.setErrorMessage(e.getLocalizedMessage());
			return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}

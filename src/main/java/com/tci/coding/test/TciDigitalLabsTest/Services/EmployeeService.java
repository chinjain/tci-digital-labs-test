package com.tci.coding.test.TciDigitalLabsTest.Services;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tci.coding.test.TciDigitalLabsTest.entity.Employee;
import com.tci.coding.test.TciDigitalLabsTest.model.EmployeeBonusResponse;
import com.tci.coding.test.TciDigitalLabsTest.model.EmployeeDtoResponse;
import com.tci.coding.test.TciDigitalLabsTest.model.EmployeeRequest;
import com.tci.coding.test.TciDigitalLabsTest.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}

	public void saveAll(@Valid EmployeeRequest employeeRequest) {

		List<Employee> employees = employeeRequest.getEmployees();
		employeeRepository.saveAll(employees);
	}

	public List<EmployeeBonusResponse> getBonusEligibilEmployee(String date) {

		List<Employee> employeeResponse = employeeRepository.findAll().stream().filter(emp -> isActiveDate(emp, date))
				.sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList());

		Map<String, List<Employee>> map = employeeResponse.stream()
				.collect(Collectors.groupingBy(Employee::getCurrency));

		return map.entrySet().stream().map(entry -> {
			EmployeeBonusResponse bonusResponse = new EmployeeBonusResponse();
			bonusResponse.setCurrency(entry.getKey());

			List<EmployeeDtoResponse> dtoResponses = entry.getValue().stream()
					.map(e -> new EmployeeDtoResponse(e.getEmpName(), e.getAmount())).collect(Collectors.toList());
			bonusResponse.setEmployees(dtoResponses);

			return bonusResponse;

		}).sorted(Comparator.comparing(EmployeeBonusResponse::getCurrency)).collect(Collectors.toList());
	}

	private boolean isActiveDate(Employee employee, String date) {

		return employee.getJoiningDate().compareTo(date) < 0;

	}

}

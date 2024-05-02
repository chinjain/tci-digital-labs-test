package com.tci.coding.test.TciDigitalLabsTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tci.coding.test.TciDigitalLabsTest.entity.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

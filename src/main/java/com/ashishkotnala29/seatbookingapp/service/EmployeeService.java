package com.ashishkotnala29.seatbookingapp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashishkotnala29.seatbookingapp.dao.EmployeeRepository;
import com.ashishkotnala29.seatbookingapp.model.entity.Employee;

/**
 * Service layer that allows saving employees.
 */
@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}

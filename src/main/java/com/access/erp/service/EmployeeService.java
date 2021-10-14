package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Optional<Employee> editEmployee(String empCode);
	public void deleteEmployee(String empCode);
	public Employee findEmployeeById(String empCode);
	
	
}

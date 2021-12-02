package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Employee;
import com.access.erp.repo.EmployeeRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired EmployeeRepo employeeRepo;
	@Autowired
	SeqMainRepo seqMainRepo;
	
	@Override
	public void addEmployee(Employee employee) {
		
		if (employee.getEmpCode() == "" || employee.getEmpCode() == null) {
			System.out.println("country code is : "+ employee.getEmpCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("EMP", "20-21", "EB");
			employee.setEmpCode(maxCode);
		}

		employeeRepo.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		
		return employeeRepo.findAll();
	}

	@Override
	public Optional<Employee> editEmployee(String empCode) {
		
		return employeeRepo.findById(empCode);
	}

	@Override
	public void deleteEmployee(String empCode) {
		employeeRepo.deleteById(empCode);
		
	}

	@Override
	public Employee findEmployeeById(String empCode) {
		
		return employeeRepo.findEmployeeByEmpCode(empCode);
		
	}
	

}

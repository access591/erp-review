package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Department;
import com.access.erp.repo.DepartmentRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.DepartmentService;


@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired DepartmentRepo departmentRepo;
	@Autowired SeqMainRepo seqMainRepo; 
	
	@Override
	public void addDepartment(Department department) {
		

		if (department.getDeptCode() == "" || department.getDeptCode() == null) {
			System.out.println("country code is : "+ department.getDeptCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("DPT", "20-21", "EB");
			department.setDeptCode(maxCode);
		}

		departmentRepo.save(department);
		
	}

	@Override
	public List<Department> getAllDepartment() {
		
		return departmentRepo.findAll();
	}

	@Override
	public Optional<Department> editDepartment(String deptCode) {

		return departmentRepo.findById(deptCode);
	}

	@Override
	public void deleteDepartment(String deptCode) {
		
		departmentRepo.deleteById(deptCode);
	}

}

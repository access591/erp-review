package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Department;

public interface DepartmentService {

	public void addDepartment(Department department);
	public List<Department> getAllDepartment();
	public Optional<Department> editDepartment(String deptCode);
	public void deleteDepartment(String deptCode);
}

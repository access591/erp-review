package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String>{

}

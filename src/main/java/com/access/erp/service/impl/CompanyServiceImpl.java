package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.access.erp.model.master.Company;
import com.access.erp.repo.CompanyRepo;
import com.access.erp.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{

	
	@Autowired CompanyRepo companyRepo;
	
	@Override
	public void addCompany(Company company) {
		
		
		
	}

	@Override
	public List<Company> getAllCompany() {
		
		return companyRepo.findAll();
	}

	@Override
	public Company editCompany(String companyCode) {
		
		return companyRepo.findById(companyCode).get();
	}

	@Override
	public void deleteCompany(String companyCode) {
		companyRepo.deleteById(companyCode);
		
	}

}

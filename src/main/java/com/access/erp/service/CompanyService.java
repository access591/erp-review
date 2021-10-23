package com.access.erp.service;

import java.util.List;
import java.util.Optional;


import com.access.erp.model.master.Company;

public interface CompanyService {
	
	public void addCompany(Company company);
	public List<Company> getAllCompany();
	public Company editCompany(String companyCode);
	public void deleteCompany(String companyCode);

}

package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.City;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.InsuranceDetail;
import com.access.erp.model.master.SiteOffice;
import com.access.erp.model.master.State;
import com.access.erp.repo.CompanyRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	CompanyRepo companyRepo;

	@Override
	public void addCompany(Company company) {

		if (company.getCompCode() == "" || company.getCompCode() == null) {
			System.out.println("company code is : " + company.getCompCode());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("COM", "20-21", "EB");
			company.setCompCode(maxCode);
		}

		/*
		 * for (InsuranceDetail insurance : company.getInsuranceDetail()) {
		 * insurance.setCompany(company); }
		 */
		
		
		/*
		 * for (SiteOffice siteOffice : company.getSiteOffice()) {
		 * siteOffice.setCompany(company); }
		 */

		
		companyRepo.save(company);

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

package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.repo.FinnancialActiveYearRepo;
import com.access.erp.repo.FinnancialYearRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.FinancialActiveYearService;

@Service
public class FinancialActiveYearServiceImpl implements FinancialActiveYearService {

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	FinnancialActiveYearRepo financialActiveYearRepo;
	@Autowired FinnancialYearRepo financialYearRepo;
	

	@Override
	public void addFinancialActiveYear(FinancialActiveYear financialActiveYear) {

		/*
		 * if (financialActiveYear.getId() == null) {
		 * System.out.println("country code is : " +
		 * financialActiveYear.getFinancialYearCode());
		 * 
		 * if(financialActiveYear.getFinancialYearCode().isEmpty()) {
		 * 
		 * String maxCode = seqMainRepo.findByTranType("FIA");
		 * 
		 * System.out.println(" max code is : " + maxCode);
		 * financialActiveYear.setFinancialYearCode(maxCode);
		 * 
		 * }
		 * 
		 * }
		 */
		
		//financialYearRepo.findByFinancialYearCode(financialActiveYear.getFinancialYear())
		financialActiveYearRepo.save(financialActiveYear);

		System.out.println("end");

	}

	@Override
	public List<FinancialActiveYear> getAllFinancialActiveYear() {
		return financialActiveYearRepo.findAll();
	}

	@Override
	public Optional<FinancialActiveYear> editFinancialActiveYear(Long id) {

		return financialActiveYearRepo.findById(id);
	}

	@Override
	public void deleteFinanciaActivelYear(Long id) {

		financialActiveYearRepo.deleteById(id);

	}

	@Override
	public List<FinancialActiveYear> findByCompany(Company company) {
		
		return this.financialActiveYearRepo.findByCompany(company);
	}

	@Override
	public boolean existsByFinancialYearAndMyUserAndCompany(FinancialYear ff, MyUser user, Company company) {
		
		return financialActiveYearRepo.existsByFinancialYearAndMyUserAndCompany(ff, user, company);
	}

}

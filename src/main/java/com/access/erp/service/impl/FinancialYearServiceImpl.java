package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.FinancialYear;
import com.access.erp.repo.FinnancialYearRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.FinancialYearService;

@Service
public class FinancialYearServiceImpl implements FinancialYearService {

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	FinnancialYearRepo financialYearRepo;

	@Override
	public void addFinancialYear(FinancialYear financialYear) {

		if (financialYear.getId() == null) {
			System.out.println("country code is : " + financialYear.getFinancialYearCode());
			String maxCode = seqMainRepo.findByTranType("FIN");

			System.out.println(" max code is : " + maxCode);
			financialYear.setFinancialYearCode(maxCode);
		}

		financialYearRepo.save(financialYear);

		System.out.println("end");
	}

	@Override
	public List<FinancialYear> getAllFinancialYear() {
		return financialYearRepo.findAll();
	}

	@Override
	public Optional<FinancialYear> editFinancialYear(String financialCode) {

		return financialYearRepo.findById(financialCode);
	}

	@Override
	public void deleteFinancialYear(String financialCode) {

		financialYearRepo.deleteById(financialCode);

	}

}

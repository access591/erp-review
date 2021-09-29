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
			financialYear.setFinancialYearCode(maxCode.toString());
		}

		financialYearRepo.save(financialYear);

		System.out.println("end");
	}

	@Override
	public List<FinancialYear> getAllFinancialYear() {
		return financialYearRepo.findAll();
	}

	@Override
	public Optional<FinancialYear> editFinancialYear(Long id) {

		return financialYearRepo.findById(id);
		
	}

	@Override
	public void deleteFinancialYear(Long id) {

		financialYearRepo.deleteById(id);

	}

}

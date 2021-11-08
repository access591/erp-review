package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.access.erp.model.master.FinancialYear;


public interface FinancialYearService {

	public void addFinancialYear(FinancialYear financialYear);
	public List<FinancialYear> getAllFinancialYear();
	public Optional<FinancialYear> editFinancialYear(Long id);
	public void deleteFinancialYear(Long id);
	public boolean isFinancialYearExists(String financialYearCode);
	
	
}

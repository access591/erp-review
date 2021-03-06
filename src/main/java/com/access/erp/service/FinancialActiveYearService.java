
package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;

public interface FinancialActiveYearService {

	public void addFinancialActiveYear(FinancialActiveYear financialActiveYear);

	public List<FinancialActiveYear> getAllFinancialActiveYear();

	public Optional<FinancialActiveYear> editFinancialActiveYear(Long id);

	public void deleteFinanciaActivelYear(Long id);
	
	List<FinancialActiveYear> findByCompany(Company company);
	
	boolean existsByFinancialYearAndMyUserAndCompany(FinancialYear ff,MyUser user, Company company);

}


package com.access.erp.service;

import java.util.List;
import java.util.Optional;


import com.access.erp.model.master.FinancialActiveYear;

public interface FinancialActiveYearService {

	public void addFinancialActiveYear(FinancialActiveYear financialActiveYear);

	public List<FinancialActiveYear> getAllFinancialActiveYear();

	public Optional<FinancialActiveYear> editFinancialActiveYear(Long id);

	public void deleteFinanciaActivelYear(Long id);

}

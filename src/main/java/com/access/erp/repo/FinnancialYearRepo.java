package com.access.erp.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;

@Repository
public interface FinnancialYearRepo extends JpaRepository<FinancialYear, String>{

	
	public FinancialYear findByFinancialYearCode(String financialYearCode);
	List<FinancialYear> findByActive(String active);
	
	
}

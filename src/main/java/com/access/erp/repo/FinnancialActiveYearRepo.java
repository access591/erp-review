package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;

@Repository
public interface FinnancialActiveYearRepo extends JpaRepository<FinancialActiveYear, Long>{
	
	List<FinancialActiveYear> findByCompany(Company company);
	
	//boolean existsByRegnoAndName(String regno, String name);
	
	boolean existsByFinancialYearAndMyUserAndCompany(FinancialYear ff,MyUser user, Company company);

}

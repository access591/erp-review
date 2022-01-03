package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.ItemOpening;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;

@Repository
public interface ItemOpeningRepo extends JpaRepository<ItemOpening, String>{
	
	boolean existsByItemCode(String itemCode);

}

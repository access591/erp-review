package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RfQuotation;
import com.access.erp.model.RfQuotationSupply;


@Repository
public interface RfQuotationSupplyRepo extends JpaRepository<RfQuotationSupply, Long>{
	
	List<RfQuotationSupply> findBySuppCode(String suppCode);
	List<RfQuotationSupply> findByRfQuotation(RfQuotation rfQuotation);

}

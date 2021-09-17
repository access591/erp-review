package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.QuotationDetail;

@Repository
public interface QuotationDetailRepo extends JpaRepository<QuotationDetail, String>{

	
	
}

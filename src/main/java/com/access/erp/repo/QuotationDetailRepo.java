package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.access.erp.model.QuotationDetail;

@Repository
public interface QuotationDetailRepo extends JpaRepository<QuotationDetail, String>{
	
	// only approvalStatus1 == "Y"
	public List<QuotationDetail> findByApprovalStatus1(String approvalStatus1);

	
	
}

package com.access.erp.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.erp.model.OpenIndent;

@Repository
public interface OpenIndentRepo extends JpaRepository<OpenIndent, String>{

	
	public OpenIndent findByIndentNumber(String indentNumber);
	
	public List<OpenIndent> findByApprovalStatus(String approvalStatus);
	
	@Query(value="select o from OpenIndent o where o.approvalStatus=?1 and o.indentNumber not in (select r.openIndent from RfQuotationItem r )")
	public List<OpenIndent> findIndentNotInRfq(String approvalStatus);
	
	
}

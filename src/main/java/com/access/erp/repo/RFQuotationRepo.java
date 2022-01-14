package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RfQuotation;

@Repository
public interface RFQuotationRepo extends JpaRepository<RfQuotation, String>{

	public RfQuotation findByRfqNo(String rfqNo);
	public List<RfQuotation> findAllByOrderByRfqNoDesc();
}

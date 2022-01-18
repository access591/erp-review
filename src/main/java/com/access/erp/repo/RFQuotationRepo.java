package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.erp.model.GateEntry;
import com.access.erp.model.RfQuotation;

@Repository
public interface RFQuotationRepo extends JpaRepository<RfQuotation, String>{

	public RfQuotation findByRfqNo(String rfqNo);
	public List<RfQuotation> findAllByOrderByRfqNoDesc();
	
	/*
	 * @Query(
	 * value="select g from GateEntry g where g.gateSrNo not in (select m.gateEntryNo from MRN m )"
	 * ) public List<GateEntry> findAllNotInMrn();
	 */
	
	@Query(value="select r from RfQuotation r where r.rfqNo not in (select q.rfqNo from QuotationDetail q)")
	public List<RfQuotation> findAllRfqNotINQuotaion();
}

package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.RfQuotation;
import com.access.erp.model.RfQuotationItem;
import com.access.erp.model.RfQuotationSupply;
import com.access.erp.repo.RFQuotationRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.RfQuotationService;


@Service
public class RfQuotationServiceImpl implements RfQuotationService{

	@Autowired RFQuotationRepo rfQuotationRepo;
	@Autowired SeqMainRepo seqMainRepo;
	@Autowired SessionFactory sessionFactory; 
	
	@Override
	public void addRfQuotation(RfQuotation rfQuotation) {
		
		System.out.println("add request for quotation method " + rfQuotation.getRfqNo());
		if(rfQuotation.getRfqNo()=="" || rfQuotation.getRfqNo()==null) {
			
			System.out.println("request for quotation code is : "+ rfQuotation.getRfqNo());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("RFQ", "20-21", "EB");
			rfQuotation.setRfqNo("EB-"+maxCode);
			
		}
		
		for(RfQuotationItem rfqItem : rfQuotation.getListRFQuotation()) {
			
			System.out.println("rfq item detail ");
			rfqItem.setRfQuotations(rfQuotation);
			rfqItem.setRfqDate(rfQuotation.getRfqDate());
			
			//boolean result = rfqItem.equals(rfqItem);
			
			/*
			 * if(result) { System.out.println("true "); }else {
			 * System.out.println("false"); }
			 */
		}
		

		for(RfQuotationSupply rqQSuply : rfQuotation.getListRFQuotationSupply()) {
			
			System.out.println(" rfq suply detail ");
			rqQSuply.setRfQuotation(rfQuotation);
			//rqQSuply.setOpenIndent(rfQuotation.getListRFQuotation().get);
			
		}
		
		//for(int i=0;i<)
		rfQuotationRepo.save(rfQuotation);
	}

	@Override
	public List<RfQuotation> getAllRfQuotation() {
		
		return rfQuotationRepo.findAll();
	}

	@Override
	public Optional<RfQuotation> editRfQuotation(String rfCode) {
		
		return rfQuotationRepo.findById(rfCode);
	}

	@Override
	public void deleteRfQuotation(String rfCode) {
		
		rfQuotationRepo.deleteById(rfCode);
		
	}

	@Override
	public void updateRfQuotation(RfQuotation rfQuotation) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			RfQuotation rfq = session.find(RfQuotation.class,rfQuotation.getRfqNo());
			rfq.getListRFQuotation().clear();
			rfq.getListRFQuotationSupply().clear();
			rfq.getListRFQuotation().addAll(rfQuotation.getListRFQuotation());
			rfq.getListRFQuotationSupply().addAll(rfQuotation.getListRFQuotationSupply());
			session.merge(rfQuotation);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<RfQuotation> findAllByOrderByRfqNoDsc() {
		
		return this.rfQuotationRepo.findAllByOrderByRfqNoDesc();
	}

}

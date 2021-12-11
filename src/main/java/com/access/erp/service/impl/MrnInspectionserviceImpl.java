package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.access.erp.model.MrnInspection;
import com.access.erp.model.MrnInspectionItemDetail;
import com.access.erp.repo.MrnInspectionRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.MrnInspectionService;

@Repository
public class MrnInspectionserviceImpl implements MrnInspectionService{

	@Autowired MrnInspectionRepo mrnInspectionRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	
	
	
	@Override
	public void addMrnInspection(MrnInspection mrnInspection) {
		
		if (mrnInspection.getInspNo() == "" || mrnInspection.getInspNo() == null) {
			System.out.println("mrn inspection number  is : "+ mrnInspection.getInspNo());
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("INS", "20-21", "EB");
			
			System.out.println("max code is : " + maxCode);
			
			mrnInspection.setInspNo("EB-"+maxCode);
		}
		
		for(MrnInspectionItemDetail inspectionDetail : mrnInspection.getMrnInspectionItems()) {
			
			inspectionDetail.setMrnInspection(mrnInspection);
		
		}
		mrnInspectionRepo.save(mrnInspection);
		
	}

	@Override
	public List<MrnInspection> getAllMrnInspection() {
		
		return mrnInspectionRepo.findAll();
	}

	@Override
	public Optional<MrnInspection> editMrnInspection(String mrnInspNo) {
		
		return mrnInspectionRepo.findById(mrnInspNo);
	}

	@Override
	public void deleteMrnInspection(String mrnInspNo) {
		mrnInspectionRepo.deleteById(mrnInspNo);
		
	}

}


package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.MRN;
import com.access.erp.model.MRNDetail;
import com.access.erp.repo.MRMRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.MRMService;

@Service
public class MrmServiceImpl implements MRMService {

	@Autowired MRMRepo mrmRepo;
	
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addMrm(MRN mrm) {

		// pk EB-MRN-0001
		
		if (mrm.getMrnNo() == "" || mrm.getMrnNo() == null) {
		
			System.out.println("mrn  code is : "+mrm.getMrnNo());
			
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("MRN", "20-21", "EB");
			
			System.out.println("max code is : " + maxCode);
			
			mrm.setMrnNo("EB-"+maxCode);
		}

		for(MRNDetail mrnDetail : mrm.getMrnDetails()) {
			
			mrnDetail.setGateEntryNo(mrm.gateEntryNo);
			mrnDetail.setGateEntryDate(mrm.getGateEntryDate());
			mrnDetail.setMrn(mrm);
		}
		
		
		mrmRepo.save(mrm);
		
		
	}

	@Override
	public List<MRN> getAllMrm() {
		return this.mrmRepo.findAll();
	}

	@Override
	public Optional<MRN> editMrm(String mrmCode) {
		return this.mrmRepo.findById(mrmCode);
	}

	@Override
	public void deleteMrm(String mrmCode) {
		this.mrmRepo.deleteById(mrmCode);
	}

}

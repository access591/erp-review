package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.IssueSlip;
import com.access.erp.model.IssueSlipDetail;
import com.access.erp.repo.IssueSlipRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.IssueSlipService;

@Service
public class IssueSlipServiceImpl implements IssueSlipService{

	@Autowired IssueSlipRepo issueSlipRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	
	@Override
	public void addIssueSlip(IssueSlip issueSlip) {
		
		if(issueSlip.getIssueNo()==null || issueSlip.getIssueNo()=="") {
			
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("ISU", "20-21", "EB");
			issueSlip.setIssueNo(maxCode);
		}
		
		for(IssueSlipDetail issueSlipDetail : issueSlip.getIssueSlipDetails()) {
			
			issueSlipDetail.setIssueSlip(issueSlip);
			issueSlipDetail.setIssueDate(issueSlip.getIssueDate());
		}
		
		issueSlipRepo.save(issueSlip);
		
		
	}

	@Override
	public List<IssueSlip> getAllIssueSlip() {
		
		return issueSlipRepo.findAll();
	}

	@Override
	public Optional<IssueSlip> editIssueSlip(String issueSlipNo) {
		
		return issueSlipRepo.findById(issueSlipNo);
	}

	@Override
	public void deleteIssueSlip(String issueSlipNo) {
		
		issueSlipRepo.deleteById(issueSlipNo);
	}

}

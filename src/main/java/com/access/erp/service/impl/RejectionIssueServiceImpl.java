package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.PurchaseReturnDetail;
import com.access.erp.model.RejectionIssue;
import com.access.erp.model.RejectionIssueDetail;
import com.access.erp.repo.RejectionIssueRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.RejectionIssueService;
@Service
public class RejectionIssueServiceImpl implements RejectionIssueService {

	@Autowired SeqMainRepo seqMainRepo;
	@Autowired RejectionIssueRepo rejectionIssuerepo;
	
	
	@Override
	public void addRejectionIssue(RejectionIssue rejectionissue) {
		if (rejectionissue.getIssNo() == "" | (rejectionissue.getIssNo() == null)) {
			System.out.println("purchase return  code is : " + rejectionissue.getIssNo());

			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("RIS", "20-21", "EB");

			System.out.println("max code is : " + maxCode);
			rejectionissue.setIssNo(maxCode);
			System.out.println("IssueNo----->>>>>>> "+ rejectionissue.getIssNo());
		}
         
		for(RejectionIssueDetail detail : rejectionissue.getListRejectionIssueDetail()) {
		detail.setRejectionIssue(rejectionissue);
			
		}
		rejectionIssuerepo.save(rejectionissue);

	
		
	}

	@Override
	public List<RejectionIssue> getAllRejectionIssue() {
		// TODO Auto-generated method stub
		return rejectionIssuerepo.findAll();
	}

	@Override
	public Optional<RejectionIssue> editRejectionIssue(String IssueNo) {
		// TODO Auto-generated method stub
		return rejectionIssuerepo.findById(IssueNo);
	}

	@Override
	public void deleteRejectionIssue(String IssueNo) {
		// TODO Auto-generated method stub
		rejectionIssuerepo.deleteById(IssueNo);
		
	}

}

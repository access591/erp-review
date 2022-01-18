package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.RejectionIssue;
import com.access.erp.repo.RejectionIssueRepo;
import com.access.erp.service.RejectionIssueService;
@Service
public class RejectionIssueServiceImpl implements RejectionIssueService {

	
	@Autowired RejectionIssueRepo rejectionIssuerepo;
	
	
	@Override
	public void addRejectionIssue(RejectionIssue rejectionissue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RejectionIssue> getAllRejectionIssue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<RejectionIssue> editRejectionIssue(String IssueNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRejectionIssue(String IssueNo) {
		// TODO Auto-generated method stub
		
	}

}

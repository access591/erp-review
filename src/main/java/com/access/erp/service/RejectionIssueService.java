package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.RejectionIssue;

public interface RejectionIssueService {

	
	public void addRejectionIssue(RejectionIssue rejectionissue);
	public List<RejectionIssue>getAllRejectionIssue();
	public Optional<RejectionIssue>editRejectionIssue(String IssueNo);
	public void deleteRejectionIssue(String IssueNo);
}

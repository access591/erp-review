package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.IssueSlip;

public interface IssueSlipService {
	
	public void addIssueSlip(IssueSlip issueSlip);
	public List<IssueSlip> getAllIssueSlip();
	public Optional<IssueSlip> editIssueSlip(String issueSlipNo);
	public void deleteIssueSlip(String issueSlipNo);

}

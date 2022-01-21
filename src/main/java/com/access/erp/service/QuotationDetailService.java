package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.QuotationDetail;

public interface QuotationDetailService {
	
	public void addQuotationdetail(QuotationDetail quotationDetail);
	public List<QuotationDetail> getAllQuotationDetail();
	public Optional<QuotationDetail> editQuotationDetail(String quotCode);
	public void deleteQuotationDetail(String quotCode);
	
	public List<OpenIndent> getIndentInRFQ();
	
	public void approvalForQuotationDetail(String quotNum , String status);
	
	public List<QuotationDetail> findAllOrderBy();

}

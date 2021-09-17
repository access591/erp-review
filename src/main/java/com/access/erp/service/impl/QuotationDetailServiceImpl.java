package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.QuotationDetail;
import com.access.erp.repo.QuotationDetailRepo;
import com.access.erp.service.QuotationDetailService;


@Service
public class QuotationDetailServiceImpl implements QuotationDetailService {

	@Autowired QuotationDetailRepo quotationRepo;
	
	@Override
	public void addQuotationdetail(QuotationDetail quotationDetail) {
		
		
	}

	@Override
	public List<QuotationDetail> getAllQuotationDetail() {
		return quotationRepo.findAll();
	}

	@Override
	public Optional<QuotationDetail> editQuotationDetail(String quotCode) {
		
		return quotationRepo.findById(quotCode);
	}

	@Override
	public void deleteQuotationDetail(String quotCode) {
		
		quotationRepo.deleteById(quotCode);
	}

}

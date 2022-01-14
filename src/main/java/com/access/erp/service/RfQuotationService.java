package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.RfQuotation;

public interface RfQuotationService {

	public void addRfQuotation(RfQuotation rfQuotation);
	public List<RfQuotation> getAllRfQuotation();
	public Optional<RfQuotation> editRfQuotation(String rfCode);
	public void deleteRfQuotation(String rfCode);
	
	public void updateRfQuotation(RfQuotation rfQuotation);
	public List<RfQuotation> findAllByOrderByRfqNoDsc();
}

package com.access.erp.utility;

import com.access.erp.model.QuotationDetail;
import com.access.erp.model.master.PartyMaster;

public class QuotationPartyState {
	
	private QuotationDetail quotationDetail;
	private PartyMaster partyMaster;
	
	
	public QuotationDetail getQuotationDetail() {
		return quotationDetail;
	}
	public void setQuotationDetail(QuotationDetail quotationDetail) {
		this.quotationDetail = quotationDetail;
	}
	public PartyMaster getPartyMaster() {
		return partyMaster;
	}
	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}
	
	
	

}

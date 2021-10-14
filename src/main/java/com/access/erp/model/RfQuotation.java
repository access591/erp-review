package com.access.erp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RFQ_MASTER")
public class RfQuotation {

	@Id
	@Column(name="RFQ_NUM",length=50)
	private String rfqNo;
	
	@Column(name="RFQ_DATE")
	private Date rfqDate;
	
	@Column(name="RFQ_TYPE",length=20)
	private String rfqType;
	
	@Column(name="C_CODE",length=50)
	private String cCode;
	
	@Column(name="FY_CODE",length=50)
	private String fyCode;
	
	@Column(name="u_CODE",length=50)
	private String uCode;
	
	@Column(name="u_DATE")
	private Date uDate;
	
	@Column(name="RFQ_TERMCONDITION",length=1000)
	private String rfqTermCondition;
	
	@OneToMany(mappedBy = "rfQuotations", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<RfQuotationItem> listRFQuotation = new ArrayList<>();
	
	@OneToMany(mappedBy = "rfQuotation", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<RfQuotationSupply> listRFQuotationSupply = new ArrayList<>();

	public RfQuotation() {
		super();
		
	}

	public String getRfqNo() {
		return rfqNo;
	}

	public void setRfqNo(String rfqNo) {
		this.rfqNo = rfqNo;
	}

	public Date getRfqDate() {
		return rfqDate;
	}

	public void setRfqDate(Date rfqDate) {
		this.rfqDate = rfqDate;
	}

	public String getRfqType() {
		return rfqType;
	}

	public void setRfqType(String rfqType) {
		this.rfqType = rfqType;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getFyCode() {
		return fyCode;
	}

	public void setFyCode(String fyCode) {
		this.fyCode = fyCode;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	public String getRfqTermCondition() {
		return rfqTermCondition;
	}

	public void setRfqTermCondition(String rfqTermCondition) {
		this.rfqTermCondition = rfqTermCondition;
	}



	public List<RfQuotationItem> getListRFQuotation() {
		return listRFQuotation;
	}

	public void setListRFQuotation(List<RfQuotationItem> listRFQuotation) {
		this.listRFQuotation = listRFQuotation;
	}

	public List<RfQuotationSupply> getListRFQuotationSupply() {
		return listRFQuotationSupply;
	}

	public void setListRFQuotationSupply(List<RfQuotationSupply> listRFQuotationSupply) {
		this.listRFQuotationSupply = listRFQuotationSupply;
	}
	
	
	
	
	
	
	
}

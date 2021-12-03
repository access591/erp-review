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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RFQ_MASTER")
public class RfQuotation {

	@Id
	@Column(name = "RFQ_NO", length = 15)
	private String rfqNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "RFQ_DATE")
	private Date rfqDate;

	@Column(name = "RFQ_TYPE", length = 2)
	private String rfqType;

	//fk
	@Column(name = "CCODE", length = 50)
	private String cCode;

	//fk
	@Column(name = "FYCODE", length = 50)
	private String fyCode;

	//fk
	@Column(name = "UCODE", length = 50)
	private String uCode;

	@Column(name = "UDATE")
	private Date uDate;

	@Column(name = "RFQ_TERM_CONDITION", length = 1000)
	private String rfqTermCondition;

	@OneToMany(mappedBy = "rfQuotations", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<RfQuotationItem> listRFQuotation = new ArrayList<>();

	@OneToMany(mappedBy = "rfQuotation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@Fetch(value = FetchMode.SUBSELECT)
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

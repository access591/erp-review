package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="M_FINANCIAL_ACTIVE_Y")
public class FinancialActiveYear {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="FINANCIAL_CODE")
	private String financialYearCode;
	
	
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	
	@Column(name="TO_DATE")
	private Date toDate;


	public FinancialActiveYear() {
		super();
		
	}


	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFinancialYearCode() {
		return financialYearCode;
	}


	public void setFinancialYearCode(String financialYearCode) {
		this.financialYearCode = financialYearCode;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public Date getToDate() {
		return toDate;
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	


	
}

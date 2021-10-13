package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity	
public class FinancialYear {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String financialYearCode;
	
	
	private Date fromDate;
	
	
	private Date toDate;


	public FinancialYear() {
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
package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity	
@Table(name="M_FINANCIAL_YEAR")
public class FinancialYear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FINANCIAL_CODE")
	private Long id;
	
	@Column(name="FINANCIAL_YEAR")
	private String financialYearCode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FROM_DATE")
	private Date fromDate;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="TO_DATE")
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

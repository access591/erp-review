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
	@Column(name="FYCODE",length = 6)
	private String financialYearCode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FYFROM")
	private Date fromDate;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="FYTO")
	private Date toDate;


	public FinancialYear() {
		super();
		
		System.out.println("==========>  IN FINANCIAL YEAR <==============");
		
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

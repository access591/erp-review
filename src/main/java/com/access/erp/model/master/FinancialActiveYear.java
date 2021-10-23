package com.access.erp.model.master;



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
	
	
	@Column(name="C_CODE")
	private String cCode;
	
	
	@Column(name="U_CODE")
	private String uCode;
	
	@Column(name="F_ACTIVE")
	private String fActive;


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



	public String getcCode() {
		return cCode;
	}



	public void setcCode(String cCode) {
		this.cCode = cCode;
	}



	public String getuCode() {
		return uCode;
	}



	public void setuCode(String uCode) {
		this.uCode = uCode;
	}



	public String getfActive() {
		return fActive;
	}



	public void setfActive(String fActive) {
		this.fActive = fActive;
	}


	
	
}

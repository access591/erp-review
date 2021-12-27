package com.access.erp.model.master;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="M_FINANCIAL_ACTIVE_YEAR")
public class FinancialActiveYear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
    @JoinColumn(name="FYCODE",updatable = false,insertable = true)
	private FinancialYear financialYear;
	
	@OneToOne
    @JoinColumn(name="UCODE",updatable = false,insertable = true)
	@JsonIgnore
    private MyUser myUser;

	
	@OneToOne
    @JoinColumn(name="CCODE",updatable = false,insertable = true)
	@JsonIgnore
	private Company company;
	
	
	
	
	@Column(name="FACTIVE",length=2)
	private String active;


	public FinancialActiveYear() {
		super();
		System.out.println("==========>  IN FINANCIAL ACTIVE YEAR <==============");
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public FinancialYear getFinancialYear() {
		return financialYear;
	}


	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}


	public MyUser getMyUser() {
		return myUser;
	}


	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	


	
	
}

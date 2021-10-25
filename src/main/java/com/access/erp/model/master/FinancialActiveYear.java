package com.access.erp.model.master;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="M_FINANCIAL_ACTIVE_Y")
public class FinancialActiveYear {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
    @JoinColumn(name="FINANCIAL_YEAR")
	private FinancialYear financialYear;
	
	@OneToOne
    @JoinColumn(name="USER_CODE")
    private MyUser myUser;

	
	@OneToOne
    @JoinColumn(name="COMPANY_CODE")
	private Company company;
	
	
	
	
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



	


	public String getfActive() {
		return fActive;
	}



	public void setfActive(String fActive) {
		this.fActive = fActive;
	}


	
	
}

package com.access.erp.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;

@Component
@Scope("singleton")
public class GlobalParameter {
	
	private String globaluser;
	private String globalCompany;
	private String globalFinanceYear;
	
	private Company company;
	private MyUser myUser;
	private FinancialYear fyYear;

	
	
	public String getGlobaluser() {
		return globaluser;
	}


	public void setGlobaluser(String globaluser) {
		this.globaluser = globaluser;
	}


	public String getGlobalCompany() {
		return globalCompany;
	}


	public void setGlobalCompany(String globalCompany) {
		this.globalCompany = globalCompany;
	}


	public String getGlobalFinanceYear() {
		return globalFinanceYear;
	}


	public void setGlobalFinanceYear(String globalFinanceYear) {
		this.globalFinanceYear = globalFinanceYear;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public MyUser getMyUser() {
		return myUser;
	}


	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}


	public FinancialYear getFyYear() {
		return fyYear;
	}


	public void setFyYear(FinancialYear fyYear) {
		this.fyYear = fyYear;
	}
	
	
	
	
	

}

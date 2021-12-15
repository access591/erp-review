package com.access.erp.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class GlobalParameter {
	
	private String globaluser;
	private String globalCompany;
	private String globalFinanceYear;

	
	
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
	
	
	
	
	

}

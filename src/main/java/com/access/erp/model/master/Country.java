package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Country {
	
	@Id
	@Column(name = "COUNTRY_CODE", length = 50)
	private int countryCode;
	
	@Column(name = "COUNTRY_NAME", length = 50)
	private String countryName;

	public Country() {
		super();
		
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
	

}

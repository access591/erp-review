package com.access.erp.model.master;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Country {
	
	@Id
	@Column(name = "COUNTRY_CODE", length = 50)
	private int countryCode;
	
	@Column(name = "COUNTRY_NAME", length = 50)
	private String countryName;
	
	@OneToMany(mappedBy = "country")
	private Set<State> states;

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

	public Set<State> getStates() {
		return states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}
	
	

	
	
	

}

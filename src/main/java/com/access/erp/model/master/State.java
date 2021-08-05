package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class State {

	
	@Id
	@Column(name = "STATE_CODE", length = 50)
	private int stateCode;
	
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	
	@Column(name = "COUNTRY_CODE", length = 50)
	private String countryCode;
	
	@Column(name = "GST_STATE_CODE", length = 50)
	private String gstStateCode;

	public State() {
		super();
		
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getGstStateCode() {
		return gstStateCode;
	}

	public void setGstStateCode(String gstStateCode) {
		this.gstStateCode = gstStateCode;
	}
	
	
	

}

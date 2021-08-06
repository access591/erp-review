package com.access.erp.model.master;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STATE_MASTER")
public class State {

	
	@Id
	@Column(name = "STATE_CODE", length = 50)
	private int stateCode;
	
	@Column(name = "STATE_NAME", length = 50)
	private String stateName;
	
	
	@Column(name = "GST_STATE_CODE", length = 50)
	private String gstStateCode;
	
	@ManyToOne
	@JoinColumn(name="COUNTRY_CODE")
	private Country country;
	
	@OneToMany(mappedBy = "state")
	private Set<City> cities;

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

	public String getGstStateCode() {
		return gstStateCode;
	}

	public void setGstStateCode(String gstStateCode) {
		this.gstStateCode = gstStateCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
	

	
}

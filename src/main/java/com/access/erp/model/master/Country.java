package com.access.erp.model.master;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="M_COUNTRY")
public class Country {
	
	@Id
	@Column(name = "COUNTRY_CODE", length = 50)
	private String countryCode;
	
	@Column(name = "COUNTRY_NAME", length = 50)
	private String countryName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "country",cascade = CascadeType.ALL)
	private Set<State> states;
	
	@Column(name = "INS_BY",length = 50,updatable = false)
	private String insertedBy;

	@Column(name = "INS_DATE",updatable = false)
	private Date insertedDate;
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate;
	
	@Column(name = "ACTIVE_YN",length = 10)
	private String active;

	public Country() {
		super();
		System.out.println("==========>  IN COUNTRY MASTER <==============");
		
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
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

	

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

	
	
	

}

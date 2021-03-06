package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="M_SITE_OFFICE")
public class SiteOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SITE_OFFICE_CODE",length=50)
	private Long siteOfficeCode;
	
	@Column(name="SITE_CODE",length=50)
	private String siteCode;
	
	@Column(name="SITE_LOCATION",length=50)
	private String siteLocation;
	
	@Column(name="SITE_INCHARGE",length=50)
	private String siteIncharge;
	
	@Column(name="SITE_ADDR",length=100)
	private String siteAddress;
	
	@Column(name="APPROVED_BUDGET",length=15)
	private int approvedBudget;
	
	@Column(name="LEAD_TIME",length=10)
	private int leadTime;
	
	
	@Column(name="PIN_CODE",length=10)
	private int pinCode;
	
	@Column(name="FAX",length=45)
	private String fax;
	
	@Column(name="WEBSITE",length=50)
	private String website;
	
	@Column(name="EMAIL",length=75)
	private String email;
	
	@Column(name="PHONE1",length=45)
	private String phone1;
	
	@Column(name="PHONE2",length=45)
	private String phone2;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CCODE")
	@JsonIgnore
	private Company company;

	public SiteOffice() {
		super();
		
	}

	public Long getSiteOfficeCode() {
		return siteOfficeCode;
	}

	public void setSiteOfficeCode(Long siteOfficeCode) {
		this.siteOfficeCode = siteOfficeCode;
	}

	public String getSiteLocation() {
		return siteLocation;
	}

	public void setSiteLocation(String siteLocation) {
		this.siteLocation = siteLocation;
	}

	public String getSiteIncharge() {
		return siteIncharge;
	}

	public void setSiteIncharge(String siteIncharge) {
		this.siteIncharge = siteIncharge;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public int getApprovedBudget() {
		return approvedBudget;
	}

	public void setApprovedBudget(int approvedBudget) {
		this.approvedBudget = approvedBudget;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	

	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	
	

}

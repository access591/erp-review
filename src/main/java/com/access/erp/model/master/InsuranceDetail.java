package com.access.erp.model.master;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="M_INSURANCE_DETAIL")
public class InsuranceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="INSURACE_ID",length=6)
	private Long insuranceId;
	
	@Column(name="INSURACE_CODE",length=50)
	private String insuranceCode;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CCODE")
	private Company company;
	
	
	@Column(name="CUST_CODE",length=20)
	private String custCode;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="RENEWEL_DATE")
	private Date renewalDate;
	
	@Column(name="DESC1",length=200)
	private String desc1;
	
	@Column(name="DESC2",length=200)
	private String desc2;
	
	@Column(name="VERSION",length=8)
	private String version;

	public InsuranceDetail() {
		super();
		
	}

	public String getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
	

}

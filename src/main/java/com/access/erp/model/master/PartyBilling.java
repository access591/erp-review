package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PARTY_BILLING")
public class PartyBilling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PART_BILLING_ID")
	public Long partyBillingId;
	
	@Column(name="BILLING_NAME",length = 50)
	public String billingName;
	
	@Column(name="BILLING_ADDR1",length = 50)
	public String billingAddr1;
	
	@Column(name="BILLING_ADDR2",length = 50)
	public String billingAddr2;
	
	@Column(name="BILLING_ADDR3",length = 50)
	public String billingAddr3;
	
	@Column(name="BILLING_CITY_CODE",length = 30)
	public String billingCityCode;
	
	@Column(name="BILLING_STATE_CODE",length = 30)
	public String billingStateCode;
	
	@Column(name="BILLING_COUNTRY_CODE",length = 30)
	public String billingCountryCode;
	
	@Column(name="BILLING_PIN_CODE",length = 20)
	public String billingPinCode;
	
	@Column(name="BILLING_CST_NO",length = 50)
	public String billingGstNo;
	
	@Column(name="BILLING_CITY",length = 50)
	public String billingCity;
	
	@Column(name="BILLING_STATE",length = 50)
	public String billingState;
	
	@Column(name="BILLING_COUNTRY",length = 50)
	public String billingCountry;
	
	@Column(name="BILLING_PIN",length = 50)
	public String billingPin;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "PART_CODE")
	public PartyMaster partyMaster;


	
	public PartyBilling() {
		super();
		
	}


	public Long getPartyBillingId() {
		return partyBillingId;
	}


	public void setPartyBillingId(Long partyBillingId) {
		this.partyBillingId = partyBillingId;
	}


	public String getBillingName() {
		return billingName;
	}


	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}


	public String getBillingAddr1() {
		return billingAddr1;
	}


	public void setBillingAddr1(String billingAddr1) {
		this.billingAddr1 = billingAddr1;
	}


	public String getBillingAddr2() {
		return billingAddr2;
	}


	public void setBillingAddr2(String billingAddr2) {
		this.billingAddr2 = billingAddr2;
	}


	public String getBillingAddr3() {
		return billingAddr3;
	}


	public void setBillingAddr3(String billingAddr3) {
		this.billingAddr3 = billingAddr3;
	}


	public String getBillingCityCode() {
		return billingCityCode;
	}


	public void setBillingCityCode(String billingCityCode) {
		this.billingCityCode = billingCityCode;
	}


	public String getBillingStateCode() {
		return billingStateCode;
	}


	public void setBillingStateCode(String billingStateCode) {
		this.billingStateCode = billingStateCode;
	}


	public String getBillingCountryCode() {
		return billingCountryCode;
	}


	public void setBillingCountryCode(String billingCountryCode) {
		this.billingCountryCode = billingCountryCode;
	}


	public String getBillingPinCode() {
		return billingPinCode;
	}


	public void setBillingPinCode(String billingPinCode) {
		this.billingPinCode = billingPinCode;
	}


	

	public String getBillingGstNo() {
		return billingGstNo;
	}


	public void setBillingGstNo(String billingGstNo) {
		this.billingGstNo = billingGstNo;
	}


	public PartyMaster getPartyMaster() {
		return partyMaster;
	}


	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}


	public String getBillingCity() {
		return billingCity;
	}


	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}


	public String getBillingState() {
		return billingState;
	}


	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}


	public String getBillingCountry() {
		return billingCountry;
	}


	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}


	public String getBillingPin() {
		return billingPin;
	}


	public void setBillingPin(String billingPin) {
		this.billingPin = billingPin;
	}
	
	
	
}

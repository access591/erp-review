package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PARTY_CONSIGNEE")
public class PartyConsignee {
	
	
	@Id
	@Column(name="CONSIGNEE_CODE")
	public String conSigneeCode;
	
	@Column(name="CONSIGNEE_NAME")
	public String consigneeName;
	
	@Column(name="CONSIGNEE_ADDR1")
	public String consigneeAddr1;
	
	@Column(name="CONSIGNEE_ADDR2")
	public String consigneeAddr2;
	
	
	@Column(name="CONSIGNEE_ADDR3")
	public String consigneeAddr3;
	
	@Column(name="CONSIGNEE_CITY")
	public String city;
	
	@Column(name="CONSIGNEE_STATE")
	public String country;
	
	@Column(name="CONSIGNEE_PIN")
	public String pin;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "PART_CODE")
	public PartyMaster partyMaster;


	public PartyConsignee() {
		super();
		
	}


	public String getConSigneeCode() {
		return conSigneeCode;
	}


	public void setConSigneeCode(String conSigneeCode) {
		this.conSigneeCode = conSigneeCode;
	}


	public String getConsigneeName() {
		return consigneeName;
	}


	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}


	public String getConsigneeAddr1() {
		return consigneeAddr1;
	}


	public void setConsigneeAddr1(String consigneeAddr1) {
		this.consigneeAddr1 = consigneeAddr1;
	}


	public String getConsigneeAddr2() {
		return consigneeAddr2;
	}


	public void setConsigneeAddr2(String consigneeAddr2) {
		this.consigneeAddr2 = consigneeAddr2;
	}


	public String getConsigneeAddr3() {
		return consigneeAddr3;
	}


	public void setConsigneeAddr3(String consigneeAddr3) {
		this.consigneeAddr3 = consigneeAddr3;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public PartyMaster getPartyMaster() {
		return partyMaster;
	}


	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}

	

}

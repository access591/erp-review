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
	@Column(name="CONSIGNEE_Id")
	public Long partyConsigneeId;
	
	@Column(name="CONSIGNEE_CODE")
	public String conSigneeCode;
	
	@Column(name="CITY")
	public String city;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "PART_CODE")
	public PartyMaster partyMaster;


	public PartyConsignee() {
		super();
		
	}


	public Long getPartyConsigneeId() {
		return partyConsigneeId;
	}


	public void setPartyConsigneeId(Long partyConsigneeId) {
		this.partyConsigneeId = partyConsigneeId;
	}


	public String getConSigneeCode() {
		return conSigneeCode;
	}


	public void setConSigneeCode(String conSigneeCode) {
		this.conSigneeCode = conSigneeCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public PartyMaster getPartyMaster() {
		return partyMaster;
	}


	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}
	
	
	

}

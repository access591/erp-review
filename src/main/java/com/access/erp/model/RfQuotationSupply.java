package com.access.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;


@Entity
@Table(name="RFQ_SUPP_DETAIL")
public class RfQuotationSupply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long suppCode;
	
	
	@Column(name="SUPPLIER_NAME",length = 50)
	private String suppName;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ITEM_CODE")
	private Item item;
	
	@Column(name="SUPPLIER_ADD",length = 50)
	private String suppAdd;
	
	@Column(name="SUPPLIER_CITY",length = 50)
	private String suppCity;
	
	@Column(name="SUPPLIER_STATE",length = 50)
	private String suppState;
	
	@Column(name="SR_NUM",length = 50)
	private String srNum;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "INDENT_NUMBER")
	private OpenIndent openIndent;
	
	
	@Column(name="CONTACT_PERSON",length = 50)
	private String contactPerson;
	
	@Column(name="PHONE_NUMBER",length = 50)
	private String phoneNumber;
	
	@Column(name="FAX_NUMBER",length = 50)
	private String faxNum;
	
	@Column(name="EMAIL",length = 50)
	private String email;
	
	@ManyToOne(optional = false,fetch=FetchType.LAZY)
	@JoinColumn(name = "RFQ_NUM")
	private RfQuotation rfQuotation;

	public Long getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(Long suppCode) {
		this.suppCode = suppCode;
	}

	public String getSuppName() {
		return suppName;
	}

	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getSuppAdd() {
		return suppAdd;
	}

	public void setSuppAdd(String suppAdd) {
		this.suppAdd = suppAdd;
	}

	public String getSuppCity() {
		return suppCity;
	}

	public void setSuppCity(String suppCity) {
		this.suppCity = suppCity;
	}

	public String getSuppState() {
		return suppState;
	}

	public void setSuppState(String suppState) {
		this.suppState = suppState;
	}

	public String getSrNum() {
		return srNum;
	}

	public void setSrNum(String srNum) {
		this.srNum = srNum;
	}

	public OpenIndent getOpenIndent() {
		return openIndent;
	}

	public void setOpenIndent(OpenIndent openIndent) {
		this.openIndent = openIndent;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNum() {
		return faxNum;
	}

	public void setFaxNum(String faxNum) {
		this.faxNum = faxNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RfQuotation getRfQuotation() {
		return rfQuotation;
	}

	public void setRfQuotation(RfQuotation rfQuotation) {
		this.rfQuotation = rfQuotation;
	}
	
	

}

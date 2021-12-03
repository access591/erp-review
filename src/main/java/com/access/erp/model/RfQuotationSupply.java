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
import com.access.erp.model.master.SupplierMaster;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RFQ_SUPP_DETAIL")
public class RfQuotationSupply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rfQuoSupplyID;

	/*
	 * @Column(name="SUPPLIER_CODE",length = 50) private Long suppCode;
	 */
	// @ManyToOne(optional = false,fetch=FetchType.EAGER)
	// @JoinColumn(name = "SUPPLIER_CODE")
	// @JsonIgnore
	@Column(name = "SUPP_CODE", length = 40)
	private String suppCode;

	@Column(name = "SUPP_NAME", length = 50)
	private String suppName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_CODE")
	private Item item;

	@Column(name = "SUPP_ADDR", length = 200)
	private String suppAdd;

// fk
	@Column(name = "SUPP_CITY", length = 50)
	private String suppCity;

	@Column(name = "SUPP_STATE", length = 50)
	private String suppState;

	@Column(name = "SR_NO", length = 4)
	private String srNum;

	//new field 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INDENT_NUMBER")
	private OpenIndent openIndent;

	@Column(name = "CONTACT_PERSON", length = 50)
	private String contactPerson;

	@Column(name = "PHONE_NO", length = 50)
	private String phoneNumber;

	@Column(name = "FAX_NO", length = 50)
	private String faxNum;

	@Column(name = "EMAIL", length = 50)
	private String email;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "RFQ_NO")
	@JsonIgnore
	private RfQuotation rfQuotation;

	public String getSuppCode() {
		return suppCode;
	}

	public void setSuppCode(String suppCode) {
		this.suppCode = suppCode;
	}

	public OpenIndent getOpenIndent() {
		return openIndent;
	}

	public void setOpenIndent(OpenIndent openIndent) {
		this.openIndent = openIndent;
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

	/*
	 * public OpenIndent getOpenIndent() { return openIndent; }
	 * 
	 * public void setOpenIndent(OpenIndent openIndent) { this.openIndent =
	 * openIndent; }
	 */
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

	public Long getRfQuoSupplyID() {
		return rfQuoSupplyID;
	}

	public void setRfQuoSupplyID(Long rfQuoSupplyID) {
		this.rfQuoSupplyID = rfQuoSupplyID;
	}

}

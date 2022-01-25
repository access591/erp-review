package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.MRN;
import com.access.erp.model.RejectionIssue;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RECEIPT__DETAILS")
public class ItemReturnNoteDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RET_SEQ_NO", length = 200)
	private Long retSEQNo;

	@ManyToOne(optional = true)
	@JoinColumn(name = "ITEM_CODE")
	@JsonIgnore
	private Item item;

	@ManyToOne(optional = true)
	@JoinColumn(name = "UNITS", nullable = true)
	@JsonIgnore
	private Unit unit;

	@Column(name = "QTY_RETURNED", columnDefinition = "FLOAT(14,3)", nullable = true)
	private double qtyRet;

	@Column(name = "QTY_GOOD", columnDefinition = "FLOAT(14,3)", nullable = true)
	private double qtyGood;

	@Column(name = "RATE", columnDefinition = "FLOAT(14,3)", nullable = true)
	private double rate;

	@Column(name = "REMARKS", length = 500)
	private String remarks;

	@ManyToOne(optional = true)
	@JoinColumn(name = "RECEIPT_NO")
	private ItemReturnNote itemReturnNote;

	@ManyToOne(optional = true)

	@JoinColumn(name = "MRN_NO", nullable = true)
	@JsonIgnore
	private MRN mrn;

	@Column(name = "BILL_NO", length = 15)
	private String billNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "BILL_DATE")
	private Date billDate;

	@Column(name = "TAG_STATUS")
	private String tagStatus;

	public Long getRetSEQNo() {
		return retSEQNo;
	}

	public void setRetSEQNo(Long retSEQNo) {
		this.retSEQNo = retSEQNo;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public double getQtyRet() {
		return qtyRet;
	}

	public void setQtyRet(double qtyRet) {
		this.qtyRet = qtyRet;
	}

	public double getQtyGood() {
		return qtyGood;
	}

	public void setQtyGood(double qtyGood) {
		this.qtyGood = qtyGood;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public ItemReturnNote getItemReturnNote() {
		return itemReturnNote;
	}

	public void setItemReturnNote(ItemReturnNote itemReturnNote) {
		this.itemReturnNote = itemReturnNote;
	}

	/*
	 * public MRN getMrn() { return mrn; }
	 * 
	 * 
	 * public void setMrn(MRN mrn) { this.mrn = mrn; }
	 */

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getTagStatus() {
		return tagStatus;
	}

	public void setTagStatus(String tagStatus) {
		this.tagStatus = tagStatus;
	}

}

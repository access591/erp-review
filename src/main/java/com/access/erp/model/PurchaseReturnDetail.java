package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;

@Entity
@Table(name = "PURCHASE_RETURN_DETAIL")
public class PurchaseReturnDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PrDetailId", length = 30)
	private Long detailId;

	@Column(name = "PR_DATE")
	private Date date;

	@Column(name = "SR_NO", length = 4)
	private String srNo;

	@ManyToOne
	@JoinColumn(name = "ITEM_CODE")
	private Item item;

	@Column(name = "REC_QTY", columnDefinition = "FLOAT(14,3)", nullable = true)
	private double recQty;

	@Column(name = "BILL_RATE", columnDefinition = "FLOAT(14,2)", nullable = true)
	private double rate;

	@Column(name = "RETURN_QTY", columnDefinition = "FLOAT(14,3)", nullable = true)
	private double rtQty;
	
	@ManyToOne
	@JoinColumn(name = "PURCHASE_SR_NO")
	private PurchaseReturn purchaseReturn;

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}



	public double getRecQty() {
		return recQty;
	}

	public void setRecQty(double recQty) {
		this.recQty = recQty;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRtQty() {
		return rtQty;
	}

	public void setRtQty(double rtQty) {
		this.rtQty = rtQty;
	}

	public PurchaseReturn getPurchaseReturn() {
		return purchaseReturn;
	}

	public void setPurchaseReturn(PurchaseReturn purchaseReturn) {
		this.purchaseReturn = purchaseReturn;
	}
	
	
	
	
	

	
}

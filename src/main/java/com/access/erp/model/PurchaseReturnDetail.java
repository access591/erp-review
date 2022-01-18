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
	private double eecQty;

	@Column(name = "BILL_RATE", columnDefinition = "FLOAT(14,2)", nullable = true)
	private double rate;

	@Column(name = "RETURN_QTY", columnDefinition = "FLOAT(14,3)", nullable = true)
	private double rtQty;

	
}

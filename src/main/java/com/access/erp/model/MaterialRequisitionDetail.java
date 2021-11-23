package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.UOM;

public class MaterialRequisitionDetail { 
	
	@Column(name="MATE_REQ_ID",length = 20)
	private String matReqDetId;
	
	
	@Column(name="REQUISITION_DATE")
	private Date requisitionDate;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE",nullable = false)
	private Item item;
	
	
	@ManyToOne
	@JoinColumn(name="UOM" , nullable = false)
	private UOM uom;
	
	@Column(name="QTY_REQUIRED",length = 12)
	private int qtyRequired;
	
	@ManyToOne
	@JoinColumn(name="CCODE",nullable = false)
	private Company company;
	
	@Column(name="SR_NO",length = 3)
	private String srNo;
	
	@Column(name="PEN_QTY",length = 12)
	private int penQty;
	
	@Column(name="QTY_PER_PAIR",length = 14)
	private int qtyPerpair;
	
	@Column(name="REQ_APP_STATUS",length = 10)
	private String reqAppStatus;
	
	@Column(name="REQUIRED_DATE")
	private Date requiredDate;
	
	@Column(name="QTY_APPROVED",length = 12)
	private int qtyApproved;
	
	@Column(name="REP_APP_STATUS",length = 9)
	private String repAppStatus;
	
	@Column(name="PURCHASE_TYPE",length = 9)
	private String purchaseType;
	
	@Column(name="PETTY_TYPE",length = 2)
	private String pettyType;
	
	@Column(name="ACTUAL_QTY",length = 14)
	private int actualQty;
	
	@Column(name="LOCKED_QTY",length = 14)
	private int lockedQty;
	
	
	@ManyToOne
	@JoinColumn(name="REQUISITION_NO")
	private MaterialRequisitionMaster materialRequisitionMaster;
	
	
	
	

}

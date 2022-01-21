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

import com.access.erp.model.master.Store;
import com.access.erp.model.master.UOM;

@Entity
@Table(name="ISSUE_DETAIL")
public class RejectionIssueDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REJECTIONDETAILID",length=30)
	private Long rejectionDetailId;
	
	
	@Column(name="ISS_NO")
	private String issNo;
	
	@Column(name="ISS_DATE")
	private String Date1;
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name = "ISSUE_NO",nullable = true)
	private RejectionIssue rejectionIssue;
	
	
	@Column(name = "QTY_REQ", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qtyReq;
	
	@Column(name = "QTY_ISS", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qtyIss;
	
	@Column(name="ISS_SEQ_NO",length=2)
	private String issSeqNo;
	
	@Column(name="ISS_RATE")
	private String issrate;
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name="UOM_CODE",nullable = true)
	private UOM uom;
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name="STORE_CODE",nullable = true)
	private Store store;
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name="TO_STORE",nullable = true)
    private Store store1;
	
	@Column(name="LOT_NO",length=20)
	private String lotNo;
	
	@Column(name="PRODUCT_CODE",length=15)
	private String productCode;
	
	@Column(name="DESIGN_CODE",length=9)
	private String designCode;
	
	@Column(name="ITEM_TYPE",length=1)
	private String itemType;
	

	@Column(name = "BULK_PEN_QTY", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double penQty;
	
	@Column(name="AL_ITEM_CODE",length=15)
	private String allitemCode;
	
	
	@Column(name="WIP_STOCK",length=1)
	private String wipStock;
	
	@Column(name="DOL",length=1)
	private String dol;
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}

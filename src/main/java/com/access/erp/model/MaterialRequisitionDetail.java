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

import com.access.erp.model.master.Company;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.UOM;

@Entity
@Table(name="MATERIAL_REQUISITION_DETAIL")
public class MaterialRequisitionDetail { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MATE_REQ_ID",length = 20)
	private Long matReqDetId;
	
	
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
	@JoinColumn(name="CCODE",nullable = true)
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


	public MaterialRequisitionDetail() {
		super();
		
	}


	public Long getMatReqDetId() {
		return matReqDetId;
	}


	public void setMatReqDetId(Long matReqDetId) {
		this.matReqDetId = matReqDetId;
	}


	public Date getRequisitionDate() {
		return requisitionDate;
	}


	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public UOM getUom() {
		return uom;
	}


	public void setUom(UOM uom) {
		this.uom = uom;
	}


	public int getQtyRequired() {
		return qtyRequired;
	}


	public void setQtyRequired(int qtyRequired) {
		this.qtyRequired = qtyRequired;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public String getSrNo() {
		return srNo;
	}


	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}


	public int getPenQty() {
		return penQty;
	}


	public void setPenQty(int penQty) {
		this.penQty = penQty;
	}


	public int getQtyPerpair() {
		return qtyPerpair;
	}


	public void setQtyPerpair(int qtyPerpair) {
		this.qtyPerpair = qtyPerpair;
	}


	public String getReqAppStatus() {
		return reqAppStatus;
	}


	public void setReqAppStatus(String reqAppStatus) {
		this.reqAppStatus = reqAppStatus;
	}


	public Date getRequiredDate() {
		return requiredDate;
	}


	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}


	public int getQtyApproved() {
		return qtyApproved;
	}


	public void setQtyApproved(int qtyApproved) {
		this.qtyApproved = qtyApproved;
	}


	public String getRepAppStatus() {
		return repAppStatus;
	}


	public void setRepAppStatus(String repAppStatus) {
		this.repAppStatus = repAppStatus;
	}


	public String getPurchaseType() {
		return purchaseType;
	}


	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}


	public String getPettyType() {
		return pettyType;
	}


	public void setPettyType(String pettyType) {
		this.pettyType = pettyType;
	}


	public int getActualQty() {
		return actualQty;
	}


	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}


	public int getLockedQty() {
		return lockedQty;
	}


	public void setLockedQty(int lockedQty) {
		this.lockedQty = lockedQty;
	}


	public MaterialRequisitionMaster getMaterialRequisitionMaster() {
		return materialRequisitionMaster;
	}


	public void setMaterialRequisitionMaster(MaterialRequisitionMaster materialRequisitionMaster) {
		this.materialRequisitionMaster = materialRequisitionMaster;
	}
	
	
	
	
	
	
	
	
	

}

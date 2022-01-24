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
import com.access.erp.model.master.Store;
import com.access.erp.model.master.UOM;

@Entity
@Table(name="REJECTION_ISSUE_DETAIL")
public class RejectionIssueDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REJECTIONDETAILID",length=30)
	private Long rejectionDetailId;
	
	
	@Column(name="ISS_NO")
	private String issNo;
	
	@Column(name="ISS_DATE")
	private String Date1;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_CODE")
	private Item item;

	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name = "ISSUE_NO",nullable = true)
	private RejectionIssue rejectionIssue;
	
	
	@Column(name = "QTY_REQ", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qtyReq;
	
	@Column(name = "QTY_ISS", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qtyIss;
	
	@Column(name="ISS_SEQ_NO",length=2)
	private String issSeqNo;
	
	@Column(name = "ISS_RATE", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double issrate;
	
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

	public Long getRejectionDetailId() {
		return rejectionDetailId;
	}

	public void setRejectionDetailId(Long rejectionDetailId) {
		this.rejectionDetailId = rejectionDetailId;
	}

	public String getIssNo() {
		return issNo;
	}

	public void setIssNo(String issNo) {
		this.issNo = issNo;
	}

	public String getDate1() {
		return Date1;
	}

	public void setDate1(String date1) {
		Date1 = date1;
	}

	public RejectionIssue getRejectionIssue() {
		return rejectionIssue;
	}

	public void setRejectionIssue(RejectionIssue rejectionIssue) {
		this.rejectionIssue = rejectionIssue;
	}

	public double getQtyReq() {
		return qtyReq;
	}

	public void setQtyReq(double qtyReq) {
		this.qtyReq = qtyReq;
	}

	public double getQtyIss() {
		return qtyIss;
	}

	public void setQtyIss(double qtyIss) {
		this.qtyIss = qtyIss;
	}

	public String getIssSeqNo() {
		return issSeqNo;
	}

	public void setIssSeqNo(String issSeqNo) {
		this.issSeqNo = issSeqNo;
	}

	

	public double getIssrate() {
		return issrate;
	}

	public void setIssrate(double issrate) {
		this.issrate = issrate;
	}

	public UOM getUom() {
		return uom;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Store getStore1() {
		return store1;
	}

	public void setStore1(Store store1) {
		this.store1 = store1;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public double getPenQty() {
		return penQty;
	}

	public void setPenQty(double penQty) {
		this.penQty = penQty;
	}

	public String getAllitemCode() {
		return allitemCode;
	}

	public void setAllitemCode(String allitemCode) {
		this.allitemCode = allitemCode;
	}

	public String getWipStock() {
		return wipStock;
	}

	public void setWipStock(String wipStock) {
		this.wipStock = wipStock;
	}

	public String getDol() {
		return dol;
	}

	public void setDol(String dol) {
		this.dol = dol;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}

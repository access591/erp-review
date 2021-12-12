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

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.access.erp.model.master.UOM;


@Entity
@Table(name="ISSUE_DETAIL")
public class IssueSlipDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ISSUE_SLIP_DETAIL",length = 30)
	private Long issueDetail;
		
	@ManyToOne
	@JoinColumn(name="STORE_CODE",nullable = true)
	private Store store;
	
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE",nullable = true)
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="UOM_CODE",nullable = true)
	private UOM uom;
	
	@Column(name="QTY_REQ",length = 12,nullable = true)
	private double qtyReq;
	
	@Column(name="QTY_ISS",length = 12,nullable = true)
	private double qtyIssue;
	
	@Column(name="QTY_ISS_CONV",length = 16,nullable = true)
	private String qtyIssueConv;
	
	@Column(name="ISS_SEQ_NO",length = 2,nullable = true)
	private int issueSeqNo;
	
	@Column(name="ISS_RATE",length = 15,nullable = true)
	private double issueRate;
	
	@Column(name="LOT_NO",length = 20)
	private String lotNo;
	
	
	
	@ManyToOne
	@JoinColumn(name="TO_STORE",nullable = true)
	private Store toStore;
	
	
	
	
	@Column(name="PRODUCT_CODE",length = 15)
	private String product;
	
	@Column(name="DESIGN_CODE",length = 15)
	private String design;
	
	@Column(name="ITEM_TYPE",length = 2)
	private String itemType;
	
	@Column(name="BULK_PEN_QTY",length = 12)
	private String bulkPenQty;
	
	@Column(name="AL_ITEM_CODE",length = 15)
	private String alItemCode;
	
	@Column(name="ITEM_CODE_ISSUE",length = 15)
	private String itemCodeIssue;
	
	
	
	@Column(name="ITEM_CODE_NEW",length = 50)
	private String itemCodeNew;
	
	@Column(name="WIP_STOCK",length = 2)
	private String wipStock;
	
	@Column(name="DOL",length = 2)
	private String dol;
	
	
	@ManyToOne
	@JoinColumn(name="ISS_NO",nullable = false)
	private IssueSlip issueSlip;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ISS_DATE",length = 15)
	private Date issueDate;

	public IssueSlipDetail() {
		super();
		
	}

	public Long getIssueDetail() {
		return issueDetail;
	}

	public void setIssueDetail(Long issueDetail) {
		this.issueDetail = issueDetail;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
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

	public double getQtyReq() {
		return qtyReq;
	}

	public void setQtyReq(double qtyReq) {
		this.qtyReq = qtyReq;
	}

	public double getQtyIssue() {
		return qtyIssue;
	}

	public void setQtyIssue(double qtyIssue) {
		this.qtyIssue = qtyIssue;
	}

	public String getQtyIssueConv() {
		return qtyIssueConv;
	}

	public void setQtyIssueConv(String qtyIssueConv) {
		this.qtyIssueConv = qtyIssueConv;
	}

	public int getIssueSeqNo() {
		return issueSeqNo;
	}

	public void setIssueSeqNo(int issueSeqNo) {
		this.issueSeqNo = issueSeqNo;
	}

	public double getIssueRate() {
		return issueRate;
	}

	public void setIssueRate(double issueRate) {
		this.issueRate = issueRate;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public Store getToStore() {
		return toStore;
	}

	public void setToStore(Store toStore) {
		this.toStore = toStore;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getBulkPenQty() {
		return bulkPenQty;
	}

	public void setBulkPenQty(String bulkPenQty) {
		this.bulkPenQty = bulkPenQty;
	}

	public String getAlItemCode() {
		return alItemCode;
	}

	public void setAlItemCode(String alItemCode) {
		this.alItemCode = alItemCode;
	}

	public String getItemCodeIssue() {
		return itemCodeIssue;
	}

	public void setItemCodeIssue(String itemCodeIssue) {
		this.itemCodeIssue = itemCodeIssue;
	}

	public String getItemCodeNew() {
		return itemCodeNew;
	}

	public void setItemCodeNew(String itemCodeNew) {
		this.itemCodeNew = itemCodeNew;
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

	public IssueSlip getIssueSlip() {
		return issueSlip;
	}

	public void setIssueSlip(IssueSlip issueSlip) {
		this.issueSlip = issueSlip;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	

		

}

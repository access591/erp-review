package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="ISSUE_SLIP_DETAIL",length = 30)
	private Long issueDetail;
		
	@ManyToOne
	@JoinColumn(name="STORE_CODE",nullable = false)
	private Store store;
	
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE",nullable = false)
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="UOM_CODE",nullable = false)
	private UOM uom;
	
	@Column(name="QTY_REQ",length = 12)
	private int qtyReq;
	
	@Column(name="QTY_ISS",length = 12)
	private int qtyIssue;
	
	@Column(name="QTY_ISS_CONV",length = 16)
	private String qtyIssueConv;
	
	@Column(name="ISS_SEQ_NO",length = 2)
	private int issueSeqNo;
	
	@Column(name="ISS_RATE",length = 15)
	private int issueRate;
	
	@Column(name="LOT_NO",length = 20)
	private String lotNo;
	
	
	
	@ManyToOne
	@JoinColumn(name="TO_STORE",nullable = false)
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQtyReq() {
		return qtyReq;
	}

	public void setQtyReq(int qtyReq) {
		this.qtyReq = qtyReq;
	}

	public int getQtyIssue() {
		return qtyIssue;
	}

	public void setQtyIssue(int qtyIssue) {
		this.qtyIssue = qtyIssue;
	}

	public int getIssueSeqNo() {
		return issueSeqNo;
	}

	public void setIssueSeqNo(int issueSeqNo) {
		this.issueSeqNo = issueSeqNo;
	}

	public int getIssueRate() {
		return issueRate;
	}

	public void setIssueRate(int issueRate) {
		this.issueRate = issueRate;
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

	public Store getToStore() {
		return toStore;
	}

	public void setToStore(Store toStore) {
		this.toStore = toStore;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
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

	public String getQtyIssueConv() {
		return qtyIssueConv;
	}

	public void setQtyIssueConv(String qtyIssueConv) {
		this.qtyIssueConv = qtyIssueConv;
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

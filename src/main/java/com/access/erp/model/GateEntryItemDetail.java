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
import com.access.erp.model.master.UOM;


@Entity
@Table(name="GATE_ENTRY_ITEM_DETAIL")
public class GateEntryItemDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GATE_ENTRY_DETAIL_ID",length = 30)
	private Long gateEntryDetailId;
	
	
	@JoinColumn(name="ITEM_CODE")
	@ManyToOne
	private Item item;
	
	@Column(name="ITEM_DESCRIPTION",length=100)
	private String itemDescription;
	
	@Column(name="QTY",length=18)
	private int qty;
	
	
	
	
	@Column(name="GATE_SEQ_NO",length=2)
	private int gateSeqNo;
	
	@JoinColumn(name="ORDER_NO")
	@ManyToOne
	private PurchaseOrder purchaseOrder;
	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	@Column(name="PENDING_QTY",length=12)
	private int pendingQty;
	
	@Column(name="NET_QTY",length=14)
	private int netQty;
	
	@Column(name="UOM_CODE",length=50)
	private String uom;
	
	
	
	@Column(name="QTY_TRY",length=14)
	private int qtyTrp;
	
	@Column(name="UOM_QTY_TRP",length=6)
	private String uomQtyTrp;
	
	@Column(name="QTY_WO_TRP",length=14)
	private int qtyWoTrp;
	
	@Column(name="UOM_QTY_WO_TRP",length=6)
	private String uomQtyWoTrp;
	

	
	@Column(name="UOM_NET_QTY",length=6)
	private String uomNetQty;
	
	@Column(name="SORTAGE_QTY_ACC",length=14)
	private int sortageQtyAcc;

	@Column(name="GROSS_QTY",length=14)
	private int grossQty;
	
	@Column(name="DEDUCTION_PERC",length=6)
	private int deductionPerc;
	
	@Column(name="ACTUAL_QTY",length=14)
	private int actualQty;
	
	@Column(name="DED_MOISTURE",length=20)
	private String dedMoisture;
	
	@Column(name="SHORT_QTY_UOM)",length=20)
	private String shortQtyUom;
	
	@Column(name="ACTUAL_DEDUCTION",length=5)
	private int actualDeduction;
	
	@Column(name="REBATE_ON_PUTRITY",length=5)
	private String rebateOnPurity;
	
	@Column(name="RECIEVED_QTY",length=12)
	private int recievedQty;
	
	@Column(name="ITEM_STATUS",length=2)
	private char itemStatus;
	
	@Column(name="CHK_STATUS",length=2)
	private String chkStatus;
	
	@Column(name="DED_DUST",length=5)
	private int dedDust;
	
	
	
	@Column(name="ITEM_STATUS_NW",length=2)
	private char itemStatusNw;
	
	@Column(name="CHK_STATUS_NW",length=2)
	private char chkStatusnw;
	
	@Column(name="SCH_NO",length=15)
	private char schNo;
	
	@Column(name="SCH_DATE")
	private Date schDate;
	
	@Column(name="INCOMINGS_SR_NO",length=20)
	private String incomingSrNo;
	
	@Column(name="CLAIM_SR_NO",length=20)
	private String claimSrNo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "GATE_SR_NO")
	private GateEntry gateEntry;
	
	@Column(name="GATE_ENTRY_DATE")
	private Date gateEntryDate;

	public GateEntryItemDetail() {
		super();
		
	}

	

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
	public String getUom() {
		return uom;
	}



	public void setUom(String uom) {
		this.uom = uom;
	}



	public int getGateSeqNo() {
		return gateSeqNo;
	}

	public void setGateSeqNo(int gateSeqNo) {
		this.gateSeqNo = gateSeqNo;
	}

	

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQtyTrp() {
		return qtyTrp;
	}

	public void setQtyTrp(int qtyTrp) {
		this.qtyTrp = qtyTrp;
	}

	public String getUomQtyTrp() {
		return uomQtyTrp;
	}

	public void setUomQtyTrp(String uomQtyTrp) {
		this.uomQtyTrp = uomQtyTrp;
	}

	public int getQtyWoTrp() {
		return qtyWoTrp;
	}

	public void setQtyWoTrp(int qtyWoTrp) {
		this.qtyWoTrp = qtyWoTrp;
	}

	public String getUomQtyWoTrp() {
		return uomQtyWoTrp;
	}

	public void setUomQtyWoTrp(String uomQtyWoTrp) {
		this.uomQtyWoTrp = uomQtyWoTrp;
	}

	public int getNetQty() {
		return netQty;
	}

	public void setNetQty(int netQty) {
		this.netQty = netQty;
	}

	public String getUomNetQty() {
		return uomNetQty;
	}

	public void setUomNetQty(String uomNetQty) {
		this.uomNetQty = uomNetQty;
	}

	public int getSortageQtyAcc() {
		return sortageQtyAcc;
	}

	public void setSortageQtyAcc(int sortageQtyAcc) {
		this.sortageQtyAcc = sortageQtyAcc;
	}

	public int getGrossQty() {
		return grossQty;
	}

	public void setGrossQty(int grossQty) {
		this.grossQty = grossQty;
	}

	public int getDeductionPerc() {
		return deductionPerc;
	}

	public void setDeductionPerc(int deductionPerc) {
		this.deductionPerc = deductionPerc;
	}

	public int getActualQty() {
		return actualQty;
	}

	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}

	public String getDedMoisture() {
		return dedMoisture;
	}

	public void setDedMoisture(String dedMoisture) {
		this.dedMoisture = dedMoisture;
	}

	public String getShortQtyUom() {
		return shortQtyUom;
	}

	public void setShortQtyUom(String shortQtyUom) {
		this.shortQtyUom = shortQtyUom;
	}

	public int getActualDeduction() {
		return actualDeduction;
	}

	public void setActualDeduction(int actualDeduction) {
		this.actualDeduction = actualDeduction;
	}

	public String getRebateOnPurity() {
		return rebateOnPurity;
	}

	public void setRebateOnPurity(String rebateOnPurity) {
		this.rebateOnPurity = rebateOnPurity;
	}

	public int getRecievedQty() {
		return recievedQty;
	}

	public void setRecievedQty(int recievedQty) {
		this.recievedQty = recievedQty;
	}

	public char getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(char itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getChkStatus() {
		return chkStatus;
	}

	public void setChkStatus(String chkStatus) {
		this.chkStatus = chkStatus;
	}

	public int getDedDust() {
		return dedDust;
	}

	public void setDedDust(int dedDust) {
		this.dedDust = dedDust;
	}

	public int getPendingQty() {
		return pendingQty;
	}

	public void setPendingQty(int pendingQty) {
		this.pendingQty = pendingQty;
	}

	public char getItemStatusNw() {
		return itemStatusNw;
	}

	public void setItemStatusNw(char itemStatusNw) {
		this.itemStatusNw = itemStatusNw;
	}

	public char getChkStatusnw() {
		return chkStatusnw;
	}

	public void setChkStatusnw(char chkStatusnw) {
		this.chkStatusnw = chkStatusnw;
	}

	public char getSchNo() {
		return schNo;
	}

	public void setSchNo(char schNo) {
		this.schNo = schNo;
	}

	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public String getIncomingSrNo() {
		return incomingSrNo;
	}

	public void setIncomingSrNo(String incomingSrNo) {
		this.incomingSrNo = incomingSrNo;
	}

	public String getClaimSrNo() {
		return claimSrNo;
	}

	public void setClaimSrNo(String claimSrNo) {
		this.claimSrNo = claimSrNo;
	}

	public GateEntry getGateEntry() {
		return gateEntry;
	}

	public void setGateEntry(GateEntry gateEntry) {
		this.gateEntry = gateEntry;
	}

	public Date getGateEntryDate() {
		return gateEntryDate;
	}

	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}



	public Long getGateEntryDetailId() {
		return gateEntryDetailId;
	}



	public void setGateEntryDetailId(Long gateEntryDetailId) {
		this.gateEntryDetailId = gateEntryDetailId;
	}



	public Item getItem() {
		return item;
	}



	public void setItem(Item item) {
		this.item = item;
	}



	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}



	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	
	
	
	
	
	
	
	
}

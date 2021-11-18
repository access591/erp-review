package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;


@Entity
@Table(name="INSPECTION_ITEM")
public class MrnInspectionItemDetail {
	
	
	@Id
	@Column(name="INSP_ITEM_NO",length = 20)
	private String inspItemNo;
	
	@Column(name="REP_OUT_NO",length = 20)
	private String repOutNo;
	
	@Column(name="REP_OUT_DATE")
	private Date repOutDate;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private Item item;
	
	@Column(name="MRN_RATE",length = 12)
	private int mrnRate;
	
	@Column(name="QTY_REJECTED",length = 12)
	private int qtyRejected;
	
	@Column(name="INSPECTED_QTY",length = 15)
	private int inspectedQty;
	
	@Column(name="QTY_PENDING",length = 12)
	private int qtyPending;
	
	@Column(name="INSP_STATUS",length = 2)
	private String inspStatus;
	
	@Column(name="QTY_ACCEPT_DEV",length = 12)
	private int qtyAcceptDev;
	
	@Column(name="QTY_ACCEPT_DEV_RATE",length = 12)
	private int qtyAcceptDevRate;
	
	@Column(name="QTY_UD",length = 12)
	private int qtyUd;
	
	@Column(name="ITEM_REC1",length = 12)
	private int itemRec1;
	
	
	@Column(name="INSP_DATE")
	private Date inspDate;
	
	@Column(name="INSP_SEQ_NO",length = 3)
	private int inspSeqNo;
	
	
	
	
	
	@Column(name="REJECTION_REMARKS",length = 500)
	private String rejectionRemarks;
	
	
	
	@Column(name="LOT_TYPE",length = 2)
	private String lotType;
	
	@Column(name="VISUAL_NO",length = 12)
	private int visualNo;
	
	@Column(name="DIMENSION_NO",length = 12)
	private int dimensionNo;
	
	@Column(name="TESTING_NO",length = 12)
	private int testingNo;
	
	
	
	@Column(name="QTY_ACCEPT_REW",length = 12)
	private int qtyAcceptRew;
	
	@Column(name="PAN_NO",length = 20)
	private String panNo;
	
	@Column(name="PO_DATE")
	private Date poDate;
	
	
	

	
	
	
	
	@Column(name="DEF_VISUAL_NO",length = 12)
	private int defVisualNo;
	
	@Column(name="DEF_DIMENSION_NO",length = 12)
	private int defDimensionNo;
	
	@Column(name="DEF_TESTING_NO",length = 12)
	private int defTestingNo;
	
	@Column(name="MANUFACTURING_DATE")
	private Date manufacturingDate;
	
	
	
	
	
	@Column(name="SAMPLE_SIZE",length = 12)
	private int sampleSize;
	
	
	
	
	@Column(name="INSP_LOT_STATUS",length = 2)
	private String inspLotStatus;
	
	
	
	
	
	@Column(name="ACC_INSP_QTY",length = 12)
	private int accInspQty;
	
	@Column(name="QTY_REJECTED1",length = 12)
	private int qtyRejected1;
	
	@Column(name="SEG_COST",length = 14)
	private int segCost;
	
	@Column(name="REC_COST",length = 14)
	private int recCost;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "INSP_NO")
	private MrnInspection mrnInspection;


	public MrnInspectionItemDetail() {
		super();
		
	}


	public String getInspItemNo() {
		return inspItemNo;
	}


	public void setInspItemNo(String inspItemNo) {
		this.inspItemNo = inspItemNo;
	}


	public String getRepOutNo() {
		return repOutNo;
	}


	public void setRepOutNo(String repOutNo) {
		this.repOutNo = repOutNo;
	}


	public Date getRepOutDate() {
		return repOutDate;
	}


	public void setRepOutDate(Date repOutDate) {
		this.repOutDate = repOutDate;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public int getMrnRate() {
		return mrnRate;
	}


	public void setMrnRate(int mrnRate) {
		this.mrnRate = mrnRate;
	}


	public int getQtyRejected() {
		return qtyRejected;
	}


	public void setQtyRejected(int qtyRejected) {
		this.qtyRejected = qtyRejected;
	}


	public int getInspectedQty() {
		return inspectedQty;
	}


	public void setInspectedQty(int inspectedQty) {
		this.inspectedQty = inspectedQty;
	}


	public int getQtyPending() {
		return qtyPending;
	}


	public void setQtyPending(int qtyPending) {
		this.qtyPending = qtyPending;
	}


	public String getInspStatus() {
		return inspStatus;
	}


	public void setInspStatus(String inspStatus) {
		this.inspStatus = inspStatus;
	}


	public int getQtyAcceptDev() {
		return qtyAcceptDev;
	}


	public void setQtyAcceptDev(int qtyAcceptDev) {
		this.qtyAcceptDev = qtyAcceptDev;
	}


	public int getQtyAcceptDevRate() {
		return qtyAcceptDevRate;
	}


	public void setQtyAcceptDevRate(int qtyAcceptDevRate) {
		this.qtyAcceptDevRate = qtyAcceptDevRate;
	}


	public int getQtyUd() {
		return qtyUd;
	}


	public void setQtyUd(int qtyUd) {
		this.qtyUd = qtyUd;
	}


	public int getItemRec1() {
		return itemRec1;
	}


	public void setItemRec1(int itemRec1) {
		this.itemRec1 = itemRec1;
	}


	public Date getInspDate() {
		return inspDate;
	}


	public void setInspDate(Date inspDate) {
		this.inspDate = inspDate;
	}


	public int getInspSeqNo() {
		return inspSeqNo;
	}


	public void setInspSeqNo(int inspSeqNo) {
		this.inspSeqNo = inspSeqNo;
	}


	public String getRejectionRemarks() {
		return rejectionRemarks;
	}


	public void setRejectionRemarks(String rejectionRemarks) {
		this.rejectionRemarks = rejectionRemarks;
	}


	public String getLotType() {
		return lotType;
	}


	public void setLotType(String lotType) {
		this.lotType = lotType;
	}


	public int getVisualNo() {
		return visualNo;
	}


	public void setVisualNo(int visualNo) {
		this.visualNo = visualNo;
	}


	public int getDimensionNo() {
		return dimensionNo;
	}


	public void setDimensionNo(int dimensionNo) {
		this.dimensionNo = dimensionNo;
	}


	public int getTestingNo() {
		return testingNo;
	}


	public void setTestingNo(int testingNo) {
		this.testingNo = testingNo;
	}


	public int getQtyAcceptRew() {
		return qtyAcceptRew;
	}


	public void setQtyAcceptRew(int qtyAcceptRew) {
		this.qtyAcceptRew = qtyAcceptRew;
	}


	public String getPanNo() {
		return panNo;
	}


	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}


	public Date getPoDate() {
		return poDate;
	}


	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}


	public int getDefVisualNo() {
		return defVisualNo;
	}


	public void setDefVisualNo(int defVisualNo) {
		this.defVisualNo = defVisualNo;
	}


	public int getDefDimensionNo() {
		return defDimensionNo;
	}


	public void setDefDimensionNo(int defDimensionNo) {
		this.defDimensionNo = defDimensionNo;
	}


	public int getDefTestingNo() {
		return defTestingNo;
	}


	public void setDefTestingNo(int defTestingNo) {
		this.defTestingNo = defTestingNo;
	}


	public Date getManufacturingDate() {
		return manufacturingDate;
	}


	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}


	public int getSampleSize() {
		return sampleSize;
	}


	public void setSampleSize(int sampleSize) {
		this.sampleSize = sampleSize;
	}


	public String getInspLotStatus() {
		return inspLotStatus;
	}


	public void setInspLotStatus(String inspLotStatus) {
		this.inspLotStatus = inspLotStatus;
	}


	public int getAccInspQty() {
		return accInspQty;
	}


	public void setAccInspQty(int accInspQty) {
		this.accInspQty = accInspQty;
	}


	public int getQtyRejected1() {
		return qtyRejected1;
	}


	public void setQtyRejected1(int qtyRejected1) {
		this.qtyRejected1 = qtyRejected1;
	}


	public int getSegCost() {
		return segCost;
	}


	public void setSegCost(int segCost) {
		this.segCost = segCost;
	}


	public int getRecCost() {
		return recCost;
	}


	public void setRecCost(int recCost) {
		this.recCost = recCost;
	}


	public MrnInspection getMrnInspection() {
		return mrnInspection;
	}


	public void setMrnInspection(MrnInspection mrnInspection) {
		this.mrnInspection = mrnInspection;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

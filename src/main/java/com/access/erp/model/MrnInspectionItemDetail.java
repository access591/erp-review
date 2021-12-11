package com.access.erp.model;

import java.util.Date;

import javax.annotation.Generated;
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
@Table(name="INSPECTION_ITEM")
public class MrnInspectionItemDetail {
	
	
	@Id
	@Column(name="INSP_ITEM_NO",length = 20)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inspItemNo;
	
	@Column(name="REP_OUT_NO",length = 20)
	private String repOutNo;
	
	@Column(name="REP_OUT_DATE")
	private Date repOutDate;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private Item item;
	
	@Column(name="MRN_RATE",length = 12)
	private double mrnRate;
	
	@Column(name="QTY_REJECTED",length = 12)
	private double qtyRejected;
	
	@Column(name="INSPECTED_QTY",length = 15)
	private double inspectedQty;
	
	@Column(name="QTY_PENDING",length = 12)
	private double qtyPending;
	
	@Column(name="INSP_STATUS",length = 2)
	private String inspStatus;
	
	@Column(name="QTY_ACCEPT_DEV",length = 12)
	private double qtyAcceptDev;
	
	@Column(name="QTY_ACCEPT_DEV_RATE",length = 12)
	private double qtyAcceptDevRate;
	
	@Column(name="QTY_UD",length = 12)
	private double qtyUd;
	
	@Column(name="ITEM_REC1",length = 12)
	private double itemRec1;
	
	
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
	private double qtyAcceptRew;
	
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
	private double accInspQty;
	
	@Column(name="QTY_REJECTED1",length = 12)
	private double qtyRejected1;
	
	@Column(name="SEG_COST",length = 14)
	private double segCost;
	
	@Column(name="REC_COST",length = 14)
	private double recCost;
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "INSP_NO")
	private MrnInspection mrnInspection;


	public MrnInspectionItemDetail() {
		super();
		
	}


	


	public Long getInspItemNo() {
		return inspItemNo;
	}





	public void setInspItemNo(Long inspItemNo) {
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


	public double getMrnRate() {
		return mrnRate;
	}


	public void setMrnRate(double mrnRate) {
		this.mrnRate = mrnRate;
	}


	public double getQtyRejected() {
		return qtyRejected;
	}


	public void setQtyRejected(double qtyRejected) {
		this.qtyRejected = qtyRejected;
	}


	public double getInspectedQty() {
		return inspectedQty;
	}


	public void setInspectedQty(double inspectedQty) {
		this.inspectedQty = inspectedQty;
	}


	public double getQtyPending() {
		return qtyPending;
	}


	public void setQtyPending(double qtyPending) {
		this.qtyPending = qtyPending;
	}


	public String getInspStatus() {
		return inspStatus;
	}


	public void setInspStatus(String inspStatus) {
		this.inspStatus = inspStatus;
	}


	public double getQtyAcceptDev() {
		return qtyAcceptDev;
	}


	public void setQtyAcceptDev(double qtyAcceptDev) {
		this.qtyAcceptDev = qtyAcceptDev;
	}


	public double getQtyAcceptDevRate() {
		return qtyAcceptDevRate;
	}


	public void setQtyAcceptDevRate(double qtyAcceptDevRate) {
		this.qtyAcceptDevRate = qtyAcceptDevRate;
	}


	public double getQtyUd() {
		return qtyUd;
	}


	public void setQtyUd(double qtyUd) {
		this.qtyUd = qtyUd;
	}


	public double getItemRec1() {
		return itemRec1;
	}


	public void setItemRec1(double itemRec1) {
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


	public double getQtyAcceptRew() {
		return qtyAcceptRew;
	}


	public void setQtyAcceptRew(double qtyAcceptRew) {
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


	public double getAccInspQty() {
		return accInspQty;
	}


	public void setAccInspQty(double accInspQty) {
		this.accInspQty = accInspQty;
	}


	public double getQtyRejected1() {
		return qtyRejected1;
	}


	public void setQtyRejected1(double qtyRejected1) {
		this.qtyRejected1 = qtyRejected1;
	}


	public double getSegCost() {
		return segCost;
	}


	public void setSegCost(double segCost) {
		this.segCost = segCost;
	}


	public double getRecCost() {
		return recCost;
	}


	public void setRecCost(double recCost) {
		this.recCost = recCost;
	}


	public MrnInspection getMrnInspection() {
		return mrnInspection;
	}


	public void setMrnInspection(MrnInspection mrnInspection) {
		this.mrnInspection = mrnInspection;
	}

	
}

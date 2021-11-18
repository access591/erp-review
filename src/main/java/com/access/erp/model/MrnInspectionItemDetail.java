package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.access.erp.model.master.Item;

public class MrnInspectionItemDetail {
	
	
	@Column(name="INSP_ITEM_NO",length = 20)
	private String inspItemNo;
	
	
	@Column(name="INSP_NO",length = 15)
	private String inspNo;
	
	@Column(name="INSP_DATE")
	private Date inspDate;
	
	@Column(name="INSP_SEQ_NO",length = 3)
	private int inspSeqNo;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private Item item;
	
	@Column(name="QTY_REJECTED",length = 12)
	private int qtyRejected;
	
	@Column(name="REJECTION_REMARKS",length = 500)
	private String rejectionRemarks;
	
	@Column(name="QTY_PENDING",length = 12)
	private int qtyPending;
	
	@Column(name="LOT_TYPE",length = 2)
	private String lotType;
	
	@Column(name="VISUAL_NO",length = 12)
	private int visualNo;
	
	@Column(name="DIMENSION_NO",length = 12)
	private int dimensionNo;
	
	@Column(name="TESTING_NO",length = 12)
	private int testingNo;
	
	@Column(name="QTY_ACCEPT_DEV",length = 12)
	private int qtyAcceptDev;
	
	@Column(name="QTY_ACCEPT_REW",length = 12)
	private int qtyAcceptRew;
	
	@Column(name="PAN_NO",length = 20)
	private String panNo;
	
	@Column(name="PO_DATE")
	private Date poDate;
	
	
	
	@Column(name="REP_OUT_NO",length = 20)
	private String repOutNo;
	
	@Column(name="REP_OUT_DATE")
	private Date repOutDate;
	
	@Column(name="INSPECTED_QTY",length = 15)
	private int inspectedQty;
	
	
	@Column(name="DEF_VISUAL_NO",length = 12)
	private int defVisualNo;
	
	@Column(name="DEF_DIMENSION_NO",length = 12)
	private int defDimensionNo;
	
	@Column(name="DEF_TESTING_NO",length = 12)
	private int defTestingNo;
	
	@Column(name="MANUFACTURING_DATE")
	private Date manufacturingDate;
	
	@Column(name="QTY_ACCEPT_DEV_RATE",length = 12)
	private int qtyAcceptDevRate;
	
	@Column(name="MRN_RATE",length = 12)
	private int mrnRate;
	
	@Column(name="SAMPLE_SIZE",length = 12)
	private int sampleSize;
	
	
	@Column(name="INSP_STATUS",length = 2)
	private String inspStatus;
	
	@Column(name="INSP_LOT_STATUS",length = 2)
	private String inspLotStatus;
	
	@Column(name="ITEM_REC1",length = 12)
	private int itemRec1;
	
	@Column(name="QTY_UD",length = 12)
	private int qtyUd;
	
	@Column(name="ACC_INSP_QTY",length = 12)
	private int accInspQty;
	
	@Column(name="QTY_REJECTED1",length = 12)
	private int qtyRejected1;
	
	@Column(name="SEG_COST",length = 14)
	private int segCost;
	
	@Column(name="REC_COST",length = 14)
	private int recCost;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

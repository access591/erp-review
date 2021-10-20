package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.SupplierMaster;

public class PurchaseOrder {

	@Column(name="PO_NO",length = 50)
	private String poNumber;
	
	@Column(name="PO_DATE")
	private Date poDate;
	
	@ManyToOne
	@JoinColumn(name="SUPP_CODE")
	private SupplierMaster supplier;
	
	@ManyToOne
	@JoinColumn(name="QUOT_NO")
	private QuotationDetail quotationDetail;
	
	@Column(name="QUOT_DATE")
	private Date quotationDate;
	
	@Column(name="SUPPLY_DATE")
	private Date supplyDate;
	
	@Column(name="TOTAL_VALUE",length = 10)
	private String totalValue;
	
	@Column(name="RECD_DATE",length = 50)
	private Date recdDate;
	
	@Column(name="WORKER_CODE",length = 50)
	private String workerCode;
	
	@Column(name="REMARKS",length = 100)
	private String remarks;
	
	@Column(name="CANC_STATUS",length = 8)
	private String cancStatus;
	
	@Column(name="EXCISE",length = 6)
	private int excise;
	
	@Column(name="SALES_TAX",length = 8)
	private String salesTax;
	
	@Column(name="CST",length = 8)
	private String cst;
	
	@Column(name="TRADE_DISCOUNT",length = 8)
	private int tradeDiscount;
	
	@Column(name="SURCHARGE",length = 8)
	private int surCharge;
	
	@Column(name="FREIGHT",length = 10)
	private int freight;
	
	@Column(name="PO_BASED_VAL",length = 10)
	private int poBasedVal;
	
	@Column(name="OCTROI",length = 10)
	private int octroi;
	
	@Column(name="DISCOUNT",length = 10)
	private int discount;
	
	@Column(name="AMEND_NO",length = 10)
	private int amendNo;
	
	@Column(name="AMEND_DATE")
	private Date amendDate;
	
	@Column(name="CCODE",length = 50)
	private String cCode;
	
	@Column(name="FYCODE",length = 50)
	private String fyCode;
	
	@Column(name="UCODE",length = 50)
	private String uCode;
	
	@Column(name="UDATE",length = 50)
	private Date uDate;
	
	@Column(name="CESS",length = 50)
	private Date cess;
	
	@Column(name="CONDITION1",length = 250)
	private String condition1;
	
	@Column(name="CONDITION2",length = 250)
	private String condition2;
	
	@Column(name="CONDITION3",length = 250)
	private String condition3;
	
	@Column(name="VAT",length = 10)
	private String vat;
	
	@Column(name="CONDITION_T1",length = 250)
	private String conditionT1;
	
	@Column(name="CONDITION_T2",length = 50)
	private String conditionT2;
	
	@Column(name="PRODUCTION_UNDER",length = 50)
	private String productionUnder;
	
	@Column(name="CARTAGE",length = 50)
	private int cartage;
	
	@Column(name="PO_TYPE",length = 10)
	private String poType;
	
	@Column(name="CAPITALYN",length = 10)
	private String capitalYn;
	
	@Column(name="I_ADDR",length = 150)
	private String iAddr;
	
	@Column(name="CFORM_YN",length = 10)
	private String cFormYn;
	
	@Column(name="SUB_PO_TYPE",length = 10)
	private String subPoType;
	
	@JoinColumn(name="CURRENCY_CODE")
	@ManyToOne
	private CurrencyMaster currency;
	
	@Column(name="CONVERSION_VALUE",length = 50)
	private String poDate;
	
	@Column(name="PO_CAP_TYPE",length = 50)
	private String poDate;
	
	@Column(name="CONDITION4",length = 50)
	private String poDate;
	
	@Column(name="CONDITION5",length = 50)
	private String poDate;
	
	@Column(name="CONDITION6",length = 50)
	private String poDate;
	
	@Column(name="CONDITION7",length = 50)
	private String poDate;
	
	@Column(name="CONDITION8",length = 50)
	private String poDate;
	
	@Column(name=" CONDITION9",length = 50)
	private String poNumber;
	
	@Column(name=" CONDITION10",length = 50)
	private String poDate;
	
	@Column(name=" CONDITION9",length = 50)
	private String poDate;
	
	@Column(name=" CONDITION9",length = 50)
	private String poDate;
	
	@Column(name="CONDITION9",length = 50)
	private String poDate;
	
	@Column(name="CONDITION9",length = 50)
	private String poDate;
	
	@Column(name="CONDITION9",length = 50)
	private String poDate;
	
	@Column(name="CONDITION9",length = 50)
	private String poDate;
	
	@Column(name="FORM_CODE",length = 50)
	private String poDate;
	
	@Column(name="FORM_NO",length = 50)
	private String poDate;
	
	@Column(name="FORM_DATE",length = 50)
	private String poDate;
	
	@Column(name="EXCISEABLE",length = 50)
	private String poDate;
	
	@Column(name="CONTACT_PERSON",length = 50)
	private String poNumber;
	
	@Column(name="OPEN_NO",length = 50)
	private String poDate;
	
	@Column(name="ACODE",length = 50)
	private String poDate;
	
	@Column(name="ANAME",length = 50)
	private String poDate;
	
	@Column(name="OPEN_PO",length = 50)
	private String poDate;
	
	@Column(name="APPROVAL_STATUS",length = 50)
	private String poDate;
	
	@Column(name="REMARK",length = 50)
	private String poDate;
	
	@Column(name="PO_REMARKS",length = 50)
	private String poDate;
	
	@Column(name="AMEND_REMARKS2",length = 50)
	private String poDate;
	
	@Column(name="PO_CATEGORY",length = 50)
	private String poDate;
	
	@Column(name="DELIVERY_DATE",length = 50)
	private String poDate;
	
	@Column(name="NATURE",length = 50)
	private String poDate;
	
	@Column(name="PO_REMARK",length = 50)
	private String poNumber;
	
	@Column(name="APPROVAL_DATE",length = 50)
	private String poDate;
	
	@Column(name="FRM_NO",length = 50)
	private String poDate;
	
	@Column(name="FRM_DT",length = 50)
	private String poDate;
	
	@Column(name="NATURE_OF_PUR",length = 50)
	private String poDate;
	
	@Column(name="PRICE_TYPE",length = 50)
	private String poDate;
	
	@Column(name="FOR_AMT",length = 50)
	private String poDate;
	
	@Column(name="ADV_PER",length = 50)
	private String poDate;
	
	@Column(name="ADV_VALUE",length = 50)
	private String poDate;
	
	@Column(name="PENALTY_PER",length = 50)
	private String poDate;
	
	@Column(name="PENALTY_VALUE",length = 50)
	private String poDate;
	
	@Column(name="SCH_REQ_YN",length = 50)
	private String poDate;
	
	@Column(name="PO_FOR",length = 50)
	private String poNumber;
	
	@Column(name="PO_BASED",length = 50)
	private String poDate;
	
	@Column(name="INSURANCE_SCOPE",length = 50)
	private String poDate;
	
	@Column(name="SPEC_DISC_PER",length = 50)
	private String poDate;
	
	@Column(name="SPEC_DISC_VALUE",length = 50)
	private String poDate;
	
	@Column(name="CASH_DISC_PER",length = 50)
	private String poDate;
	
	@Column(name="CASH_DISC_VALUE",length = 50)
	private String poDate;
	
	@Column(name="SPEC_DUTY_PER",length = 50)
	private String poDate;
	
	@Column(name="SPEC_DUTY_VALUE",length = 50)
	private String poDate;
	
	@Column(name="LANDING_PER",length = 50)
	private String poDate;
	
	@Column(name="LANDING_VALUE",length = 50)
	private String poDate;
	
	@Column(name="NET_MODVAT_VALUE",length = 50)
	private String poDate;
	
	@Column(name="PACKING",length = 50)
	private String poNumber;
	
	@Column(name="COMP_STMT",length = 50)
	private String poDate;
	
	@Column(name="APPROVAL_ATTACH",length = 50)
	private String poDate;
	
	@Column(name="ORDER_LOW",length = 50)
	private String poDate;
	
	@Column(name="REMARKS_LOW",length = 50)
	private String poDate;
	
	@Column(name="INSP_REMARKS",length = 50)
	private String poDate;
	
	@Column(name="TIME_BASE_DT",length = 50)
	private String poDate;
	
	@Column(name="WARRANTY_START_DT",length = 50)
	private String poDate;
	
	@Column(name="WARRANTY_END_DT",length = 50)
	private String poDate;
	
	@Column(name="PO_TYPE_CODE",length = 50)
	private String poDate;
	
	@Column(name="CONDITION_NOTE",length = 50)
	private String poDate;
	
	@Column(name="BSR_CODE",length = 50)
	private String poDate;
	
	@Column(name="BSR_YN",length = 50)
	private String poNumber;
	
	@Column(name="NOTE1",length = 50)
	private String poDate;
	
	@Column(name="NOTE2",length = 50)
	private String poDate;
	
	@Column(name="NOTE2",length = 50)
	private String poDate;
	
	@Column(name="NOTE2",length = 50)
	private String poDate;
	
	@Column(name="CANCEL_DATE",length = 50)
	private String poDate;
	
	@Column(name="CANCEL_BY",length = 50)
	private String poDate;
	
	@Column(name="DOCUMENT_PATH",length = 50)
	private String poDate;
	
	@Column(name="DOC_FILE",length = 50)
	private String poDate;
	
	@Column(name="REPEAT_ORDER_NO",length = 50)
	private String poDate;
	
	@Column(name="REPEAT_ORDER_DATE",length = 50)
	private String poDate;
	
	@Column(name="INACC_CODE",length = 50)
	private String poDate;
	
	@Column(name="APPROVAL_SOURCE",length = 50)
	private String poNumber;
	
	
	
	
	
	
}

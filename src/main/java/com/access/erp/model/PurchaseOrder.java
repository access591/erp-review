/*
 * package com.access.erp.model;
 * 
 * import java.util.Date;
 * 
 * import javax.persistence.Column; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne;
 * 
 * import com.access.erp.model.master.CurrencyMaster; import
 * com.access.erp.model.master.SupplierMaster;
 * 
 * public class PurchaseOrder {
 * 
 * @Column(name = "PO_NO", length = 50) private String poNumber;
 * 
 * @Column(name = "PO_DATE") private Date poDate;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "SUPP_CODE") private SupplierMaster supplier;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "QUOT_NO") private QuotationDetail quotationDetail;
 * 
 * @Column(name = "QUOT_DATE") private Date quotationDate;
 * 
 * @Column(name = "SUPPLY_DATE") private Date supplyDate;
 * 
 * @Column(name = "TOTAL_VALUE", length = 10) private String totalValue;
 * 
 * @Column(name = "RECD_DATE", length = 50) private Date recdDate;
 * 
 * @Column(name = "WORKER_CODE", length = 50) private String workerCode;
 * 
 * @Column(name = "REMARKS", length = 100) private String remarks;
 * 
 * @Column(name = "CANC_STATUS", length = 8) private String cancStatus;
 * 
 * @Column(name = "EXCISE", length = 6) private int excise;
 * 
 * @Column(name = "SALES_TAX", length = 8) private String salesTax;
 * 
 * @Column(name = "CST", length = 8) private String cst;
 * 
 * @Column(name = "TRADE_DISCOUNT", length = 8) private int tradeDiscount;
 * 
 * @Column(name = "SURCHARGE", length = 8) private int surCharge;
 * 
 * @Column(name = "FREIGHT", length = 10) private int freight;
 * 
 * @Column(name = "PO_BASED_VAL", length = 10) private int poBasedVal;
 * 
 * @Column(name = "OCTROI", length = 10) private int octroi;
 * 
 * @Column(name = "DISCOUNT", length = 10) private int discount;
 * 
 * @Column(name = "AMEND_NO", length = 10) private int amendNo;
 * 
 * @Column(name = "AMEND_DATE") private Date amendDate;
 * 
 * @Column(name = "CCODE", length = 50) private String cCode;
 * 
 * @Column(name = "FYCODE", length = 50) private String fyCode;
 * 
 * @Column(name = "UCODE", length = 50) private String uCode;
 * 
 * @Column(name = "UDATE", length = 50) private Date uDate;
 * 
 * @Column(name = "CESS", length = 50) private Date cess;
 * 
 * @Column(name = "CONDITION1", length = 250) private String condition1;
 * 
 * @Column(name = "CONDITION2", length = 250) private String condition2;
 * 
 * @Column(name = "CONDITION3", length = 250) private String condition3;
 * 
 * @Column(name = "VAT", length = 10) private String vat;
 * 
 * @Column(name = "CONDITION_T1", length = 250) private String conditionT1;
 * 
 * @Column(name = "CONDITION_T2", length = 50) private String conditionT2;
 * 
 * @Column(name = "PRODUCTION_UNDER", length = 50) private String
 * productionUnder;
 * 
 * @Column(name = "CARTAGE", length = 50) private int cartage;
 * 
 * @Column(name = "PO_TYPE", length = 10) private String poType;
 * 
 * @Column(name = "CAPITALYN", length = 10) private String capitalYn;
 * 
 * @Column(name = "I_ADDR", length = 150) private String iAddr;
 * 
 * @Column(name = "CFORM_YN", length = 10) private String cFormYn;
 * 
 * @Column(name = "SUB_PO_TYPE", length = 10) private String subPoType;
 * 
 * @JoinColumn(name = "CURRENCY_CODE")
 * 
 * @ManyToOne private CurrencyMaster currency;
 * 
 * @Column(name = "CONVERSION_VALUE", length = 20) private int conversionValue;
 * 
 * @Column(name = "PO_CAP_TYPE", length = 10) private String poCapType;
 * 
 * @Column(name = "CONDITION4", length = 500) private String condition4;
 * 
 * @Column(name = "CONDITION5", length = 500) private String condition5;
 * 
 * @Column(name = "CONDITION6", length = 500) private String condition6;
 * 
 * @Column(name = "CONDITION7", length = 500) private String condition7;
 * 
 * @Column(name = "CONDITION8", length = 500) private String condition8;
 * 
 * @Column(name = " CONDITION9", length = 500) private String condition9;
 * 
 * @Column(name = " CONDITION10", length = 500) private String condition10;
 * 
 * @Column(name = " CONDITION11", length = 500) private String condition11;
 * 
 * @Column(name = " CONDITION12", length = 500) private String condition12;
 * 
 * @Column(name = "CONDITION13", length = 500) private String condition13;
 * 
 * @Column(name = "CONDITION14", length = 500) private String condition14;
 * 
 * @Column(name = "CONDITION15", length = 500) private String condition15;
 * 
 * @Column(name = "CONDITION16", length = 500) private String condition16;
 * 
 * @Column(name = "FORM_CODE", length = 20) private String fromCode;
 * 
 * @Column(name = "FORM_NO", length = 20) private String fromNum;
 * 
 * @Column(name = "FORM_DATE") private Date fromDate;
 * 
 * @Column(name = "EXCISEABLE", length = 20) private String exceseable;
 * 
 * @Column(name = "CONTACT_PERSON", length = 50) private String contactPerson;
 * 
 * @Column(name = "OPEN_NO", length = 10) private String openNumber;
 * 
 * @Column(name = "ACODE", length = 10) private String aCode;
 * 
 * @Column(name = "ANAME", length = 50) private String aName;
 * 
 * @Column(name = "OPEN_PO", length = 20) private String openPo;
 * 
 * @Column(name = "APPROVAL_STATUS", length = 10) private String approvalStatus;
 * 
 * @Column(name = "REMARK", length = 100) private String remarks;
 * 
 * @Column(name = "PO_REMARKS", length = 100) private String poRemarks;
 * 
 * @Column(name = "AMEND_REMARKS2", length = 100) private String amendRemarks2;
 * 
 * @Column(name = "PO_CATEGORY", length = 10) private String poCategory;
 * 
 * @Column(name = "DELIVERY_DATE") private String deliveryDate;
 * 
 * @Column(name = "NATURE", length = 10) private String nature;
 * 
 * @Column(name = "PO_REMARK", length = 100) private String poRemarks;
 * 
 * @Column(name = "APPROVAL_DATE") private Date approvalDate;
 * 
 * @Column(name = "FRM_NO", length = 10) private int frmNo;
 * 
 * @Column(name = "FRM_DT") private String frmDate;
 * 
 * @Column(name = "NATURE_OF_PUR", length = 10) private String natureOfPur;
 * 
 * @Column(name = "PRICE_TYPE", length = 10) private String priceType;
 * 
 * @Column(name = "FOR_AMT", length = 10) private int forAmt;
 * 
 * @Column(name = "ADV_PER", length = 10) private String advPer;
 * 
 * @Column(name = "ADV_VALUE", length = 10) private int advValue;
 * 
 * @Column(name = "PENALTY_PER", length = 10) private int penaltyPer;
 * 
 * @Column(name = "PENALTY_VALUE", length = 10) private String penaltyValue;
 * 
 * @Column(name = "SCH_REQ_YN", length = 10) private String schReqYn;
 * 
 * @Column(name = "PO_FOR", length = 10) private String poFor;
 * 
 * @Column(name = "PO_BASED", length = 10) private String poBased;
 * 
 * @Column(name = "INSURANCE_SCOPE", length = 5) private String insuranceScope;
 * 
 * @Column(name = "SPEC_DISC_PER", length = 10) private String specDiscPer;
 * 
 * @Column(name = "SPEC_DISC_VALUE", length = 10) private String specDiscValue;
 * 
 * @Column(name = "CASH_DISC_PER", length = 10) private String cashDiscPer;
 * 
 * @Column(name = "CASH_DISC_VALUE", length = 10) private String cashDiscValue;
 * 
 * @Column(name = "SPEC_DUTY_PER", length = 10) private String specDutyPer;
 * 
 * @Column(name = "SPEC_DUTY_VALUE", length = 10) private String specDutyValue;
 * 
 * @Column(name = "LANDING_PER", length = 10) private String landingPer;
 * 
 * @Column(name = "LANDING_VALUE", length = 10) private String landingValue;
 * 
 * @Column(name = "NET_MODVAT_VALUE", length = 10) private String
 * netModVatValue;
 * 
 * @Column(name = "PACKING", length = 10) private String packing;
 * 
 * @Column(name = "COMP_STMT", length = 5) private String compStmt;
 * 
 * @Column(name = "APPROVAL_ATTACH", length = 5) private String approvalAttach;
 * 
 * @Column(name = "ORDER_LOW", length = 5) private String orderLow;
 * 
 * @Column(name = "REMARKS_LOW", length = 500) private String remarksLow;
 * 
 * @Column(name = "INSP_REMARKS", length = 50) private String poDate;
 * 
 * @Column(name = "TIME_BASE_DT", length = 50) private String poDate;
 * 
 * @Column(name = "WARRANTY_START_DT", length = 50) private String poDate;
 * 
 * @Column(name = "WARRANTY_END_DT", length = 50) private String poDate;
 * 
 * @Column(name = "PO_TYPE_CODE", length = 50) private String poDate;
 * 
 * @Column(name = "CONDITION_NOTE", length = 50) private String poDate;
 * 
 * @Column(name = "BSR_CODE", length = 50) private String poDate;
 * 
 * @Column(name = "BSR_YN", length = 50) private String poNumber;
 * 
 * @Column(name = "NOTE1", length = 50) private String poDate;
 * 
 * @Column(name = "NOTE2", length = 50) private String poDate;
 * 
 * @Column(name = "NOTE2", length = 50) private String poDate;
 * 
 * @Column(name = "NOTE2", length = 50) private String poDate;
 * 
 * @Column(name = "CANCEL_DATE", length = 50) private String poDate;
 * 
 * @Column(name = "CANCEL_BY", length = 50) private String poDate;
 * 
 * @Column(name = "DOCUMENT_PATH", length = 50) private String poDate;
 * 
 * @Column(name = "DOC_FILE", length = 50) private String poDate;
 * 
 * @Column(name = "REPEAT_ORDER_NO", length = 50) private String poDate;
 * 
 * @Column(name = "REPEAT_ORDER_DATE", length = 50) private String poDate;
 * 
 * @Column(name = "INACC_CODE", length = 50) private String poDate;
 * 
 * @Column(name = "APPROVAL_SOURCE", length = 50) private String poNumber;
 * 
 * }
 */
package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;



public class QuotationItem {
	
	
	@Id
	@Column(name="QUO_ITEM_CODE",length=50)
	private String qtItemCode;
	
	@Column(name="QUO_ITEM_RATE",length=50)
	private int qtItemRate;
	
	@Column(name="QUO_ITEM_QTY",length=50)
	private String qtItemQty;
	
	@Column(name="QUO_SEQ_NO",length=10)
	private int qtSeqNo;
	
	@Column(name="QUALITY",length=50)
	private String quality;
	
	@Column(name="INDENT_NUM",length=50)
	private String indentNum;
	
	@Column(name="INDENT_DATE")
	private Date indentDate;
	
	@Column(name="EMPLOYEE",length=50)
	private String employeeCode;
	
	@Column(name="WORKER_CODE",length=50)
	private String workerCode;
	
	@Column(name="CURRENCY_CODE",length=50)
	private String currencyCode;
	
	@Column(name="CONVERSION_VALUE",length=10)
	private int conversionValue;
	
	@Column(name="EXCISE",length=10)
	private int excise;
	
	@Column(name="SALES_TAX",length=10)
	private int salesTax;
	
	@Column(name="CST",length=10)
	private int cst;
	
	@Column(name="TRADE_DISCOUNT",length=10)
	private int tradeDiscount;
	
	@Column(name="SUR_CHARGE",length=10)
	private int surCharge;
	
	@Column(name="DISCOUNT",length=10)
	private int discount;
	
	@Column(name="FREIGHT",length=10)
	private int freight;
	
	@Column(name="PACKING",length=10)
	private int packing;
	
	@Column(name="OCT_ROI",length=10)
	private int octRoi;
	
	@Column(name="CESS",length=10)
	private int cess;
	
	@Column(name="INDENT_SEQ_NO",length=10)
	private int indentSeqNo;
	
	@Column(name="VAT",length=10)
	private int vat;
	
	@Column(name="TOTAL_VALUE",length=10)
	private int totalValue;
	
	@Column(name="ITEM_NET_VAL",length=10)
	private int itemNetVal;
	
	@Column(name="SURCHARGE_NET_VAL",length=10)
	private int surchargeNetVal;
	
	
	@Column(name="EXCISE_VAL",length=10)
	private int exciseValue;
	
	@Column(name="CESS_VAL",length=10)
	private int cessValue;
	
	@Column(name="CST_VAL",length=10)
	private int cstValue;
	
	@Column(name="SHCESS_VAL",length=10)
	private int shcessValue;
	
	@Column(name="DISCOUNT_VALUE",length=10)
	private int discountValue;
	
	@Column(name="TRADE_VALUE",length=10)
	private int tradevalue;
	
	@Column(name="RATE",length=10)
	private int rate;
	
	@Column(name="VAT_SURCHARGE",length=10)
	private int vatSurcharge;
	
	@Column(name="APPROVAL_STATUS",length=10)
	private String approvalStatus;
	
	@Column(name="DATE_OF_APPROVAL",length=10)
	private String dateOfApproval;
	
	@Column(name="APPROVED_BY",length=50)
	private String approvedBy;
	
	@Column(name="DATE_OF_CANCEL")
	private Date dateOfCancel;
	
	@Column(name="CANCEL_REMARKS",length=50)
	private String cancelRemarks;
	
	@Column(name="QUOT_REMARKS",length=50)
	private String quotRemark;
	
	@Column(name="CGST",length=10)
	private int cgst;
	
	@Column(name="CGST_VALUE",length=10)
	private int cgstValue;
	
	@Column(name="SGST",length=10)
	private int sgst;
	
	
	@Column(name="SGST_VALUE",length=10)
	private int sgstValue;
	
	@Column(name="IGST",length=10)
	private int igst;
	
	@Column(name="IGST_VALUE",length=10)
	private int igstValue;
	
	@Column(name="SURCHARGE_VAL",length=10)
	private int surchargeVal;
	
	@Column(name="SHCESS",length=10)
	private int shcess;
	
	

}

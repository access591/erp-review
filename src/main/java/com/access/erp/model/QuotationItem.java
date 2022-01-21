package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="QUOTATION_ITEM") //DETAIL TABLE 
public class QuotationItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Q_CODE")
	private Long QCOde;
	
	@Column(name = "QTY", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qty;
	
	//fk
	@Column(name="ITEM_CODE",length=50)
	private String qtItemCode;
	
	
	//14,2
	@Column(name = "ITEM_RATE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double qtItemRate;
	
	//14,3
	@Column(name = "ITEM_QTY", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qtItemQty;
	
	
	@Column(name="QUO_SEQ_NO",length=5)
	private int qtSeqNo;
	
	@Column(name="QUALITY",length=30)
	private String quality;
	
	//fk from inent master
	@Column(name="INDENT_NO",length=50)
	private String indentNum;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="INDENT_DATE")
	private Date indentDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_CODE")
	private Employee employee;
	
	@Column(name="WORKER_CODE",length=10)
	private String workerCode;
	
	@Column(name="CURRENCY_CODE",length=10)
	private String currencyCode;
	
	//14.2
	@Column(name = "CONVERSIONVALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double conversionValue;
	
	//14.2
	@Column(name = "EXCISE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double excise;
	
	@Column(name="SALES_TAX",length=10)
	private double salesTax;
	
	@Column(name="CST",length=10)
	private double cst;
	
	@Column(name="TRADE_DISCOUNT",columnDefinition = "FLOAT(14,2)",nullable = true)
	private double tradeDiscount;
	
	//5.2
	@Column(name = "SUR_CHARGE", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double surCharge;
	//5.2
	@Column(name = "DISCOUNT", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double discount;
	
	//14.2
	@Column(name = "FREIGHT", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double freight;
	
	//14.2
	@Column(name = "PACKING", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double packing;
	
	//14.2
	@Column(name = "OCT_ROI", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double octRoi;
	
	//5.2
	@Column(name = "CESS", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double cess;
	
	//5.2
	@Column(name = "INDENT_SEQ_NO", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double indentSeqNo;
	
	//5.2
	@Column(name = "VAT", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double vat;
	
	//14.2
	//against single record 
	@Column(name = "TOTAL_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double totalValue;
	
	//14.3
	@Column(name = "ITEM_NET_VAL", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double itemNetVal;
	
	//14.2
	@Column(name = "SURCHARGENETVAL", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double surchargeNetVal;
	
	//14.2
	@Column(name = "EXCISE_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double exciseValue;
	
	//14.2
	@Column(name = "CESS_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double cessValue;
	
	//14.2
	@Column(name = "CST_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double cstValue;
	
	//14.2
	@Column(name = "SHCESS_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double shcessValue;
	
	//14.2
	//total value inr  against total row 
	@Column(name = "DISCOUNT_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double discountValue;
	
	//14.2
	@Column(name = "TRADE_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double tradevalue;
	
	//14.2
	@Column(name = "RATE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double rate;
	
	//5.2
	@Column(name = "VAT_SURCHARGE", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double vatSurcharge;
	
	
	@Column(name="APPROVAL_STATUS",length=2)
	private String approvalStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="DATE_OF_APPROVAL")
	private Date dateOfApproval;
	
	@Column(name="APPROVED_BY",length=10)
	private String approvedBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DATE_OF_CANCEL")
	private Date dateOfCancel;
	
	@Column(name="CANCEL_REMARKS",length=500)
	private String cancelRemarks;
	
	@Column(name="QUOT_REMARKS",length=500)
	private String quotRemark;
	
	//5.2
	@Column(name = "CGST", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double cgst;
	
	//14.2
	@Column(name = "CGST_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double cgstValue;
	
	//5.2
	@Column(name = "SGST", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double sgst;
	
	//14.2
	@Column(name = "SGST_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double sgstValue;
	
	//5.2
	@Column(name = "IGST", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double igst;
	
	//14.2
	@Column(name = "IGST_VALUE", columnDefinition = "FLOAT(14,2)",nullable = true)
	private double igstValue;
	
	//5.2
	@Column(name = "SURCHARGE_VAL", columnDefinition = "FLOAT(5,2)",nullable = true)
	private double surchargeVal;
	
	@Column(name = "SHCESS", columnDefinition = "FLOAT(10)",nullable = true)
	private double shcess;
	
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "QUOTATION_DETAIL_CODE")
	private QuotationDetail quotationDetail;



	public Long getQCOde() {
		return QCOde;
	}



	public void setQCOde(Long qCOde) {
		QCOde = qCOde;
	}



	public double getQty() {
		return qty;
	}



	public void setQty(double qty) {
		this.qty = qty;
	}



	public String getQtItemCode() {
		return qtItemCode;
	}



	public void setQtItemCode(String qtItemCode) {
		this.qtItemCode = qtItemCode;
	}



	public double getQtItemRate() {
		return qtItemRate;
	}



	public void setQtItemRate(double qtItemRate) {
		this.qtItemRate = qtItemRate;
	}



	public double getQtItemQty() {
		return qtItemQty;
	}



	public void setQtItemQty(double qtItemQty) {
		this.qtItemQty = qtItemQty;
	}



	public int getQtSeqNo() {
		return qtSeqNo;
	}



	public void setQtSeqNo(int qtSeqNo) {
		this.qtSeqNo = qtSeqNo;
	}



	public String getQuality() {
		return quality;
	}



	public void setQuality(String quality) {
		this.quality = quality;
	}



	public String getIndentNum() {
		return indentNum;
	}



	public void setIndentNum(String indentNum) {
		this.indentNum = indentNum;
	}



	public Date getIndentDate() {
		return indentDate;
	}



	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public String getWorkerCode() {
		return workerCode;
	}



	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}



	public String getCurrencyCode() {
		return currencyCode;
	}



	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}



	public double getConversionValue() {
		return conversionValue;
	}



	public void setConversionValue(double conversionValue) {
		this.conversionValue = conversionValue;
	}



	public double getExcise() {
		return excise;
	}



	public void setExcise(double excise) {
		this.excise = excise;
	}



	public double getSalesTax() {
		return salesTax;
	}



	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}



	public double getCst() {
		return cst;
	}



	public void setCst(double cst) {
		this.cst = cst;
	}



	public double getTradeDiscount() {
		return tradeDiscount;
	}



	public void setTradeDiscount(double tradeDiscount) {
		this.tradeDiscount = tradeDiscount;
	}



	public double getSurCharge() {
		return surCharge;
	}



	public void setSurCharge(double surCharge) {
		this.surCharge = surCharge;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public double getFreight() {
		return freight;
	}



	public void setFreight(double freight) {
		this.freight = freight;
	}



	public double getPacking() {
		return packing;
	}



	public void setPacking(double packing) {
		this.packing = packing;
	}



	public double getOctRoi() {
		return octRoi;
	}



	public void setOctRoi(double octRoi) {
		this.octRoi = octRoi;
	}



	public double getCess() {
		return cess;
	}



	public void setCess(double cess) {
		this.cess = cess;
	}



	public double getIndentSeqNo() {
		return indentSeqNo;
	}



	public void setIndentSeqNo(double indentSeqNo) {
		this.indentSeqNo = indentSeqNo;
	}



	public double getVat() {
		return vat;
	}



	public void setVat(double vat) {
		this.vat = vat;
	}



	public double getTotalValue() {
		return totalValue;
	}



	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}



	public double getItemNetVal() {
		return itemNetVal;
	}



	public void setItemNetVal(double itemNetVal) {
		this.itemNetVal = itemNetVal;
	}



	public double getSurchargeNetVal() {
		return surchargeNetVal;
	}



	public void setSurchargeNetVal(double surchargeNetVal) {
		this.surchargeNetVal = surchargeNetVal;
	}



	public double getExciseValue() {
		return exciseValue;
	}



	public void setExciseValue(double exciseValue) {
		this.exciseValue = exciseValue;
	}



	public double getCessValue() {
		return cessValue;
	}



	public void setCessValue(double cessValue) {
		this.cessValue = cessValue;
	}



	public double getCstValue() {
		return cstValue;
	}



	public void setCstValue(double cstValue) {
		this.cstValue = cstValue;
	}



	public double getShcessValue() {
		return shcessValue;
	}



	public void setShcessValue(double shcessValue) {
		this.shcessValue = shcessValue;
	}



	public double getDiscountValue() {
		return discountValue;
	}



	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}



	public double getTradevalue() {
		return tradevalue;
	}



	public void setTradevalue(double tradevalue) {
		this.tradevalue = tradevalue;
	}



	public double getRate() {
		return rate;
	}



	public void setRate(double rate) {
		this.rate = rate;
	}



	public double getVatSurcharge() {
		return vatSurcharge;
	}



	public void setVatSurcharge(double vatSurcharge) {
		this.vatSurcharge = vatSurcharge;
	}



	public String getApprovalStatus() {
		return approvalStatus;
	}



	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}



	public Date getDateOfApproval() {
		return dateOfApproval;
	}



	public void setDateOfApproval(Date dateOfApproval) {
		this.dateOfApproval = dateOfApproval;
	}



	public String getApprovedBy() {
		return approvedBy;
	}



	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}



	public Date getDateOfCancel() {
		return dateOfCancel;
	}



	public void setDateOfCancel(Date dateOfCancel) {
		this.dateOfCancel = dateOfCancel;
	}



	public String getCancelRemarks() {
		return cancelRemarks;
	}



	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}



	public String getQuotRemark() {
		return quotRemark;
	}



	public void setQuotRemark(String quotRemark) {
		this.quotRemark = quotRemark;
	}



	public double getCgst() {
		return cgst;
	}



	public void setCgst(double cgst) {
		this.cgst = cgst;
	}



	public double getCgstValue() {
		return cgstValue;
	}



	public void setCgstValue(double cgstValue) {
		this.cgstValue = cgstValue;
	}



	



	public double getSgst() {
		return sgst;
	}



	public void setSgst(double sgst) {
		this.sgst = sgst;
	}



	public double getSgstValue() {
		return sgstValue;
	}



	public void setSgstValue(double sgstValue) {
		this.sgstValue = sgstValue;
	}



	public double getIgst() {
		return igst;
	}



	public void setIgst(double igst) {
		this.igst = igst;
	}



	public double getIgstValue() {
		return igstValue;
	}



	public void setIgstValue(double igstValue) {
		this.igstValue = igstValue;
	}



	public double getSurchargeVal() {
		return surchargeVal;
	}



	public void setSurchargeVal(double surchargeVal) {
		this.surchargeVal = surchargeVal;
	}



	public double getShcess() {
		return shcess;
	}



	public void setShcess(double shcess) {
		this.shcess = shcess;
	}



	public QuotationDetail getQuotationDetail() {
		return quotationDetail;
	}



	public void setQuotationDetail(QuotationDetail quotationDetail) {
		this.quotationDetail = quotationDetail;
	}
	
	
	

	
	

}

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


@Entity
@Table(name="QUOTATION_ITEM") //DETAIL TABLE 
public class QuotationItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Q_CODE")
	private Long QCOde;
	
	//fk
	@Column(name="ITEM_CODE",length=50)
	private String qtItemCode;
	
	
	//14,2
	@Column(name="ITEM_RATE",length=50)
	private int qtItemRate;
	
	//14,3
	@Column(name="ITEM_QTY",length=50)
	private String qtItemQty;
	
	
	@Column(name="QUO_SEQ_NO",length=5)
	private int qtSeqNo;
	
	@Column(name="QUALITY",length=30)
	private String quality;
	
	//fk from inent master
	@Column(name="INDENT_NUM",length=50)
	private String indentNum;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="INDENT_DATE")
	private Date indentDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EMP_CODE")
	private Employee employee;
	
	@Column(name="WORKER_CODE",length=10)
	private String workerCode;
	
	@Column(name="CURRENCY_CODE",length=10)
	private String currencyCode;
	
	//14.2
	@Column(name="CONVERSION_VALUE",length=10)
	private int conversionValue;
	
	//14.2
	@Column(name="EXCISE",length=10)
	private int excise;
	
	@Column(name="SALES_TAX",length=10)
	private int salesTax;
	
	@Column(name="CST",length=10)
	private int cst;
	
	@Column(name="TRADE_DISCOUNT",length=10)
	private int tradeDiscount;
	
	//5.2
	@Column(name="SUR_CHARGE",length=10)
	private int surCharge;
	//5.2
	@Column(name="DISCOUNT",length=10)
	private int discount;
	
	//14.2
	@Column(name="FREIGHT",length=10)
	private int freight;
	
	//14.2
	@Column(name="PACKING",length=10)
	private int packing;
	
	//14.2
	@Column(name="OCT_ROI",length=10)
	private int octRoi;
	
	//5.2
	@Column(name="CESS",length=10)
	private int cess;
	
	//5.2
	@Column(name="INDENT_SEQ_NO",length=10)
	private int indentSeqNo;
	
	//5.2
	@Column(name="VAT",length=10)
	private int vat;
	
	//14.2
	//against single record 
	@Column(name="TOTAL_VALUE",length=10)
	private int totalValue;
	
	//14.3
	@Column(name="ITEM_NET_VAL",length=10)
	private int itemNetVal;
	
	//14.2
	@Column(name="SURCHARGE_NET_VAL",length=10)
	private int surchargeNetVal;
	
	//14.2
	@Column(name="EXCISE_VAL",length=10)
	private int exciseValue;
	
	//14.2
	@Column(name="CESS_VAL",length=10)
	private int cessValue;
	
	//14.2
	@Column(name="CST_VAL",length=10)
	private int cstValue;
	
	//14.2
	@Column(name="SHCESS_VAL",length=10)
	private int shcessValue;
	
	//14.2
	//total value inr  against total row 
	@Column(name="DISCOUNT_VALUE",length=10)
	private int discountValue;
	
	//14.2
	@Column(name="TRADE_VALUE",length=10)
	private int tradevalue;
	
	//14.2
	@Column(name="RATE",length=10)
	private int rate;
	
	//5.2
	@Column(name="VAT_SURCHARGE",length=10)
	private int vatSurcharge;
	
	
	@Column(name="APPROVAL_STATUS",length=2)
	private String approvalStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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
	@Column(name="CGST",length=10)
	private int cgst;
	
	//14.2
	@Column(name="CGST_VALUE",length=10)
	private int cgstValue;
	
	//5.2
	@Column(name="SGST",length=10)
	private int sgst;
	
	//14.2
	@Column(name="SGST_VALUE",length=10)
	private int sgstValue;
	
	//5.2
	@Column(name="IGST",length=10)
	private int igst;
	
	//14.2
	@Column(name="IGST_VALUE",length=10)
	private int igstValue;
	
	//5.2
	@Column(name="SURCHARGE_VAL",length=10)
	private int surchargeVal;
	
	@Column(name="SHCESS",length=10)
	private int shcess;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "QUOTATION_DETAIL_CODE")
	private QuotationDetail quotationDetail;
	
	
	

	public Long getQCOde() {
		return QCOde;
	}

	public void setQCOde(Long qCOde) {
		QCOde = qCOde;
	}

	public String getQtItemCode() {
		return qtItemCode;
	}

	public void setQtItemCode(String qtItemCode) {
		this.qtItemCode = qtItemCode;
	}

	public int getQtItemRate() {
		return qtItemRate;
	}

	public void setQtItemRate(int qtItemRate) {
		this.qtItemRate = qtItemRate;
	}

	public String getQtItemQty() {
		return qtItemQty;
	}

	public void setQtItemQty(String qtItemQty) {
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

	public int getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(int conversionValue) {
		this.conversionValue = conversionValue;
	}

	public int getExcise() {
		return excise;
	}

	public void setExcise(int excise) {
		this.excise = excise;
	}

	public int getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(int salesTax) {
		this.salesTax = salesTax;
	}

	public int getCst() {
		return cst;
	}

	public void setCst(int cst) {
		this.cst = cst;
	}

	public int getTradeDiscount() {
		return tradeDiscount;
	}

	public void setTradeDiscount(int tradeDiscount) {
		this.tradeDiscount = tradeDiscount;
	}

	public int getSurCharge() {
		return surCharge;
	}

	public void setSurCharge(int surCharge) {
		this.surCharge = surCharge;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getFreight() {
		return freight;
	}

	public void setFreight(int freight) {
		this.freight = freight;
	}

	public int getPacking() {
		return packing;
	}

	public void setPacking(int packing) {
		this.packing = packing;
	}

	public int getOctRoi() {
		return octRoi;
	}

	public void setOctRoi(int octRoi) {
		this.octRoi = octRoi;
	}

	public int getCess() {
		return cess;
	}

	public void setCess(int cess) {
		this.cess = cess;
	}

	public int getIndentSeqNo() {
		return indentSeqNo;
	}

	public void setIndentSeqNo(int indentSeqNo) {
		this.indentSeqNo = indentSeqNo;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public int getItemNetVal() {
		return itemNetVal;
	}

	public void setItemNetVal(int itemNetVal) {
		this.itemNetVal = itemNetVal;
	}

	public int getSurchargeNetVal() {
		return surchargeNetVal;
	}

	public void setSurchargeNetVal(int surchargeNetVal) {
		this.surchargeNetVal = surchargeNetVal;
	}

	public int getExciseValue() {
		return exciseValue;
	}

	public void setExciseValue(int exciseValue) {
		this.exciseValue = exciseValue;
	}

	public int getCessValue() {
		return cessValue;
	}

	public void setCessValue(int cessValue) {
		this.cessValue = cessValue;
	}

	public int getCstValue() {
		return cstValue;
	}

	public void setCstValue(int cstValue) {
		this.cstValue = cstValue;
	}

	public int getShcessValue() {
		return shcessValue;
	}

	public void setShcessValue(int shcessValue) {
		this.shcessValue = shcessValue;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}

	public int getTradevalue() {
		return tradevalue;
	}

	public void setTradevalue(int tradevalue) {
		this.tradevalue = tradevalue;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getVatSurcharge() {
		return vatSurcharge;
	}

	public void setVatSurcharge(int vatSurcharge) {
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

	public int getCgst() {
		return cgst;
	}

	public void setCgst(int cgst) {
		this.cgst = cgst;
	}

	public int getCgstValue() {
		return cgstValue;
	}

	public void setCgstValue(int cgstValue) {
		this.cgstValue = cgstValue;
	}

	public int getSgst() {
		return sgst;
	}

	public void setSgst(int sgst) {
		this.sgst = sgst;
	}

	public int getSgstValue() {
		return sgstValue;
	}

	public void setSgstValue(int sgstValue) {
		this.sgstValue = sgstValue;
	}

	public int getIgst() {
		return igst;
	}

	public void setIgst(int igst) {
		this.igst = igst;
	}

	public int getIgstValue() {
		return igstValue;
	}

	public void setIgstValue(int igstValue) {
		this.igstValue = igstValue;
	}

	public int getSurchargeVal() {
		return surchargeVal;
	}

	public void setSurchargeVal(int surchargeVal) {
		this.surchargeVal = surchargeVal;
	}

	public int getShcess() {
		return shcess;
	}

	public void setShcess(int shcess) {
		this.shcess = shcess;
	}

	public QuotationDetail getQuotationDetail() {
		return quotationDetail;
	}

	public void setQuotationDetail(QuotationDetail quotationDetail) {
		this.quotationDetail = quotationDetail;
	}
	
	
	
	
	

}

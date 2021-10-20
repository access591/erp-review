package com.access.erp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="QUOTATION_DETAIL")
public class QuotationDetail {

	
	@Id
	@Column(name="QUOT_NUM",length = 30)
	private String quotNo;
	
	@Column(name="QUOT_DATE",length = 30)
	private Date quotDate;
	
	@Column(name="RECEIVED_ON",length = 30)
	private Date receivedOn;
	
	// employee code fk
	@Column(name="EMPLOYEE",length = 30)
	private String employee;
	
	@Column(name="WORKER_CODE",length = 30)
	private String workerCode;
	
	@Column(name="INDENR_NUM",length = 30)
	private String indentNu;
	
	@Column(name="INDENT_DATE")
	private Date indentDate;
	
	@Column(name="QUOT_SUB",length = 30)
	private String quotSub;
	
	@Column(name="SUPPLIER_CODE",length = 30)
	private String suplierCode;
	
	@Column(name="EXCISE",length = 10)
	private int excise;
	
	@Column(name="SALES_TAX",length = 10)
	private int salesTax;
	
	@Column(name="CST",length = 30)
	private int cst;
	
	@Column(name="TRADE_DISCOUNT",length = 30)
	private int tradeDiscount;
	
	@Column(name="FREIGHT",length = 30)
	private int freight;
	
	@Column(name="PACKING",length = 30)
	private int packing;
	
	@Column(name="OCTROI",length = 30)
	private String octRoi;
	
	@Column(name="DELIVERY_PERIOD",length = 30)
	private String deliveryPeriod;
	
	@Column(name="CONDITION_1",length = 30)
	private String conditions1;
	
	@Column(name="CONDITION_2",length = 30)
	private String conditions2;
	
	@Column(name="CONDITION_3",length = 30)
	private String conditions3;
	
	@Column(name="CONDITION_4",length = 30)
	private String conditions4;
	
	@Column(name="DEL_MODE",length = 30)
	private String delMode;
	
	
	@Column(name="C_C0DE",length = 30)
	private String cCode;
	
	@Column(name="FY_CODE",length = 30)
	private String fyCode;
	
	
	@Column(name="U_CODE",length = 30)
	private String uCode;
	
	@Column(name="u_DATE",length = 30)
	private Date uDate;
	
	@Column(name="CESS",length = 30)
	private int cess;
	
	@Column(name="ITEM_CODE",length = 30)
	private String itemCode;
	
	@Column(name="CURRENCY_CODE",length = 30)
	private String currencyCode;
	
	@Column(name="CONVERSION_VALUE",length = 30)
	private String conversionValue;
	
	@Column(name="CAPITAL_YN",length = 30)
	private String capitalYn;
	
	@Column(name="TEMP_SUP_NAME",length = 30)
	private String tempSupName;
	
	@Column(name="SUP_ADD_1",length = 30)
	private String supAdd1;
	
	@Column(name="TEMP_SUP_ADD2",length = 30)
	private String temSupAdd2;
	
	@Column(name="SUP_CITY_CODE",length = 30)
	private String supCityCode;
	
	@Column(name="SUP_COUNTRY",length = 30)
	private String supCountry;
	
	@Column(name="FROM_CODE",length = 30)
	private String fromCode;
	
	@Column(name="QUOT_TYPE",length = 30)
	private String quotType;
	
	@Column(name="RFQ_NUM",length = 30)
	private String rfqNo;
	
	@Column(name="RFQ_DATE")
	private Date rfqDate;
	
	@Column(name="APPROVAL_STATUS_1",length = 5)
	private String approvalStatus1 = "N";
	
	@Column(name="APPROVAL_STATUS_2",length = 5)
	private String approvalStatus2;
	
	@Column(name="APPROVAL_STATUS_3",length = 5)
	private String approvalStatus3;
	
	@Column(name="APPROVAL_STATUS_4",length = 5)
	private String approvalStatus4;
	
	@Column(name="APPROVAL_DATE_1")
	private Date approvalDate1;
	
	@Column(name="APPROVAL_DATE_2")
	private Date approvalDate2;
	
	@Column(name="APPROVAL_DATE_3")
	private Date approvalDate3;
	
	@Column(name="APPROVAL_DATE_4")
	private Date approvalDate4;
	
	@Column(name="APPROVED_BY_1",length = 30)
	private String approvedBy1;
	
	@Column(name="APPROVED_BY_2",length = 30)
	private String approvedBy2;
	
	@Column(name="APPROVED_BY_3",length = 30)
	private String approvedBy3;
	
	@Column(name="APPROVED_BY_4",length = 30)
	private String approvedBy4;
	
	@Column(name="REMARKS_1",length = 100)
	private String remarks1;
	
	@Column(name="REMARKS_2",length = 100)
	private String remarks2;
	
	@Column(name="REMARKS_3",length = 100)
	private String remarks3;
	
	@Column(name="REMARKS_4",length = 100)
	private String remarks4;
	
	@OneToMany(mappedBy = "quotationDetail", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<QuotationItem> quotationItem;
	
	

	public QuotationDetail() {
		super();
		
	}

	public String getQuotNo() {
		return quotNo;
	}

	public void setQuotNo(String quotNo) {
		this.quotNo = quotNo;
	}

	public Date getQuotDate() {
		return quotDate;
	}

	public void setQuotDate(Date quotDate) {
		this.quotDate = quotDate;
	}

	public Date getReceivedOn() {
		return receivedOn;
	}

	public void setReceivedOn(Date receivedOn) {
		this.receivedOn = receivedOn;
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public String getIndentNu() {
		return indentNu;
	}

	public void setIndentNu(String indentNu) {
		this.indentNu = indentNu;
	}

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public String getQuotSub() {
		return quotSub;
	}

	public void setQuotSub(String quotSub) {
		this.quotSub = quotSub;
	}

	public String getSuplierCode() {
		return suplierCode;
	}

	public void setSuplierCode(String suplierCode) {
		this.suplierCode = suplierCode;
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

	public String getOctRoi() {
		return octRoi;
	}

	public void setOctRoi(String octRoi) {
		this.octRoi = octRoi;
	}

	public String getDeliveryPeriod() {
		return deliveryPeriod;
	}

	public void setDeliveryPeriod(String deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	public String getConditions1() {
		return conditions1;
	}

	public void setConditions1(String conditions1) {
		this.conditions1 = conditions1;
	}

	public String getConditions2() {
		return conditions2;
	}

	public void setConditions2(String conditions2) {
		this.conditions2 = conditions2;
	}

	public String getConditions3() {
		return conditions3;
	}

	public void setConditions3(String conditions3) {
		this.conditions3 = conditions3;
	}

	public String getConditions4() {
		return conditions4;
	}

	public void setConditions4(String conditions4) {
		this.conditions4 = conditions4;
	}

	public String getDelMode() {
		return delMode;
	}

	public void setDelMode(String delMode) {
		this.delMode = delMode;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getFyCode() {
		return fyCode;
	}

	public void setFyCode(String fyCode) {
		this.fyCode = fyCode;
	}

	public String getuCode() {
		return uCode;
	}

	public void setuCode(String uCode) {
		this.uCode = uCode;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	public int getCess() {
		return cess;
	}

	public void setCess(int cess) {
		this.cess = cess;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getConversionValue() {
		return conversionValue;
	}

	public void setConversionValue(String conversionValue) {
		this.conversionValue = conversionValue;
	}

	public String getCapitalYn() {
		return capitalYn;
	}

	public void setCapitalYn(String capitalYn) {
		this.capitalYn = capitalYn;
	}

	public String getTempSupName() {
		return tempSupName;
	}

	public void setTempSupName(String tempSupName) {
		this.tempSupName = tempSupName;
	}

	public String getSupAdd1() {
		return supAdd1;
	}

	public void setSupAdd1(String supAdd1) {
		this.supAdd1 = supAdd1;
	}

	public String getTemSupAdd2() {
		return temSupAdd2;
	}

	public void setTemSupAdd2(String temSupAdd2) {
		this.temSupAdd2 = temSupAdd2;
	}

	public String getSupCityCode() {
		return supCityCode;
	}

	public void setSupCityCode(String supCityCode) {
		this.supCityCode = supCityCode;
	}

	public String getSupCountry() {
		return supCountry;
	}

	public void setSupCountry(String supCountry) {
		this.supCountry = supCountry;
	}

	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}

	public String getQuotType() {
		return quotType;
	}

	public void setQuotType(String quotType) {
		this.quotType = quotType;
	}

	

	public String getRfqNo() {
		return rfqNo;
	}

	public void setRfqNo(String rfqNo) {
		this.rfqNo = rfqNo;
	}

	public Date getRfqDate() {
		return rfqDate;
	}

	public void setRfqDate(Date rfqDate) {
		this.rfqDate = rfqDate;
	}

	public String getApprovalStatus1() {
		return approvalStatus1;
	}

	public void setApprovalStatus1(String approvalStatus1) {
		this.approvalStatus1 = approvalStatus1;
	}

	public String getApprovalStatus2() {
		return approvalStatus2;
	}

	public void setApprovalStatus2(String approvalStatus2) {
		this.approvalStatus2 = approvalStatus2;
	}

	public String getApprovalStatus3() {
		return approvalStatus3;
	}

	public void setApprovalStatus3(String approvalStatus3) {
		this.approvalStatus3 = approvalStatus3;
	}

	public String getApprovalStatus4() {
		return approvalStatus4;
	}

	public void setApprovalStatus4(String approvalStatus4) {
		this.approvalStatus4 = approvalStatus4;
	}

	public Date getApprovalDate1() {
		return approvalDate1;
	}

	public void setApprovalDate1(Date approvalDate1) {
		this.approvalDate1 = approvalDate1;
	}

	public Date getApprovalDate2() {
		return approvalDate2;
	}

	public void setApprovalDate2(Date approvalDate2) {
		this.approvalDate2 = approvalDate2;
	}

	public Date getApprovalDate3() {
		return approvalDate3;
	}

	public void setApprovalDate3(Date approvalDate3) {
		this.approvalDate3 = approvalDate3;
	}

	public Date getApprovalDate4() {
		return approvalDate4;
	}

	public void setApprovalDate4(Date approvalDate4) {
		this.approvalDate4 = approvalDate4;
	}

	public String getApprovedBy1() {
		return approvedBy1;
	}

	public void setApprovedBy1(String approvedBy1) {
		this.approvedBy1 = approvedBy1;
	}

	public String getApprovedBy2() {
		return approvedBy2;
	}

	public void setApprovedBy2(String approvedBy2) {
		this.approvedBy2 = approvedBy2;
	}

	public String getApprovedBy3() {
		return approvedBy3;
	}

	public void setApprovedBy3(String approvedBy3) {
		this.approvedBy3 = approvedBy3;
	}

	public String getApprovedBy4() {
		return approvedBy4;
	}

	public void setApprovedBy4(String approvedBy4) {
		this.approvedBy4 = approvedBy4;
	}

	public String getRemarks1() {
		return remarks1;
	}

	public void setRemarks1(String remarks1) {
		this.remarks1 = remarks1;
	}

	public String getRemarks2() {
		return remarks2;
	}

	public void setRemarks2(String remarks2) {
		this.remarks2 = remarks2;
	}

	public String getRemarks3() {
		return remarks3;
	}

	public void setRemarks3(String remarks3) {
		this.remarks3 = remarks3;
	}

	public String getRemarks4() {
		return remarks4;
	}

	public void setRemarks4(String remarks4) {
		this.remarks4 = remarks4;
	}

	public List<QuotationItem> getQuotationItem() {
		return quotationItem;
	}

	public void setQuotationItem(List<QuotationItem> quotationItem) {
		this.quotationItem = quotationItem;
	}
	
	
	
	
	
	
	
	
	
	
	
}

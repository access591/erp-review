
package com.access.erp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;






@Entity
@Table(name="PURCHASE_ORDER")
public class PurchaseOrder {

	@Id
	@Column(name = "PO_NO", length = 30)
	private String poNumber;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "PO_DATE")
	private Date poDate;
	
	@Column(name = "CANC_STATUS", length = 2)
	private String cancStatus;
	
	@Column(name = "NATURE_OF_PUR", length = 10)
	private String natureOfPur;
	
	@Column(name = "OPEN_PO", length = 2)
	private String openPo;
	
	@Column(name = "PO_TYPE", length = 10)
	private String poType;
	
	//@ManyToOne
	//@JoinColumn(name = "QUOT_NO")
	@Column(name = "QUOT_NO", length = 40)
	private String quotationDetail;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "QUOT_DATE")
	private Date quotationDate;
	
	
	
	@Column(name = "SUPP_CODE",length = 30)
	private String  supplier;
	
	@Column(name = "CURRENCY", length=2)
	private String  currency;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "SUPPLY_DATE")
	private Date supplyDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DELIVERY_DATE")
	private Date deliveryDate;
	
	//14,2
	@Column(name = "CONVERSION_VALUE", length = 20)
	private int conversionValue;
	
	@Column(name = "REMARKS", length = 100)
	private String remarks;

	//14,2
	@Column(name = "TOTAL_VALUE", length = 10)
	private String totalValue;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "RECD_DATE")
	private Date recdDate;

	@Column(name = "WORKER_CODE", length = 10)
	private String workerCode;


	//5,2
	@Column(name = "EXCISE", length = 6)
	private int excise;

	//5,2
	@Column(name = "SALES_TAX", length = 8)
	private String salesTax;

	//5,2
	@Column(name = "CST", length = 8)
	private String cst;

	//5,2
	@Column(name = "TRADE_DISCOUNT", length = 8)
	private int tradeDiscount;

	//5,2
	@Column(name = "SURCHARGE", length = 8)
	private int surCharge;

	//5,2
	@Column(name = "FREIGHT", length = 10)
	private int freight;

	@Column(name = "PO_BASED_VAL", length = 10)
	private int poBasedVal;

	//14,2
	@Column(name = "OCTROI", length = 10)
	private int octroi;

	//5,2
	@Column(name = "DISCOUNT", length = 10)
	private int discount;

	//5,2
	@Column(name = "AMEND_NO", length = 3)
	private int amendNo;

	@Column(name = "AMEND_DATE")
	private Date amendDate;

	//fk
	@Column(name = "CCODE", length = 50)
	private String cCode;

	@Column(name = "FYCODE", length = 50)
	private String fyCode;

	@Column(name = "UCODE", length = 50)
	private String uCode;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UDATE", length = 50)
	private Date uDate;

	//5,2
	@Column(name = "CESS", length = 50)
	private String cess;

	@Column(name = "CONDITION1", length = 500)
	private String condition1;

	@Column(name = "CONDITION2", length = 500)
	private String condition2;

	@Column(name = "CONDITION3", length = 500)
	private String condition3;

	
	//5,2
	@Column(name = "VAT", length = 10)
	private String vat;

	@Column(name = "CONDITION_T1", length = 500)
	private String conditionT1;

	@Column(name = "CONDITION_T2", length = 500)
	private String conditionT2;

	@Column(name = "PRODUCTION_UNDER", length = 500)
	private String productionUnder;

	//5,2
	@Column(name = "CAR_TAGE")
	private Long cartage;

	

	@Column(name = "CAPITALYN", length = 2)
	private String capitalYn;

	@Column(name = "I_ADDR", length = 150)
	private String iAddr;

	@Column(name = "CFORM_YN", length = 2)
	private String cFormYn;

	@Column(name = "SUB_PO_TYPE", length = 2)
	private String subPoType;

	
	

	

	@Column(name = "PO_CAP_TYPE", length = 2)
	private String poCapType;

	@Column(name = "CONDITION4", length = 500)
	private String condition4;

	@Column(name = "CONDITION5", length = 500)
	private String condition5;

	@Column(name = "CONDITION6", length = 500)
	private String condition6;

	@Column(name = "CONDITION7", length = 500)
	private String condition7;

	@Column(name = "CONDITION8", length = 500)
	private String condition8;

	@Column(name = " CONDITION9", length = 500)
	private String condition9;

	@Column(name = " CONDITION10", length = 500)
	private String condition10;

	@Column(name = " CONDITION11", length = 500)
	private String condition11;

	@Column(name = " CONDITION12", length = 500)
	private String condition12;

	@Column(name = "CONDITION13", length = 500)
	private String condition13;

	@Column(name = "CONDITION14", length = 500)
	private String condition14;

	@Column(name = "CONDITION15", length = 500)
	private String condition15;

	@Column(name = "CONDITION16", length = 500)
	private String condition16;

	@Column(name = "FORM_CODE", length = 6)
	private String fromCode;

	@Column(name = "FORM_NO", length = 20)
	private String fromNum;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FORM_DATE")
	private Date fromDate;

	@Column(name = "EXCISEABLE", length = 20)
	private String exceseable;

	@Column(name = "CONTACT_PERSON", length = 50)
	private String contactPerson;

	@Column(name = "OPEN_NO", length = 10)
	private String openNumber;

	@Column(name = "ACODE", length = 10)
	private String aCode;

	@Column(name = "ANAME", length = 80)
	private String aName;

	

	@Column(name = "APPROVAL_STATUS", length =2)
	private String approvalStatus ="P";

	@Column(name = "REMARK", length = 100)
	private String remark;

	@Column(name = "PO_REMARKS", length = 500)
	private String poRemarks;

	@Column(name = "AMEND_REMARKS2", length = 500)
	private String amendRemarks2;

	@Column(name = "PO_CATEGORY", length = 2)
	private String poCategory;

	

	@Column(name = "NATURE", length = 2)
	private String nature;

	@Column(name = "PO_REMARK", length = 500)
	private String poRemark;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "APPROVAL_DATE")
	private Date approvalDate;

	@Column(name = "FRM_NO", length = 20)
	private int frmNo;

	@Column(name = "FRM_DT")
	private String frmDate;

	

	@Column(name = "PRICE_TYPE", length = 10)
	private String priceType;

	@Column(name = "FOR_AMT", length = 10)
	private int forAmt;

	@Column(name = "ADV_PER", length = 10)
	private String advPer;

	@Column(name = "ADV_VALUE", length = 10)
	private int advValue;

	@Column(name = "PENALTY_PER", length = 10)
	private int penaltyPer;

	@Column(name = "PENALTY_VALUE", length = 10)
	private String penaltyValue;

	@Column(name = "SCH_REQ_YN", length = 10)
	private String schReqYn;

	@Column(name = "PO_FOR", length = 10)
	private String poFor;

	@Column(name = "PO_BASED", length = 10)
	private String poBased;

	@Column(name = "INSURANCE_SCOPE", length = 5)
	private String insuranceScope;

	@Column(name = "SPEC_DISC_PER", length = 10)
	private String specDiscPer;

	@Column(name = "SPEC_DISC_VALUE", length = 10)
	private String specDiscValue;

	@Column(name = "CASH_DISC_PER", length = 10)
	private String cashDiscPer;

	@Column(name = "CASH_DISC_VALUE", length = 10)
	private String cashDiscValue;

	@Column(name = "SPEC_DUTY_PER", length = 10)
	private String specDutyPer;

	@Column(name = "SPEC_DUTY_VALUE", length = 10)
	private String specDutyValue;

	@Column(name = "LANDING_PER", length = 10)
	private String landingPer;

	@Column(name = "LANDING_VALUE", length = 10)
	private String landingValue;

	@Column(name = "NET_MODVAT_VALUE", length = 10)
	private String netModVatValue;

	@Column(name = "PACKING", length = 10)
	private String packing;

	@Column(name = "COMP_STMT", length = 5)
	private String compStmt;

	@Column(name = "APPROVAL_ATTACH", length = 5)
	private String approvalAttach;

	@Column(name = "ORDER_LOW", length = 5)
	private String orderLow;

	@Column(name = "REMARKS_LOW", length = 500)
	private String remarksLow;

	@Column(name = "INSP_REMARKS", length = 50)
	private String inspRemarks;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "TIME_BASE_DT")
	private Date timeBaseDt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "WARRANTY_START_DT")
	private Date warrantyStartDt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "WARRANTY_END_DT")
	private Date warrantyEndDt;

	@Column(name = "PO_TYPE_CODE", length = 50)
	private String poTypeCode;

	@Column(name = "CONDITION_NOTE", length = 500)
	private String conditionNote;

	@Column(name = "BSR_CODE", length = 10)
	private int bsrCode;

	@Column(name = "BSR_YN", length = 5)
	private String bsrYn;

	@Column(name = "NOTE1", length = 500)
	private String note1;

	@Column(name = "NOTE2", length = 500)
	private String note2;

	@Column(name = "NOTE3", length = 500)
	private String note3;

	@Column(name = "NOTE4", length = 500)
	private String note4;

	@Column(name = "CANCEL_DATE")
	private Date cancelDate;

	@Column(name = "CANCEL_BY", length = 50)
	private String cancelBy;

	@Column(name = "DOCUMENT_PATH", length = 200)
	private String documentPath;

	@Column(name = "DOC_FILE", length = 50)
	private String docFile;

	@Column(name = "REPEAT_ORDER_NO", length = 15)
	private String repetOrderNum;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "REPEAT_ORDER_DATE")
	private Date repetOrderDate;

	@Column(name = "INACC_CODE", length = 20)
	private String inaccCode;

	@Column(name = "APPROVAL_SOURCE", length = 30)
	private String approvalSource;
	
	
	@OneToMany(mappedBy = "purchaseOrder", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	//@Fetch(value = FetchMode.SUBSELECT)
	private List<PurchaseOrderItem> listPurchaseOrderItem = new ArrayList<>();


	public PurchaseOrder() {
		super();
		
	}


	public String getPoNumber() {
		return poNumber;
	}


	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}


	public Date getPoDate() {
		return poDate;
	}


	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}


	public String getCancStatus() {
		return cancStatus;
	}


	public void setCancStatus(String cancStatus) {
		this.cancStatus = cancStatus;
	}


	public String getNatureOfPur() {
		return natureOfPur;
	}


	public void setNatureOfPur(String natureOfPur) {
		this.natureOfPur = natureOfPur;
	}


	public String getOpenPo() {
		return openPo;
	}


	public void setOpenPo(String openPo) {
		this.openPo = openPo;
	}


	public String getPoType() {
		return poType;
	}


	public void setPoType(String poType) {
		this.poType = poType;
	}


	

	public String getQuotationDetail() {
		return quotationDetail;
	}


	public void setQuotationDetail(String quotationDetail) {
		this.quotationDetail = quotationDetail;
	}


	public Date getQuotationDate() {
		return quotationDate;
	}


	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}


	


	


	public String getSupplier() {
		return supplier;
	}


	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public Date getSupplyDate() {
		return supplyDate;
	}


	public void setSupplyDate(Date supplyDate) {
		this.supplyDate = supplyDate;
	}


	public Date getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public int getConversionValue() {
		return conversionValue;
	}


	public void setConversionValue(int conversionValue) {
		this.conversionValue = conversionValue;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getTotalValue() {
		return totalValue;
	}


	public void setTotalValue(String totalValue) {
		this.totalValue = totalValue;
	}


	public Date getRecdDate() {
		return recdDate;
	}


	public void setRecdDate(Date recdDate) {
		this.recdDate = recdDate;
	}


	public String getWorkerCode() {
		return workerCode;
	}


	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}


	public int getExcise() {
		return excise;
	}


	public void setExcise(int excise) {
		this.excise = excise;
	}


	public String getSalesTax() {
		return salesTax;
	}


	public void setSalesTax(String salesTax) {
		this.salesTax = salesTax;
	}


	public String getCst() {
		return cst;
	}


	public void setCst(String cst) {
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


	public int getFreight() {
		return freight;
	}


	public void setFreight(int freight) {
		this.freight = freight;
	}


	public int getPoBasedVal() {
		return poBasedVal;
	}


	public void setPoBasedVal(int poBasedVal) {
		this.poBasedVal = poBasedVal;
	}


	public int getOctroi() {
		return octroi;
	}


	public void setOctroi(int octroi) {
		this.octroi = octroi;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public int getAmendNo() {
		return amendNo;
	}


	public void setAmendNo(int amendNo) {
		this.amendNo = amendNo;
	}


	public Date getAmendDate() {
		return amendDate;
	}


	public void setAmendDate(Date amendDate) {
		this.amendDate = amendDate;
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


	public String getCess() {
		return cess;
	}


	public void setCess(String cess) {
		this.cess = cess;
	}


	public String getCondition1() {
		return condition1;
	}


	public void setCondition1(String condition1) {
		this.condition1 = condition1;
	}


	public String getCondition2() {
		return condition2;
	}


	public void setCondition2(String condition2) {
		this.condition2 = condition2;
	}


	public String getCondition3() {
		return condition3;
	}


	public void setCondition3(String condition3) {
		this.condition3 = condition3;
	}


	public String getVat() {
		return vat;
	}


	public void setVat(String vat) {
		this.vat = vat;
	}


	public String getConditionT1() {
		return conditionT1;
	}


	public void setConditionT1(String conditionT1) {
		this.conditionT1 = conditionT1;
	}


	public String getConditionT2() {
		return conditionT2;
	}


	public void setConditionT2(String conditionT2) {
		this.conditionT2 = conditionT2;
	}


	public String getProductionUnder() {
		return productionUnder;
	}


	public void setProductionUnder(String productionUnder) {
		this.productionUnder = productionUnder;
	}


	

	public Long getCartage() {
		return cartage;
	}


	public void setCartage(Long cartage) {
		this.cartage = cartage;
	}


	public String getCapitalYn() {
		return capitalYn;
	}


	public void setCapitalYn(String capitalYn) {
		this.capitalYn = capitalYn;
	}


	public String getiAddr() {
		return iAddr;
	}


	public void setiAddr(String iAddr) {
		this.iAddr = iAddr;
	}


	public String getcFormYn() {
		return cFormYn;
	}


	public void setcFormYn(String cFormYn) {
		this.cFormYn = cFormYn;
	}


	public String getSubPoType() {
		return subPoType;
	}


	public void setSubPoType(String subPoType) {
		this.subPoType = subPoType;
	}


	public String getPoCapType() {
		return poCapType;
	}


	public void setPoCapType(String poCapType) {
		this.poCapType = poCapType;
	}


	public String getCondition4() {
		return condition4;
	}


	public void setCondition4(String condition4) {
		this.condition4 = condition4;
	}


	public String getCondition5() {
		return condition5;
	}


	public void setCondition5(String condition5) {
		this.condition5 = condition5;
	}


	public String getCondition6() {
		return condition6;
	}


	public void setCondition6(String condition6) {
		this.condition6 = condition6;
	}


	public String getCondition7() {
		return condition7;
	}


	public void setCondition7(String condition7) {
		this.condition7 = condition7;
	}


	public String getCondition8() {
		return condition8;
	}


	public void setCondition8(String condition8) {
		this.condition8 = condition8;
	}


	public String getCondition9() {
		return condition9;
	}


	public void setCondition9(String condition9) {
		this.condition9 = condition9;
	}


	public String getCondition10() {
		return condition10;
	}


	public void setCondition10(String condition10) {
		this.condition10 = condition10;
	}


	public String getCondition11() {
		return condition11;
	}


	public void setCondition11(String condition11) {
		this.condition11 = condition11;
	}


	public String getCondition12() {
		return condition12;
	}


	public void setCondition12(String condition12) {
		this.condition12 = condition12;
	}


	public String getCondition13() {
		return condition13;
	}


	public void setCondition13(String condition13) {
		this.condition13 = condition13;
	}


	public String getCondition14() {
		return condition14;
	}


	public void setCondition14(String condition14) {
		this.condition14 = condition14;
	}


	public String getCondition15() {
		return condition15;
	}


	public void setCondition15(String condition15) {
		this.condition15 = condition15;
	}


	public String getCondition16() {
		return condition16;
	}


	public void setCondition16(String condition16) {
		this.condition16 = condition16;
	}


	public String getFromCode() {
		return fromCode;
	}


	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}


	public String getFromNum() {
		return fromNum;
	}


	public void setFromNum(String fromNum) {
		this.fromNum = fromNum;
	}


	public Date getFromDate() {
		return fromDate;
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	public String getExceseable() {
		return exceseable;
	}


	public void setExceseable(String exceseable) {
		this.exceseable = exceseable;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public String getOpenNumber() {
		return openNumber;
	}


	public void setOpenNumber(String openNumber) {
		this.openNumber = openNumber;
	}


	public String getaCode() {
		return aCode;
	}


	public void setaCode(String aCode) {
		this.aCode = aCode;
	}


	public String getaName() {
		return aName;
	}


	public void setaName(String aName) {
		this.aName = aName;
	}


	public String getApprovalStatus() {
		return approvalStatus;
	}


	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getPoRemarks() {
		return poRemarks;
	}


	public void setPoRemarks(String poRemarks) {
		this.poRemarks = poRemarks;
	}


	public String getAmendRemarks2() {
		return amendRemarks2;
	}


	public void setAmendRemarks2(String amendRemarks2) {
		this.amendRemarks2 = amendRemarks2;
	}


	public String getPoCategory() {
		return poCategory;
	}


	public void setPoCategory(String poCategory) {
		this.poCategory = poCategory;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public String getPoRemark() {
		return poRemark;
	}


	public void setPoRemark(String poRemark) {
		this.poRemark = poRemark;
	}


	public Date getApprovalDate() {
		return approvalDate;
	}


	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}


	public int getFrmNo() {
		return frmNo;
	}


	public void setFrmNo(int frmNo) {
		this.frmNo = frmNo;
	}


	public String getFrmDate() {
		return frmDate;
	}


	public void setFrmDate(String frmDate) {
		this.frmDate = frmDate;
	}


	public String getPriceType() {
		return priceType;
	}


	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}


	public int getForAmt() {
		return forAmt;
	}


	public void setForAmt(int forAmt) {
		this.forAmt = forAmt;
	}


	public String getAdvPer() {
		return advPer;
	}


	public void setAdvPer(String advPer) {
		this.advPer = advPer;
	}


	public int getAdvValue() {
		return advValue;
	}


	public void setAdvValue(int advValue) {
		this.advValue = advValue;
	}


	public int getPenaltyPer() {
		return penaltyPer;
	}


	public void setPenaltyPer(int penaltyPer) {
		this.penaltyPer = penaltyPer;
	}


	public String getPenaltyValue() {
		return penaltyValue;
	}


	public void setPenaltyValue(String penaltyValue) {
		this.penaltyValue = penaltyValue;
	}


	public String getSchReqYn() {
		return schReqYn;
	}


	public void setSchReqYn(String schReqYn) {
		this.schReqYn = schReqYn;
	}


	public String getPoFor() {
		return poFor;
	}


	public void setPoFor(String poFor) {
		this.poFor = poFor;
	}


	public String getPoBased() {
		return poBased;
	}


	public void setPoBased(String poBased) {
		this.poBased = poBased;
	}


	public String getInsuranceScope() {
		return insuranceScope;
	}


	public void setInsuranceScope(String insuranceScope) {
		this.insuranceScope = insuranceScope;
	}


	public String getSpecDiscPer() {
		return specDiscPer;
	}


	public void setSpecDiscPer(String specDiscPer) {
		this.specDiscPer = specDiscPer;
	}


	public String getSpecDiscValue() {
		return specDiscValue;
	}


	public void setSpecDiscValue(String specDiscValue) {
		this.specDiscValue = specDiscValue;
	}


	public String getCashDiscPer() {
		return cashDiscPer;
	}


	public void setCashDiscPer(String cashDiscPer) {
		this.cashDiscPer = cashDiscPer;
	}


	public String getCashDiscValue() {
		return cashDiscValue;
	}


	public void setCashDiscValue(String cashDiscValue) {
		this.cashDiscValue = cashDiscValue;
	}


	public String getSpecDutyPer() {
		return specDutyPer;
	}


	public void setSpecDutyPer(String specDutyPer) {
		this.specDutyPer = specDutyPer;
	}


	public String getSpecDutyValue() {
		return specDutyValue;
	}


	public void setSpecDutyValue(String specDutyValue) {
		this.specDutyValue = specDutyValue;
	}


	public String getLandingPer() {
		return landingPer;
	}


	public void setLandingPer(String landingPer) {
		this.landingPer = landingPer;
	}


	public String getLandingValue() {
		return landingValue;
	}


	public void setLandingValue(String landingValue) {
		this.landingValue = landingValue;
	}


	public String getNetModVatValue() {
		return netModVatValue;
	}


	public void setNetModVatValue(String netModVatValue) {
		this.netModVatValue = netModVatValue;
	}


	public String getPacking() {
		return packing;
	}


	public void setPacking(String packing) {
		this.packing = packing;
	}


	public String getCompStmt() {
		return compStmt;
	}


	public void setCompStmt(String compStmt) {
		this.compStmt = compStmt;
	}


	public String getApprovalAttach() {
		return approvalAttach;
	}


	public void setApprovalAttach(String approvalAttach) {
		this.approvalAttach = approvalAttach;
	}


	public String getOrderLow() {
		return orderLow;
	}


	public void setOrderLow(String orderLow) {
		this.orderLow = orderLow;
	}


	public String getRemarksLow() {
		return remarksLow;
	}


	public void setRemarksLow(String remarksLow) {
		this.remarksLow = remarksLow;
	}


	public String getInspRemarks() {
		return inspRemarks;
	}


	public void setInspRemarks(String inspRemarks) {
		this.inspRemarks = inspRemarks;
	}


	public Date getTimeBaseDt() {
		return timeBaseDt;
	}


	public void setTimeBaseDt(Date timeBaseDt) {
		this.timeBaseDt = timeBaseDt;
	}


	public Date getWarrantyStartDt() {
		return warrantyStartDt;
	}


	public void setWarrantyStartDt(Date warrantyStartDt) {
		this.warrantyStartDt = warrantyStartDt;
	}


	public Date getWarrantyEndDt() {
		return warrantyEndDt;
	}


	public void setWarrantyEndDt(Date warrantyEndDt) {
		this.warrantyEndDt = warrantyEndDt;
	}


	public String getPoTypeCode() {
		return poTypeCode;
	}


	public void setPoTypeCode(String poTypeCode) {
		this.poTypeCode = poTypeCode;
	}


	public String getConditionNote() {
		return conditionNote;
	}


	public void setConditionNote(String conditionNote) {
		this.conditionNote = conditionNote;
	}


	public int getBsrCode() {
		return bsrCode;
	}


	public void setBsrCode(int bsrCode) {
		this.bsrCode = bsrCode;
	}


	public String getBsrYn() {
		return bsrYn;
	}


	public void setBsrYn(String bsrYn) {
		this.bsrYn = bsrYn;
	}


	public String getNote1() {
		return note1;
	}


	public void setNote1(String note1) {
		this.note1 = note1;
	}


	public String getNote2() {
		return note2;
	}


	public void setNote2(String note2) {
		this.note2 = note2;
	}


	public String getNote3() {
		return note3;
	}


	public void setNote3(String note3) {
		this.note3 = note3;
	}


	public String getNote4() {
		return note4;
	}


	public void setNote4(String note4) {
		this.note4 = note4;
	}


	public Date getCancelDate() {
		return cancelDate;
	}


	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}


	public String getCancelBy() {
		return cancelBy;
	}


	public void setCancelBy(String cancelBy) {
		this.cancelBy = cancelBy;
	}


	public String getDocumentPath() {
		return documentPath;
	}


	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}


	public String getDocFile() {
		return docFile;
	}


	public void setDocFile(String docFile) {
		this.docFile = docFile;
	}


	public String getRepetOrderNum() {
		return repetOrderNum;
	}


	public void setRepetOrderNum(String repetOrderNum) {
		this.repetOrderNum = repetOrderNum;
	}


	public Date getRepetOrderDate() {
		return repetOrderDate;
	}


	public void setRepetOrderDate(Date repetOrderDate) {
		this.repetOrderDate = repetOrderDate;
	}


	public String getInaccCode() {
		return inaccCode;
	}


	public void setInaccCode(String inaccCode) {
		this.inaccCode = inaccCode;
	}


	public String getApprovalSource() {
		return approvalSource;
	}


	public void setApprovalSource(String approvalSource) {
		this.approvalSource = approvalSource;
	}


	public List<PurchaseOrderItem> getListPurchaseOrderItem() {
		return listPurchaseOrderItem;
	}


	public void setListPurchaseOrderItem(List<PurchaseOrderItem> listPurchaseOrderItem) {
		this.listPurchaseOrderItem = listPurchaseOrderItem;
	}




}

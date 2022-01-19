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
import com.access.erp.model.master.Item;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="PURCHASE_ORDER_ITEM")
public class PurchaseOrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PURCHASE_ORDER_ITEM", length = 30)
	private Long purchaseOrderItem;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "INDENT_NO",nullable=true) 
	@JsonIgnore
	private OpenIndent openIndent;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "INDENT_DATE", length = 50)
	private Date indentDate;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_CODE")
	//@JsonIgnore
	private Item item;
	
	//@Column(precision=10, scale=2)
	@Column(name = "ITEM_RATE",length = 40)
	private String itemRate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "RATE_EFFECTIVE_DATE")
	private Date rateEffectiveDate;
	
	@Column(name = "QTY_ORD", length = 40)
	private String qtyOrder;
	
	@Column(name = "ITEM_STATUS",length=5)
	private String itemStatus = "P";
	
	
	@Column(name = "ITEM_REMARKS" ,length = 500)
	private String itemRemarks;

	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "PO_DATE")
	private Date poDate;

	
	@Column(name = "PO_SEQ_NO", precision=12, scale=3)
	private int poSeqNo;
	
	@Column(name = "EXCISE", precision=10, scale=3)
	private int excise;

	@Column(name = "PACKING",length = 10)
	private int packing;


	@Column(name = "P_UNDER",length = 10)
	private String pUnder;


	@Column(name = "CAR_TAG", length = 10)
	private int carTag;
	
	@Column(name = "SALES_TAX",precision=10, scale=3)
	private int salesTax;

	@Column(name = "CST",length = 10)
	private int cst;

	@Column(name = "TRADE_DISCOUNT",length = 10)
	private int tradeDiscount;

	@Column(name = "SURCHARGE", length = 10)
	private int surCharge;
	
	
	@Column(name = "FREIGHT",precision=16, scale=3,nullable = true)
	private int freight = 0;

	@Column(name = "OCTROI",length = 15)
	private int octroi;

	@Column(name = "DISCOUNT",length=15)
	private int discount;


	@Column(name = "CESS", length = 12)
	private int cess;
	
	@Column(name = "VAT", length = 12)
	private int vat;

	@Column(name = "D_ADDRESS",length=150)
	private String dAddress;

	

	@ManyToOne(optional = true)
	@JoinColumn(name = "EMPLOYEE_CODE",nullable = true)
	private Employee employee;

	@Column(name = "SRHRCESS",length = 10)
	private int srhrCess;


	@Column(name = "SURCHARGE_CESS", length = 20)
	private String surchargeCess;
	
	@Column(name = "VAT_CT_ST", length = 15)
	private String vatCtSt;

	@Column(name = "VAT_CST_ST",length = 15)
	private String vatCstSt;


	@Column(name = "TDS", length = 10)
	private int tds;
	
	@Column(name = "VAT_SURCHARGE", length = 12)
	private int vatSurcharge;

	@Column(name = "SERVICE_CHARGE",length=12)
	private int serviceCharge;

	@Column(name = "EXCISE_VALUE",length=12)
	private int exciseValue;


	//@Column(precision = 5, scale = 4)
	
	@Column(name = "DISC_VALUE",precision=12, scale=3,nullable = true)
	//@Type(type = "big_decimal")
	private double discValue;
	
	@Column(name = "TRD_DISC_VALUE", length = 15)
	private int trdDiscValue;

	@Column(name = "CESS_VALUE",length=12)
	private int cessValue;

	@Column(name = "SRHRCESS_VALUE",length=12)
	private int srhrcessValue;

	@Column(name = "SURCHARGE_VALUE", length = 15)
	private int surchargeValue;
	
	@Column(name = "VAT_VALUE", length = 15)
	private String vatValue;

	@Column(name = "VAT_SUR_VALUE",length=15)
	private int vatSurValue;

	@Column(name = "CST_VALUE",length = 15)
	private int cstValue;


	@Column(name = "SERVICE_TAX_VALUE", length = 12)
	private int serviceTaxValue;
	
	@Column(name = "MODVAT_PER", length = 12)
	private int modVatPer;

	@Column(name = "MODVAT_VALUE",length = 12)
	private int modVatValue;


	@Column(name = "TOLERANCE_DAYS", length = 12)
	private int toleranceDays;
	
	@Column(name = "PACKING_PER", length = 12)
	private int packingPer;

	@Column(name = "ITEM_SPEC",length = 50)
	private String itemSpec;
	
	@Column(name = "EXCESS_QTY_PER",length = 15)
	private int excessQtyPer;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "EXP_DATE")
	private Date expDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "MFG_DATE")
	private Date mfgDate;

	@Column(name = "SHELF_LIFE",length = 10)
	private int shelfLife;
	
	
	@Column(name = "DISC_PER",length = 10,nullable = true)
	private double discPer;


	@Column(name = "NET_OF_MODVAT", length = 12)
	private int netOfModVat;
	
	@Column(name = "CIF_CHG_PER", length = 10)
	private int cifChgPer;

	@Column(name = "CIF_CHG_VALUE",length = 15)
	private int cifChgValue;
	
	@Column(name = "LAND_CHG", length = 10)
	private int landChg;

	@Column(name = "LAND_CHG_VALUE",length=15)
	private int landChgValue;

	@Column(name = "CUST_DUTY", length = 10)
	private int custDuty;

	@Column(name = "CUST_DUTY_VALUE",length = 15)
	private int custDutyValue;
	
	@Column(name = "SPL_DUTY", length = 10)
	private int splDuty;

	@Column(name = "SPL_DUTY_VALUE",length=15)
	private int splDutyValue;

	@Column(name = "CASH_DIS", length = 10)
	private int cashDis;

	@Column(name = "CASH_DIS_VAL",length = 15)
	private int cashDisVal;
	
	@Column(name = "WASHERY_SALT_CHG", length = 10)
	private int washerySaltChg;

	@Column(name = "CONV_CHG",length=10)
	private int convChg;
	
	
	@Column(name = "CONV_CHG_VALUE", length = 15)
	private int convChgValue;

	@Column(name = "VAT_RET_AMT",length = 15)
	private int vatRetAmt;
	
	@Column(name = "WASHERY_SALT_VALUE", length = 15)
	private int washerySaltValue;

	@Column(name = "INDENT_NO_TEMP",length=50)
	private String indentNoTemp;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "INDENT_DATE_TEMP")
	private Date indentDateTemp;

	@Column(name = "ITEM_CANC",length = 4)
	private char itemCanc = 'N';
	
	@Column(name = "CGST", length = 10,nullable = true)
	private double cgst;

	
	//@Column(precision = 5, scale = 4)
	//@Type(type = "big_decimal")
	//private double similarity;
	
	@Column(name = "TOTAL_VALUE", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double totalValue;
	
	@Column(name = "TOTAL_VALUE_INR", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double totalValueInr;
	
	
	@Column(name = "CGST_VALUE",precision=15, scale=3,nullable = true)
	//@Type(type = "big_decimal")
	private double cgstValue;
	
	@Column(name = "SGST", length = 10,nullable = true)
	private double sgst;

	@Column(name = "SGST_VALUE",precision=15, scale=3,nullable = true)
	//@Type(type = "big_decimal")
	private double sgstValue;
	
	@Column(name = "IGST", length = 10,nullable = true)
	private double igst;

	
	@Column(name = "IGST_VALUE",precision=15, scale=3,nullable = true)
	//@Type(type = "big_decimal")
	private double igstValue;
	
	@Column(name = "COST_CENTRE_CODE",length=10)
	private int costCenterCode;
	
	@Column(name = "DOL",length = 2)
	private String dol;
	
	 @ManyToOne(fetch= FetchType.LAZY)
	 @JoinColumn(name="PO_NO")
	 @JsonBackReference
	private PurchaseOrder purchaseOrder;

	public PurchaseOrderItem() {
		super();
		
	}
	
	

	public String getDol() {
		return dol;
	}



	public void setDol(String dol) {
		this.dol = dol;
	}



	public Long getPurchaseOrderItem() {
		return purchaseOrderItem;
	}

	public void setPurchaseOrderItem(Long purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}

	public OpenIndent getOpenIndent() {
		return openIndent;
	}

	public void setOpenIndent(OpenIndent openIndent) {
		this.openIndent = openIndent;
	}

	public Date getIndentDate() {
		return indentDate;
	}

	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemRate() {
		return itemRate;
	}

	public void setItemRate(String itemRate) {
		this.itemRate = itemRate;
	}

	public Date getRateEffectiveDate() {
		return rateEffectiveDate;
	}

	public void setRateEffectiveDate(Date rateEffectiveDate) {
		this.rateEffectiveDate = rateEffectiveDate;
	}

	public String getQtyOrder() {
		return qtyOrder;
	}

	public void setQtyOrder(String qtyOrder) {
		this.qtyOrder = qtyOrder;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public int getPoSeqNo() {
		return poSeqNo;
	}

	public void setPoSeqNo(int poSeqNo) {
		this.poSeqNo = poSeqNo;
	}

	public int getExcise() {
		return excise;
	}

	public void setExcise(int excise) {
		this.excise = excise;
	}

	public int getPacking() {
		return packing;
	}

	public void setPacking(int packing) {
		this.packing = packing;
	}

	public String getpUnder() {
		return pUnder;
	}

	public void setpUnder(String pUnder) {
		this.pUnder = pUnder;
	}

	public int getCarTag() {
		return carTag;
	}

	public void setCarTag(int carTag) {
		this.carTag = carTag;
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

	public int getFreight() {
		return freight;
	}

	public void setFreight(int freight) {
		this.freight = freight;
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

	public int getCess() {
		return cess;
	}

	public void setCess(int cess) {
		this.cess = cess;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public String getdAddress() {
		return dAddress;
	}

	public void setdAddress(String dAddress) {
		this.dAddress = dAddress;
	}

	

	public double getTotalValue() {
		return totalValue;
	}



	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}



	public double getTotalValueInr() {
		return totalValueInr;
	}



	public void setTotalValueInr(double totalValueInr) {
		this.totalValueInr = totalValueInr;
	}



	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getSrhrCess() {
		return srhrCess;
	}

	public void setSrhrCess(int srhrCess) {
		this.srhrCess = srhrCess;
	}

	public String getSurchargeCess() {
		return surchargeCess;
	}

	public void setSurchargeCess(String surchargeCess) {
		this.surchargeCess = surchargeCess;
	}

	public String getVatCtSt() {
		return vatCtSt;
	}

	public void setVatCtSt(String vatCtSt) {
		this.vatCtSt = vatCtSt;
	}

	public String getVatCstSt() {
		return vatCstSt;
	}

	public void setVatCstSt(String vatCstSt) {
		this.vatCstSt = vatCstSt;
	}

	public int getTds() {
		return tds;
	}

	public void setTds(int tds) {
		this.tds = tds;
	}

	public int getVatSurcharge() {
		return vatSurcharge;
	}

	public void setVatSurcharge(int vatSurcharge) {
		this.vatSurcharge = vatSurcharge;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getExciseValue() {
		return exciseValue;
	}

	public void setExciseValue(int exciseValue) {
		this.exciseValue = exciseValue;
	}

	public double getDiscValue() {
		return discValue;
	}

	public void setDiscValue(double discValue) {
		this.discValue = discValue;
	}

	public int getTrdDiscValue() {
		return trdDiscValue;
	}

	public void setTrdDiscValue(int trdDiscValue) {
		this.trdDiscValue = trdDiscValue;
	}

	public int getCessValue() {
		return cessValue;
	}

	public void setCessValue(int cessValue) {
		this.cessValue = cessValue;
	}

	public int getSrhrcessValue() {
		return srhrcessValue;
	}

	public void setSrhrcessValue(int srhrcessValue) {
		this.srhrcessValue = srhrcessValue;
	}

	public int getSurchargeValue() {
		return surchargeValue;
	}

	public void setSurchargeValue(int surchargeValue) {
		this.surchargeValue = surchargeValue;
	}

	public String getVatValue() {
		return vatValue;
	}

	public void setVatValue(String vatValue) {
		this.vatValue = vatValue;
	}

	public int getVatSurValue() {
		return vatSurValue;
	}

	public void setVatSurValue(int vatSurValue) {
		this.vatSurValue = vatSurValue;
	}

	public int getCstValue() {
		return cstValue;
	}

	public void setCstValue(int cstValue) {
		this.cstValue = cstValue;
	}

	public int getServiceTaxValue() {
		return serviceTaxValue;
	}

	public void setServiceTaxValue(int serviceTaxValue) {
		this.serviceTaxValue = serviceTaxValue;
	}

	public int getModVatPer() {
		return modVatPer;
	}

	public void setModVatPer(int modVatPer) {
		this.modVatPer = modVatPer;
	}

	public int getModVatValue() {
		return modVatValue;
	}

	public void setModVatValue(int modVatValue) {
		this.modVatValue = modVatValue;
	}

	public int getToleranceDays() {
		return toleranceDays;
	}

	public void setToleranceDays(int toleranceDays) {
		this.toleranceDays = toleranceDays;
	}

	public int getPackingPer() {
		return packingPer;
	}

	public void setPackingPer(int packingPer) {
		this.packingPer = packingPer;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public int getExcessQtyPer() {
		return excessQtyPer;
	}

	public void setExcessQtyPer(int excessQtyPer) {
		this.excessQtyPer = excessQtyPer;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public int getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	public double getDiscPer() {
		return discPer;
	}

	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}

	public int getNetOfModVat() {
		return netOfModVat;
	}

	public void setNetOfModVat(int netOfModVat) {
		this.netOfModVat = netOfModVat;
	}

	public int getCifChgPer() {
		return cifChgPer;
	}

	public void setCifChgPer(int cifChgPer) {
		this.cifChgPer = cifChgPer;
	}

	public int getCifChgValue() {
		return cifChgValue;
	}

	public void setCifChgValue(int cifChgValue) {
		this.cifChgValue = cifChgValue;
	}

	public int getLandChg() {
		return landChg;
	}

	public void setLandChg(int landChg) {
		this.landChg = landChg;
	}

	public int getLandChgValue() {
		return landChgValue;
	}

	public void setLandChgValue(int landChgValue) {
		this.landChgValue = landChgValue;
	}

	public int getCustDuty() {
		return custDuty;
	}

	public void setCustDuty(int custDuty) {
		this.custDuty = custDuty;
	}

	public int getCustDutyValue() {
		return custDutyValue;
	}

	public void setCustDutyValue(int custDutyValue) {
		this.custDutyValue = custDutyValue;
	}

	public int getSplDuty() {
		return splDuty;
	}

	public void setSplDuty(int splDuty) {
		this.splDuty = splDuty;
	}

	public int getSplDutyValue() {
		return splDutyValue;
	}

	public void setSplDutyValue(int splDutyValue) {
		this.splDutyValue = splDutyValue;
	}

	public int getCashDis() {
		return cashDis;
	}

	public void setCashDis(int cashDis) {
		this.cashDis = cashDis;
	}

	public int getCashDisVal() {
		return cashDisVal;
	}

	public void setCashDisVal(int cashDisVal) {
		this.cashDisVal = cashDisVal;
	}

	public int getWasherySaltChg() {
		return washerySaltChg;
	}

	public void setWasherySaltChg(int washerySaltChg) {
		this.washerySaltChg = washerySaltChg;
	}

	public int getConvChg() {
		return convChg;
	}

	public void setConvChg(int convChg) {
		this.convChg = convChg;
	}

	public int getConvChgValue() {
		return convChgValue;
	}

	public void setConvChgValue(int convChgValue) {
		this.convChgValue = convChgValue;
	}

	public int getVatRetAmt() {
		return vatRetAmt;
	}

	public void setVatRetAmt(int vatRetAmt) {
		this.vatRetAmt = vatRetAmt;
	}

	public int getWasherySaltValue() {
		return washerySaltValue;
	}

	public void setWasherySaltValue(int washerySaltValue) {
		this.washerySaltValue = washerySaltValue;
	}

	public String getIndentNoTemp() {
		return indentNoTemp;
	}

	public void setIndentNoTemp(String indentNoTemp) {
		this.indentNoTemp = indentNoTemp;
	}

	public Date getIndentDateTemp() {
		return indentDateTemp;
	}

	public void setIndentDateTemp(Date indentDateTemp) {
		this.indentDateTemp = indentDateTemp;
	}

	public char getItemCanc() {
		return itemCanc;
	}

	public void setItemCanc(char itemCanc) {
		this.itemCanc = itemCanc;
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

	public int getCostCenterCode() {
		return costCenterCode;
	}

	public void setCostCenterCode(int costCenterCode) {
		this.costCenterCode = costCenterCode;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	
	
	

}

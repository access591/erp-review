package com.access.erp.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="MATERIAL_RECEIPT_DETAILS")
public class MRNDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MRN_DETAIL_ID" , length = 20)
	private Long mrnDetailId;
	
	@Column(name="MAT_SERV_TYPE",length = 2)
	private String matServType;
	
	@ManyToOne
	@JoinColumn(name="ITEM_CODE")
	private Item item;
	
	@ManyToOne
	@JoinColumn(name="STORE_CODE")
	public Store  store;
	
	
	@Column(name="REMARKS",length = 50)
	private String remarks;
	
	@Column(name="MRN_SEQ_NO",length = 3)
	private int mrnSeqNo;
	
	
	@Column(name = "ITEM_REC",precision=14, scale=3,nullable = true)
	private double itemRec; // rec qty 
	
	@Column(name = "ITEM_RATE",precision=14, scale=3,nullable = true)
	private double itemRate;  //po rate 
	
	
	@Column(name = "ITEM_INV",precision=12, scale=3,nullable = true)
	private double itemInv;  //invQty
	
	
	@Column(name = "ITEM_RATE_ON_BILL",precision=14, scale=3,nullable = true)
	private double itemrateOnBill; // bill rate
	
	
	@Column(name = "ITEM_NET_VAL",precision=12, scale=3,nullable = true)
	private Double itemNetVal;  //net cost
	
	@Column(name = "TOTAL_PUR_COST",precision=12, scale=3,nullable = true)
	private double totalPurCost  ; // total pur cost 
	
	
	@Column(name = "TOTAL_VALUE",precision=12, scale=3,nullable = true)
	private double totalvalue; // total cost
	
	
	@Column(name="CAPITALYN",length = 2)
	private String capitalYn;
	
	@Column(name="EXCISE",length = 8)
	private int excise;
	
	@Column(name="PACKING",length = 16)
	private int packing;
	
	@Column(name="CARTAGE",length = 16)
	private int cartage;
	
	@Column(name="P_UNDER",length = 20)
	private String pUnder;
	
	@Column(name="SALE_TAX",length = 8)
	private String saleTax;
	
	@Column(name="CST",length = 8)
	private int cst;
	
	@Column(name="TRADE_DISCOUNT",length = 8)
	private int tradeDiscount;
	
	@Column(name="SURCHARGE",length = 8)
	private int surcharge;
	
	@Column(name="FREIGHT",length = 15)
	private int freight;
	
	@Column(name="OCTROI",length = 15)
	private int octroi;
	
	@Column(name="DISCOUNT",length = 8)
	private int discount;
	
	@Column(name="CESS",length = 8)
	private int cess;
	
	@Column(name="VAT",length = 8)
	private int vat;
	
	@Column(name="D_ADDRESS",length = 200)
	private String dAddress;
	
	
	
	
	@Column(name="AIR_FREIGHT",length = 16)
	private int airFreight;
	
	@Column(name="CARGO_FREIGHT",length = 16)
	private int cargoFreight;
	
	@Column(name="CIF",length = 15)
	private int cif;
	
	@Column(name="CVD",length = 15)
	private int cvd;
	
	@Column(name="ED_CESS_CVD",length = 15)
	private int edCessCvd;
	
	@Column(name="ED_CESS_CUSTOM",length = 15)
	private int edCessCustom;
	
	@Column(name="ADD_DUTY",length = 15)
	private int addCity;
	
	@Column(name="STATUS_TAX",length = 2)
	private String statusTax;
	
	@Column(name="INSURANCE_PERC",length = 5)
	private int insurancePerc;
	
	@Column(name="INSURANCE_VALUE",length = 15)
	private int insuranceValue;
	
	@Column(name="MISC_CHARGES",length = 15)
	private int miscCharge;
	
	@Column(name="LANDING_CHARGES_PERC",length = 5)
	private int landingChargesPerc;
	
	@Column(name="LANDING_CHARGES_VALUE",length = 15)
	private int landingChargesValue;
	
	@Column(name="PO_NO",length = 15)
	private String poNo;
	
	@Column(name="PO_DATE") //m or s 
	private Date poDate;
	
	@ManyToOne
	@JoinColumn(name="GATE_ENTRY_NO")
	public GateEntry gateEntryNo;
	
	@Column(name="GATE_ENTRY_DATE")
	private Date gateEntryDate;
	
	
	@Column(name="CUSTOM_DUTY",length = 15)
	private int customDuty;
	
	@Column(name="EXCISE_VALUE",length = 15)
	private int exciseValue;
	
	@Column(name="DISCOUNT_VALUE",length = 14)
	private int discountValue;
	
	@Column(name="TRADE_DISCOUNT_VALUE",length = 14)
	private int tradeDiscountValue;
	
	@Column(name="CESS_VALUE",length = 14)
	private int cessvalue;
	
	@Column(name="SURCHARGE_VALUE",length = 14)
	private int surchargeValue;
	
	
	@Column(name="VAT_VALUE",length = 14)
	private int vatValue;
	
	@Column(name="SALES_TAX_VALUE",length = 14)
	private int salesTaxValue;
	
	@Column(name="CST_VALUE",length = 14)
	private int cstValue;
	
	@Column(name = "ITEM_NET_VAL", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double poNetVal;
	
	@Column(name="MISCELLANEOUS_CHARGES",length = 15)
	private int miscellaneousCharges;
	
	@Column(name="NON_CST_VALUE",length = 14)
	private int nonCstValue;
	
	@Column(name="NON_ST_VALUE",length = 14)
	private int nonStValue;
	
	@Column(name="SERVICE_TAX_VALUE",length = 14)
	private int serviceTaxValue;
	
	@Column(name="MISC_CHARGES_FOR_EXCIS",length = 15)
	private int miscChargesForValue;
	
	@Column(name="NON_VAT_VALUE",length = 14)
	private int nonVatValue;
	
	
	
	
	
	@Column(name="NON_EXCISE",length = 8)
	private int nonExcise;
	
	@Column(name="NON_EXCISE_VALUE",length = 14)
	private int nonExciseValue;
	
	@Column(name="NON_CESS",length = 8)
	private int nonCess;
	
	@Column(name="NON_CESS_VALUE",length = 14)
	private int nonCessValue;
	
	@Column(name="NON_SURCHARGE",length = 8)
	private int nonSurcharge;
	
	@Column(name="NON_SURCHARGE_VALUE",length = 14)
	private int nonSurchargeValue;
	
	@Column(name="NON_FREIGHT",length = 15)
	private int nonFreight;
	
	@Column(name="NON_PACKING",length = 16)
	private int nonPacking;
	
	@Column(name="SERVICE_TAX",length = 8)
	private int serviceTax;
	
	@Column(name="NON_SERVICE_TAX",length = 8)
	private int nonServiceTax;
	
	@Column(name="NON_SERVICE_TAX_VALUE",length = 14)
	private int nonServiceTaxValue;
	
	@Column(name="SRHRCESS",length = 8)
	private int srhrcess;
	
	
	@Column(name="SRHRCESS_VALUE",length = 14)
	private int srhrcessValue;
	
	@Column(name="NON_SRHRCESS",length = 8)
	private int nonSrhrcess;
	
	@Column(name="NON_SRHRCESS_VALUE",length = 14)
	private int nonSrhrcessValue;
	
	@Column(name="NON_CST",length = 8)
	private int nonCst;
	
	@Column(name="NON_VAT",length = 8)
	private int nonVat;
	
	@Column(name="NON_SALES_TAX",length = 8)
	private int nonSalesTax;
	
	@Column(name="NON_SALES_TAX_VALUE",length = 14)
	private int nonSalesTaxValue;
	
	
	
	@Column(name="ASS_VALUE",length = 15)
	private String assvalue;
	
	@Column(name="MISC_OTHER_CHANGES",length = 15)
	private int miscOtherChanges;
	
	@Column(name="TDS",length = 8)
	private int tds;
	
	@Column(name="TDS_VALUE",length = 15)
	private int tdsValue;
	
	@Column(name="VAT_REJECTION",length = 14)
	private int vatRejection;
	
	@Column(name="DOL_STATUS",length = 2)
	private String dolStatus;
	
	@Column(name="VAT_SURCHARGE",length = 8)
	private int vatSurcharge;
	
	@Column(name="VAT_SURCHARGE_VALUE",length = 14)
	private int vatSurchargeValue;
	
	@Column(name="MISC_OTHER_CHARGES",length = 15)
	private int miscOtherharges;
	
	@Column(name="CUSTOM_DUTY_PER",length = 8)
	private int customDutyPer;
	
	@Column(name="CVD_PER",length = 8)
	private int cvdPer;
	
	@Column(name="CESS_CVD_PER",length = 8)
	private int cessCvdPer;
	
	@Column(name="CESS_CUSTOM_PER",length = 8)
	private int cessCustomPer;
	
	@Column(name="DUTY_PER",length = 8)
	private int dutyPer;
	
	@Column(name="DEV_CHARGES",length = 8)
	private int devCharges;
	
	
	
	@Column(name="ITEM_RECEIVED",length = 12)
	private int itemRecieved;
	
	@Column(name="DOL",length = 2)
	private String dol;
	
	@Column(name="SERVICE_CHARGE",length = 15)
	private int serviceCharge;
	
	@Column(name="SERVICE_TAX_LIST",length = 30)
	private String serviceTaxList;
	
	@Column(name="COL_CODE",length = 16)
	private String colCode;
	
	@Column(name="HEAT_NO",length = 15)
	private String heatNo;
	
	@Column(name="QTY_REC_BAR",length = 14)
	private int qtyRecBar;
	
	@Column(name="ADD_DUTY_PER",length = 5)
	private int addDutyPer;
	
	@Column(name="ADD_DUTY_VALUE",length = 14)
	private int addDutyValue;
	
	@Column(name="SAD_VALUE",length = 14)
	private int sadValue;
	
	@Column(name="SAD",length = 8)
	private int sad;
	
	@Column(name="AED",length = 8)
	private int aed;
	
	@Column(name="AED_VALUE",length = 14)
	private int aedValue;
	
	@Column(name = "CGST",precision=12, scale=2,nullable = true)
	private double cgst;
	
	@Column(name = "CGST_VALUE",precision=12, scale=3,nullable = true)
	private double cgstValue;
	
	@Column(name = "SGST",precision=12, scale=3,nullable = true)
	private double sgst;
	
	@Column(name = "SGST_VALUE",precision=12, scale=3,nullable = true)
	private double sgstvalue;
	
	@Column(name = "IGST",precision=12, scale=3,nullable = true)
	private double igst;
	
	@Column(name = "IGST_VALUE",precision=12, scale=3,nullable = true)
	private double igstValue;
	
	
	
	@Column(name="ED_HCESS_CUSTOM_PER",length = 5)
	private int edHcessCustomPer;
	
	@Column(name="ED_HCESS_CUSTOM",length = 14)
	private int edHcessCustom;
	
	@Column(name="ED_CESS_CUSTOM_PER",length = 15)
	private int edCessCustomPer;
	
	@Column(name="CON_UOM",length = 6)
	private String conUom;
	
	@Column(name="NET_WEIGHT",length = 12)
	private String netWeight;
	
	@Column(name="MF_DATE")
	private Date mfDate;
	
	@Column(name="IN_EX_VAT_CST",length = 2)
	private String inExVatCst;
	
	@Column(name="INCL_EXCL",length = 2)
	private String inclExcl;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "MRN_NO")
	@JsonBackReference
	private MRN mrn;
	
	@Column(name="MRN_DATE")
	public Date mrnDate;

	public MRNDetail() {
		super();
		
	}

	public Long getMrnDetailId() {
		return mrnDetailId;
	}

	public void setMrnDetailId(Long mrnDetailId) {
		this.mrnDetailId = mrnDetailId;
	}

	public String getMatServType() {
		return matServType;
	}

	public void setMatServType(String matServType) {
		this.matServType = matServType;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getMrnSeqNo() {
		return mrnSeqNo;
	}

	public void setMrnSeqNo(int mrnSeqNo) {
		this.mrnSeqNo = mrnSeqNo;
	}

	

	public double getItemInv() {
		return itemInv;
	}

	public void setItemInv(double itemInv) {
		this.itemInv = itemInv;
	}

	public Double getItemNetVal() {
		return itemNetVal;
	}

	public void setItemNetVal(Double itemNetVal) {
		
		 if(null != itemNetVal){
		        this.itemNetVal = itemNetVal;

		    }else{
		        this.itemNetVal = (double) 0;
		    }
		 
		 
		this.itemNetVal = itemNetVal;
	}


	public double getItemRec() {
		return itemRec;
	}

	public void setItemRec(double itemRec) {
		this.itemRec = itemRec;
	}

	public double getItemRate() {
		return itemRate;
	}

	public void setItemRate(double itemRate) {
		this.itemRate = itemRate;
	}

	public double getItemrateOnBill() {
		return itemrateOnBill;
	}

	public void setItemrateOnBill(double itemrateOnBill) {
		this.itemrateOnBill = itemrateOnBill;
	}

	public double getTotalPurCost() {
		return totalPurCost;
	}

	public void setTotalPurCost(double totalPurCost) {
		this.totalPurCost = totalPurCost;
	}

	public double getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(double totalvalue) {
		this.totalvalue = totalvalue;
	}

	public String getCapitalYn() {
		return capitalYn;
	}

	public void setCapitalYn(String capitalYn) {
		this.capitalYn = capitalYn;
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

	public int getCartage() {
		return cartage;
	}

	public void setCartage(int cartage) {
		this.cartage = cartage;
	}

	public String getpUnder() {
		return pUnder;
	}

	public void setpUnder(String pUnder) {
		this.pUnder = pUnder;
	}

	public String getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(String saleTax) {
		this.saleTax = saleTax;
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

	public int getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(int surcharge) {
		this.surcharge = surcharge;
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

	public int getAirFreight() {
		return airFreight;
	}

	public void setAirFreight(int airFreight) {
		this.airFreight = airFreight;
	}

	public int getCargoFreight() {
		return cargoFreight;
	}

	public void setCargoFreight(int cargoFreight) {
		this.cargoFreight = cargoFreight;
	}

	public int getCif() {
		return cif;
	}

	public void setCif(int cif) {
		this.cif = cif;
	}

	public int getCvd() {
		return cvd;
	}

	public void setCvd(int cvd) {
		this.cvd = cvd;
	}

	public int getEdCessCvd() {
		return edCessCvd;
	}

	public void setEdCessCvd(int edCessCvd) {
		this.edCessCvd = edCessCvd;
	}

	public int getEdCessCustom() {
		return edCessCustom;
	}

	public void setEdCessCustom(int edCessCustom) {
		this.edCessCustom = edCessCustom;
	}

	public int getAddCity() {
		return addCity;
	}

	public void setAddCity(int addCity) {
		this.addCity = addCity;
	}

	public String getStatusTax() {
		return statusTax;
	}

	public void setStatusTax(String statusTax) {
		this.statusTax = statusTax;
	}

	public int getInsurancePerc() {
		return insurancePerc;
	}

	public void setInsurancePerc(int insurancePerc) {
		this.insurancePerc = insurancePerc;
	}

	public int getInsuranceValue() {
		return insuranceValue;
	}

	public void setInsuranceValue(int insuranceValue) {
		this.insuranceValue = insuranceValue;
	}

	public int getMiscCharge() {
		return miscCharge;
	}

	public void setMiscCharge(int miscCharge) {
		this.miscCharge = miscCharge;
	}

	public int getLandingChargesPerc() {
		return landingChargesPerc;
	}

	public void setLandingChargesPerc(int landingChargesPerc) {
		this.landingChargesPerc = landingChargesPerc;
	}

	public int getLandingChargesValue() {
		return landingChargesValue;
	}

	public void setLandingChargesValue(int landingChargesValue) {
		this.landingChargesValue = landingChargesValue;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public GateEntry getGateEntryNo() {
		return gateEntryNo;
	}

	public void setGateEntryNo(GateEntry gateEntryNo) {
		this.gateEntryNo = gateEntryNo;
	}

	public Date getGateEntryDate() {
		return gateEntryDate;
	}

	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}

	public int getCustomDuty() {
		return customDuty;
	}

	public void setCustomDuty(int customDuty) {
		this.customDuty = customDuty;
	}

	public int getExciseValue() {
		return exciseValue;
	}

	public void setExciseValue(int exciseValue) {
		this.exciseValue = exciseValue;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}

	public int getTradeDiscountValue() {
		return tradeDiscountValue;
	}

	public void setTradeDiscountValue(int tradeDiscountValue) {
		this.tradeDiscountValue = tradeDiscountValue;
	}

	public int getCessvalue() {
		return cessvalue;
	}

	public void setCessvalue(int cessvalue) {
		this.cessvalue = cessvalue;
	}

	public int getSurchargeValue() {
		return surchargeValue;
	}

	public void setSurchargeValue(int surchargeValue) {
		this.surchargeValue = surchargeValue;
	}

	public int getVatValue() {
		return vatValue;
	}

	public void setVatValue(int vatValue) {
		this.vatValue = vatValue;
	}

	public int getSalesTaxValue() {
		return salesTaxValue;
	}

	public void setSalesTaxValue(int salesTaxValue) {
		this.salesTaxValue = salesTaxValue;
	}

	public int getCstValue() {
		return cstValue;
	}

	public void setCstValue(int cstValue) {
		this.cstValue = cstValue;
	}

	

	public double getPoNetVal() {
		return poNetVal;
	}

	public void setPoNetVal(double poNetVal) {
		this.poNetVal = poNetVal;
	}

	public int getMiscellaneousCharges() {
		return miscellaneousCharges;
	}

	public void setMiscellaneousCharges(int miscellaneousCharges) {
		this.miscellaneousCharges = miscellaneousCharges;
	}

	public int getNonCstValue() {
		return nonCstValue;
	}

	public void setNonCstValue(int nonCstValue) {
		this.nonCstValue = nonCstValue;
	}

	public int getNonStValue() {
		return nonStValue;
	}

	public void setNonStValue(int nonStValue) {
		this.nonStValue = nonStValue;
	}

	public int getServiceTaxValue() {
		return serviceTaxValue;
	}

	public void setServiceTaxValue(int serviceTaxValue) {
		this.serviceTaxValue = serviceTaxValue;
	}

	public int getMiscChargesForValue() {
		return miscChargesForValue;
	}

	public void setMiscChargesForValue(int miscChargesForValue) {
		this.miscChargesForValue = miscChargesForValue;
	}

	public int getNonVatValue() {
		return nonVatValue;
	}

	public void setNonVatValue(int nonVatValue) {
		this.nonVatValue = nonVatValue;
	}

	public int getNonExcise() {
		return nonExcise;
	}

	public void setNonExcise(int nonExcise) {
		this.nonExcise = nonExcise;
	}

	public int getNonExciseValue() {
		return nonExciseValue;
	}

	public void setNonExciseValue(int nonExciseValue) {
		this.nonExciseValue = nonExciseValue;
	}

	public int getNonCess() {
		return nonCess;
	}

	public void setNonCess(int nonCess) {
		this.nonCess = nonCess;
	}

	public int getNonCessValue() {
		return nonCessValue;
	}

	public void setNonCessValue(int nonCessValue) {
		this.nonCessValue = nonCessValue;
	}

	public int getNonSurcharge() {
		return nonSurcharge;
	}

	public void setNonSurcharge(int nonSurcharge) {
		this.nonSurcharge = nonSurcharge;
	}

	public int getNonSurchargeValue() {
		return nonSurchargeValue;
	}

	public void setNonSurchargeValue(int nonSurchargeValue) {
		this.nonSurchargeValue = nonSurchargeValue;
	}

	public int getNonFreight() {
		return nonFreight;
	}

	public void setNonFreight(int nonFreight) {
		this.nonFreight = nonFreight;
	}

	public int getNonPacking() {
		return nonPacking;
	}

	public void setNonPacking(int nonPacking) {
		this.nonPacking = nonPacking;
	}

	public int getServiceTax() {
		return serviceTax;
	}

	public void setServiceTax(int serviceTax) {
		this.serviceTax = serviceTax;
	}

	public int getNonServiceTax() {
		return nonServiceTax;
	}

	public void setNonServiceTax(int nonServiceTax) {
		this.nonServiceTax = nonServiceTax;
	}

	public int getNonServiceTaxValue() {
		return nonServiceTaxValue;
	}

	public void setNonServiceTaxValue(int nonServiceTaxValue) {
		this.nonServiceTaxValue = nonServiceTaxValue;
	}

	public int getSrhrcess() {
		return srhrcess;
	}

	public void setSrhrcess(int srhrcess) {
		this.srhrcess = srhrcess;
	}

	public int getSrhrcessValue() {
		return srhrcessValue;
	}

	public void setSrhrcessValue(int srhrcessValue) {
		this.srhrcessValue = srhrcessValue;
	}

	public int getNonSrhrcess() {
		return nonSrhrcess;
	}

	public void setNonSrhrcess(int nonSrhrcess) {
		this.nonSrhrcess = nonSrhrcess;
	}

	public int getNonSrhrcessValue() {
		return nonSrhrcessValue;
	}

	public void setNonSrhrcessValue(int nonSrhrcessValue) {
		this.nonSrhrcessValue = nonSrhrcessValue;
	}

	public int getNonCst() {
		return nonCst;
	}

	public void setNonCst(int nonCst) {
		this.nonCst = nonCst;
	}

	public int getNonVat() {
		return nonVat;
	}

	public void setNonVat(int nonVat) {
		this.nonVat = nonVat;
	}

	public int getNonSalesTax() {
		return nonSalesTax;
	}

	public void setNonSalesTax(int nonSalesTax) {
		this.nonSalesTax = nonSalesTax;
	}

	public int getNonSalesTaxValue() {
		return nonSalesTaxValue;
	}

	public void setNonSalesTaxValue(int nonSalesTaxValue) {
		this.nonSalesTaxValue = nonSalesTaxValue;
	}

	public String getAssvalue() {
		return assvalue;
	}

	public void setAssvalue(String assvalue) {
		this.assvalue = assvalue;
	}

	public int getMiscOtherChanges() {
		return miscOtherChanges;
	}

	public void setMiscOtherChanges(int miscOtherChanges) {
		this.miscOtherChanges = miscOtherChanges;
	}

	public int getTds() {
		return tds;
	}

	public void setTds(int tds) {
		this.tds = tds;
	}

	public int getTdsValue() {
		return tdsValue;
	}

	public void setTdsValue(int tdsValue) {
		this.tdsValue = tdsValue;
	}

	public int getVatRejection() {
		return vatRejection;
	}

	public void setVatRejection(int vatRejection) {
		this.vatRejection = vatRejection;
	}

	public String getDolStatus() {
		return dolStatus;
	}

	public void setDolStatus(String dolStatus) {
		this.dolStatus = dolStatus;
	}

	public int getVatSurcharge() {
		return vatSurcharge;
	}

	public void setVatSurcharge(int vatSurcharge) {
		this.vatSurcharge = vatSurcharge;
	}

	public int getVatSurchargeValue() {
		return vatSurchargeValue;
	}

	public void setVatSurchargeValue(int vatSurchargeValue) {
		this.vatSurchargeValue = vatSurchargeValue;
	}

	public int getMiscOtherharges() {
		return miscOtherharges;
	}

	public void setMiscOtherharges(int miscOtherharges) {
		this.miscOtherharges = miscOtherharges;
	}

	public int getCustomDutyPer() {
		return customDutyPer;
	}

	public void setCustomDutyPer(int customDutyPer) {
		this.customDutyPer = customDutyPer;
	}

	public int getCvdPer() {
		return cvdPer;
	}

	public void setCvdPer(int cvdPer) {
		this.cvdPer = cvdPer;
	}

	public int getCessCvdPer() {
		return cessCvdPer;
	}

	public void setCessCvdPer(int cessCvdPer) {
		this.cessCvdPer = cessCvdPer;
	}

	public int getCessCustomPer() {
		return cessCustomPer;
	}

	public void setCessCustomPer(int cessCustomPer) {
		this.cessCustomPer = cessCustomPer;
	}

	public int getDutyPer() {
		return dutyPer;
	}

	public void setDutyPer(int dutyPer) {
		this.dutyPer = dutyPer;
	}

	public int getDevCharges() {
		return devCharges;
	}

	public void setDevCharges(int devCharges) {
		this.devCharges = devCharges;
	}

	public int getItemRecieved() {
		return itemRecieved;
	}

	public void setItemRecieved(int itemRecieved) {
		this.itemRecieved = itemRecieved;
	}

	public String getDol() {
		return dol;
	}

	public void setDol(String dol) {
		this.dol = dol;
	}

	public int getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(int serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public String getServiceTaxList() {
		return serviceTaxList;
	}

	public void setServiceTaxList(String serviceTaxList) {
		this.serviceTaxList = serviceTaxList;
	}

	public String getColCode() {
		return colCode;
	}

	public void setColCode(String colCode) {
		this.colCode = colCode;
	}

	public String getHeatNo() {
		return heatNo;
	}

	public void setHeatNo(String heatNo) {
		this.heatNo = heatNo;
	}

	public int getQtyRecBar() {
		return qtyRecBar;
	}

	public void setQtyRecBar(int qtyRecBar) {
		this.qtyRecBar = qtyRecBar;
	}

	public int getAddDutyPer() {
		return addDutyPer;
	}

	public void setAddDutyPer(int addDutyPer) {
		this.addDutyPer = addDutyPer;
	}

	public int getAddDutyValue() {
		return addDutyValue;
	}

	public void setAddDutyValue(int addDutyValue) {
		this.addDutyValue = addDutyValue;
	}

	public int getSadValue() {
		return sadValue;
	}

	public void setSadValue(int sadValue) {
		this.sadValue = sadValue;
	}

	public int getSad() {
		return sad;
	}

	public void setSad(int sad) {
		this.sad = sad;
	}

	public int getAed() {
		return aed;
	}

	public void setAed(int aed) {
		this.aed = aed;
	}

	public int getAedValue() {
		return aedValue;
	}

	public void setAedValue(int aedValue) {
		this.aedValue = aedValue;
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

	public double getSgstvalue() {
		return sgstvalue;
	}

	public void setSgstvalue(double sgstvalue) {
		this.sgstvalue = sgstvalue;
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

	public int getEdHcessCustomPer() {
		return edHcessCustomPer;
	}

	public void setEdHcessCustomPer(int edHcessCustomPer) {
		this.edHcessCustomPer = edHcessCustomPer;
	}

	public int getEdHcessCustom() {
		return edHcessCustom;
	}

	public void setEdHcessCustom(int edHcessCustom) {
		this.edHcessCustom = edHcessCustom;
	}

	public int getEdCessCustomPer() {
		return edCessCustomPer;
	}

	public void setEdCessCustomPer(int edCessCustomPer) {
		this.edCessCustomPer = edCessCustomPer;
	}

	public String getConUom() {
		return conUom;
	}

	public void setConUom(String conUom) {
		this.conUom = conUom;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public Date getMfDate() {
		return mfDate;
	}

	public void setMfDate(Date mfDate) {
		this.mfDate = mfDate;
	}

	public String getInExVatCst() {
		return inExVatCst;
	}

	public void setInExVatCst(String inExVatCst) {
		this.inExVatCst = inExVatCst;
	}

	public String getInclExcl() {
		return inclExcl;
	}

	public void setInclExcl(String inclExcl) {
		this.inclExcl = inclExcl;
	}

	public MRN getMrn() {
		return mrn;
	}

	public void setMrn(MRN mrn) {
		this.mrn = mrn;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}


	@Override
    public boolean equals(Object obj) {
        if (obj instanceof MRNDetail) {
            return ((MRNDetail) obj).mrn == mrn;
        }
        return false;
    }
    
	/*
	 * @Override public int hashCode() {
	 * 
	 * int i = this.mrnDetailId.intValue(); return i; }
	 */
	
	
	

}

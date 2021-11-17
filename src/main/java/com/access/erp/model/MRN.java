package com.access.erp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.CurrencyMaster;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.SupplierMaster;


@Entity
@Table(name="MATERIAL_RECEIPT")
public class MRN {

	@Id
	@Column(name="MRN_NO",length = 15)
	public String mrnNo;
	
	@Column(name="MRN_DATE" )
	public Date mrnDate;
	
	@ManyToOne
	@JoinColumn(name="GATE_ENTRY_NO")
	public GateEntry gateEntryNo;
	
	@Column(name="GATE_ENTRY_DATE")
	public Date gateEntryDate;
	
	@ManyToOne
	@JoinColumn(name="SUPP_CODE")
	public SupplierMaster supplierMaster;
	
	@Column(name="BILL_TYPE",length = 2)
	public String billType;
	
	@Column(name="BILL_NO",length = 25)
	public String billNo;
	
	@Column(name="MRN_TYPE",length = 2)
	public String mrnType;
	
	@ManyToOne
	@JoinColumn(name="CURRENCY_CODE")
	public CurrencyMaster currency;
	
	@Column(name="BILL_DATE")
	public Date billDate;
	
	@Column(name="RECIP_DATE")
	public Date reciepDate;
	
	@Column(name="CONVERSION_VALUE",length = 14)
	public String conversionvalue;
	
	
	
	@Column(name="MRN_VAL",length = 14) //decimal nummber ,.00(14,2)
	public int mrnval;
	
	
	
	
	
	
	
	
	
	
	
	@Column(name="PO_NO",length = 25)
	public String poNo;
	
	@Column(name="PO_DATE")
	public Date poDate;
	
	
	
	@Column(name="WORKER_CODE")
	public String workerCode;
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_CODE")
	public Employee employee;
	
	@ManyToOne
	@JoinColumn(name="CCODE")
	public Company company;
	
	@JoinColumn(name="FYCODE")
	public String mrmCode;
	
	@ManyToOne
	@JoinColumn(name="UCODE")
	public MyUser myUser;
	
	@Column(name="UDATE")
	public Date uDate;
	
	@Column(name="PENDING_AMT",length = 14)
	public int pendingAmt;
	
	@Column(name="TRADE_DISCOUNT",length = 5)
	public int tradeDiscount;
	
	@Column(name="EXCISE",length = 5)
	public int excise;
	
	@Column(name="SALES_TAX",length = 5)
	public int salesTax;
	
	@Column(name="CST",length = 5)
	public int cst;
	
	@Column(name="SURCHARGE",length = 5)
	public int surCharge;
	
	@Column(name="FREIGHT",length = 14)
	public int freight;
	
	@Column(name="PACKING",length = 14)
	public int packing;
	
	@Column(name="OCTROI",length = 14)
	public int octroi;
	
	@Column(name="DISCOUNT",length = 5)
	public int discount;
	
	@Column(name="CESS",length = 5)
	public int cess;
	
	@Column(name="VAT",length = 5)
	public int vat;
	
	@Column(name="BILL_VALUE",length = 14)
	public int billValue;
	
	@Column(name="CARTAGE",length = 5)
	public int cartage;
	
	@Column(name="STATUS_TAX",length = 2)
	public String statusTax;
	
	@Column(name="NAME_TRANS",length = 100)
	public String nameTrans;
	
	@Column(name="G_R_NO",length = 25)
	public String grNo;
	
	@Column(name="G_R_DATE")
	public Date grDate;
	
	
	
	@Column(name="CAPITALYN",length = 2)
	public String capitalYn;
	
	@Column(name="CFORM_YN",length = 2)
	public String cFromYn;
	
	
	
	
	
	
	
	
	
	@Column(name="CHALLAN_NO",length = 25)
	public String challenNo;
	
	@Column(name="CHALLAN_DATE")
	public Date challenDate;
	
	@Column(name="CT3_NO",length = 25)
	public String ct3No;
	
	@Column(name="CT3_DATE")
	public Date ct3Date;
	
	@Column(name="ARE3_NO",length = 25)
	public String are3No;
	
	@Column(name="ARE3_DATE")
	public Date are3Date;
	
	@Column(name="MODE_OF_ENTRY",length = 2)
	public String modeOfEntry;
	
	@Column(name="PVNO",length = 9)
	public String pvno;
	
	@Column(name="PVDATE")
	public Date pvDate;
	
	@Column(name="VAT_FORM_TYPE",length = 5)
	public String vatFromType;
	
	@Column(name="FORM_CODE",length = 4)
	public String fromCode;
	
	@Column(name="PROCUREMENT_NO",length = 20)
	public String procurementNo;
	
	@Column(name="PROCUREMENT_DATE")
	public Date procurementDate;
	
	@Column(name="BILL_ENTRY_NO",length = 20)
	public String billEntryNo;
	
	@Column(name="BILL_ENTRY_DATE")
	public Date billEntryDate;
	
	@Column(name="EXCISE_FORM_CODE",length = 4)
	public String exciseFormCode;
	
	@Column(name="POST_PV_YN",length = 2)
	public String postPvYn;
	
	@Column(name="AWB_BILL_NO",length = 50)
	public String awbBillNo;
	
	@Column(name="AWB_BILL_DATE" )
	public Date awbBillDate;
	
	@Column(name="PO_TYPE",length = 2)
	public String poType;
	
	@Column(name="TOTAL_ROUND_CHOICE",length = 2)
	public String totalGrandChoice;
	
	@Column(name="DEBIT_NOTE_DATE")
	public Date debitNoteDate;
	
	@Column(name="DEBIT_NOTE_NO",length = 9)
	public String debitNoteNo;
	
	@Column(name="DNOTE",length = 2)
	public String dNote;
	
	@Column(name="FORM_TYPE",length = 2)
	public String formType;
	
	@Column(name="PURCHASE_CAT",length = 2)
	public String purchaseCat;
	
	@Column(name="JVNO",length = 9)
	public String jvNO;
	
	@Column(name="JVDATE")
	public String jvDate;
	
	@Column(name="MRN_THROUGH",length = 2)
	public String mrnThrough;
	
	@Column(name="LC_NO",length = 16)
	public String lcNo;
	
	@Column(name="LC_DATE")
	public Date lcDate;
	
	@Column(name="BARCODE_ID",length = 4)
	public String barcodeId;
	
	@Column(name="ITC_ELIGIABLE",length = 1)
	public String itcEligiable;
	
	@OneToMany(mappedBy = "mrn", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<MRNDetail> mrnDetails = new ArrayList<>();
	
	

	public MRN() {
		super();
		
	}

	public String getMrnNo() {
		return mrnNo;
	}

	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	public Date getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(Date mrnDate) {
		this.mrnDate = mrnDate;
	}

	public int getMrnval() {
		return mrnval;
	}

	public void setMrnval(int mrnval) {
		this.mrnval = mrnval;
	}

	public SupplierMaster getSupplierMaster() {
		return supplierMaster;
	}

	public void setSupplierMaster(SupplierMaster supplierMaster) {
		this.supplierMaster = supplierMaster;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	public Date getReciepDate() {
		return reciepDate;
	}

	public void setReciepDate(Date reciepDate) {
		this.reciepDate = reciepDate;
	}

	public String getWorkerCode() {
		return workerCode;
	}

	public void setWorkerCode(String workerCode) {
		this.workerCode = workerCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getMrmCode() {
		return mrmCode;
	}

	public void setMrmCode(String mrmCode) {
		this.mrmCode = mrmCode;
	}

	public MyUser getMyUser() {
		return myUser;
	}

	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	public int getPendingAmt() {
		return pendingAmt;
	}

	public void setPendingAmt(int pendingAmt) {
		this.pendingAmt = pendingAmt;
	}

	public int getTradeDiscount() {
		return tradeDiscount;
	}

	public void setTradeDiscount(int tradeDiscount) {
		this.tradeDiscount = tradeDiscount;
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

	public int getPacking() {
		return packing;
	}

	public void setPacking(int packing) {
		this.packing = packing;
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

	public int getBillValue() {
		return billValue;
	}

	public void setBillValue(int billValue) {
		this.billValue = billValue;
	}

	public int getCartage() {
		return cartage;
	}

	public void setCartage(int cartage) {
		this.cartage = cartage;
	}

	public String getStatusTax() {
		return statusTax;
	}

	public void setStatusTax(String statusTax) {
		this.statusTax = statusTax;
	}

	public String getNameTrans() {
		return nameTrans;
	}

	public void setNameTrans(String nameTrans) {
		this.nameTrans = nameTrans;
	}

	public String getGrNo() {
		return grNo;
	}

	public void setGrNo(String grNo) {
		this.grNo = grNo;
	}

	public Date getGrDate() {
		return grDate;
	}

	public void setGrDate(Date grDate) {
		this.grDate = grDate;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public String getCapitalYn() {
		return capitalYn;
	}

	public void setCapitalYn(String capitalYn) {
		this.capitalYn = capitalYn;
	}

	public String getcFromYn() {
		return cFromYn;
	}

	public void setcFromYn(String cFromYn) {
		this.cFromYn = cFromYn;
	}

	

	public CurrencyMaster getCurrency() {
		return currency;
	}

	public void setCurrency(CurrencyMaster currency) {
		this.currency = currency;
	}

	public String getConversionvalue() {
		return conversionvalue;
	}

	public void setConversionvalue(String conversionvalue) {
		this.conversionvalue = conversionvalue;
	}

	public String getMrnType() {
		return mrnType;
	}

	public void setMrnType(String mrnType) {
		this.mrnType = mrnType;
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

	public String getChallenNo() {
		return challenNo;
	}

	public void setChallenNo(String challenNo) {
		this.challenNo = challenNo;
	}

	public Date getChallenDate() {
		return challenDate;
	}

	public void setChallenDate(Date challenDate) {
		this.challenDate = challenDate;
	}

	public String getCt3No() {
		return ct3No;
	}

	public void setCt3No(String ct3No) {
		this.ct3No = ct3No;
	}

	public Date getCt3Date() {
		return ct3Date;
	}

	public void setCt3Date(Date ct3Date) {
		this.ct3Date = ct3Date;
	}

	public String getAre3No() {
		return are3No;
	}

	public void setAre3No(String are3No) {
		this.are3No = are3No;
	}

	public Date getAre3Date() {
		return are3Date;
	}

	public void setAre3Date(Date are3Date) {
		this.are3Date = are3Date;
	}

	public String getModeOfEntry() {
		return modeOfEntry;
	}

	public void setModeOfEntry(String modeOfEntry) {
		this.modeOfEntry = modeOfEntry;
	}

	public String getPvno() {
		return pvno;
	}

	public void setPvno(String pvno) {
		this.pvno = pvno;
	}

	public Date getPvDate() {
		return pvDate;
	}

	public void setPvDate(Date pvDate) {
		this.pvDate = pvDate;
	}

	public String getVatFromType() {
		return vatFromType;
	}

	public void setVatFromType(String vatFromType) {
		this.vatFromType = vatFromType;
	}

	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
	}

	public String getProcurementNo() {
		return procurementNo;
	}

	public void setProcurementNo(String procurementNo) {
		this.procurementNo = procurementNo;
	}

	public Date getProcurementDate() {
		return procurementDate;
	}

	public void setProcurementDate(Date procurementDate) {
		this.procurementDate = procurementDate;
	}

	public String getBillEntryNo() {
		return billEntryNo;
	}

	public void setBillEntryNo(String billEntryNo) {
		this.billEntryNo = billEntryNo;
	}

	public Date getBillEntryDate() {
		return billEntryDate;
	}

	public void setBillEntryDate(Date billEntryDate) {
		this.billEntryDate = billEntryDate;
	}

	public String getExciseFormCode() {
		return exciseFormCode;
	}

	public void setExciseFormCode(String exciseFormCode) {
		this.exciseFormCode = exciseFormCode;
	}

	public String getPostPvYn() {
		return postPvYn;
	}

	public void setPostPvYn(String postPvYn) {
		this.postPvYn = postPvYn;
	}

	public String getAwbBillNo() {
		return awbBillNo;
	}

	public void setAwbBillNo(String awbBillNo) {
		this.awbBillNo = awbBillNo;
	}

	public Date getAwbBillDate() {
		return awbBillDate;
	}

	public void setAwbBillDate(Date awbBillDate) {
		this.awbBillDate = awbBillDate;
	}

	public String getPoType() {
		return poType;
	}

	public void setPoType(String poType) {
		this.poType = poType;
	}

	public String getTotalGrandChoice() {
		return totalGrandChoice;
	}

	public void setTotalGrandChoice(String totalGrandChoice) {
		this.totalGrandChoice = totalGrandChoice;
	}

	public Date getDebitNoteDate() {
		return debitNoteDate;
	}

	public void setDebitNoteDate(Date debitNoteDate) {
		this.debitNoteDate = debitNoteDate;
	}

	public String getDebitNoteNo() {
		return debitNoteNo;
	}

	public void setDebitNoteNo(String debitNoteNo) {
		this.debitNoteNo = debitNoteNo;
	}

	public String getdNote() {
		return dNote;
	}

	public void setdNote(String dNote) {
		this.dNote = dNote;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getPurchaseCat() {
		return purchaseCat;
	}

	public void setPurchaseCat(String purchaseCat) {
		this.purchaseCat = purchaseCat;
	}

	public String getJvNO() {
		return jvNO;
	}

	public void setJvNO(String jvNO) {
		this.jvNO = jvNO;
	}

	public String getJvDate() {
		return jvDate;
	}

	public void setJvDate(String jvDate) {
		this.jvDate = jvDate;
	}

	public String getMrnThrough() {
		return mrnThrough;
	}

	public void setMrnThrough(String mrnThrough) {
		this.mrnThrough = mrnThrough;
	}

	public String getLcNo() {
		return lcNo;
	}

	public void setLcNo(String lcNo) {
		this.lcNo = lcNo;
	}

	public Date getLcDate() {
		return lcDate;
	}

	public void setLcDate(Date lcDate) {
		this.lcDate = lcDate;
	}

	public String getBarcodeId() {
		return barcodeId;
	}

	public void setBarcodeId(String barcodeId) {
		this.barcodeId = barcodeId;
	}

	public String getItcEligiable() {
		return itcEligiable;
	}

	public void setItcEligiable(String itcEligiable) {
		this.itcEligiable = itcEligiable;
	}

	public List<MRNDetail> getMrnDetails() {
		return mrnDetails;
	}

	public void setMrnDetails(List<MRNDetail> mrnDetails) {
		this.mrnDetails = mrnDetails;
	}
	
	
	
}

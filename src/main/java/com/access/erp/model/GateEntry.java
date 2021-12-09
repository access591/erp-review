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

import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.SupplierMaster;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "GATE_ENTRY")
public class GateEntry {

	@Id
	@Column(name = "GATE_SR_NO", length = 20)
	private String gateSrNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "GATE_ENTRY_DATE")
	private Date gateEntryDate;

	@Column(name = "ENTRY_TYPE", length = 2)
	private String entryType;

	// supplier code

	@ManyToOne(optional = false)
	@JoinColumn(name = "SUPPLIER_CODE")
	private PartyMaster partyMaster;

	@Column(name = "GR_NUMBER", length = 25)
	private String grNumber;

	@Column(name = "GR_DATE")
	private Date grDate;

	// tr_code
	@Column(name = "TR_CODE", length = 15)
	private String trCode;
	
	@Column(name = "VEHICLE_NUMBER", length = 20)
	private String vehicleNumber;
	
	@Column(name = "REMARKS", length = 500)
	private String remarks;
	

	@Column(name = "ORDER_NO", length = 20)
	private String orderNo;

	@Column(name = "TIME_IN")
	private Date timeIn;

	

	@Column(name = "BILL_NUMBER", length = 20)
	private String billNumber;

	@Column(name = "BILL_DATE")
	private Date billDate;

	@Column(name = "GOODS_CATEGORY", length = 8)
	private String goodsCategory;

	

	// ccode
	@ManyToOne(optional = false)
	@JoinColumn(name = "CCODE")
	private Company company;

	// fycode
	@ManyToOne(optional = false)
	@JoinColumn(name = "FY_CODE")
	private FinancialActiveYear financialActiveYear;

	// ucode

	@ManyToOne(optional = false)
	@JoinColumn(name = "U_CODE")
	private MyUser myUser;

	@Column(name = "U_DATE")
	private Date uDate;

	@Column(name = "RETURN_GATE_PASS_NO", length = 20)
	private String returnGatePassNo;

	@Column(name = "NAME_TRANS", length = 100)
	private String nameTrans;

	@Column(name = "BILL_TYPE", length = 2)
	private String billType;

	@Column(name = "REP_OUT_NO", length = 15)
	private String repOutNo;

	@Column(name = "GATE_PASS_DATE")
	private Date gatePassdate;

	@Column(name = "PAY_ABLE_TO", length = 50)
	private String payableTo;

	@Column(name = "LABOUR_CHARGES", length = 16)
	private float labourCharges;

	@Column(name = "FRIEGHT_CHARGES", length = 16)
	private float freightCharges;

	@Column(name = "JVNO", length = 10)
	private String jvno;

	@Column(name = "JV_DATE")
	private String jvDate;

	@Column(name = "BILL_AMOUNT", length = 16)
	private int billAmount;

	@Column(name = "TRANS_MODE", length = 15)
	private String transMode;

	@Column(name = "SCHEDULE_NO", length = 15)
	private String secheduleNo;

	@Column(name = "SCHEDULE_DATE")
	private Date secheduledate;

	@Column(name = "SHIFT", length = 15)
	private String shift;

	@Column(name = "T_DATE")
	private Date tDate;

	@Column(name = "REGISTER_NUMBER", length = 25)
	private String registerNumber;

	@Column(name = "REGISTER_DATE")
	private Date registerDate;

	@Column(name = "PITTY_INDENT_DATE")
	private Date pittyIndentDate;

	@Column(name = "PITTY_INDENT", length = 30)
	private String pittyIndent;

	@Column(name = "WARRANTY_NO", length = 20)
	private String warrantyNo;

	@Column(name = "WARRANTY_DATE")
	private String warrantyDate;

	@Column(name = "BAR_CODE", length = 14)
	private int barCode;

	
	@JsonManagedReference
	@OneToMany(mappedBy = "gateEntry", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<GateEntryItemDetail> gateEntryItemDetails = new ArrayList<>();

	public GateEntry() {
		super();

	}

	public String getGateSrNo() {
		return gateSrNo;
	}

	public void setGateSrNo(String gateSrNo) {
		this.gateSrNo = gateSrNo;
	}

	public Date getGateEntryDate() {
		return gateEntryDate;
	}

	public void setGateEntryDate(Date gateEntryDate) {
		this.gateEntryDate = gateEntryDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}



	public PartyMaster getPartyMaster() {
		return partyMaster;
	}

	public void setPartyMaster(PartyMaster partyMaster) {
		this.partyMaster = partyMaster;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getGoodsCategory() {
		return goodsCategory;
	}

	public void setGoodsCategory(String goodsCategory) {
		this.goodsCategory = goodsCategory;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public FinancialActiveYear getFinancialActiveYear() {
		return financialActiveYear;
	}

	public void setFinancialActiveYear(FinancialActiveYear financialActiveYear) {
		this.financialActiveYear = financialActiveYear;
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

	public String getReturnGatePassNo() {
		return returnGatePassNo;
	}

	public void setReturnGatePassNo(String returnGatePassNo) {
		this.returnGatePassNo = returnGatePassNo;
	}

	public String getNameTrans() {
		return nameTrans;
	}

	public void setNameTrans(String nameTrans) {
		this.nameTrans = nameTrans;
	}

	public String getGrNumber() {
		return grNumber;
	}

	public void setGrNumber(String grNumber) {
		this.grNumber = grNumber;
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

	public String getRepOutNo() {
		return repOutNo;
	}

	public void setRepOutNo(String repOutNo) {
		this.repOutNo = repOutNo;
	}

	public String getTrCode() {
		return trCode;
	}

	public void setTrCode(String trCode) {
		this.trCode = trCode;
	}

	public Date getGatePassdate() {
		return gatePassdate;
	}

	public void setGatePassdate(Date gatePassdate) {
		this.gatePassdate = gatePassdate;
	}

	public String getEntryType() {
		return entryType;
	}

	public void setEntryType(String entryType) {
		this.entryType = entryType;
	}

	public String getPayableTo() {
		return payableTo;
	}

	public void setPayableTo(String payableTo) {
		this.payableTo = payableTo;
	}

	public float getLabourCharges() {
		return labourCharges;
	}

	public void setLabourCharges(float labourCharges) {
		this.labourCharges = labourCharges;
	}

	public float getFreightCharges() {
		return freightCharges;
	}

	public void setFreightCharges(float freightCharges) {
		this.freightCharges = freightCharges;
	}

	public String getJvno() {
		return jvno;
	}

	public void setJvno(String jvno) {
		this.jvno = jvno;
	}

	public String getJvDate() {
		return jvDate;
	}

	public void setJvDate(String jvDate) {
		this.jvDate = jvDate;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public String getTransMode() {
		return transMode;
	}

	public void setTransMode(String transMode) {
		this.transMode = transMode;
	}

	public String getSecheduleNo() {
		return secheduleNo;
	}

	public void setSecheduleNo(String secheduleNo) {
		this.secheduleNo = secheduleNo;
	}

	public Date getSecheduledate() {
		return secheduledate;
	}

	public void setSecheduledate(Date secheduledate) {
		this.secheduledate = secheduledate;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Date gettDate() {
		return tDate;
	}

	public void settDate(Date tDate) {
		this.tDate = tDate;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Date getPittyIndentDate() {
		return pittyIndentDate;
	}

	public void setPittyIndentDate(Date pittyIndentDate) {
		this.pittyIndentDate = pittyIndentDate;
	}

	public String getPittyIndent() {
		return pittyIndent;
	}

	public void setPittyIndent(String pittyIndent) {
		this.pittyIndent = pittyIndent;
	}

	public String getWarrantyNo() {
		return warrantyNo;
	}

	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	public String getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(String warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public int getBarCode() {
		return barCode;
	}

	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}

	public List<GateEntryItemDetail> getGateEntryItemDetails() {
		return gateEntryItemDetails;
	}

	public void setGateEntryItemDetails(List<GateEntryItemDetail> gateEntryItemDetails) {
		this.gateEntryItemDetails = gateEntryItemDetails;
	}

}

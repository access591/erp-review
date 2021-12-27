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
import com.access.erp.model.master.Department;
import com.access.erp.model.master.Employee;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.model.master.SupplierMaster;


@Entity
@Table(name="GATE_PASS")
public class GatePass {

	@Id
	@Column(name = "GATE_PASS_NO", length = 15)
	private String gatePassNo;

	@Column(name = "GATE_PASS_DATE")
	private Date gatePassDate;

	@Column(name = "GATE_PASS_TYPE", length = 2)
	private String gatePassType;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ITEM_RETURN_DATE")
	private Date itemReturnDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CANCELLATION_DATE")
	private Date canellationDate;
	

	@ManyToOne
	@JoinColumn(name = "DEPT_CODE", nullable = false)
	private Department department;

	@ManyToOne
	@JoinColumn(name = "EMPLOYEE_CODE",nullable = false)
	private Employee employee;
	
	
	@ManyToOne
	@JoinColumn(name = "SUPP_CODE",nullable=false)
	private SupplierMaster supplier;
	
	@Column(name = "CUST_CODE", length = 15)
	private String custCode;

	
	@Column(name = "CONSIGNEE_NAME", length = 30)
	private String consigneeName;

	@Column(name = "CONSIGNEE_ADDRESS", length = 200)
	private String consigneeAddress;
	
	@Column(name = "PURPOSE", length = 200)
	private String purpose;

	@Column(name = "REMARKS", length = 500)
	private String remarks;


	
	@Column(name = "WORKER_CODE", length = 10)
	private String workerCode;

	

	@Column(name = "SENT_LOCATION", length = 30)
	private String sentLocation;

	
	

	

	
	

	@ManyToOne
	@JoinColumn(name = "CCODE",nullable=false,updatable = false,insertable = true)
	private Company ccode;

	@ManyToOne
	@JoinColumn(name = "FYCODE",nullable=false,updatable = false,insertable = true)
	private FinancialYear fycode;

	@ManyToOne
	@JoinColumn(name = "UCODE",nullable = false,updatable = false,insertable = true)
	private MyUser myUser;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UDATE")
	private Date udate;

	@Column(name = "INVOICE_NO", length = 15)
	private String invoiceNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "INVOICE_DATE")
	private Date invoiceDate;

	@Column(name = "CHALLAN_NO", length = 15)
	private String challanNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "CHALLAN_DATE")
	private Date challanDate;
	
	@Column(name = "JOB_OUT_NO", length = 15)
	private String jobOutNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "JOB_OUT_DATE")
	private Date jobOutDate;
	
	@Column(name = "ISS_NO", length = 15)
	private String issNo;

	@Column(name = "ISS_DT")
	private String issDate;

	@ManyToOne
	@JoinColumn(name = "PARTY_CODE",nullable = false)
	private PartyMaster party;

	@Column(name = "LOAN_SR_NO", length = 15)
	private String loanSrNo;

	@Column(name = "LOAN_DATE")
	private String loanDate;

	@Column(name = "REP_OUT_NO", length = 15)
	private String repOutNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "REP_OUT_DATE")
	private Date repOutDate;

	@Column(name = "SUB_CONSIGNEE_TYPE", length = 2)
	private String subConsigneeType;

	

	@ManyToOne
	@JoinColumn(name = "MRN_NO",nullable = false)
	private MRN mrn;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "MRN_DATE")
	private String mrnDate;

	@Column(name = "CARRIER_NAME", length = 200)
	private String carrierName;

	
	
	@OneToMany(mappedBy = "gatePass", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	List<GatePassDetail> gatePassDetails = new ArrayList<>();

	public GatePass() {
		super();
	}

	public String getGatePassNo() {
		return gatePassNo;
	}

	public void setGatePassNo(String gatePassNo) {
		this.gatePassNo = gatePassNo;
	}

	public Date getGatePassDate() {
		return gatePassDate;
	}

	public void setGatePassDate(Date gatePassDate) {
		this.gatePassDate = gatePassDate;
	}

	public String getGatePassType() {
		return gatePassType;
	}

	public void setGatePassType(String gatePassType) {
		this.gatePassType = gatePassType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	public Date getItemReturnDate() {
		return itemReturnDate;
	}

	public void setItemReturnDate(Date itemReturnDate) {
		this.itemReturnDate = itemReturnDate;
	}

	public String getSentLocation() {
		return sentLocation;
	}

	public void setSentLocation(String sentLocation) {
		this.sentLocation = sentLocation;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public SupplierMaster getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierMaster supplier) {
		this.supplier = supplier;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCanellationDate() {
		return canellationDate;
	}

	public void setCanellationDate(Date canellationDate) {
		this.canellationDate = canellationDate;
	}

	public Company getCcode() {
		return ccode;
	}

	public void setCcode(Company ccode) {
		this.ccode = ccode;
	}

	

	public FinancialYear getFycode() {
		return fycode;
	}

	public void setFycode(FinancialYear fycode) {
		this.fycode = fycode;
	}

	public MyUser getMyUser() {
		return myUser;
	}

	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public Date getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(Date challanDate) {
		this.challanDate = challanDate;
	}

	public PartyMaster getParty() {
		return party;
	}

	public void setParty(PartyMaster party) {
		this.party = party;
	}

	public String getLoanSrNo() {
		return loanSrNo;
	}

	public void setLoanSrNo(String loanSrNo) {
		this.loanSrNo = loanSrNo;
	}

	public String getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}

	public String getRepOutNo() {
		return repOutNo;
	}

	public void setRepOutNo(String repOutNo) {
		this.repOutNo = repOutNo;
	}

	public Date getRepOutDate() {
		return repOutDate;
	}

	public void setRepOutDate(Date repOutDate) {
		this.repOutDate = repOutDate;
	}

	public String getSubConsigneeType() {
		return subConsigneeType;
	}

	public void setSubConsigneeType(String subConsigneeType) {
		this.subConsigneeType = subConsigneeType;
	}

	public String getJobOutNo() {
		return jobOutNo;
	}

	public void setJobOutNo(String jobOutNo) {
		this.jobOutNo = jobOutNo;
	}

	public Date getJobOutDate() {
		return jobOutDate;
	}

	public void setJobOutDate(Date jobOutDate) {
		this.jobOutDate = jobOutDate;
	}

	public MRN getMrn() {
		return mrn;
	}

	public void setMrn(MRN mrn) {
		this.mrn = mrn;
	}

	public String getMrnDate() {
		return mrnDate;
	}

	public void setMrnDate(String mrnDate) {
		this.mrnDate = mrnDate;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getIssNo() {
		return issNo;
	}

	public void setIssNo(String issNo) {
		this.issNo = issNo;
	}

	public String getIssDate() {
		return issDate;
	}

	public void setIssDate(String issDate) {
		this.issDate = issDate;
	}

	public List<GatePassDetail> getGatePassDetails() {
		return gatePassDetails;
	}

	public void setGatePassDetails(List<GatePassDetail> gatePassDetails) {
		this.gatePassDetails = gatePassDetails;
	}
	
	
	
	
	
	
	

}

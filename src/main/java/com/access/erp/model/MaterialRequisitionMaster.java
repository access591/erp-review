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

import com.access.erp.model.master.Employee;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Store;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="MATERIAL_REQUISITION_MASTER")
public class MaterialRequisitionMaster {

	@Id
	@Column(name="REQUISITION_NO", length = 15)
	private String requisitionNo;  
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="REQUISITION_DATE")
	private Date requisitionDate;  
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_CODE",nullable=false)
	private Employee employee;  
	
	@Column(name="REQUISITION_TYPE", length = 2)
	private String requisitionType;  
	
	@Column(name="WORK_CENTER_CODE", length = 6 )
	private String workCenterCode;  
	
	
	@Column(name="REQ_TYPE", length = 2)
	private String reqType;  
	
	@ManyToOne
	@JoinColumn(name="STORE_CODE",nullable = false)
	private Store store; 
	
	
	@Column(name="REMARKS", length = 500)
	private String remarks;  
	
	@Column(name="LOT_NO", length = 15)
	private String lotNo;  
	
	@Column(name="CCODE")
	private String cCode;  
	
	@ManyToOne
	@JoinColumn(name="UCODE",nullable = true)
	private MyUser myUser;  
	
	@Column(name="UDATE")
	private Date uDate;  
	
	@Column(name="PLANNING_ID", length = 15)
	private String planningId;  
	
	
	
	
	@Column(name="SITE_CODE", length = 30)
	private String siteCode;  
	
	
	
	@Column(name="LOCATION", length = 50)
	private String location;  
	
	@ManyToOne
	@JoinColumn(name="FYCODE",nullable = true)
	private FinancialActiveYear fyYear;  
	
	@Column(name="PLANNING_DATE")
	private Date planningDate;  
	
	@ManyToOne
	@JoinColumn(name="INDENT_NO",nullable = true)
	private OpenIndent openIndent;  
	
	@Column(name="INDENT_DATE")
	private Date indentDate;  
	
	@Column(name="DAILY_TRANSACTION_ID ", length = 15)
	private String dailyTransactionId;  
	
	@Column(name="DAILY_TRANSACTION_DATE")
	private Date dailyTransactionDate; 
	
	@Column(name="REQUISITION_STATUS", length = 2)
	private String requisitionStatus;  
	
	@Column(name="LOT_DATE")
	private Date lotDate; 
	
	@Column(name="APPROVAL_STATUS", length = 2)
	private String approvalStatus = "N";  
	
	@Column(name="DATE_OF_APPROVAL")
	private Date dateOfApproval;  
	
	@Column(name="APPROVAL_CODE", length = 10)
	private String approvalCode; 
	
	@Column(name="DATE_OF_CANCEL")
	private Date dateOfCancel;  
	
	@Column(name="REMARKS_CANCEL", length = 500)
	private String remarksCancel;
	
	@Column(name="PRO_ORDER_NO", length = 15)
	private String proOrderNo;  
	
	
	@Column(name="PO_DATE")
	private Date poDate;  
	
	
	@Column(name="JOB_ID", length = 15)
	private String jobId;  
	
	
	@Column(name="JOB_DATE")
	private Date jobDate;  
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "materialRequisitionMaster", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	List<MaterialRequisitionDetail> materialRequisitionDetails = new ArrayList<>();

	public MaterialRequisitionMaster() {
		super();
		
	}

	public String getRequisitionNo() {
		return requisitionNo;
	}

	public void setRequisitionNo(String requisitionNo) {
		this.requisitionNo = requisitionNo;
	}

	public Date getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
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

	public String getPlanningId() {
		return planningId;
	}

	public void setPlanningId(String planningId) {
		this.planningId = planningId;
	}

	public String getWorkCenterCode() {
		return workCenterCode;
	}

	public void setWorkCenterCode(String workCenterCode) {
		this.workCenterCode = workCenterCode;
	}

	public String getRequisitionType() {
		return requisitionType;
	}

	public void setRequisitionType(String requisitionType) {
		this.requisitionType = requisitionType;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public FinancialActiveYear getFyYear() {
		return fyYear;
	}

	public void setFyYear(FinancialActiveYear fyYear) {
		this.fyYear = fyYear;
	}

	public Date getPlanningDate() {
		return planningDate;
	}

	public void setPlanningDate(Date planningDate) {
		this.planningDate = planningDate;
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

	public String getDailyTransactionId() {
		return dailyTransactionId;
	}

	public void setDailyTransactionId(String dailyTransactionId) {
		this.dailyTransactionId = dailyTransactionId;
	}

	public Date getDailyTransactionDate() {
		return dailyTransactionDate;
	}

	public void setDailyTransactionDate(Date dailyTransactionDate) {
		this.dailyTransactionDate = dailyTransactionDate;
	}

	public String getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public Date getLotDate() {
		return lotDate;
	}

	public void setLotDate(Date lotDate) {
		this.lotDate = lotDate;
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

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}

	public Date getDateOfCancel() {
		return dateOfCancel;
	}

	public void setDateOfCancel(Date dateOfCancel) {
		this.dateOfCancel = dateOfCancel;
	}

	public String getRemarksCancel() {
		return remarksCancel;
	}

	public void setRemarksCancel(String remarksCancel) {
		this.remarksCancel = remarksCancel;
	}

	public String getProOrderNo() {
		return proOrderNo;
	}

	public void setProOrderNo(String proOrderNo) {
		this.proOrderNo = proOrderNo;
	}

	public Date getPoDate() {
		return poDate;
	}

	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getJobDate() {
		return jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<MaterialRequisitionDetail> getMaterialRequisitionDetails() {
		return materialRequisitionDetails;
	}

	public void setMaterialRequisitionDetails(List<MaterialRequisitionDetail> materialRequisitionDetails) {
		this.materialRequisitionDetails = materialRequisitionDetails;
	}
	
	
	
	
	
}

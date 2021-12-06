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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.access.erp.model.master.Employee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;





@Entity
@Table(name = "PR_INDENT_MAST")
public class OpenIndent {

	@Id
	@Column(name = "INDENT_NO", length = 15)
	private String indentNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "INDENTS_DATE")
	private Date indentDate;

	@Column(name = "IND_DEPT", length = 6)
	private String indDept;

	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="EMP_CODE")
	//@JsonBackReference
	@JsonIgnore
	private Employee employee;

	@Column(name = "WORKER_CODE", length = 10)
	private String workerCode;

	@Column(name = "IND_REMARKS", length = 500)
	private String indentRemark;

	@Column(name = "APPROVAL_STATUS", length = 2)
	private String approvalStatus = "N";
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_APPROVAL")
	private Date dateOfApproval;
	
	//employee code 
	// final approval 
	
	
	@ManyToOne( optional = true)
	@JoinColumn(name = "AUTH_EMP_CODE",nullable = true)
	//@JsonManagedReference
	@JsonIgnore
	private Employee authEmpCode;
	
	@Column(name = "DEPT_CODE", length = 50)
	private String deptCode;
	
	
	@Column(name = "DEPT_NAME", length = 50)
	private String deptName;
	
	@Column(name = "IND_PUR_STATUS", length = 2)
	private String indPurStatus;
	
	//fk
	@Column(name = "CCODE", length = 50)
	private String company;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "UDATE", length = 50)
	private Date update;
	
	@Column(name = "URGENCY", length = 20)
	private String urgency;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "AS_ON_DATE")
	private Date asOnDate;
	
	
	//14,2 
	@Column(name = "TOTAL_VALUE", length = 20)
	private int totalvalue;

	@Column(name = "CURRENCY_CODE", length = 2)
	private String currencyCode;

	
	//fk
	@Column(name = "FYCODE", length = 20)
	private String fyCode;

	
	//fk
	@Column(name = "UCODE", length = 50)
	private String user;
	
	@Column(name = "CONVERSION_VALUE", length = 16)
	private String conversionValue;
	
	@Column(name = "INDENT_TYPE", length = 2)
	private String indentType;
	
	@Column(name = "SALES_ORDER_NU", length = 50)
	private String salesOrderNu;
	
	@Column(name = "ID_OR_SO", length = 2)
	private String idOrSo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "SALES_ORDER_DATE")
	private Date salesOrderDate;
	
	@Column(name = "REMARKS", length = 500)
	private String remarks;


	@Column(name = "UNAME", length = 50)
	private String uName;

	@Column(name = "EXCISEABLE", length = 2)
	private String exciseable;
	
	@Column(name = "REQUISITION_NO", length = 20)
	private String requistionNu;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "REQUISITION_DATE", length = 100)
	private Date requisitionDate;
	
	@Column(name = "INDENT_STATUS", length = 2)
	private String indentsStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "DATE_OF_CANCEL")
	private Date dateOfCancel;

	@Column(name = "REMARKS_CANCEL", length = 100)
	private String remarkCancel;

	@Column(name = "OP_IND_YN", length = 2)
	private String opIndYn;
	
	@Column(name = "APPROVAL_STATUS_L1", length = 2)
	private String approvalStatus1 = "N";
	
	@Column(name = "APPROVAL_STATUS_L2", length = 2)
	private String approvalStatus2 = "N";

	
	@Column(name = "APPROVAL_STATUS_L3", length = 2)
	private String approvalStatus3 = "N";
	
	@Column(name = "APPROVAL_STATUS_L4", length = 2)
	private String approvalStatus4;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "APPROVAL_DATE_L1")
	private Date approvalDate1;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "APPROVAL_DATE_L2")
	private Date approvalDate2;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "APPROVAL_DATE_L3")
	private Date approvalDate3;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "APPROVAL_DATE_L4")
	private Date approvalDate4;
	
	
	@Column(name = "APPROVED_BY_L1", length = 20)
	private String approvedBy1;
	
	@Column(name = "APPROVED_BY_L2", length = 20)
	private String approvedBy2;

	
	@Column(name = "APPROVED_BY_L3", length = 20)
	private String approvedBy3;
	
	@Column(name = "APPROVED_BY_L4", length = 20)
	private String approvedBy4;
	
	@Column(name = "REMARKS_L1", length = 500)
	private String remarks1;
	
	@Column(name = "REMARKS_L2", length = 500)
	private String remarks2;

	
	@Column(name = "REMARKS_L3", length = 500)
	private String remarks3;
	
	@Column(name = "REMARKS_L4", length = 500)
	private String remarks4;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "openIndent")
	@Fetch(value = FetchMode.SUBSELECT)
	//@JsonManagedReference
	private List<OpenIndentDetail> opeIndentDetail = new ArrayList<>();


	public OpenIndent() {
		super();
		
	}


	public String getIndentNumber() {
		return indentNumber;
	}


	public void setIndentNumber(String indentNumber) {
		this.indentNumber = indentNumber;
	}


	public Date getIndentDate() {
		
		
		return indentDate;
	}


	public void setIndentDate(Date indentDate) {
		this.indentDate = indentDate;
	}


	public String getIndDept() {
		return indDept;
	}


	public void setIndDept(String indDept) {
		this.indDept = indDept;
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


	public String getIndentRemark() {
		return indentRemark;
	}


	public void setIndentRemark(String indentRemark) {
		this.indentRemark = indentRemark;
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


	

	public Employee getAuthEmpCode() {
		return authEmpCode;
	}


	public void setAuthEmpCode(Employee authEmpCode) {
		this.authEmpCode = authEmpCode;
	}


	public String getIndPurStatus() {
		return indPurStatus;
	}


	public void setIndPurStatus(String indPurStatus) {
		this.indPurStatus = indPurStatus;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public Date getUpdate() {
		return update;
	}


	public void setUpdate(Date update) {
		this.update = update;
	}


	public String getUrgency() {
		return urgency;
	}


	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}


	public Date getAsOnDate() {
		return asOnDate;
	}


	public void setAsOnDate(Date asOnDate) {
		this.asOnDate = asOnDate;
	}


	public int getTotalvalue() {
		return totalvalue;
	}


	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}


	public String getCurrencyCode() {
		return currencyCode;
	}


	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public String getFyCode() {
		return fyCode;
	}


	public void setFyCode(String fyCode) {
		this.fyCode = fyCode;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getConversionValue() {
		return conversionValue;
	}


	public void setConversionValue(String conversionValue) {
		this.conversionValue = conversionValue;
	}


	public String getIndentType() {
		return indentType;
	}


	public void setIndentType(String indentType) {
		this.indentType = indentType;
	}


	public String getSalesOrderNu() {
		return salesOrderNu;
	}


	public void setSalesOrderNu(String salesOrderNu) {
		this.salesOrderNu = salesOrderNu;
	}


	public String getIdOrSo() {
		return idOrSo;
	}


	public void setIdOrSo(String idOrSo) {
		this.idOrSo = idOrSo;
	}


	public Date getSalesOrderDate() {
		return salesOrderDate;
	}


	public void setSalesOrderDate(Date salesOrderDate) {
		this.salesOrderDate = salesOrderDate;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	public String getExciseable() {
		return exciseable;
	}


	public void setExciseable(String exciseable) {
		this.exciseable = exciseable;
	}


	public String getRequistionNu() {
		return requistionNu;
	}


	public void setRequistionNu(String requistionNu) {
		this.requistionNu = requistionNu;
	}


	public Date getRequisitionDate() {
		return requisitionDate;
	}


	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}


	public String getIndentsStatus() {
		return indentsStatus;
	}


	public void setIndentsStatus(String indentsStatus) {
		this.indentsStatus = indentsStatus;
	}


	public Date getDateOfCancel() {
		return dateOfCancel;
	}


	public void setDateOfCancel(Date dateOfCancel) {
		this.dateOfCancel = dateOfCancel;
	}


	public String getRemarkCancel() {
		return remarkCancel;
	}


	public void setRemarkCancel(String remarkCancel) {
		this.remarkCancel = remarkCancel;
	}


	public String getOpIndYn() {
		return opIndYn;
	}


	public void setOpIndYn(String opIndYn) {
		this.opIndYn = opIndYn;
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


	public List<OpenIndentDetail> getOpeIndentDetail() {
		return opeIndentDetail;
	}


	public void setOpeIndentDetail(List<OpenIndentDetail> opeIndentDetail) {
		this.opeIndentDetail = opeIndentDetail;
	}


	public String getDeptCode() {
		return deptCode;
	}


	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	

	
	
}

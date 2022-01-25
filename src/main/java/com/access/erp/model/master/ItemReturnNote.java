package com.access.erp.model.master;

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

import com.access.erp.model.IssueSlip;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "RECEIPT_MASTER")
public class ItemReturnNote {

	@Id
	@Column(name = "RECEIPT_NO", length = 15)
	private String receiptNo;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "RECEIPT_DATE")
	private Date recptDate;

	@ManyToOne(optional = true)
	@JoinColumn(name = "ISSUE_NO")
	@JsonIgnore
	private IssueSlip issueSlip;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	@Column(name = "REMARKS", length = 500)
	private Date remarks;

	@ManyToOne(optional = true)
	@JoinColumn(name = "CCODE", updatable = false, insertable = true)
	@JsonIgnore
	private Company company;

	@ManyToOne
	@JoinColumn(name = "FY_CODE", updatable = false, insertable = true)
	@JsonIgnore
	private FinancialYear fyyear;

	@ManyToOne(optional = false)
	@JoinColumn(name = "U_CODE", updatable = false, insertable = true)
	@JsonIgnore
	private MyUser myUser;

	@Column(name = "U_DATE")
	private Date uDate;

	@ManyToOne(optional = true)
	@JoinColumn(name = "EMPLOYEE_CODE", nullable = true)
	@JsonIgnore
	private Employee employee;

	@Column(name = "WORKER_CODE")
	private String workerCode;

	@Column(name = "CAPITAL_YN")
	private String capital;

	@Column(name = "SITE_CODE")
	private String siteCode;

	@Column(name = "ISSUE_MODE")
	private String issMode;

	@Column(name = "WORK_CENTRE_CODE", length = 6)
	private String workCK;

	@OneToMany(mappedBy = "itemReturnNote", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonManagedReference
	private List<ItemReturnNoteDetail> listItemReturnNoteDetail = new ArrayList<>();

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public Date getRecptDate() {
		return recptDate;
	}

	public void setRecptDate(Date recptDate) {
		this.recptDate = recptDate;
	}

	public IssueSlip getIssueSlip() {
		return issueSlip;
	}

	public void setIssueSlip(IssueSlip issueSlip) {
		this.issueSlip = issueSlip;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getRemarks() {
		return remarks;
	}

	public void setRemarks(Date remarks) {
		this.remarks = remarks;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public FinancialYear getFyyear() {
		return fyyear;
	}

	public void setFyyear(FinancialYear fyyear) {
		this.fyyear = fyyear;
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

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getIssMode() {
		return issMode;
	}

	public void setIssMode(String issMode) {
		this.issMode = issMode;
	}

	public String getWorkCK() {
		return workCK;
	}

	public void setWorkCK(String workCK) {
		this.workCK = workCK;
	}

	public List<ItemReturnNoteDetail> getListItemReturnNoteDetail() {
		return listItemReturnNoteDetail;
	}

	public void setListItemReturnNoteDetail(List<ItemReturnNoteDetail> listItemReturnNoteDetail) {
		this.listItemReturnNoteDetail = listItemReturnNoteDetail;
	}

}

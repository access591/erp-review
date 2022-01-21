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

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.Store;


@Entity
@Table(name = "REJECTION_ISSUE")
public class RejectionIssue {

	@Id
	@Column(name = "ISSUE_NO", length = 15)
	private String IssNo;


	@Column(name = "ISS_DT")
	private Date issueDate;

	@Column(name = "ISS_TYPE", length = 10)
	private String issType;

	@Column(name = "ISS_DEPT", length = 15)
	private String issDept;

	@Column(name = "WORK_CENTRE_CODE", length = 6)
	private String workCK;

	@Column(name = "ISS_TO")
	private String issTo;

	@Column(name = "ISSUED_BY", length = 9)
	private String IssuedBy;

	@ManyToOne
	@JoinColumn(name = "CCODE")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "FYCODE")
	private FinancialYear financialyear;

	@Column(name = "UPDATE_BY", length = 50)
	private String updateBy;

	@Column(name = "UDATE")
	private Date updatedDate;

	@ManyToOne
	@JoinColumn(name = "STORE_CODE", updatable = true, insertable = true)
	private Store store;

	
	@ManyToOne
	@JoinColumn(name = "REQUISITION_NO")
	private MaterialRequisitionMaster requisitionMaster;

	@Column(name = "REQUISITION_DATE")
	private Date reqDate;;

	@Column(name = "MANUAL_ISSUE_SLIP_NO")
	private String manualIssSlipNo;

	@Column(name = "BULK_ISSUE", length = 1)
	private String bulkIssue;

	@Column(name = "PRODUCT_CODE", length = 15)
	private String productCode;

	@Column(name = "DESIGN_CODE", length = 9)
	private String designCode;

	@Column(name = "PROCESS_CODE", length = 15)
	private String processCode;

	@Column(name = "FOR_TRADING", length = 1)
	private String forTrading;

	@Column(name = "REQ_TYPE", length = 1)
	private String reqType;

	@Column(name = "LOT_NO", length = 19)
	private String lotNo;

	@Column(name = "LOT_DATE ")
	private String Date;

	@Column(name = "PRODUCTION_ORDER_NO    ", length = 10)
	private String productionOrderNo;

	@Column(name = "PRODUCTION_ORDER_DATE  ")
	private String Date2;

	@Column(name = "LOT_QTY")
	private String number;

	@Column(name = "SITE_CODE")
	private String siteCode;

	@Column(name = "ISSUE_STATUS ", length = 50)
	private String issueStatus;

	@Column(name = "TRAN_TYPE", length = 2)
	private String tran;
	
	
	@OneToMany(mappedBy = "rejectionIssue", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<RejectionIssueDetail> listRejectionIssueDetail = new ArrayList<>();


	public String getIssNo() {
		return IssNo;
	}


	public void setIssNo(String issNo) {
		IssNo = issNo;
	}



	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}


	public String getIssType() {
		return issType;
	}


	public void setIssType(String issType) {
		this.issType = issType;
	}


	public String getIssDept() {
		return issDept;
	}


	public void setIssDept(String issDept) {
		this.issDept = issDept;
	}


	public String getWorkCK() {
		return workCK;
	}


	public void setWorkCK(String workCK) {
		this.workCK = workCK;
	}


	public String getIssTo() {
		return issTo;
	}


	public void setIssTo(String issTo) {
		this.issTo = issTo;
	}


	public String getIssuedBy() {
		return IssuedBy;
	}


	public void setIssuedBy(String issuedBy) {
		IssuedBy = issuedBy;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public FinancialYear getFinancialyear() {
		return financialyear;
	}


	public void setFinancialyear(FinancialYear financialyear) {
		this.financialyear = financialyear;
	}


	public String getUpdateBy() {
		return updateBy;
	}


	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public MaterialRequisitionMaster getRequisitionMaster() {
		return requisitionMaster;
	}


	public void setRequisitionMaster(MaterialRequisitionMaster requisitionMaster) {
		this.requisitionMaster = requisitionMaster;
	}


	


	public Date getReqDate() {
		return reqDate;
	}


	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}


	public String getManualIssSlipNo() {
		return manualIssSlipNo;
	}


	public void setManualIssSlipNo(String manualIssSlipNo) {
		this.manualIssSlipNo = manualIssSlipNo;
	}


	public String getBulkIssue() {
		return bulkIssue;
	}


	public void setBulkIssue(String bulkIssue) {
		this.bulkIssue = bulkIssue;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getDesignCode() {
		return designCode;
	}


	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}


	public String getProcessCode() {
		return processCode;
	}


	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}


	public String getForTrading() {
		return forTrading;
	}


	public void setForTrading(String forTrading) {
		this.forTrading = forTrading;
	}


	public String getReqType() {
		return reqType;
	}


	public void setReqType(String reqType) {
		this.reqType = reqType;
	}


	public String getLotNo() {
		return lotNo;
	}


	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getProductionOrderNo() {
		return productionOrderNo;
	}


	public void setProductionOrderNo(String productionOrderNo) {
		this.productionOrderNo = productionOrderNo;
	}


	public String getDate2() {
		return Date2;
	}


	public void setDate2(String date2) {
		Date2 = date2;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getSiteCode() {
		return siteCode;
	}


	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}


	public String getIssueStatus() {
		return issueStatus;
	}


	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}


	public String getTran() {
		return tran;
	}


	public void setTran(String tran) {
		this.tran = tran;
	}


	public List<RejectionIssueDetail> getListRejectionIssueDetail() {
		return listRejectionIssueDetail;
	}


	public void setListRejectionIssueDetail(List<RejectionIssueDetail> listRejectionIssueDetail) {
		this.listRejectionIssueDetail = listRejectionIssueDetail;
	}
	
	


}

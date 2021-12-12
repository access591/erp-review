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
import com.access.erp.model.master.Store;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="MATERIAL_ISSUE")
public class IssueSlip {
	
	@Id
	@Column(name="ISS_NO",length = 15)
	private String issueNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="ISS_DT")
	private Date issueDate;
	
	@Column(name="ISS_TYPE",length = 10)
	private String issueType;
	
	@Column(name="REQ_TYPE",length = 2)
	private String reqType;
	
	@ManyToOne
	@JoinColumn(name="REQUISITION_NO",nullable = false)
	private MaterialRequisitionMaster requisition;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="REQUISITION_DATE")
	private Date requisitionDate;
	
	@Column(name="BULK_ISSUE",length = 2)
	private String bulkIssue = "N";
	
	@Column(name="TRAN_TYPE",length = 2)
	private String tranType;
	
	@Column(name="ISS_TO",length = 9)
	private String issueTo;
	
	@Column(name="ISS_DEPT",length = 15)
	private String issueDept;
	
	
	@Column(name="WORK_CENTRE_CODE",length = 15)
	private String workCenterCode;
	
	@Column(name="ISSUED_BY",length = 30)
	private String issuedBy;

	
	@ManyToOne
	@JoinColumn(name="CCODE",nullable = true)
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="FYCODE",nullable = true)
	private FinancialActiveYear fycode;
	
	@ManyToOne
	@JoinColumn(name="UCODE",nullable = true)
	private MyUser muUser;
	
	
	
	@Column(name="UDATE")
	private Date uDate;
	
	
	@ManyToOne
	@JoinColumn(name="STORE_CODE",nullable = true)
	private Store store;
	
	@ManyToOne 
	@JoinColumn(name="TO_STORE_CODE",nullable = true)
	private Store toStoreCode;
	
	
	
	
	@Column(name="MANUAL_ISSUE_SLIP_NO",length = 25)
	private String mannualIssueSlipNo;
	
	
	
	@Column(name="PRODUCT_CODE",length = 30)
	private String productCode;
	
	@Column(name="DESIGN_CODE",length = 30)
	private String designCode;
	
	@Column(name="PROCESS_CODE",length = 15)
	private String processCode;
	
	
	@Column(name="FOR_TRADING",length = 2)
	private String forTrading;
	
	
	
	@Column(name="LOT_NO",length = 20)
	private String lotNo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="LOT_DATE")
	private Date lotDate;
	
	@Column(name="PRODUCTION_ORDER_NO",length = 15)
	private String productionOrderNo;
	
	@Column(name="PRODUCTION_ORDER_DATE")
	private Date productionOrderDate;
	
	@Column(name="LOT_QTY",length = 12)
	private int lotQty;
	
	@Column(name="SITE_CODE",length = 10)
	private String siteCode;
	
	@Column(name="ISSUE_STATUS",length = 50)
	private String issueSatus;
	
	
	
	
	
	@OneToMany(mappedBy = "issueSlip", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	List<IssueSlipDetail> issueSlipDetails = new ArrayList<>();



	public IssueSlip() {
		super();
		
	}



	public String getIssueNo() {
		return issueNo;
	}



	public void setIssueNo(String issueNo) {
		this.issueNo = issueNo;
	}



	public Date getIssueDate() {
		return issueDate;
	}



	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}



	


	public String getIssueType() {
		return issueType;
	}



	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}



	public String getIssueDept() {
		return issueDept;
	}



	public void setIssueDept(String issueDept) {
		this.issueDept = issueDept;
	}



	public String getWorkCenterCode() {
		return workCenterCode;
	}



	public void setWorkCenterCode(String workCenterCode) {
		this.workCenterCode = workCenterCode;
	}



	public String getIssueTo() {
		return issueTo;
	}



	public void setIssueTo(String issueTo) {
		this.issueTo = issueTo;
	}



	public String getIssuedBy() {
		return issuedBy;
	}



	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}



	public FinancialActiveYear getFycode() {
		return fycode;
	}



	public void setFycode(FinancialActiveYear fycode) {
		this.fycode = fycode;
	}



	public MyUser getMuUser() {
		return muUser;
	}



	public void setMuUser(MyUser muUser) {
		this.muUser = muUser;
	}



	public Date getuDate() { 
		return uDate;
	}



	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}



	public Store getStore() {
		return store;
	}



	public void setStore(Store store) {
		this.store = store;
	}



	public Store getToStoreCode() {
		return toStoreCode;
	}



	public void setToStoreCode(Store toStoreCode) {
		this.toStoreCode = toStoreCode;
	}



	public MaterialRequisitionMaster getRequisition() {
		return requisition;
	}



	public void setRequisition(MaterialRequisitionMaster requisition) {
		this.requisition = requisition;
	}



	public Date getRequisitionDate() {
		return requisitionDate;
	}



	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}



	public String getMannualIssueSlipNo() {
		return mannualIssueSlipNo;
	}



	public void setMannualIssueSlipNo(String mannualIssueSlipNo) {
		this.mannualIssueSlipNo = mannualIssueSlipNo;
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



	public Date getLotDate() {
		return lotDate;
	}



	public void setLotDate(Date lotDate) {
		this.lotDate = lotDate;
	}



	public String getProductionOrderNo() {
		return productionOrderNo;
	}



	public void setProductionOrderNo(String productionOrderNo) {
		this.productionOrderNo = productionOrderNo;
	}



	public Date getProductionOrderDate() {
		return productionOrderDate;
	}



	public void setProductionOrderDate(Date productionOrderDate) {
		this.productionOrderDate = productionOrderDate;
	}



	public int getLotQty() {
		return lotQty;
	}



	public void setLotQty(int lotQty) {
		this.lotQty = lotQty;
	}



	public String getSiteCode() {
		return siteCode;
	}



	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}



	public String getIssueSatus() {
		return issueSatus;
	}



	public void setIssueSatus(String issueSatus) {
		this.issueSatus = issueSatus;
	}



	public String getTranType() {
		return tranType;
	}



	public void setTranType(String tranType) {
		this.tranType = tranType;
	}



	public List<IssueSlipDetail> getIssueSlipDetails() {
		return issueSlipDetails;
	}



	public void setIssueSlipDetails(List<IssueSlipDetail> issueSlipDetails) {
		this.issueSlipDetails = issueSlipDetails;
	}
	
	
	
	
	
	
	

}

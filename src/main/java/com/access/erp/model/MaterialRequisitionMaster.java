package com.access.erp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.access.erp.model.master.Employee;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.Store;

public class MaterialRequisitionMaster {

	@Column(name="REQUISITION_NO", length = 10)
	private String requisitionNo;  
	
	@Column(name="REQUISITION_DATE")
	private Date requisitionDate;  
	
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_CODE",nullable=false)
	private Employee employee;  
	
	@Column(name="REMARKS", length = 500)
	private String remarks;  
	
	@Column(name="LOT_NO", length = 15)
	private String lotNo;  
	
	@Column(name="CCODE")
	private String REQUISITION_NO;  
	
	@ManyToOne
	@JoinColumn(name="UCODE",nullable = false)
	private MyUser myUser;  
	
	@Column(name="UDATE")
	private Date uDate;  
	
	@Column(name="PLANNING_ID", length = 15)
	private String planningId;  
	
	@Column(name="WORK_CENTER_CODE", length = 6 )
	private String workCenterCode;  
	
	@Column(name="REQUISITION_TYPE", length = 2)
	private String requisitionType;  
	
	@Column(name="SITE_CODE", length = 30)
	private String siteCode;  
	
	@Column(name="REQ_TYPE", length = 2)
	private String reqType;  
	
	@Column(name="LOCATION", length = 50)
	private String location;  
	
	@ManyToOne
	@JoinColumn(name="FYCODE",nullable = false)
	private FinancialActiveYear fyYear;  
	
	@Column(name="PLANNING_DATE")
	private Date planningDate;  
	
	@ManyToOne
	@JoinColumn(name="INDENT_NO",nullable = false)
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
	private String approvalStatus;  
	
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
	
	@ManyToOne
	@JoinColumn(name="STORE_CODE",nullable = false)
	private Store store; 
	
	@OneToMany(mappedBy = "materialRequisitionMaster", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	List<MaterialRequisitionDetail> materialRequisitionDetails = new ArrayList<>();
	
}

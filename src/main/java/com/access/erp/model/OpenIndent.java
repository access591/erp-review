package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "OPEN_INDENT")
public class OpenIndent {

	@Id
	@Column(name = "INDENT_NUMBER", length = 30)
	private String indentNumber;
	
	@Column(name = "INDENTS_DATE")
	private Date indentDate;

	@Column(name = "COMP_NAME", length = 100)
	private String indDept;

	@Column(name = "EMP_CODE", length = 50)
	private String employee;

	@Column(name = "WORKER_CODE", length = 50)
	private String workerCode;

	@Column(name = "INDENTS_REMARKS", length = 250)
	private String indentRemark;

	@Column(name = "APPROVAL_STATUS", length = 20)
	private String approvalStatus;
	
	@Column(name = "DATE_OF_APPROVAL")
	private Date dateOfApproval;
	
	@Column(name = "AUTH_EMP_CODE", length = 50)
	private String authEmpCode;
	
	@Column(name = "IND_PUR_STATUS", length = 50)
	private String indPurStatus;
	
	@Column(name = "COMPANY_CODE", length = 50)
	private String company;

	@Column(name = "UP_DATE", length = 50)
	private Date update;
	
	@Column(name = "URGENCY", length = 50)
	private String urgency;
	
	@Column(name = "AS_ON_DATE", length = 50)
	private Date asOnDate;
	
	@Column(name = "TOTAL_VALUE", length = 20)
	private int totalvalue;

	@Column(name = "CURRENCY_CODE", length = 30)
	private String currencyCode;

	@Column(name = "FY_CODE", length = 20)
	private String fyCode;

	@Column(name = "USER_CODE", length = 50)
	private String user;
	
	@Column(name = "CONVERSION_VALUE", length = 50)
	private String conversionValue;
	
	@Column(name = "INDENT_TYPE", length = 50)
	private String indentType;
	
	@Column(name = "SALES_ORDER_NU", length = 50)
	private String salesOrderNu;
	
	@Column(name = "ID_OR_SO", length = 100)
	private String idOrSo;
	
	@Column(name = "SALES_ORDER_DATE", length = 100)
	private Date salesOrderDate;
	
	@Column(name = "REMARKS", length = 100)
	private String remarks;

	@Column(name = "USER_NAME", length = 100)
	private String uName;

	@Column(name = "EXCISEABLE", length = 100)
	private String exciseable;
	
	@Column(name = "REQUISITION_NO", length = 100)
	private String requistionNu;
	
	@Column(name = "REQUISITION_DATE", length = 100)
	private Date requisitionDate;
	
	@Column(name = "INDENT_STATUS", length = 100)
	private String indentsStatus;
	
	@Column(name = "DATE_OF_CANCEL", length = 100)
	private Date dateOfCancel;

	@Column(name = "REMARKS_CANCE", length = 100)
	private String remarkCancel;

	@Column(name = "OP_IND_YN", length = 100)
	private String opIndYn;
	
	@Column(name = "APPROVAL_STATUS_L1", length = 100)
	private String approvalStatus1;
	
	@Column(name = "APPROVAL_STATUS_L2", length = 100)
	private String approvalStatus2;

	
	@Column(name = "APPROVAL_STATUS_L3", length = 100)
	private String approvalStatus3;
	
	@Column(name = "APPROVAL_STATUS_L4", length = 100)
	private String approvalStatus4;
	
	
	@Column(name = "APPROVAL_DATE_L1", length = 100)
	private Date approvalDate1;
	
	@Column(name = "APPROVAL_DATE_L2", length = 100)
	private Date approvalDate2;
	
	@Column(name = "APPROVAL_DATE_L3", length = 100)
	private Date approvalDate3;
	
	@Column(name = "APPROVAL_DATE_L4", length = 100)
	private Date approvalDate4;
	
	
	@Column(name = "APPROVED_BY_L1", length = 100)
	private String approvedBy1;
	
	@Column(name = "APPROVED_BY_L2", length = 100)
	private String approvedBy2;

	
	@Column(name = "APPROVED_BY_L3", length = 100)
	private String approvedBy3;
	
	@Column(name = "APPROVED_BY_L4", length = 100)
	private String approvedBy4;
	
	@Column(name = "REMARKS_L1", length = 100)
	private String remarks1;
	
	@Column(name = "REMARKS_L2", length = 100)
	private String remarks2;

	
	@Column(name = "REMARKS_L3", length = 100)
	private String remarks3;
	
	@Column(name = "REMARKS_L4", length = 100)
	private String remarks4;
	

}

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
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "REJECTION_ISSUE")
public class RejectionIssue {

	@Id
	@Column(name = "ISSUE_NO", length = 15)
	private String IssNo;


	@Column(name = "ISS_DT")
	private Date date;

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
	private String Date1;

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
	
	


}

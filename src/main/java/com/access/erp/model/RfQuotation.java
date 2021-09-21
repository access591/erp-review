package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class RfQuotation {

	@Id
	@Column(name="RFQ_NUM",length=50)
	private String rfqNo;
	
	@Column(name="RFQ_DATE")
	private Date rfqDate;
	
	@Column(name="RFQ_TYPE",length=20)
	private String rfqType;
	
	@Column(name="C_CODE",length=50)
	private String cCode;
	
	@Column(name="FY_CODE",length=50)
	private String fyCode;
	
	@Column(name="u_CODE",length=50)
	private String uCode;
	
	@Column(name="u_DATE")
	private Date uDate;
	
	@Column(name="RFQ_TERMCONDITION",length=1000)
	private String rfqTermCondition;
	
	
	
	
	
}

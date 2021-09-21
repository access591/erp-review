package com.access.erp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

public class RfQuotationItem {
	
	@Id
	@Column(name="ID",length = 50)
	private Long id;
	
	@Column(name="",length = 50)
	private String itemCode;
	
	@Column(name="",length = 50)
	private String uom;
	
	@Column(name="",length = 50)
	private String srNo;
	
	@Column(name="",length = 50)
	private String qty;
	
	@Column(name="",length = 50)
	private String reqDate;
	
	@Column(name="",length = 50)
	private String itemSpec;
	
	@Column(name="",length = 50)
	private String termCondition;
	
	@Column(name="",length = 50)
	private String remarks;
	
	@Column(name="",length = 50)
	private String indentNu;
	
	@Column(name="")
	private Date indentDate;
	
	
	
	

}

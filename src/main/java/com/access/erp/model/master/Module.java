package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODULE_MASTER")
public class Module {
	
	@Id
	@Column(name = "MODULE_CODE",length = 50)
	private String moduleCode;
	
	@Column(name = "MODULE_NAME",length = 50)
	private String moduleName;
	
	@Column(name = "ACTIVE_YN",length = 5)
	private String active;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBy;

	@Column(name = "INS_DATE")
	private Date insertedDate=new Date();
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate=new Date();
	
	@Column(name = "SEQ_NO")
	private int seqNo;

	
}

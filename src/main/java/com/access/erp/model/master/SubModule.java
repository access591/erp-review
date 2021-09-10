package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "SUB_MODULE_MASTER")*/
public class SubModule {
	
	
	@Id
	@Column(name = "SUB_MODULE_CODE",length = 50)
	private String subModuleCode;

	@Column(name = "SUB_MODULE_NAME",length = 50)
	private String subModuleName;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBySubModule;

	@Column(name = "INS_DATE")
	private Date insertedDateSubModule =  new Date();
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBySubModule;

	@Column(name = "UPDATE_DATE")
	private Date updatedDateSubModule = new Date();
	
	
	@Column(name = "ACTIVE_YN",length = 10)
	private String acitveSubModule;
	
	@Column(name = "SEQ_NO",length = 50)
	private int seqNoSubModule;
	
	
	

}

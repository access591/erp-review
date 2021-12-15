package com.access.erp.model.master;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROGRAM_MASTER")
public class Program {
	
	
	@Id
	@Column(name = "PCODE",length = 40)
	private String programCode;
	
	@Column(name = "PNAME",length = 50)
	private String programName;
	
	@Column(name = "PTYPE",length = 6)
	private String programType;
	
	@Column(name = "PRG_HREF_NAME",length = 100)
	private String programHrefName;
	
	@Column(name = "SEQ_NO")
	private int seqNo;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBy;
	
	@Column(name = "INS_DATE")
	private Date insertedDate;
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate;
	
	@Column(name = "ACTIVE_YN",length = 2)
	private String active;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "SMCODE",nullable = true)
	private SubModuleMaster subModuleMaster;
	
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "MCODE",nullable = true)
	private ModuleMaster  module;
	
	
	
	
	


	public ModuleMaster getModule() {
		return module;
	}


	public void setModule(ModuleMaster module) {
		this.module = module;
	}


	public Program() {
		super();
		
	}


	public String getProgramCode() {
		return programCode;
	}


	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}


	public String getProgramName() {
		return programName;
	}


	public void setProgramName(String programName) {
		this.programName = programName;
	}


	public String getProgramType() {
		return programType;
	}


	public void setProgramType(String programType) {
		this.programType = programType;
	}


	public String getProgramHrefName() {
		return programHrefName;
	}


	public void setProgramHrefName(String programHrefName) {
		this.programHrefName = programHrefName;
	}


	


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public SubModuleMaster getSubModuleMaster() {
		return subModuleMaster;
	}


	public void setSubModuleMaster(SubModuleMaster subModuleMaster) {
		this.subModuleMaster = subModuleMaster;
	}


	public int getSeqNo() {
		return seqNo;
	}


	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}


	public String getInsertedBy() {
		return insertedBy;
	}


	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}


	public Date getInsertedDate() {
		return insertedDate;
	}


	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
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

	

	
	

	
}

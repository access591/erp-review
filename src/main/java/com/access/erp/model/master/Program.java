package com.access.erp.model.master;

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
	@Column(name = "PRG_CODE",length = 50)
	private String programCode;
	
	@Column(name = "PRG_NAME",length = 50)
	private String programName;
	
	@Column(name = "PRG_TYPE",length = 10)
	private String programType;
	
	@Column(name = "PRG_HREF_NAME",length = 100)
	private String programHrefName;
	
	@Column(name = "SEQ_NO")
	private int seqNo;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBy;
	
	@Column(name = "ACTIVE_YN",length = 10)
	private String activeYn;
	
	
	@ManyToOne
	@JoinColumn(name = "SUB_MODUEL_CODE")
	private SubModuleMaster subModuleMaster;


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


	public String getActiveYn() {
		return activeYn;
	}


	public void setActiveYn(String activeYn) {
		this.activeYn = activeYn;
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
	

	
}

package com.access.erp.model.master;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "M_SUB_MODULE")
public class SubModuleMaster {
	
	
	@Id
	@Column(name = "SMCODE",length = 40)
	private String subModuleCode;

	@Column(name = "SMNAME",length = 50)
	private String subModuleName;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBySubModule;

	@Column(name = "INS_DATE")
	private Date insertedDateSubModule;
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBySubModule;

	@Column(name = "UPDATE_DATE")
	private Date updatedDateSubModule;
	
	
	@Column(name = "ACTIVE_YN",length = 10)
	private String active;
	
	@Column(name = "SEQ_NO",length = 50)
	private int seqNoSubModule;
	
	@ManyToOne
	@JoinColumn(name="MODULE_CODE")
	private ModuleMaster moduleMaster;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "subModuleMaster",cascade = CascadeType.ALL)
	private Set<Program> program;

	public String getSubModuleCode() {
		return subModuleCode;
	}

	public void setSubModuleCode(String subModuleCode) {
		this.subModuleCode = subModuleCode;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getInsertedBySubModule() {
		return insertedBySubModule;
	}

	public void setInsertedBySubModule(String insertedBySubModule) {
		this.insertedBySubModule = insertedBySubModule;
	}

	public Date getInsertedDateSubModule() {
		return insertedDateSubModule;
	}

	public void setInsertedDateSubModule(Date insertedDateSubModule) {
		this.insertedDateSubModule = insertedDateSubModule;
	}

	public String getUpdateBySubModule() {
		return updateBySubModule;
	}

	public void setUpdateBySubModule(String updateBySubModule) {
		this.updateBySubModule = updateBySubModule;
	}

	public Date getUpdatedDateSubModule() {
		return updatedDateSubModule;
	}

	public void setUpdatedDateSubModule(Date updatedDateSubModule) {
		this.updatedDateSubModule = updatedDateSubModule;
	}

	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public int getSeqNoSubModule() {
		return seqNoSubModule;
	}

	public void setSeqNoSubModule(int seqNoSubModule) {
		this.seqNoSubModule = seqNoSubModule;
	}

	public ModuleMaster getModuleMaster() {
		return moduleMaster;
	}

	public void setModuleMaster(ModuleMaster moduleMaster) {
		this.moduleMaster = moduleMaster;
	}

	public Set<Program> getProgram() {
		return program;
	}

	public void setProgram(Set<Program> program) {
		this.program = program;
	}
	
	
	
	

}

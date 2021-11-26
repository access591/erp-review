package com.access.erp.model.master;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "M_MODULE")
public class ModuleMaster {
	
	@Id
	@Column(name = "MCODE",length = 40)
	private String moduleCode;
	
	@Column(name = "MNAME",length = 50)
	private String moduleName;
	
	@Column(name = "ACTIVE_YN",length = 2)
	private String active;
	
	@Column(name = "INS_BY")
	private String insertedBy;

	@Column(name = "INS_DATE")
	private Date insertedDate=new Date();
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate=new Date();
	
	@Column(name = "SEQ_NO")
	private int seqNo;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "moduleMaster",cascade = CascadeType.ALL)
	private Set<SubModuleMaster> subModule;

	public ModuleMaster() {
		super();
		
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		
		
		this.moduleCode = moduleCode;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
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

	public int getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public Set<SubModuleMaster> getSubModule() {
		return subModule;
	}

	public void setSubModule(Set<SubModuleMaster> subModule) {
		this.subModule = subModule;
	}

	
	

	
}

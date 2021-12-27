package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "M_DEPARTMENT")
public class Department {
	
	
	@Id
	@Column(name = "DEPT_CODE", length = 50)
	private String deptCode;
	
	@Column(name = "DEPT_NAME", length = 50)
	private String deptName;
	
	@Column(name = "CCODE", length = 4,updatable = false,insertable = true)
	private String compCode;
	
	@Column(name = "DEPT_HEAD_CODE", length = 50)
	private String depHead;
	
	@Column(name = "DEPT_SR_CODE", length = 50)
	private String deptSrCode;
	
	
	@Column(name = "INS_BY",length = 50,updatable = false,insertable = true)
	private String insertedBy;

	@Column(name = "INS_DATE",updatable = false,insertable = true)
	private Date insertedDate;
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate;
	
	@Column(name = "ACTIVE_YN")
	private String active;
	
	
	

	public Department() {
		super();
		System.out.println("==========>  IN DEPARTMENT MASTER <==============");
		
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public String getDepHead() {
		return depHead;
	}

	public void setDepHead(String depHead) {
		this.depHead = depHead;
	}

	public String getDeptSrCode() {
		return deptSrCode;
	}

	public void setDeptSrCode(String deptSrCode) {
		this.deptSrCode = deptSrCode;
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

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	
	
}

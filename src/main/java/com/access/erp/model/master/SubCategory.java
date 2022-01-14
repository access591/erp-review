package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "M_SUB_CATEGORY")
public class SubCategory {

	@Id
	@Column(name = "SUB_CATEGORY_CODE", length = 20)
	private String subCategoryCode;
	
	@Column(name = "SUBCAT_DESCRIPTION", length = 50)
	private String subCategoryDesc;
	
	
	
	@ManyToOne
	@JoinColumn(name="CATEGORY_CODE")
	private  Category category;
	
	
	@ManyToOne
	@JoinColumn(name="CCODE",updatable = false, insertable = true)
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="UCODE",updatable = false, insertable = true)
	private MyUser myuser;
	

	

	@Column(name = "INS_BY", length = 50, updatable = false, insertable = true)
	private String insertedBy;

	@Column(name = "INS_DATE", updatable = false, insertable = true)
	private Date insertedDate;

	@Column(name = "UPDATE_BY", length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate;

	@Column(name = "ACTIVE_YN", length = 10)
	private String active = "Y";

	

	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
	}

	public String getSubCategoryDesc() {
		return subCategoryDesc;
	}

	public void setSubCategoryDesc(String subCategoryDesc) {
		this.subCategoryDesc = subCategoryDesc;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public MyUser getMyuser() {
		return myuser;
	}

	public void setMyuser(MyUser myuser) {
		this.myuser = myuser;
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

package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="M_CATEGORY")
public class Category {

	
	
	@Id
	@Column(name = "CATEGORY_CODE", length = 10)
	private String categCode;
	
	
	@Column(name = "ACCOUNT_HEAD", length = 50)
	private String accountHead;
	
	@Column(name = "PARENT_CODE", length = 30)
	private String parentCode;
	
	@Column(name = "PARENT_NAME", length = 50)
	private String parentName;
	
	@Column(name = "CATEGORY_DESCRIPTION", length = 150)
	private String description;
	
	@Column(name = "A_DESCRIPTION", length = 100)
	private String accountDescription;
	
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
	
	//CCODE 
	@Column(name="CCODE", updatable=true, insertable=true)
	private String compCode;

	public Category() {
		super();
		System.out.println("==========>  IN CATEGORY MASTER <==============");
		
	}

	

	public String getAccountDescription() {
		return accountDescription;
	}



	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}



	public String getCategCode() {
		return categCode;
	}

	public void setCategCode(String categCode) {
		this.categCode = categCode;
	}

	public String getAccountHead() {
		return accountHead;
	}

	public void setAccountHead(String accountHead) {
		this.accountHead = accountHead;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getCompCode() {
		return compCode;
	}



	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}



	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	
}

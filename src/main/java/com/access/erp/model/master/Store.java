package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="M_STORE")
public class Store {

	
	@Id
	@Column(name = "STORE_CODE", length = 20)
	private String storeCode;
	
	@Column(name = "STORE_STATUS", length = 2)
	private String storeStatus;
	
	
	@Column(name = "STORE_TYPE", length = 20)
	private String storeType;
	
	@Column(name = "STORE_LOCATION", length = 40)
	private String location;
	
	@Column(name = "STORE_DESCRIPTION", length = 40)
	private String description;
	
	@Column(name = "INS_BY",length = 50,updatable = false)
	private String insertedBy;

	@Column(name = "INS_DATE",updatable = false)
	private Date insertedDate;
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate;
	
	
	@Column(name = "ACTIVE_YN", length = 2)
	private String active;
	
	
	//code add

	public Store() {
		super();
		
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

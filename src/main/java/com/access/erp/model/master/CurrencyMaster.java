package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="M_CURRENCY")
public class CurrencyMaster {

	
	@Id
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	
	@Column(name="CURRENCY_VALUE")
	private String currencyValue;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBy;

	@Column(name = "INS_DATE")
	private Date insertedDate=new Date();
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate=new Date();

	public CurrencyMaster() {
		super();
		System.out.println("==========>  IN CURRENCY MASTER <==============");
		
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(String currencyValue) {
		this.currencyValue = currencyValue;
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

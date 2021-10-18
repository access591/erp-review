package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "M_SUPPLIER")
public class SupplierMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SUPPLIER_CODE")
	private Long supplierId;
	
	@Column(name="SUPPLIER_NAME")
	private String supplierName;
	
	@Column(name="SUPPLIER_ADD")
	private String supplierAdd;
	
	@Column(name="SUPPLIER_CITY")
	private String supplierCity;
	
	@Column(name="SUPPLIER_STATE")
	private String supplierState;
	
	@Column(name="SUPPLIER_COUNTRY")
	private String supplierCountry;
	
	

	public SupplierMaster() {
		super();
		
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAdd() {
		return supplierAdd;
	}

	public void setSupplierAdd(String supplierAdd) {
		this.supplierAdd = supplierAdd;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public String getSupplierState() {
		return supplierState;
	}

	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}

	public String getSupplierCountry() {
		return supplierCountry;
	}

	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	}
	
	
		

}

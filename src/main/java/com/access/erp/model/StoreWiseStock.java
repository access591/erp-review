package com.access.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.FinancialYear;
import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;

@Entity
@Table(name="STORE_WISE_STOCK")
public class StoreWiseStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne(optional = true)
    @JoinColumn(name="ITEM_CODE",nullable = true)
	private Item item;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="STORE_CODE",nullable = true)
	private Store store;
	
	@Column(name = "QTY", columnDefinition = "FLOAT(14,3)",nullable = true)
	private double qty;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="FYCODE",nullable = true)
	private FinancialYear fyYear;
	
	@ManyToOne(optional = true)
    @JoinColumn(name="CCODE")
	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	

	public FinancialYear getFyYear() {
		return fyYear;
	}

	public void setFyYear(FinancialYear fyYear) {
		this.fyYear = fyYear;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
	
}

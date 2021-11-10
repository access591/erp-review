package com.access.erp.model.master;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "M_DESIGNATION")
public class Designation {
	
	@Id
	@Column(name = "DESIG_CODE", length = 50)
	private String desigCode;
	
	@Column(name = "DESIG_NAME", length = 50)
	private String desigName;
	
	@Column(name = "PAY_SCALE_CODE", length = 50)
	private String payScaleCode;
	
	@Column(name = "BASIC_SLAB_1")
	private long basicSlab1;
	
	@Column(name = "BASIC_SLAB_2")
	private long basicSlab2;
	
	@Column(name = "BASIC_SLAB_3")
	private long basicSlab3;
	
	@Column(name = "INCREMENT1")
	private long increment1;
	
	@Column(name = "INCREMENT2")
	private long increment2;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBy;

	@Column(name = "INS_DATE")
	private Date insertedDate=new Date();
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate=new Date();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "designation",cascade = CascadeType.ALL)
	List<Employee> employees;

	
	public Designation() {
		super();
		System.out.println("==========>  IN DESIGNATION MASTER <==============");
	}

	public String getDesigCode() {
		return desigCode;
	}

	public void setDesigCode(String desigCode) {
		this.desigCode = desigCode;
	}

	public String getDesigName() {
		return desigName;
	}

	public void setDesigName(String desigName) {
		this.desigName = desigName;
	}

	public String getPayScaleCode() {
		return payScaleCode;
	}

	public void setPayScaleCode(String payScaleCode) {
		this.payScaleCode = payScaleCode;
	}

	public long getBasicSlab1() {
		return basicSlab1;
	}

	public void setBasicSlab1(long basicSlab1) {
		this.basicSlab1 = basicSlab1;
	}

	public long getBasicSlab2() {
		return basicSlab2;
	}

	public void setBasicSlab2(long basicSlab2) {
		this.basicSlab2 = basicSlab2;
	}

	public long getBasicSlab3() {
		return basicSlab3;
	}

	public void setBasicSlab3(long basicSlab3) {
		this.basicSlab3 = basicSlab3;
	}

	public long getIncrement1() {
		return increment1;
	}

	public void setIncrement1(long increment1) {
		this.increment1 = increment1;
	}

	public long getIncrement2() {
		return increment2;
	}

	public void setIncrement2(long increment2) {
		this.increment2 = increment2;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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

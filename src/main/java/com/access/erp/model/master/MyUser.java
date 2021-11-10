package com.access.erp.model.master;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="M_MY_USER")
@Component
public class MyUser {

	@Id
	@Column(name = "UCODE",length = 50)
	private String userCode; 
	
	@Column(name = "USER_NAME",length = 50)
	private String userName;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	
	@OneToOne
	@JoinColumn(name="EMP_CODE")
	private Employee employee;
	
	@OneToMany(mappedBy = "myUSer", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<UserRole> listUserRole = new ArrayList<>();
	
	/*
	 * @ManyToMany(mappedBy = "myUser") private List<UserRights> UserRights = new
	 * ArrayList<>();
	 */
	
	@Column(name = "Ins_by",updatable = false,length = 50)
	private String insBy;

	@Column(name = "ins_date",updatable = false)
	private Date insDate= new Date();
	
	@Column(name = "upd_by",insertable = false,length = 50)
	private String updBy;

	@Column(name = "upd_date",insertable = false)
	private Date updDate=new Date();

	public MyUser() {
		super();
		
	}

	
	public List<UserRole> getListUserRole() {
		return listUserRole;
	}


	public void setListUserRole(List<UserRole> listUserRole) {
		this.listUserRole = listUserRole;
	}


	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getInsBy() {
		return insBy;
	}

	public void setInsBy(String insBy) {
		this.insBy = insBy;
	}

	public Date getInsDate() {
		return insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getUpdBy() {
		return updBy;
	}

	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	
	
	
}

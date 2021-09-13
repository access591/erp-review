package com.access.erp.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MY_USER")
public class MyUser {

	@Id
	@Column(name = "USER_CODE",length = 30,updatable = false)
	private String userCode;
	
	@Column(name = "USER_NAME",length = 50)
	private String userName;
	
	@Column(name = "USER_PASSWORD")
	private String userPassword;
	
	@ManyToMany(mappedBy = "myUser")
	private List<UserRights> UserRights = new ArrayList<>();
	
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

	public List<UserRights> getUserRights() {
		return UserRights;
	}

	public void setUserRights(List<UserRights> userRights) {
		UserRights = userRights;
	} 
	
	
	
	
}

package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ROLE")
	private Long userRoleId;

	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "USER_CODE")
	private MyUser myUSer;
	
	
	@JsonBackReference
	@ManyToOne(optional = false)
	@JoinColumn(name = "ROLE_CODE")
	private Role role;

	public UserRole() {
		super();
		
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public MyUser getMyUSer() {
		return myUSer;
	}

	public void setMyUSer(MyUser myUSer) {
		this.myUSer = myUSer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
	
	
	
	

}

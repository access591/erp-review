package com.access.erp.model.master;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	private Long roleId;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	@OneToOne
	@JoinColumn(name="HOME_ADDRESS_ID")
	private Program program;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<UserRole> userRoleList = new ArrayList<>();
	

}

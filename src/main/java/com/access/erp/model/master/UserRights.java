package com.access.erp.model.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="USER_RIGHTS")
public class UserRights {

	@Id
	@Column(name="RIGHTS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PROGRAM_CODE",updatable = false)
	private Program programCode;

	@Column(name = "ACTIVE_YN")
	private String active;
	
	@ManyToMany
	@JoinTable(name = "USER_USERRIGHTS", 
    joinColumns = { @JoinColumn(name = "RIGHTS_ID") }, 
    inverseJoinColumns = { @JoinColumn(name = "USER_CODE") })
	private List<MyUser> myUser = new ArrayList<>();
	
	
	@Column(name = "INS_BY", updatable = false)
	private String insBy;

	@Column(name = "INS_DATE", updatable = false)
	private Date insDate = new Date();

	@Column(name = "UPD_BY", insertable = false)
	private String updBy;

	@Column(name = "UPD_DATE", insertable = false)
	private Date updDate = new Date();

	public UserRights() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Program getProgramCode() {
		return programCode;
	}

	public void setProgramCode(Program programCode) {
		this.programCode = programCode;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public List<MyUser> getMyUser() {
		return myUser;
	}

	public void setMyUser(List<MyUser> myUser) {
		this.myUser = myUser;
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

package com.access.erp.model.master;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "M_URIGHTS")
public class UserRights implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3115353075342584614L;

	 @Id
	 @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_CODE")
	private MyUser myUser;
	
	@ManyToOne
	@JoinColumn(name ="MODULE_CODE",updatable = false)
	private ModuleMaster module;
	
	@ManyToOne
	@JoinColumn(name = "SUB_MODULE_CODE",updatable = false)
	private SubModuleMaster subModule;

	@ManyToOne
	@JoinColumn(name = "PRG_CODE",updatable = false)
	private Program prgCode;

	@Column(name = "ACTIVE_YN")
	private String active;
	
	
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
		System.out.println("==========>  IN USER RIGHT <==============");
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MyUser getMyUser() {
		return myUser;
	}
	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}
	
	public ModuleMaster getModule() {
		return module;
	}
	public void setModule(ModuleMaster module) {
		this.module = module;
	}
	public SubModuleMaster getSubModule() {
		return subModule;
	}
	public void setSubModule(SubModuleMaster subModule) {
		this.subModule = subModule;
	}
	public Program getPrgCode() {
		return prgCode;
	}
	public void setPrgCode(Program prgCode) {
		this.prgCode = prgCode;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}

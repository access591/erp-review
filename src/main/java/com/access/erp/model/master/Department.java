package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "DEPARTMENT_MASTER")*/
public class Department {
	
	
	@Id
	@Column(name = "DEPT_CODE", length = 50)
	private String deptCode;
	
	@Column(name = "DEPT_NAME", length = 50)
	private String deptName;
	
	@Column(name = "COMP_CODE", length = 50)
	private String compCode;
	
	@Column(name = "DEPT_HEAD_CODE", length = 50)
	private String depHead;
	
	@Column(name = "DEPT_SR_CODE", length = 50)
	private String deptSrCode;

	public Department() {
		super();
		
	}

	
}

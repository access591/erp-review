package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESIGNATION_MASTER")
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
	
	@Column(name = "COMP_CODE")
	private long compCode;
	
	
	
	

}

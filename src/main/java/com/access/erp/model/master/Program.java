package com.access.erp.model.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*@Entity
@Table(name = "PROGRAM_MASTER")*/
public class Program {
	
	
	@Id
	@Column(name = "PRG_CODE",length = 50)
	private String programCode;
	
	@Column(name = "PRG_NAME",length = 50)
	private String programName;
	
	@Column(name = "PRG_TYPE",length = 10)
	private String programType;
	
	@Column(name = "PRG_HREF_NAME",length = 100)
	private String programHrefName;
	
	@Column(name = "ACTIVE_YN",length = 10)
	private String activeYn;

}

package com.access.erp.utility;

import java.util.List;

import com.access.erp.model.master.Program;
import com.access.erp.model.master.SubModuleMaster;

public class SubModuleProgram {
	
	private List<SubModuleMaster> subModuleList;
	private List<Program> programList;
	
	
	public List<SubModuleMaster> getSubModuleList() {
		return subModuleList;
	}
	public void setSubModuleList(List<SubModuleMaster> subModuleList) {
		this.subModuleList = subModuleList;
	}
	public List<Program> getProgramList() {
		return programList;
	}
	public void setProgramList(List<Program> programList) {
		this.programList = programList;
	}
	
	
	

}

package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Program;

public interface ProgramService {

	public void addProgram(Program program);
	public List<Program> getAllProgram();
	public Optional<Program> editProgram(String programCode);
	public void deleteProgram(String programCode);

}

package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.Program;
import com.access.erp.repo.ProgramRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService{

	@Autowired SeqMainRepo seqMainRepo;
	@Autowired ProgramRepo programRepo;
	
	
	@Override
	public void addProgram(Program program) {
		
		if(program.getProgramCode()=="" || program.getProgramCode()==null) {
			String maxCode = seqMainRepo.findByTranType("PRO");
			System.out.println("max code is : "+ maxCode);
			program.setProgramCode(maxCode);
		}
		
		
		programRepo.save(program);
	}

	@Override
	public List<Program> getAllProgram() {
		
		return programRepo.findAll();
	}

	@Override
	public Optional<Program> editProgram(String programCode) {
		
		return programRepo.findById(programCode);
	}

	@Override
	public void deleteProgram(String programCode) {
		
		programRepo.deleteById(programCode);
	}

}

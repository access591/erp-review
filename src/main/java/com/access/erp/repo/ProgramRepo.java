package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.Program;
import com.access.erp.model.master.SubModuleMaster;

@Repository
public interface ProgramRepo extends JpaRepository<Program, String>{
	
	List<Program> findByModuleAndActive(ModuleMaster module , String active);
	
	List<Program> findBySubModuleMasterAndActive(SubModuleMaster subModuleMaster, String active);

}

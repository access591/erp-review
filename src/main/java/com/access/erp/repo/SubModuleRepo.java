package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.ModuleMaster;
import com.access.erp.model.master.SubModuleMaster;

@Repository
public interface SubModuleRepo extends JpaRepository<SubModuleMaster, String>{
	
	
	List<SubModuleMaster> findByModuleMasterAndActive(ModuleMaster moduleMaster,String active);

}

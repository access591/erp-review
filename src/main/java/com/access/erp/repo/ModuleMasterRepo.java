package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.ModuleMaster;


@Repository
public interface ModuleMasterRepo extends JpaRepository<ModuleMaster, String>{
	
	List<ModuleMaster> findByActive(String active);

}

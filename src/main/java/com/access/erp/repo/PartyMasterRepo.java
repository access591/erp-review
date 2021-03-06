package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.PartyMaster;

@Repository
public interface PartyMasterRepo extends JpaRepository<PartyMaster, String>{
	
	public List<PartyMaster> findByPartyCodeContaining(String s);

}

package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.PartyMaster;

public interface PartyMasterService {
	
	public void addPartyMaster(PartyMaster partyMaster);
	public List<PartyMaster> getAllpartyMaster();
	public Optional<PartyMaster> editPartyMaster(String partyCode);
	public void deletePartyMaster(String partyCode);
	
	public List<PartyMaster> findByPartyCodeContaining(String s);
	
}

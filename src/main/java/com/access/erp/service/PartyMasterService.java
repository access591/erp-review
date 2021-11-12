package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.PartyMaster;

public interface PartyMasterService {
	
	public void addPartyMaster(PartyMaster city);
	public List<PartyMaster> getAllpartyMaster();
	public Optional<PartyMaster> editPartyMaster(String partyCode);
	public void deletePartMaster(String partyCode);
	
}

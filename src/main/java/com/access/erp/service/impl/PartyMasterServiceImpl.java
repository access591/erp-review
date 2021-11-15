package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.PartyBilling;
import com.access.erp.model.master.PartyConsignee;
import com.access.erp.model.master.PartyMaster;
import com.access.erp.repo.PartyMasterRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.PartyMasterService;

@Service
public class PartyMasterServiceImpl implements PartyMasterService{

	
	@Autowired PartyMasterRepo partyMasterRepo;
	@Autowired SeqMainRepo seqmainRepo;
	
	@Override
	public void addPartyMaster(PartyMaster partyMaster) {
		
		String maxCode =  seqmainRepo.findByTranType("PRT");
		partyMaster.setPartyCode("EB" + partyMaster.getCustType() + maxCode.substring(3));
		
		for(PartyBilling party : partyMaster.getListPartyBilling()) {
			
			party.setPartyMaster(partyMaster);
		}
		
		for(PartyConsignee partyConsignee : partyMaster.getListPartyConsignee()) {
			
			partyConsignee.setPartyMaster(partyMaster);
		}
		
		partyMasterRepo.save(partyMaster);
		
	}

	@Override
	public List<PartyMaster> getAllpartyMaster() {
		
		return partyMasterRepo.findAll();
	}

	@Override
	public Optional<PartyMaster> editPartyMaster(String partyCode) {
		
		return partyMasterRepo.findById(partyCode);
	}

	@Override
	public void deletePartyMaster(String partyCode) {
		
		partyMasterRepo.deleteById(partyCode);
		
	}

}
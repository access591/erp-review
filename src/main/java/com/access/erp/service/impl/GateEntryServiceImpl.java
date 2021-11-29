package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.GateEntry;
import com.access.erp.repo.GateEntryRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.GateEntryService;

@Service
public class GateEntryServiceImpl implements GateEntryService{

	@Autowired GateEntryRepo gateEntryRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	
	@Override
	public void addGateEntry(GateEntry gateEntry) {
		
		if(gateEntry.getGateSrNo() == null || gateEntry.getGateSrNo()=="") {
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("GEN", "20-21", "EB");
			gateEntry.setGateSrNo("EB"+ maxCode);
		}
		
		gateEntryRepo.save(gateEntry);
		
	}

	@Override
	public List<GateEntry> getAllGateEntry() {
		
		return gateEntryRepo.findAll();
	}

	@Override
	public Optional<GateEntry> editGateEntry(String gateEntryCode) {
		
		return gateEntryRepo.findById(gateEntryCode);
	}

	@Override
	public void deleteGateEntry(String gateEntryCode) {
		gateEntryRepo.deleteById(gateEntryCode);
		
	}

}

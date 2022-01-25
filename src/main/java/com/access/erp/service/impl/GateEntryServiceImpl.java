package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.GateEntry;
import com.access.erp.model.GateEntryItemDetail;
import com.access.erp.model.master.Company;
import com.access.erp.model.master.FinancialActiveYear;
import com.access.erp.model.master.MyUser;
import com.access.erp.model.master.SupplierMaster;
import com.access.erp.repo.GateEntryRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.CompanyService;
import com.access.erp.service.FinancialActiveYearService;
import com.access.erp.service.GateEntryService;
import com.access.erp.service.MyUserService;
import com.access.erp.service.PartyMasterService;
import com.access.erp.singleton.GlobalParameter;

@Service
public class GateEntryServiceImpl implements GateEntryService{

	@Autowired GateEntryRepo gateEntryRepo;
	@Autowired SeqMainRepo seqMainRepo;
	@Autowired PartyMasterService partyMasterService;
	@Autowired CompanyService companyService;
	@Autowired MyUserService myUSerService;
	@Autowired FinancialActiveYearService financialActiveYearService;
	@Autowired GlobalParameter globalParameter;
	
	
	@Override
	public void addGateEntry(GateEntry gateEntry) {
		
		if(gateEntry.getGateSrNo().isEmpty() || gateEntry.getGateSrNo() == null || gateEntry.getGateSrNo()=="") {
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("GEN", "20-21", "EB");
			gateEntry.setGateSrNo("EB"+ maxCode);
		}
		
		
		gateEntry.setCompany(globalParameter.getCompany());
	
		gateEntry.setFinancialYear(globalParameter.getFyYear());
		
		gateEntry.setMyUser(globalParameter.getMyUser());
		
		
		/*
		 * for(GateEntryItemDetail gateEntryItemDetail :
		 * gateEntry.getGateEntryItemDetails()) {
		 * gateEntryItemDetail.setGateEntry(gateEntry); }
		 */
		
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

	@Override
	public List<GateEntry> findAllNotInMrn() {
		
	
		return this.gateEntryRepo.findAllNotInMrn();
	}

}

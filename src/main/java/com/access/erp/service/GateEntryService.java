package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.GateEntry;

public interface GateEntryService {
	
	public void addGateEntry(GateEntry gateEntry);
	public List<GateEntry> getAllGateEntry();
	public Optional<GateEntry> editGateEntry(String gateEntryCode);
	public void deleteGateEntry(String gateEntryCode);
	
	
	public List<GateEntry> findAllNotInMrn();
	
	

}

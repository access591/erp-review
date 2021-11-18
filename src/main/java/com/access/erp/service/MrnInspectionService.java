package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.MrnInspection;

public interface MrnInspectionService {
	
	public void addMrnInspection(MrnInspection mrnInspection);
	public List<MrnInspection> getAllMrnInspection();
	public Optional<MrnInspection> editMrnInspection(String mrnInspNo);
	public void deleteMrnInspection(String mrnInspNo);

}

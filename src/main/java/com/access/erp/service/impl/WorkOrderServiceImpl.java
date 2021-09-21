package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.WorkOrderS;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.repo.WorkOrderServiceRepo;
import com.access.erp.service.WorkOrderService;

@Service
public class WorkOrderServiceImpl implements WorkOrderService{

	@Autowired WorkOrderServiceRepo workOrderRepo;
	@Autowired SeqMainRepo seqMainRepo;
	
	@Override
	public void addWorkOrder(WorkOrderS workOrder) {
		
	}

	@Override
	public List<WorkOrderS> getAllWorkOrder() {
		
		return workOrderRepo.findAll();
	}

	@Override
	public Optional<WorkOrderS> editWorkOrder(Long workId) {
		
		return workOrderRepo.findById(workId);
	}

	@Override
	public void deleteWorkOrder(Long workid) {
		workOrderRepo.deleteById(workid);
		
	}

}

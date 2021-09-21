package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.WorkOrderS;

public interface WorkOrderService {
	
	public void addWorkOrder(WorkOrderS workOrder);
	public List<WorkOrderS> getAllWorkOrder();
	public Optional<WorkOrderS> editWorkOrder(Long workId);
	public void deleteWorkOrder(Long workid);

}

package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.PurchaseOrder;


@Repository
public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder, String>{
	
	List<PurchaseOrder> findAllByOrderByPoNumberDesc();
	List<PurchaseOrder> findByApprovalStatus(String approvalStatus);

}

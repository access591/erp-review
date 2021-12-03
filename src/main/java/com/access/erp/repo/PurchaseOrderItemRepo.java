package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.PurchaseOrder;
import com.access.erp.model.PurchaseOrderItem;
import com.access.erp.model.master.Item;


@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrderItem, Long>{
	
	public List<PurchaseOrderItem> findByPurchaseOrder(PurchaseOrder po);
	
	public PurchaseOrderItem findByItemAndPurchaseOrder(Item item,PurchaseOrder purchaseOrder);

}

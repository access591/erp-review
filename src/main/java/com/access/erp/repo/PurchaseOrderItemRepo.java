package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.PurchaseOrderItem;


@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrderItem, Long>{

}

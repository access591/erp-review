package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.PurchaseReturnDetail;

@Repository
public interface purchaseReturnDetailRepo  extends JpaRepository<PurchaseReturnDetail,Long>{

}

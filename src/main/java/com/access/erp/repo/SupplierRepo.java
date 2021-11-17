package com.access.erp.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.SupplierMaster;

public interface SupplierRepo extends JpaRepository<SupplierMaster, Long>{
	
	public SupplierMaster findBySupplierId(Long supplierId);
	
	

}

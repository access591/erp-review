package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.MaterialRequisitionMaster;

@Repository
public interface MaterialRequisitionMasterRepo extends JpaRepository<MaterialRequisitionMaster, String>{

}

package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.WorkOrderS;

@Repository
public interface WorkOrderServiceRepo extends JpaRepository<WorkOrderS, Long>{

}

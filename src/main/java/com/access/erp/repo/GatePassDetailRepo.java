package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.GatePassDetail;

@Repository
public interface GatePassDetailRepo extends JpaRepository<GatePassDetail, Long>{

}

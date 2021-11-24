package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.GatePass;

@Repository
public interface GatePassRepo extends JpaRepository<GatePass, String>{

}

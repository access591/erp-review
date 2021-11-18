package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.MrnInspection;

@Repository
public interface MrnInspectionRepo extends JpaRepository<MrnInspection, String>{

}

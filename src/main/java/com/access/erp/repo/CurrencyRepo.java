package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.CurrencyMaster;

@Repository
public interface CurrencyRepo extends JpaRepository<CurrencyMaster,String>{

}

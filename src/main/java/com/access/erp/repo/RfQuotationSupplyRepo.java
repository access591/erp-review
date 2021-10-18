package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.RfQuotationSupply;


@Repository
public interface RfQuotationSupplyRepo extends JpaRepository<RfQuotationSupply, Long>{

}

package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.StoreWiseStock;


@Repository
public interface StoreWisestockRepo extends JpaRepository<StoreWiseStock, Long>{

}

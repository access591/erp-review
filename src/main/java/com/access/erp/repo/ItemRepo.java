package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.Item;


@Repository
public interface ItemRepo extends JpaRepository<Item, String>{
	
	public Item findByItemCode(String itemCode);

}

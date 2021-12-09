package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.GateEntry;
import com.access.erp.model.GateEntryItemDetail;
import com.access.erp.model.master.Item;

@Repository
public interface GateEntryDetailRepo extends JpaRepository<GateEntryItemDetail, Long>{
	
	public List<GateEntryItemDetail> findByGateEntry(GateEntry gateEntry);
	
	
	// return onlt single record 
	// uniq 
	public List<GateEntryItemDetail> findByGateEntryAndItem(GateEntry gateEntry ,Item item);

}

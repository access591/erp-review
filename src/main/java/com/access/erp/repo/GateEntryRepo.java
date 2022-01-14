package com.access.erp.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.erp.model.GateEntry;

@Repository
public interface GateEntryRepo extends JpaRepository<GateEntry, String>{

	@Query(value="select g from GateEntry g where g.gateSrNo not in (select m.gateEntryNo from MRN m )")
	public List<GateEntry> findAllNotInMrn();
}

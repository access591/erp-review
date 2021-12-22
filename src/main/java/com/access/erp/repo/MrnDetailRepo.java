package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.MRN;
import com.access.erp.model.MRNDetail;
import com.access.erp.model.master.Item;

public interface MrnDetailRepo extends JpaRepository<MRNDetail, Long>{

	public List<MRNDetail> findByMrn(MRN mrn);
	
	public List<MRNDetail> findByMrnAndItem(MRN mrn , Item item);
	
	public List<MRNDetail> findByDolStatus(String dol);
	
	List<MRNDetail> findDistinctByDolStatus(String dol);
}

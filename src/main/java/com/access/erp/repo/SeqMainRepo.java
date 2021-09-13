package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.SeqMain;


@Repository
public interface SeqMainRepo extends JpaRepository<SeqMain, Long>{

	
	@Query(value="select FN_PRGM_CODE(?1)incId",nativeQuery=true)
	public String findByTranType(String code);

}
 
 






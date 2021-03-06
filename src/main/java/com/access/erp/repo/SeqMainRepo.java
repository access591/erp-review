package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.access.erp.model.master.SeqMain;


@Repository
public interface SeqMainRepo extends JpaRepository<SeqMain, Long>{

	
	@Query(value="select FN_PRGM_CODE(?1)incId",nativeQuery=true)
	public String findByTranType(String code);
	
	//TRAN_TYPE=V_PRG_TYPE AND FYCODE =V_FYCODE AND CCODE =V_CCODE
	//SELECT FN_PRGM_CODE('TST','21-22','EB') A FROM DUAL;
	
	@Query(value="SELECT FN_PRGM_CODE(?1,?2,?3) A FROM DUAL",nativeQuery=true)
	public String findByTranTypeAndFyCodeAndCCode(String code,String fyCode,String cCode);

}
 
 






package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;


@Repository
public interface OpenIndentDetailRepo extends JpaRepository<OpenIndentDetail, Long>{
	
	List<OpenIndentDetail> findByOpenIndent(OpenIndent openIndent);
	OpenIndentDetail findByIndItemCode(String indentItemCode);
	
	OpenIndentDetail findByIndItemCodeAndOpenIndent(String indentItemCode,OpenIndent openIndent);

}

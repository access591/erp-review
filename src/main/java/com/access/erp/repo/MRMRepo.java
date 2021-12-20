
package com.access.erp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.MRN;

@Repository
public interface MRMRepo extends JpaRepository<MRN, String> {
	
	List<MRN> findByMrnDetailsDol(String dol);

}

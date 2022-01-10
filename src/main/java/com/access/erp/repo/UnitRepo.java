package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.access.erp.model.master.Unit;

public interface UnitRepo extends JpaRepository<Unit,String> {

}

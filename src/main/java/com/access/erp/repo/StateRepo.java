package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access.erp.model.master.State;

public interface StateRepo extends JpaRepository<State, String>{

}

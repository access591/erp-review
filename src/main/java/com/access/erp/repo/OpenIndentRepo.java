package com.access.erp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.access.erp.model.OpenIndent;

@Repository
public interface OpenIndentRepo extends JpaRepository<OpenIndent, String>{

}

package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.master.Designation;

public interface DesignationService {

	public void addDesignation(Designation designation);
	public List<Designation> getAllDesignation();
	public Optional<Designation> editDesignation(String desigCode);
	public void deleteDesignation(String disigCode);
}


package com.access.erp.service;

import java.util.List;
import java.util.Optional;

import com.access.erp.model.OpenIndent;

public interface OpenIndentService {

	public void addOpenIndent(OpenIndent openIndent);

	public List<OpenIndent> getAllOpenIndent();

	public Optional<OpenIndent> editOpenIndent(String indentCode);

	public void deleteOpenIndent(String indentCode);
	
	
	public void updateOpenIndent(OpenIndent openIndent);
	
	public void approval(String indentNumber,String approvalStatus,String level);
	
	public List<OpenIndent> approvedOpenIndent();
	
	
	//public void updateOpenIndent(OpenIndent openIndent)

}

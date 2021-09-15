
package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.OpenIndentService;

@Service
public class OpenIndentServiceImpl implements OpenIndentService {

	@Autowired
	OpenIndentRepo openIndentRepo;
	@Autowired
	SeqMainRepo seqMainRepo;

	@Override
	public void addOpenIndent(OpenIndent openIndent) {

		if (openIndent.getIndentNumber() == "" || openIndent.getIndentNumber() == null) {
			System.out.println("country code is : " + openIndent.getIndentNumber());
			String maxCode = seqMainRepo.findByTranType("IND");
			openIndent.setIndentNumber(maxCode);
		}

		for (OpenIndentDetail indent : openIndent.getOpeIndentDetail()) {
			// openIndent.getOpeIndentDetail().add(indent);
			indent.setOpenIndent(openIndent);
		}

		openIndentRepo.save(openIndent);

	}

	@Override
	public List<OpenIndent> getAllOpenIndent() {

		return openIndentRepo.findAll();
	}

	@Override
	public Optional<OpenIndent> editOpenIndent(String indentCode) {

		return openIndentRepo.findById(indentCode);
	}

	@Override
	public void deleteOpenIndent(String indentCode) {
		openIndentRepo.deleteById(indentCode);

	}

}

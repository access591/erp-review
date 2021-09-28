
package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.OpenIndentDetail;
import com.access.erp.repo.OpenIndentDetailRepo;
import com.access.erp.repo.OpenIndentRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.OpenIndentService;

@Service
public class OpenIndentServiceImpl implements OpenIndentService {

	@Autowired
	OpenIndentRepo openIndentRepo;
	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	OpenIndentDetailRepo indentDetailRepo;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addOpenIndent(OpenIndent openIndent) {

		
		
		System.out.println("testing open indent detail : Id =>" + openIndent.getOpeIndentDetail().get(0).getId());
		
		if (openIndent.getIndentNumber() == "" || openIndent.getIndentNumber() == null) {
			System.out.println("country code is : " + openIndent.getIndentNumber());
			String maxCode = seqMainRepo.findByTranType("IND");
			openIndent.setIndentNumber(maxCode);

			for (OpenIndentDetail indent : openIndent.getOpeIndentDetail()) {
				// openIndent.getOpeIndentDetail().add(indent);
				indent.setOpenIndent(openIndent);
				// indentDetailRepo.save(indent);
			}
			
			openIndentRepo.save(openIndent);

		} else {

			Session session = sessionFactory.openSession();
			Transaction tx = null;

			try {
				tx = session.beginTransaction();
				
				OpenIndent open = session.find(OpenIndent.class, openIndent.getIndentNumber());
				
				open.getOpeIndentDetail().clear();
				
				for(OpenIndentDetail indentDetail : openIndent.getOpeIndentDetail()) {
					
					//open.getOpeIndentDetail.add
					indentDetail.setOpenIndent(open);
					
					open.getOpeIndentDetail().add(indentDetail);
				}
				
				
				
				session.merge(openIndent);
				tx.commit();

				// query.getResultList();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}

		}

		

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

	@Override
	public void updateOpenIndent(OpenIndent openIndent) {

		Optional<OpenIndent> open = openIndentRepo.findById(openIndent.getIndentNumber());

		openIndent.getOpeIndentDetail().addAll(openIndent.getOpeIndentDetail());

	}

}

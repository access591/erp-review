
package com.access.erp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
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

		// System.out.println("testing open indent detail : Id =>" +
		// openIndent.getOpeIndentDetail().get(0).getId());

		if (openIndent.getIndentNumber() == "" || openIndent.getIndentNumber() == null) {
			System.out.println("country code is : " + openIndent.getIndentNumber());
			String maxCode = seqMainRepo.findByTranType("IND");
			openIndent.setIndentNumber("EB-IND"+maxCode.substring(2));

			for (OpenIndentDetail indent : openIndent.getOpeIndentDetail()) {
				// openIndent.getOpeIndentDetail().add(indent);

//				String maxCode1 = seqMainRepo.findByTranType("IDT");
//				indent.setIndItemCode(maxCode);

				//System.out.println("indent item code : " + indent.getItem().getItemCode());
				//indent.setItem(indent.getItem());
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

				for (OpenIndentDetail indentDetail : openIndent.getOpeIndentDetail()) {

					// open.getOpeIndentDetail.add
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

	@Override
	public void approval(String indentNumber, String approvalStatus, String level) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			OpenIndent openIndent = session.find(OpenIndent.class, indentNumber);

			if (level.equals("1")) {

				openIndent.setApprovalDate1(new Date());
				openIndent.setApprovalStatus1(approvalStatus);

			}

			else if (level.equals("2")) {
				openIndent.setApprovalDate2(new Date());
				openIndent.setApprovalStatus2(approvalStatus);

			}

			else if (level.equals("3")) {
				openIndent.setApprovalDate3(new Date());
				openIndent.setApprovalStatus3(approvalStatus);
				openIndent.setApprovalStatus(approvalStatus);
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public List<OpenIndent> approvedOpenIndent() {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		List<OpenIndent> result = null;

		try {

			tx = session.beginTransaction();
			TypedQuery<OpenIndent> query = session
					.createQuery("from OpenIndent o where o.approvalStatus=:approvalStatus", OpenIndent.class);
			query.setParameter("approvalStatus", "Y");
			result = query.getResultList();
			tx.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}

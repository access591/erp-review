package com.access.erp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.OpenIndent;
import com.access.erp.model.QuotationDetail;
import com.access.erp.model.QuotationItem;
import com.access.erp.model.RfQuotation;
import com.access.erp.model.RfQuotationItem;
import com.access.erp.repo.QuotationDetailRepo;
import com.access.erp.repo.RFQuotationRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.QuotationDetailService;

@Service
public class QuotationDetailServiceImpl implements QuotationDetailService {

	@Autowired
	QuotationDetailRepo quotationRepo;
	@Autowired
	RFQuotationRepo rfQuotationRepo;
	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addQuotationdetail(QuotationDetail quotationDetail) {

		if (quotationDetail.getQuotNo() == "" || quotationDetail.getQuotNo() == null) {
			System.out.println("quotation detail/item  code is : " + quotationDetail.getQuotNo());
			String maxCode = seqMainRepo.findByTranType("QUT");
			quotationDetail.setQuotNo(maxCode);
		}

		for (QuotationItem qItem : quotationDetail.getQuotationItem()) {

			qItem.setQuotationDetail(quotationDetail);

		}

		quotationRepo.save(quotationDetail);
	}

	@Override
	public List<QuotationDetail> getAllQuotationDetail() {
		return quotationRepo.findAll();
	}

	@Override
	public Optional<QuotationDetail> editQuotationDetail(String quotCode) {

		return quotationRepo.findById(quotCode);
	}

	@Override
	public void deleteQuotationDetail(String quotCode) {

		quotationRepo.deleteById(quotCode);
	}

	@Override
	public List<OpenIndent> getIndentInRFQ() {

		// Get All RFQ
		List<RfQuotation> listRfQuotation = rfQuotationRepo.findAll();

		List<OpenIndent> listOpenIndent = new ArrayList<>();
		// Check RFQ Size
		if (listRfQuotation.size() > 0) {

			// Traverse RFQ List for Getting RFQ Code (PK)
			for (RfQuotation rfq : listRfQuotation) {

				// rfq.getRfqNo() unique key

				// Get RfQuotation Item List in RFQuotation
				List<RfQuotationItem> listRFQuotation = rfq.getListRFQuotation();
				if (listRFQuotation.size() > 0) {

					for (RfQuotationItem rfqItem : listRFQuotation) {

						listOpenIndent.add(rfqItem.getOpenIndent());

					}
				}
			}
		}

		return listOpenIndent;
	}

	@Override
	public void approvalForQuotationDetail(String quotNum, String status) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			QuotationDetail quotationDetail = session.find(QuotationDetail.class, quotNum);
			quotationDetail.setApprovalDate1(new Date());
			quotationDetail.setApprovalStatus1(status);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}

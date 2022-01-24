package com.access.erp.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.access.erp.model.PurchaseReturn;
import com.access.erp.model.PurchaseReturnDetail;
import com.access.erp.repo.PurchaseReturnRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.PurchaseReturnService;

@Service
public class PurchaseReturnServiceImpl implements PurchaseReturnService {

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	PurchaseReturnRepo purchaseReturnrepo;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addPurchaseReturn(PurchaseReturn purchaseReturn) {

		if (purchaseReturn.getPurchasePrNo() == "" | (purchaseReturn.getPurchasePrNo() == null)) {
			System.out.println("purchase return  code is : " + purchaseReturn.getPurchasePrNo());

			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("PR", "20-21", "EB");

			System.out.println("max code is : " + maxCode);
			purchaseReturn.setPurchasePrNo(maxCode);
		}

		for (PurchaseReturnDetail detail : purchaseReturn.getListPurchaseReturnDetail()) {
			detail.setPurchaseReturn(purchaseReturn);
		}

		purchaseReturnrepo.save(purchaseReturn);

	}

	@Override
	public List<PurchaseReturn> getAllPurchaseReturn() {
		// TODO Auto-generated method stub
		return purchaseReturnrepo.findAll();
	}

	@Override
	public Optional<PurchaseReturn> editPurchaseReturn(String purchasePrNo) {
		// TODO Auto-generated method stub
		return purchaseReturnrepo.findById(purchasePrNo);
	}

	@Override
	public void deletePurchaseReturn(String purchasePrNo) {
		// TODO Auto-generated method stub
		purchaseReturnrepo.deleteById(purchasePrNo);
	}

	@Override
	public void updatePurchaseReturn(PurchaseReturn purchaseReturn) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {

			PurchaseReturn pr = session.find(PurchaseReturn.class, purchaseReturn.getPurchasePrNo());

			tx = session.beginTransaction();
			pr.getListPurchaseReturnDetail().clear();

			for (PurchaseReturnDetail purchaseDetail : purchaseReturn.getListPurchaseReturnDetail()) {

				purchaseDetail.setPurchaseReturn(purchaseReturn);

				pr.getListPurchaseReturnDetail().add(purchaseDetail);

			}

			// po.getListPurchaseOrderItem().addAll(purchaseOrder.getListPurchaseOrderItem());
			session.merge(purchaseReturn);

			tx.commit();

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

}

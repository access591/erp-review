package com.access.erp.service.impl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.master.FinancialYear;
import com.access.erp.repo.FinnancialYearRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.FinancialYearService;

@Service
public class FinancialYearServiceImpl implements FinancialYearService {

	@Autowired
	SeqMainRepo seqMainRepo;
	@Autowired
	FinnancialYearRepo financialYearRepo;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addFinancialYear(FinancialYear financialYear) {

		financialYearRepo.save(financialYear);

		System.out.println("end");
	}

	@Override
	public List<FinancialYear> getAllFinancialYear() {
		return financialYearRepo.findAll();
	}

	@Override
	public Optional<FinancialYear> editFinancialYear(String id) {

		return financialYearRepo.findById(id);

	}

	@Override
	public void deleteFinancialYear(String id) {

		financialYearRepo.deleteById(id);

	}

	@Override
	public boolean isFinancialYearExists(String financialYearCode) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean results = false;

		try {
			tx = session.beginTransaction();

			Query<FinancialYear> query = session.createQuery("from FinancialYear f where f.financialYearCode=:financialYearCode",
					FinancialYear.class);
			query.setParameter("financialYearCode", financialYearCode);
			
			List<FinancialYear> listFinancialYear = query.getResultList();
			
			for(FinancialYear f : listFinancialYear) {
				System.out.println("f value is : " + f.getFinancialYearCode() + " : " + f.getFinancialYearCode());
			}
			
			if(listFinancialYear.size()>0) {
				System.out.println("not null");
				results = true;
			}
			
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		System.out.println("rseult is :" + results);
		return results;
		
	}

}

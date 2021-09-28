//package com.access.erp.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.access.erp.model.master.FinancialActiveYear;
//import com.access.erp.repo.FinnancialActiveYearRepo;
//import com.access.erp.repo.SeqMainRepo;
//import com.access.erp.service.FinancialActiveYearService;
//
//@Service
//public class FinancialActiveYearServiceImpl implements FinancialActiveYearService{
//
//	@Autowired SeqMainRepo seqMainRepo;
//	@Autowired FinnancialActiveYearRepo financialActiveYearRepo;
//	
//	
//	@Override
//	public void addFinancialActiveYear(FinancialActiveYear financialActiveYear) {
//		
//		
//		if (financialActiveYear.getFinancialYearCode() == "" || financialActiveYear.getFinancialYearCode() == null) {
//			System.out.println("country code is : "+ financialActiveYear.getFinancialYearCode());
//			String maxCode = seqMainRepo.findByTranType("FIA");
//			
//			System.out.println(" max code is : " + maxCode);
//			financialActiveYear.setFinancialYearCode(maxCode);
//		}
//
//		financialActiveYearRepo.save(financialActiveYear);
//		
//		System.out.println("end");
//		
//	}
//
//	@Override
//	public List<FinancialActiveYear> getAllFinancialActiveYear() {
//		return financialActiveYearRepo.findAll();
//	}
//
//	@Override
//	public Optional<FinancialActiveYear> editFinancialActiveYear(String financialCode) {
//		
//		return financialActiveYearRepo.findById(financialCode);
//	}
//
//	@Override
//	public void deleteFinanciaActivelYear(String financialCode) {
//	
//		financialActiveYearRepo.deleteById(financialCode);
//		
//	}
//
//
//
//}

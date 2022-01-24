package com.access.erp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.access.erp.model.MaterialRequisitionDetail;
import com.access.erp.model.MaterialRequisitionMaster;
import com.access.erp.model.QuotationDetail;
import com.access.erp.repo.MaterialRequisitionMasterRepo;
import com.access.erp.repo.SeqMainRepo;
import com.access.erp.service.MaterialRequisitionMasterService;

@Service
public class MaterialRequisitionMasterServiceImpl implements MaterialRequisitionMasterService{

	@Autowired MaterialRequisitionMasterRepo materialRequisitionMasterRepo;
	@Autowired SeqMainRepo seqMainRepo;
	@Autowired SessionFactory sessionFactory;
	
	
	@Override
	public void addMaterialRequisitionMaster(MaterialRequisitionMaster materialRequisitionMaster) {
		
		//category.getCategCode() == "" || category.getCategCode() == null
		
		if(materialRequisitionMaster.getRequisitionNo().isEmpty() || materialRequisitionMaster.getRequisitionNo() == "" || materialRequisitionMaster.getRequisitionNo() == null) {
			
			
			
			String maxCode = seqMainRepo.findByTranTypeAndFyCodeAndCCode("REQ", "20-21", "EB");
			materialRequisitionMaster.setRequisitionNo("EB-"+maxCode);
			
			
		}
		
		for(MaterialRequisitionDetail detail : materialRequisitionMaster.getMaterialRequisitionDetails()) {
			
			detail.setMaterialRequisitionMaster(materialRequisitionMaster);
		}
		
		
		materialRequisitionMasterRepo.save(materialRequisitionMaster);
		
	}

	@Override
	public List<MaterialRequisitionMaster> getAllMaterialRequisitionMaster() {
		
		return materialRequisitionMasterRepo.findAll();
	}

	@Override
	public Optional<MaterialRequisitionMaster> editMaterialRequisitionMaster(String matReqNo) {
		
		return materialRequisitionMasterRepo.findById(matReqNo);
	}

	@Override
	public void deleteMaterialRequisitionMaster(String matReqNo) {
		
		materialRequisitionMasterRepo.deleteById(matReqNo);
		
	}

	@Override
	public void materialRequisitionApproval(String reqNum, String approvalStatus) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			MaterialRequisitionMaster requisition = session.find(MaterialRequisitionMaster.class, reqNum);
			
			if(approvalStatus.equals("Y")) {
				requisition.setApprovalStatus(approvalStatus);
				requisition.setDateOfApproval(new Date());
			}
			else if (approvalStatus.equals("C")) {
				requisition.setDateOfCancel(new Date());
				requisition.setApprovalStatus(approvalStatus);
			}
			
			
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}

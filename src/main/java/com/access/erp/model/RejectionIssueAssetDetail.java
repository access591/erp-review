package com.access.erp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.access.erp.model.master.Item;
import com.access.erp.model.master.Store;
import com.access.erp.model.master.UOM;

@Entity
@Table(name="ISS_ASSET_DETAIL")
public class RejectionIssueAssetDetail {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="REJECTIONASSETDETAILID",length=30)
	private Long rejectionAssetDetailId;
	
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name="ITEM_CODE",nullable = true)
	private Item item;
	
	@Column(name="ASSETNO",length=20)
	private String assetNo;
	

	@Column(name="ASSET_SEQ_NO",length=20)
	private String assetSeqNo;
	
	@ManyToOne(optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name="STORE_CODE",nullable = true)
	private Store store;
	
	
	
	
}

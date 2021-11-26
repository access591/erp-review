                                package com.access.erp.model.master;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="M_ITEM")
public class Item {
	
	@Id
	@Column(name="ITEM_CODE",length = 30)
	private String itemCode;
	
	@Column(name="ITEM_NAME",length = 150)
	private String itemName;
	
	

    @ManyToOne(optional = false)
    @JoinColumn(name="CATEGORY_CODE")
    @JsonIgnore
	private Category category;
	
	@Column(name="PART_NO",length = 15)
	private String partNum;
	
	@Column(name="PART_NAME",length = 150)
	private String partName;
	
	@Column(name="STORE_INFO",length = 40)
	private String storeInfo;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="STORE_CODE")
	@JsonIgnore
	private Store store;
	
	///14 , 2
	@Column(name="UNIT_COST",length = 14)
	private int unitCode;
	
	//12,3
	@Column(name="MIN_LEVEL",length = 12)
	private int minLevel;
	
	//12,3
	@Column(name="MAX_LEVEL",length = 14)
	private int maxLavel;
	
	

	//12,3
	@Column(name="REORDER_LEVEL",length = 12)
	private int reOrderLevel;
	
	
	@Column(name="BIN_NO",length = 30)
	private String binNum;
	
	//12,2
	@Column(name="ITEM_AVGRATE",length = 14)
	private int itemAvgRate;
	
	//12,2
	@Column(name="OVERHEAD_COST",length = 14)
	private int overHeadCost;
	
	//12,2
	@Column(name="ITEM_RATE",length = 14)
	private int itemRate;
	
	@Column(name="ITEM_ISSUE",length = 2)
	private String itemIssue;
	
	@Column(name="ITEM_SET",length = 2)
	private String itemSet;
	
	@Column(name="REQUISITION_METHOD",length = 30)
	private String requisitionMethod;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="UOM_CODE")
	@JsonIgnore
	private UOM uom;
	
	@Column(name="ACC_LEDGER_CODE",length = 10)
	private String accLedgerCode;
	
	@Column(name="ITEM_MODEL",length = 30)
	private String itemModel;
	
	@Column(name="TECH_SPEC",length = 2000)
	private String techSpec;
	
	@Column(name="EXCISABLE",length = 2)
	private String excisable;
	
	
	//
	
	
	//5,2
	@Column(name="DUTY_RATE",length = 10)
	private int dutyRate;
	
	//5,2
	@Column(name="CENVAT",length = 10)
	private int cenvat;
	
	//5,2
	@Column(name="SED",length = 10)
	private int sed;
	
	//5,2
	@Column(name="AED_TTA",length = 10)
	private int aedTta;
	
	//5,2
	@Column(name="AED_GSI",length = 10)
	private int aedGsi;
	
	//5,2
	@Column(name="CESS",length = 10)
	private int cess;
	
	@Column(name="ADDL_DUTY",length = 10)
	private int addlDuty;
	
	@Column(name="OTHERS",length = 10)
	private int others;
	
	@Column(name="DUTY_PAYMENT_PARTICULAR",length = 500)
	private String dutyPaymentParticular;
	
	@Column(name="CST_RATE",length = 10)
	private int cstRate;
	
	@Column(name="SST_RATE",length = 10)
	private int sstRate;
	
	@Column(name="VAT_RATE",length = 10)
	private int vatRate;
	
	@Column(name="DESCRIPTION",length = 500)
	private String description;
	
	@Column(name="ST_RATE",length = 10)
	private int stRate;
	
	@Column(name="CHAPTER_NO",length = 50)
	private String chapterNo;
	
	@Column(name="CET_HEADING",length = 50)
	private String cetHeading;
	
	@Column(name="CET_SUBHEADING",length = 50)
	private String cetSubHeading;
	
	@Column(name="PRODUCT_GROUP",length = 50)
	private String productGroup;
	
	@Column(name="WORK_CENTER_CODE",length = 50)
	private String workCenterCode;
	
	@Column(name="ITEM_TYPE",length = 5)
	private String itemType;
	
	@Column(name="BULK_ISS_YN",length = 5)
	private String bulkIssYn;
	
	@Column(name="DUTY_YN",length = 5)
	private String dutyYn;
	
	@Column(name="PETTY_ITEM",length = 5)
	private String pettyItem;
	
	@Column(name="SHELF_LIFE_YN",length = 5)
	private String shelfLifeYn;
	
	@Column(name="PRODUCT_CODE",length = 30)
	private String productCode;
	
	@Column(name="ITEM_IMPORTED",length = 10)
	private String itemImported;
	
	@Column(name="NO_OF_DAYS",length = 7)
	private int noOfDays;
	
	@Column(name="DESIGN_CODE",length = 30)
	private String designCode;
	
	@Column(name="SHORTAGE_QTY_ACC",length = 14)
	private int shortageQtyAcc;
	
	@Column(name="UOM_SHORTAGE_QTY",length = 15)
	private String uomShortageQty;
	
	@Column(name="DOL",length = 2)
	private String dol;
	
	@Column(name="INVENTORY_ITEM",length = 2)
	private String inventoryItem;
	
	@Column(name="SCRAP_PRODUCT_YN",length = 2)
	private String scrapProductYn;
	
	@Column(name="TRADING_ITEM",length = 2)
	private String tradingItem;
	
	@Column(name="WARR_ITEM_YN",length = 2)
	private String warItemYn;
	
	@Column(name="SECTION_CODE",length = 7)
	private String sectionCode;
	
	@Column(name="GRADE_CODE",length = 20)
	private String gradeCode;
	
	@Column(name="TARIFF_ITEM",length = 10)
	private int tariffItem;
	
	@Column(name="SIZE_CODE",length = 6)
	private String sizeCode;
	
	//5,2
	@Column(name="SR_HR_CESS",length = 10)
	private int srHrCess;
	
	@Column(name="BIN_LOC",length = 50)
	private String binLoc;
	
	@Column(name="CRITICAL_ITEM",length = 2)
	private String criticalItem;
	
	
	@Column(name="HSN_CODE",length = 10)
	private String hsnCode;
	
	//5,2
	@Column(name="CGST",length = 10)
	private String cgst;
	
	//5,2
	@Column(name="SGST",length = 10)
	private String sgst;
	
	//5,2
	@Column(name="IGST",length = 10)
	private String igst;
	
	// ITEM CODE 
	@Column(name="OLD_ITEM_CODE",length = 30)
	private String oldItemCode;
	
	
	// ITEM CODE 
	@Column(name="OLD_CATEGORY_CODE",length = 30)
	private String oldCategoryCode;
	
	@Column(name="TOLRANCE",length = 10)
	private int tolrance;
	
	@Column(name="ITEM_CONF",length = 10)
	private String itemConf;
	
	@Column(name="AREA",length = 100)
	private String area;

	@Column(name="CCODE", updatable=false, insertable=false)
	private String compCode;
	
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<PackingDetail> packingDetails;

	public Item() {
		super();
		
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public String getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public UOM getUom() {
		return uom;
	}

	public void setUom(UOM uom) {
		this.uom = uom;
	}

	public String getPartNum() {
		return partNum;
	}

	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(int unitCode) {
		this.unitCode = unitCode;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}

	public int getMaxLavel() {
		return maxLavel;
	}

	public void setMaxLavel(int maxLavel) {
		this.maxLavel = maxLavel;
	}

	public int getReOrderLevel() {
		return reOrderLevel;
	}

	public void setReOrderLevel(int reOrderLevel) {
		this.reOrderLevel = reOrderLevel;
	}

	public String getBinNum() {
		return binNum;
	}

	public void setBinNum(String binNum) {
		this.binNum = binNum;
	}

	public int getItemAvgRate() {
		return itemAvgRate;
	}

	public void setItemAvgRate(int itemAvgRate) {
		this.itemAvgRate = itemAvgRate;
	}

	public int getOverHeadCost() {
		return overHeadCost;
	}

	public void setOverHeadCost(int overHeadCost) {
		this.overHeadCost = overHeadCost;
	}

	public int getItemRate() {
		return itemRate;
	}

	public void setItemRate(int itemRate) {
		this.itemRate = itemRate;
	}

	public String getItemIssue() {
		return itemIssue;
	}

	public void setItemIssue(String itemIssue) {
		this.itemIssue = itemIssue;
	}

	public String getItemSet() {
		return itemSet;
	}

	public void setItemSet(String itemSet) {
		this.itemSet = itemSet;
	}

	public String getRequisitionMethod() {
		return requisitionMethod;
	}

	public void setRequisitionMethod(String requisitionMethod) {
		this.requisitionMethod = requisitionMethod;
	}

	

	public String getAccLedgerCode() {
		return accLedgerCode;
	}

	public void setAccLedgerCode(String accLedgerCode) {
		this.accLedgerCode = accLedgerCode;
	}

	public String getItemModel() {
		return itemModel;
	}

	public void setItemModel(String itemModel) {
		this.itemModel = itemModel;
	}

	public String getTechSpec() {
		return techSpec;
	}

	public void setTechSpec(String techSpec) {
		this.techSpec = techSpec;
	}

	public String getExcisable() {
		return excisable;
	}

	public void setExcisable(String excisable) {
		this.excisable = excisable;
	}

	

	public String getCompCode() {
		return compCode;
	}

	public void setCompCode(String compCode) {
		this.compCode = compCode;
	}

	public int getDutyRate() {
		return dutyRate;
	}

	public void setDutyRate(int dutyRate) {
		this.dutyRate = dutyRate;
	}

	public int getCenvat() {
		return cenvat;
	}

	
	public List<PackingDetail> getPackingDetails() {
		return packingDetails;
	}

	public void setPackingDetails(List<PackingDetail> packingDetails) {
		this.packingDetails = packingDetails;
	}

	public void setCenvat(int cenvat) {
		this.cenvat = cenvat;
	}

	public int getSed() {
		return sed;
	}

	public void setSed(int sed) {
		this.sed = sed;
	}

	public int getAedTta() {
		return aedTta;
	}

	public void setAedTta(int aedTta) {
		this.aedTta = aedTta;
	}

	public int getAedGsi() {
		return aedGsi;
	}

	public void setAedGsi(int aedGsi) {
		this.aedGsi = aedGsi;
	}

	public int getCess() {
		return cess;
	}

	public void setCess(int cess) {
		this.cess = cess;
	}

	public int getAddlDuty() {
		return addlDuty;
	}

	public void setAddlDuty(int addlDuty) {
		this.addlDuty = addlDuty;
	}

	public int getOthers() {
		return others;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public String getDutyPaymentParticular() {
		return dutyPaymentParticular;
	}

	public void setDutyPaymentParticular(String dutyPaymentParticular) {
		this.dutyPaymentParticular = dutyPaymentParticular;
	}

	public int getCstRate() {
		return cstRate;
	}

	public void setCstRate(int cstRate) {
		this.cstRate = cstRate;
	}

	public int getSstRate() {
		return sstRate;
	}

	public void setSstRate(int sstRate) {
		this.sstRate = sstRate;
	}

	public int getVatRate() {
		return vatRate;
	}

	public void setVatRate(int vatRate) {
		this.vatRate = vatRate;
	}

	public int getStRate() {
		return stRate;
	}

	public void setStRate(int stRate) {
		this.stRate = stRate;
	}

	public String getChapterNo() {
		return chapterNo;
	}

	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}

	public String getCetHeading() {
		return cetHeading;
	}

	public void setCetHeading(String cetHeading) {
		this.cetHeading = cetHeading;
	}

	public String getCetSubHeading() {
		return cetSubHeading;
	}

	public void setCetSubHeading(String cetSubHeading) {
		this.cetSubHeading = cetSubHeading;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public String getWorkCenterCode() {
		return workCenterCode;
	}

	public void setWorkCenterCode(String workCenterCode) {
		this.workCenterCode = workCenterCode;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getBulkIssYn() {
		return bulkIssYn;
	}

	public void setBulkIssYn(String bulkIssYn) {
		this.bulkIssYn = bulkIssYn;
	}

	public String getDutyYn() {
		return dutyYn;
	}

	public void setDutyYn(String dutyYn) {
		this.dutyYn = dutyYn;
	}

	public String getPettyItem() {
		return pettyItem;
	}

	public void setPettyItem(String pettyItem) {
		this.pettyItem = pettyItem;
	}

	public String getShelfLifeYn() {
		return shelfLifeYn;
	}

	public void setShelfLifeYn(String shelfLifeYn) {
		this.shelfLifeYn = shelfLifeYn;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getItemImported() {
		return itemImported;
	}

	public void setItemImported(String itemImported) {
		this.itemImported = itemImported;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}

	public int getShortageQtyAcc() {
		return shortageQtyAcc;
	}

	public void setShortageQtyAcc(int shortageQtyAcc) {
		this.shortageQtyAcc = shortageQtyAcc;
	}

	public String getUomShortageQty() {
		return uomShortageQty;
	}

	public void setUomShortageQty(String uomShortageQty) {
		this.uomShortageQty = uomShortageQty;
	}

	public String getDol() {
		return dol;
	}

	public void setDol(String dol) {
		this.dol = dol;
	}

	public String getInventoryItem() {
		return inventoryItem;
	}

	public void setInventoryItem(String inventoryItem) {
		this.inventoryItem = inventoryItem;
	}

	public String getScrapProductYn() {
		return scrapProductYn;
	}

	public void setScrapProductYn(String scrapProductYn) {
		this.scrapProductYn = scrapProductYn;
	}

	public String getTradingItem() {
		return tradingItem;
	}

	public void setTradingItem(String tradingItem) {
		this.tradingItem = tradingItem;
	}

	public String getWarItemYn() {
		return warItemYn;
	}

	public void setWarItemYn(String warItemYn) {
		this.warItemYn = warItemYn;
	}

	public String getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public int getTariffItem() {
		return tariffItem;
	}

	public void setTariffItem(int tariffItem) {
		this.tariffItem = tariffItem;
	}

	public String getSizeCode() {
		return sizeCode;
	}

	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}

	public int getSrHrCess() {
		return srHrCess;
	}

	public void setSrHrCess(int srHrCess) {
		this.srHrCess = srHrCess;
	}

	public String getBinLoc() {
		return binLoc;
	}

	public void setBinLoc(String binLoc) {
		this.binLoc = binLoc;
	}

	public String getCriticalItem() {
		return criticalItem;
	}

	public void setCriticalItem(String criticalItem) {
		this.criticalItem = criticalItem;
	}

	

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getCgst() {
		return cgst;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public String getSgst() {
		return sgst;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public String getIgst() {
		return igst;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public String getOldItemCode() {
		return oldItemCode;
	}

	public void setOldItemCode(String oldItemCode) {
		this.oldItemCode = oldItemCode;
	}

	public String getOldCategoryCode() {
		return oldCategoryCode;
	}

	public void setOldCategoryCode(String oldCategoryCode) {
		this.oldCategoryCode = oldCategoryCode;
	}

	public int getTolrance() {
		return tolrance;
	}

	public void setTolrance(int tolrance) {
		this.tolrance = tolrance;
	}

	public String getItemConf() {
		return itemConf;
	}

	public void setItemConf(String itemConf) {
		this.itemConf = itemConf;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	

}

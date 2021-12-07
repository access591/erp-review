//1.**************************************************OPEN INDENT********************************************** */



//**************************************************END OPEN INDENT********************************************** */









//*********************************************RequestForQuotation***************************









//*********************************************end request for quotation***************************




//*********************************************QUOTATION DETAIL ********************************* */









function changeCurrency() {

	var currencyCode = document.getElementById("currencyCode").value;

	//var currencyValue = currencyCode.options[currencyCode.selectedIndex].text;
	var currencyValue = $('#currencyCode :selected').text();
	console.log("currency code is : " + currencyCode)
	console.log("currency value is : " + currencyValue)
	document.getElementById("currencyValue").value = currencyCode;


	//console.log("supplier id is : "+ currencyCode)



}



//Get Object length
Object.size = function(obj) {
	var size = 0,
		key;
	for (key in obj) {
		if (obj.hasOwnProperty(key)) size++;
	}
	return size;
};





var totalValue = 0;

//calulation of total row 
function calculationOfTotalValue() {
	var totalInr = document.getElementById("totalInrValue0").value;
	totalValue = totalInr;
	total_totalInr_calc();
}
function totalDiscountInPercentFun() {

	var totalInPercent = document.getElementById("totalDiscountInPercent").value;
	var result = totalValue * totalInPercent / 100;
	document.getElementById("totalDiscountInValue").value = result;
}

function discountInPercentFun() {
	var discountInPercent = document.getElementById("discountInPercent").value;
	var result = totalValue * discountInPercent / 100;
	document.getElementById("discountInValue").value = result;
}

function sgstInPercentFun() {
	var sgstInPercent = document.getElementById("sgstInPercent").value;
	var result = totalValue * sgstInPercent / 100;
	document.getElementById("sgstInValue").value = result;
	total_totalInr_calc_discount()
}

function cgstInPercentFun() {
	var cgstInPercent = document.getElementById("cgstInPercent").value;
	var result = totalValue * cgstInPercent / 100;
	document.getElementById("cgstInValue").value = result;
}

function igstInPercentFun() {
	var igstInPercent = document.getElementById("igstInPercent").value;
	var result = totalValue * igstInPercent / 100;
	document.getElementById("igstInValue").value = result
}


function total_totalInr_calc() {

	document.getElementById("totalRs").value = totalValue;

}

function total_totalInr_calc_discount() {

	var totalDiscountInvalue = document.getElementById("totalDiscountInValue").value;
	var discountInvalue = document.getElementById("discountInValue").value;
	var sgstInValue = document.getElementById("sgstInValue").value;
	var cgstInValue = document.getElementById("cgstInValue").value;
	var igstInValue = document.getElementById("igstInValue").value;

	var totalValueWithDiscount = totalValue - (totalDiscountInvalue + discountInvalue + sgstInValue + cgstInValue + igstInValue)

	if (totalValueWithDiscount >= 0) {
		document.getElementById("totalCount").value = totalValueWithDiscount;
	}


}



//*********************************************END QUOTATION DETAIL ********************************* */








//*******************************************PURCHASE ORDER ******************************** */

function supplierInfoPurchase() {

	var supplierCode = document.getElementById("supplierId").value;
	console.log("ItemCode is : " + supplierCode)

	$.ajax({
		type: "GET",
		url: "supplierDetail/" + supplierCode,

		success: function(data) {
			console.log("Data From Supplier Info Purchase : " + data)

			$("#supplierState").val(data.supplierState)
			//$("#uomCode").val(data.uom.uomCode);



		}, error: function() {
			console.log("Error");
		}
	});

}








/*
function indentDetailInCaseOfIndent() {


	$.ajax({
		type: "GET",
		url: "indent/indentdetail/",

		success: function(data) {
			console.log("Data From quotaionInfo : " + data)

			//$("#quotationDate").val(data.quotDate)
			//$("#uomCode").val(data.uom.uomCode);

			console.log(" result : " + JSON.stringify(data))

			console.log(" result : " + data[0])

			//console.log(" result : " + data.listRfQuotationItem[0].item.itemCode)

			var options = '<option value=""><strong>Select Indent</strong></option>';
			$(data).each(function(index, value) {

				console.log("data in loop : ")
				console.log("data in loop : " + value)

				options += '<option value="' + value + '">' + value + '</option>';

			});

			$('.indentContainer').html(options);



		}, error: function() {
			console.log("Error");
		}
	});

}*/



function getIndentDetailPo() {

	var indentNumber = document.getElementById("indentNumberPo").value;

	$.ajax({
		type: "GET",
		url: "indentdetail/" + indentNumber,

		success: function(data) {
			console.log("Indent Detail data is : " + data)

			console.log("indent data is : " + data.indentDate)
			$("#indentDatePo").val(data.indentDate)
			//$("#empName").val(data.employee.empName);
			//$("#empCode").val(data.employee.empCode);

			getItemList(indentNumber);



		}, error: function() {
			console.log("Error");
		}
	});
}


function getItemList(indentNumber) {


	console.log("get Item List Function is : " + indentNumber)

	$.ajax({
		type: "GET",
		url: "itemList/" + indentNumber,

		success: function(data) {
			console.log("Item Info behalf of Indent Number  : " + data)

			var options = '<option value=""><strong>Select Item</strong></option>';
			$(data).each(function(index, value) {

				console.log("item info : " + value.itemCode)
				console.log("item info : " + value.itemName)

				options += '<option value="' + value.itemCode + '">' + value.description + '</option>';

			});

			$('.itemContainerPo').html(options);

		}, error: function() {
			console.log("Error");
		}
	});

}


function getItemInfoInPo() {

	var itemNumber = document.getElementById("itemPo").value;
	var indentNumber = document.getElementById("indentNumberPo").value;
	console.log("get item detail : " + indentNumber + " : " + itemNumber)

	$.ajax({
		type: "GET",
		url: "itemInfo/" + itemNumber + "/" + indentNumber,

		success: function(data) {
			console.log("item info detail " + data)

			$("#itemRate0").val(data.itemRate)
			$("#qtyOrder0").val(data.indQty)


			totalCostCal();

		}, error: function() {
			console.log("Error");
		}
	});
}

function totalCostCal() {

	var itemRate = document.getElementById("itemRate0").value;
	var qtyOrderrate = document.getElementById("qtyOrder0").value;

	var freight = document.getElementById("freight0").value;


	document.getElementById("totalCost0").value = itemRate * qtyOrderrate;
	document.getElementById("totalCostInr0").value = itemRate * qtyOrderrate;

}
function calulationOfCgst() {

	var totalCost = document.getElementById("totalCost0").value;

	var cgstInPer = document.getElementById("cgstInPer0").value;
	document.getElementById("cgstInValue0").value = totalCost * cgstInPer / 100;
}

function calulationOfSgst() {
	var totalCost = document.getElementById("totalCost0").value;

	var sgstInPer = document.getElementById("sgstInPer0").value;
	//var sgstInValue =  document.getElementById("sgstInValue0").value;
	document.getElementById("sgstInValue0").value = totalCost * sgstInPer / 100;


}

function calulationOfIgst() {
	var totalCost = document.getElementById("totalCost0").value;

	var igstInPer = document.getElementById("igstInPer0").value;
	//var igstInValue = document.getElementById("igstInValue0").value;
	document.getElementById("igstInValue0").value = totalCost * igstInPer / 100;

}

function calulationOfDiscount() {
	var totalCost = document.getElementById("totalCost0").value;

	var descountInPer = document.getElementById("descountInPer0").value;
	//var descountInValue = document.getElementById("descountInValue0").value;
	document.getElementById("descountInValue0").value = totalCost * descountInPer / 100;
}






//******************************************END PURCHASE ORDER ******************************* */












//********************************************Company Detail ********************************* */


function getCityOnState() {

	var stateCode = document.getElementById("state").value;
	console.log("State is : " + stateCode)

	$.ajax({
		type: "GET",
		url: "citylist/" + stateCode,

		success: function(data) {

			var options = '<option value=""><strong>Select City</strong></option>';
			$(data).each(function(index, value) {

				console.log("item info : " + value.cityCode)
				console.log("item info : " + value.cityName)

				options += '<option value="' + value.cityCode + '">' + value.cityName + '</option>';

			});

			$('.cityContainer').html(options);

		}, error: function() {
			console.log("Error");
		}
	});
}


function getRCityOnState() {

	var stateCode = document.getElementById("rState").value;
	console.log("State is : " + stateCode)

	$.ajax({
		type: "GET",
		url: "citylist/" + stateCode,

		success: function(data) {

			var options = '<option value=""><strong>Select City</strong></option>';
			$(data).each(function(index, value) {

				console.log("item info : " + value.cityCode)
				console.log("item info : " + value.cityName)

				options += '<option value="' + value.cityCode + '">' + value.cityName + '</option>';

			});

			$('.rCityContainer').html(options);

		}, error: function() {
			console.log("Error");
		}
	});
}


//*********************************GATE ENTRY ***************************************************** */

function getOrderIndentDetailPo() {

// this po 
	var indentNumber = document.getElementById("orderIndentNumberPo").value;
	console.log("order indent number is : " + indentNumber)

	$.ajax({
		type: "GET",
		url: "indentdetailinpo/" + indentNumber,

		success: function(data) {
			console.log("order indent response  : " + data)

			console.log("order indent date   : " + convertDate(data.poDate))
			console.log("order indent date   : " + data.poDate)

			
			
			
			$("#orderIndentDatePo0").val(data.poDate)
			//$("#empName").val(data.employee.empName);
			//$("#empCode").val(data.employee.empCode);

			getOrderItemList(indentNumber);

			//item trave





		}, error: function() {
			console.log("Error");
		}
	});
}

function convertDate(inputFormat) {
	function pad(s) { return (s < 10) ? '0' + s : s; }
	var d = new Date(inputFormat)
	return [pad(d.getDate()), pad(d.getMonth() + 1), d.getFullYear()].join('/')
}



function getOrderItemList(poNumber) {


	//Get Item lIst in purchase order item detail using po number (FK)

	console.log("get Item List Function is : " + poNumber)

	$.ajax({
		type: "GET",
		url: "itemList/" + poNumber,

		success: function(data) {
			console.log("Item Info behalf of Indent Number  : " + data)

			var options = '<option value=""><strong>Select Item</strong></option>';
			$(data).each(function(index, value) {

				console.log("item info : " + value.item.itemCode)
				console.log("item info : " + value.item.description)

				options += '<option value="' + value.item.itemCode + '">' + value.item.description + '</option>';

			});

			$('.orderItemContainerPo').html(options);

		}, error: function() {
			console.log("Error");
		}
	});
}



function getOrderItemDetailForPo() {

	var itemNumber = document.getElementById("orderItemPo").value;
	var poNumber = document.getElementById("orderIndentNumberPo").value;

	$.ajax({
		type: "GET",
		url: "itemInfo/" + itemNumber + "/"+poNumber,

		success: function(data) {
			
			console.log("getOrderItemDetailForPo item description  :" + data.description)
			$("#orderItemCode0").val(data.item.description)
			//orderItemCode0
			//$("#orderItemCode0").val(data.itemCode)
			$("#orderItemuom").val(data.item.uom.uomCode)
			$("#qtyOrder0").val(data.purchaseOrderItem.qtyOrder)

		}, error: function() {
			console.log("Error");
		}
	});

}



//***********************************END GATE ENTRY ************************************************* */



//***********************************MRN ************************************************* */


function getGateEntryInfo() {


	var gateEntryNumber = document.getElementById("gateEntryNumber").value;

	//console.log("get Item List Function is : " + indentNumber)

	$.ajax({
		type: "GET",
		url: "gateentryinfo/" + gateEntryNumber,

		success: function(data) {
			console.log("Item Info behalf of Indent Number  : " + data)

			$("#mrnGateEntryDate").val(data.mrnUtility.gateEntry.gateEntryDate)
			$("#mrnSupplierCode").val(data.mrnUtility.gateEntry.supplier)
			$("#mrnCurrencyCode").val(data.mrnUtility.gateEntry.currency)


			// add dynamic drop down in item list in mrn detail form 

			var options = '<option value=""><strong>Select Item</strong></option>';

			$(data.itemList).each(function(index, value) {

				//console.log("item info : " + value.item.itemCode)
				//console.log("item info : " + value.item.itemName)

				options += '<option value="' + value.itemList.itemCode + '">' + value.item.itemName + '</option>';

			});

			$('.orderItemContainerPo').html(options);


		}, error: function() {
			console.log("Error");
		}
	});
}














//***********************************END MRN ************************************************* */




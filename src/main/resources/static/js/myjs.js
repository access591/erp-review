//1.**************************************************END OPEN INDENT********************************************** */


function indentGetEmployee() {

	console.log("select..");

	var empCode = document.getElementById("employee").value;
	console.log("emp code : " + empCode);


	$.ajax({
		type: "GET",
		url: "employeeinfo/" + empCode,

		success: function(data) {
			//$("#resultarea").text(data);
			console.log("response data : " + data);
			$("#employeename").val(data.empName);
			$("#departmentcode").val(data.department.deptCode)
			$("#departmentname").val(data.department.deptName)
		}, error: function() {
			console.log("Error");
		}
	});

}

//**************************************************END OPEN INDENT********************************************** */









//*********************************************RequestForQuotation***************************









//*********************************************end request for quotation***************************




//*********************************************QUOTATION DETAIL ********************************* */


function changeRequestForQuotation() {

	console.log("get Item function calling");
	var rfqNumber = document.getElementById("rfqNum").value;
	console.log("emp code : " + rfqNumber);

	$.ajax({
		type: "GET",
		url: "rfqdetail/" + rfqNumber,

		success: function(data) {
			console.log("ite data is : " + data)

			$("#rfqDate").val(data.rfqDate)

		}, error: function() {
			console.log("Error");
		}
	});



}



function supplierInfo1() {

	var supplierId = document.getElementById("supplierId").value;
	console.log("supplier id is : " + supplierId)

	$.ajax({
		type: "GET",
		url: "supplierinfo/" + supplierId,

		success: function(data) {
			console.log("ite data is : " + data)

			//$("#supplierAdd").val(data.supplierAdd)
			$("#supplierCity").val(data.supplierCity)
			$("#supplierState").val(data.supplierState)
			$("#supplierName").val(data.supplierName)
		}, error: function() {
			console.log("Error");
		}
	});

}



function changeCurrency() {

	var currencyCode = document.getElementById("currencyCode").value;

	//var currencyValue = currencyCode.options[currencyCode.selectedIndex].text;
	var currencyValue = $('#currencyCode :selected').text();
	console.log("currency code is : " + currencyCode)
	console.log("currency value is : " + currencyValue)
	document.getElementById("currencyValue").value = currencyCode;


	//console.log("supplier id is : "+ currencyCode)



}


function getIndentDetailByIndentNumber() {

	var indentNumber = document.getElementById("indentNumber").value;

	$.ajax({
		type: "GET",
		url: "indentdetail/" + indentNumber,

		success: function(data) {
			console.log("ite data is : " + data)

			console.log("indent data is : " + data.indentDate)
			$("#indentDate").val(data.indentDate)
			$("#empName").val(data.employee.empName);
			$("#empCode").val(data.employee.empCode);

			getItemListByIndentNumber(indentNumber);



		}, error: function() {
			console.log("Error");
		}
	});

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


// dynamic drop down 
function getItemListByIndentNumber(indentNumber) {


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

				options += '<option value="' + value.itemCode + '">' + value.itemName + '</option>';

			});

			$('.itemContainer').html(options);

		}, error: function() {
			console.log("Error");
		}
	});

}


function changeItemInQuotationDetail() {

	var itemCode = document.getElementById("item").value;
	console.log("ItemCode is : " + itemCode)

	$.ajax({
		type: "GET",
		url: "itemInfo/" + itemCode,

		success: function(data) {
			console.log("Item Info behalf of Indent Number  : " + data)

			$("#itemDescriptin").val(data.description)
			$("#uomCode").val(data.uom.uomCode);



		}, error: function() {
			console.log("Error");
		}
	});

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

function quotationNumberInfo() {

	var quotationNumber = document.getElementById("quotationNumber").value;
	console.log("quotation number is : " + quotationNumber)

	$.ajax({
		type: "GET",
		url: "quotationDetail/" + quotationNumber,

		success: function(data) {
			console.log("Data From quotaionInfo : " + data)

			$("#quotationDate").val(data.quotDate)
			//$("#uomCode").val(data.uom.uomCode);

			getIndentAgainstQuotationDetail()


		}, error: function() {
			console.log("Error");
		}
	});

}


function getIndentAgainstQuotationDetail() {

	//do all value clear on click selection 

	/*$('#quotationDate').val('');*/


	var quotationNumber = document.getElementById("quotationNumber").value;
	console.log("quotation number is/ getIndent against quotation detail  : " + quotationNumber)

	$.ajax({
		type: "GET",
		url: "indentdetail/" + quotationNumber,

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
}


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

}



function getIndentDetailPo() {

	var indentNumber = document.getElementById("indentNumberPo").value;

	$.ajax({
		type: "GET",
		url: "indentdetail/" + indentNumber,

		success: function(data) {
			console.log("ite data is : " + data)

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

				options += '<option value="' + value.itemCode + '">' + value.itemName + '</option>';

			});

			$('.itemContainerPo').html(options);

		}, error: function() {
			console.log("Error");
		}
	});

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

	var indentNumber = document.getElementById("orderIndentNumberPo").value;

	$.ajax({
		type: "GET",
		url: "indentdetailinpo/" + indentNumber,

		success: function(data) {
			console.log("ite data is : " + data)

			console.log("indent data is : " + data.poDate)
			$("#orderIndentDatePo").val(data.poDate)
			//$("#empName").val(data.employee.empName);
			//$("#empCode").val(data.employee.empCode);

			getOrderItemList(indentNumber);

			//item trave





		}, error: function() {
			console.log("Error");
		}
	});
}

function getOrderItemList(indentNumber) {


	//Get Item lIst in purchase order item detail using po number (FK)

	console.log("get Item List Function is : " + indentNumber)

	$.ajax({
		type: "GET",
		url: "itemList/" + indentNumber,

		success: function(data) {
			console.log("Item Info behalf of Indent Number  : " + data)

			var options = '<option value=""><strong>Select Item</strong></option>';
			$(data).each(function(index, value) {

				console.log("item info : " + value.item.itemCode)
				console.log("item info : " + value.item.itemName)

				options += '<option value="' + value.item.itemCode + '">' + value.item.itemName + '</option>';

			});

			$('.orderItemContainerPo').html(options);

		}, error: function() {
			console.log("Error");
		}
	});
}



function getOrderItemDetailForPo(){
	
	var itemNumber = document.getElementById("orderItemPo").value;
	
	$.ajax({
		type: "GET",
		url: "itemInfo/" + itemNumber,

		success: function(data) {
			
			$("#orderItemDescription").val(data.description)
			$("#orderItemuom").val(data.uom.uomCode)	

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




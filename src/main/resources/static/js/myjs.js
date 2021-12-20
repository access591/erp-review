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







//***********************************END GATE ENTRY ************************************************* */



//***********************************MRN ************************************************* */

















//***********************************END MRN ************************************************* */




//1.**************************************************END OPEN INDENT********************************************** */


function indentGetEmployee() {

	console.log("select..");

	var empCode = document.getElementById("employee").value;
	console.log("emp code : " + empCode);


	$.ajax({
		type: "GET",
		url: "/employee/employeeinfo/" + empCode,

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

function getIndentList() {

	console.log("get Item function calling");
	var indentNumber = document.getElementById("indentNumber").value;
	console.log("emp code : " + indentNumber);


	$.ajax({
		type: "GET",
		url: "/requestquotation/itemdetail/" + indentNumber,

		success: function(data) {
			//$("#resultarea").text(data);
			console.log("response data : " + $(this.data).addClass('show'));


			$("#indentDate").val(data.indentDate);

			var options = '<option value=""><strong>Select Item</strong></option>';
			$(data.listItem).each(function(index, value) {

				console.log("item info : " + value.description)
				options += '<option value="' + value.itemCode + '">' + value.description + '</option>';

			});

			$('.itemContainer').html(options);
			// $("#departmentcode").val(data.department.deptCode)
			// $("#departmentname").val(data.department.deptName)
		}, error: function() {
			console.log("Error");
		}
	});

}

function getItemDetail() {

	var item = document.getElementById("item").value;

	$.ajax({
		type: "GET",
		url: "/requestquotation/itemdetail1/" + item,

		success: function(data) {
			console.log("ite data is : " + data)

			$("#uom").val(data.uom.uomCode)
			// $("#departmentname").val(data.department.deptName)
		}, error: function() {
			console.log("Error");
		}
	});
}


function supplierInfo() {

	var supplierId = document.getElementById("supplierId").value;
	console.log("supplier id is : " + supplierId)

	$.ajax({
		type: "GET",
		url: "/requestquotation/supplierdetail/" + supplierId,

		success: function(data) {
			console.log("ite data is : " + data)

			$("#supplierAdd").val(data.supplierAdd)
			$("#supplierCity").val(data.supplierCity)
			$("#supplierState").val(data.supplierState)
			// $("#departmentname").val(data.department.deptName)
		}, error: function() {
			console.log("Error");
		}
	});

}


function addRowInRfQuotation() {
	idIndex = 0;
	$(document)
		.ready(
			function() {
				console.log("click function...");
				var i = 1;

				console.log("idINdexin add buttton function"
					+ idIndex);
				$("#add_row")
					.click(
						function() {
							idIndex++;
							$('#addr' + i)
								.html(
									"<td><input type='text' style='width: 90px;'id='desigCode" + idIndex + "'name='employeRequisitionDetail[" + i + "].designation.desgCode' required></td>"
									+

									"<td><select style='width: 130px;' id='designationName"
									+ idIndex
									+ "'name='employeRequisitionDetail["
									+ i
									+ "].designation.desgName'onchange='selectDesignation()' required><option value=''>Select</option></select></td>"
									+ "<td><select id='location'name='employeRequisitionDetail[" + "].location' required><option value=''>Select</option><option value='Court'>Court</option><option value='Department'>Department</option></select></td>"
									+ "<td><select style='width: 90px;' id='sex'name='employeRequisitionDetail[" + + "].sex' required><option value=''>Select</option><option value='Male'>Male</option><option value='Female'>Female</option></select></td>"
									+ "<td><input type='text' style='width: 90px;'id='ageFrom'name='employeRequisitionDetail[" + i + "].ageFrom' required></td>"
									+ " </td><td><input type='text' style='width: 90px;'id='desigCode'name='employeRequisitionDetail[" + i + "].ageTo' required></td>"
									+

									"<td><input type='text' style='width: 120px;'id='acadQuali'name='employeRequisitionDetail[" + i + "].acadQuali' required></td>"
									+ "<td><input type='text' style='width: 120px;'id='techQuali'name='employeRequisitionDetail[" + i + "].techQuali' required></td>"
									+ "<td><input type='text' style='width: 90px;'id='minExperience'name='employeRequisitionDetail[" + i + "].minExperience' required></td>"
									+ "<td><input type='text' style='width: 90px;'id='maxExpierence'name='employeRequisitionDetail[" + i + "].maxExperience' required></td>"
									+ "<td><select style='width: 120px;id='vacanncyType' name='employeRequisitionDetail[" + i + "].vacanncyType' required><option value=''>Select</option><option value='Fresher'>Fresher</option><option value='Experience'>Experience</option></select></td>"
									+ "<td><input type='text' style='width: 90px;'id='totalVacancy'name='employeRequisitionDetail[" + i + "].totalvacancy' required></td>"
									+ "<td><input type='text' style='width: 120px;'id='salaryFrom'name='employeRequisitionDetail[" + i + "].salaryFrom' required></td>"
									+ "<td><input type='text' style='width: 120px;'id='salaryTo'name='employeRequisitionDetail[" + i + "].salaryTo' required></td>"
									+ "<td><input type='text' style='width: 120px;'id='remarks'name='employeRequisitionDetail[" + i + "].remarks' required></td>");

							$('#example').append(
								'<tr id="addr'
								+ (i + 1)
								+ '"></tr>');
							$('#_cr').val(i + 1);
							i++;

							changeDepartment();

						});

				$("#delete_row").click(function() {
					if (i > 1) {
						$("#addr" + (i - 1)).html('');
						$('#_cr').val(i - 1);
						i--;
						idIndex--;
					}
				});

			});

}

//*********************************************end request for quotation***************************




//*********************************************QUOTATION DETAIL ********************************* */


function changeRequestForQuotation() {

	console.log("get Item function calling");
	var rfqNumber = document.getElementById("rfqNum").value;
	console.log("emp code : " + rfqNumber);

	$.ajax({
		type: "GET",
		url: "/quotationdetail/rfqdetail/" + rfqNumber,

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
		url: "/quotationdetail/supplierinfo/" + supplierId,

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
		url: "/quotationdetail/indentdetail/" + indentNumber,

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



function getItemListByIndentNumber(indentNumber) {


	console.log("get Item List Function is : " + indentNumber)

	$.ajax({
		type: "GET",
		url: "/quotationdetail/itemList/" + indentNumber,

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
		url: "/quotationdetail/itemInfo/" + itemCode,

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
		url: "/purchaseorder/supplierDetail/" + supplierCode,

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
		url: "/purchaseorder/quotationDetail/" + quotationNumber,

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
		url: "/purchaseorder/indentdetail/" + quotationNumber,

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
		url: "/purchaseorder/indent/indentdetail/",

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
		url: "/quotationdetail/indentdetail/" + indentNumber,

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
		url: "/quotationdetail/itemList/" + indentNumber,

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
		url: "/companydetail/citylist/" + stateCode,

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
		url: "/companydetail/citylist/" + stateCode,

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


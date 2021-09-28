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
			console.log("response data : " + data.department.deptName);
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





//>**************************************************COMON DYNAMIC AJAX********************************************** */


function dynamicAjaxRequest(url, val) {

}


//**************************************************END COMMON AJAX********************************************** */
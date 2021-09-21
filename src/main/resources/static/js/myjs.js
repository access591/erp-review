//1.**************************************************END OPEN INDENT********************************************** */


function indentGetEmployee() {

	console.log("select..");

	var empCode = document.getElementById("employee").value;
	console.log("emp code : " + empCode);


	$.ajax({
		type: "GET",
		url: "/employee/employeeinfo/" +empCode,
		
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


















//>**************************************************COMON DYNAMIC AJAX********************************************** */


function dynamicAjaxRequest(url, val) {

}


//**************************************************END COMMON AJAX********************************************** */

//************************Company Detail  */


$('form[id="companyDetail"]').validate({
	
	rules: {
		companyCode: 'required',
		
	},
	messages: {
		companyCode:'company code is required',
		
		
	},
	submitHandler: function(form) {
		form.submit();
	}
});








$(function() {

	$("form[id='cityForm']").validate({

		rules: {
			cityName: "required",

		},

		messages: {
			cityName: "Please enter your firstname",

		},
		submitHandler: function(form) {
			form.submit();
		}
	});
});
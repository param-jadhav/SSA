<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SSN Enrollment</title>
<style>
.error {
	color: #FF0000
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {

		$('form[id="ssnEnrollForm"]').validate({
			rules : {
				firstName : 'required',
				lastName : 'required',
				dob : 'required',
				gender : 'required',
				state : 'required',
				phNo : 'required',
			},
			messages : {
				firstName : 'Please enter first name',
				lastName : 'please enter last name',
				dob : 'Please Enter Date of Birth',
				gender : 'Please Select Gender',
				state : 'Please Select state',
				phNo : 'please enter Phone Number',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});

		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true,
			 yearRange: "-60:+0", 
			maxDate : new Date(),
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
</head>
<body>
	<font color='green'>${success}</font>
	<font color='red'>${failure}</font>

	<h2>Enrollment For SSN(Social Security Number)</h2>
	<form:form action="enrollSSN" method="POST" modelAttribute="ssnModel"
		enctype="multipart/form-data" id="ssnEnrollForm">
		<table>
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><form:input path="dob" id="datepicker" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobuttons path="gender" items="${gendersList}" /></td>
			</tr>
			<tr>
				<td>Phno:</td>
				<td><form:input path="phNo" /></td>
			</tr>

			<tr>
				<td>Select State:</td>
				<td><form:select path="state" items="${statesList}" /></td>
			</tr>
			<tr>
				<td>Select Photo:</td>
				<td><form:input type="file" path="photo" /></td>
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="Submit" value="Enroll" id="enrollBtn" /></td>
			</tr>

		</table>


	</form:form>
</body>
</html>
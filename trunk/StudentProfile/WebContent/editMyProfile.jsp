<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<style type="text/css">
.border-class {
	border-style: dashed;
	border-width: 1px;
	border-color: black;
}
</style>


<script>
	var dateToday = new Date();
	var curmonth = dateToday.getMonth();
	var curdate = dateToday.getDate();
	var curyear = dateToday.getFullYear();
	$(function() {
		$('.checkboxLabel').after('<br>');

		$('#datepicker').datepicker({
			showOn : "button",
			buttonImage : "images/calendar.gif",
			buttonImageOnly : true,
			numberOfMonths : 1,
			showButtonPanel : true,
		//minDate:dateToday,
		//maxDate: new Date(curyear,curmonth,(curdate+2)),

		});// end of datepicker

		$("#myForm").submit(function(evt) {

			//evt.preventDefault();

		});// end of myForm submit

	});// end of ready
</script>
</head>
<body>
	<s:form id="myForm" action="editMyProfileAction" method="post"
		theme="simple" enctype="multipart/form-data">
		<table>

			<tr>
				<td>Roll No</td>

				<td><s:textfield name="studentID"
						value="%{#session.student.stuID}" /></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><s:textfield name="studentName"
						value="%{#session.student.stuName}" /></td>
			</tr>

			<tr>
				<td>Date Of Birth</td>
				<td><input type="text" id="datepicker" name=studentDOB
					value="<s:property value="%{#session.student.stuDOB}" />" /></td>
			</tr>

			<tr>
				<td>Upload Pic</td>

				<td><s:file name="uploadPic" /></td>
			</tr>

			<tr>
				<td>Interests <br>
					<div class="border-class">
						<s:checkboxlist list="interests" listKey="intID"
							listValue="intName" name="selectedInterests"></s:checkboxlist>
					</div>

				</td>
			</tr>

			<tr>
				<td><s:submit name="editProfileButton" id="mysubmit"
						value="Update" /></td>
			</tr>

		</table>

		<s:actionerror />
	</s:form>
</body>
</html>
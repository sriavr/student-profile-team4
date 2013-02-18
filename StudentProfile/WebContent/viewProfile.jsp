<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
</head>
<body>
	<s:form id="myForm" action="myProfileAction" method="post"
		theme="simple">
		<table border=2>

			<tr>
				<td>Roll No</td>
				<td><s:property value="student.stuRollNo" /></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><s:property value="student.stuName" /></td>
			</tr>

			<tr>
				<td>Date Of Birth</td>
				<td><s:property value="student.stuDOB" /></td>
			</tr>

			<tr>
				<td>Interests</td>
				<td><s:iterator value="interests" status="interestStatus"
						var="i">
						<s:property value="intName" />
						<s:if test="#interestStatus.last" />

						<s:else>,
						</s:else>

					</s:iterator></td>
			</tr>

			<tr>
				<td><s:submit name="editProfileButton" id="mysubmit"
						value="Edit Profile" disabled="%{disabled}" /></td>
			</tr>

		</table>

	</s:form>
</body>
</html>
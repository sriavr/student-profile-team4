<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Faculty</title>
</head>
<body>
	<h2>
		Displaying faculty for subject:
		<s:text name="subject.subName"></s:text>
	</h2>

	<table>
		<tr>
			<td>Faculty name</td>
		</tr>

		<s:iterator value="facultyList">
			<tr>
				<td><s:text name="facName"></s:text></td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/table_new.css">
<title>Assign Subjects for Faculty</title>
</head>
<body>
	<s:form action="assignFacSub">
		<s:text name="msg"></s:text>
		<s:select list="faculties" listKey="facID" listValue="facName"
			headerKey="-1" headerValue=" -- Select Faculty --"
			name="selectedFacID" label="Faculty"></s:select>

		<s:select list="subjects" listKey="subID" listValue="subName"
			headerKey="-1" headerValue=" -- Select Subject --"
			name="selectedSubID" label="Subject"></s:select>

		<s:submit label="Assign"></s:submit>
	</s:form>
</body>
</html>
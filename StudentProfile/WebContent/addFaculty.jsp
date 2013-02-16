<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add faculty</title>
</head>
<body>
	<s:form action="addFaculty">
		<s:label name="msg"></s:label>
		<s:textfield name="facName" label="Faculty Name"></s:textfield>
		<s:submit value="Add Faculty"></s:submit>
	</s:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logged out</title>
</head>
<body>
	<s:form action="login">
		<h2>Successfully logged out of Student Profile Website</h2>
		<div style="clear: both;">
			<s:submit action="login" value="Login"></s:submit>
		</div>
	</s:form>
</body>
</html>
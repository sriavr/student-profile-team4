<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<div align="center" style="border: thick;">
		<s:form action="loginAction">
			<s:textfield name="userName" label="User Name"></s:textfield>
			<s:password name="password" label="Password"></s:password>
			<!-- 			<input type="text" placeholder="User Name" name="userName"/><br> -->
			<!-- 			<input type="password" placeholder="Password" name="password"/><br> -->
			<!-- 				<input type="submit" value="Submit" /><input type="button" -->
			<!-- 					value="Forgot Password" /> -->

			<s:submit value="Login">
			</s:submit>

		</s:form>
	</div>
</body>
</html>
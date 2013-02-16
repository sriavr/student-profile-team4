<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div style="margin-left: 30px; border-left: 30px">
		<s:if test="%{#session.role.equals('student')}">
			<a href="myProfileAction"> <img
				src="<s:url action="profilePicAction"/>" height="100" width="100" /></a>
			<br>
			<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Last logged on: <s:property value="%{#session.student.stuLoggedIn}" />

		</s:if>
		<s:else>

		</s:else>
	</div>
</body>
</html>
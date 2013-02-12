<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Announcements</title>
</head>
<body>
	<s:action name="announcementsAction"/>
	<marquee direction="up" loop="true" width="100%"> 
		<s:iterator value="%{#session.announcementsList}" var="announcement">
			<s:property value="%{#announcement}"/><br>
		</s:iterator>
	 </marquee>
</body>
</html>
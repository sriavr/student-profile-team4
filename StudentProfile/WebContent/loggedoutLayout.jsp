<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<style type="text/css">
#header {
	width: 100%;
	height: 10%;
	display: block;
}

#left {
	width: 20%;
	height: 80%;
	/*display: inline;*/
	float: left;
	clear: left;
}

#body {
	width: 80%;
	height: 80%;
	/*display: inline;*/
	float: left;
}

#announcement {
	width: 50%;
	height: 10%;
	/*display: inline;*/
	margin: 0%;
	float: left;
	clear: left;
}

#news {
	width: 50%;
	height: 10%;
	/*display: inline;*/
	margin: 0%;
	float: left;
	clear: right;
}
</style>
</head>
<body style="background-color: gray;">
	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>
	<div id="body">
		<tiles:insertAttribute name="body" />
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
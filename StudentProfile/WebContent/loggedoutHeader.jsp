<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<head>
<script type="text/javascript">
	//This function is to edit the href of search hyperlink. Once the user blurs search textfield, the hyperlink' lik is modified
	function editSearchLink() {
		document.getElementById("searchLink").href = document
				.getElementById("searchLink").href
				+ document.getElementById("friend_id").value;
	}
</script>
<link rel="stylesheet" type="text/css" href="/css/header.css" />
</head>
<body>
	<h1>Student Profile Information System</h1>
</body>
</html>

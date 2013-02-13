<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header Page</title>
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
	<div id="topnav" style="display:block; width:100%;">
	<div style="float:left">
		<input type="text" id="friend_id" onblur="editSearchLink()" placeholder="Search Friends"/> <a
			href="search?id=" id="searchLink">Search</a>
	</div>
	<s:if test="%{#session.role.equals('student')}">
	<div style="float:right">
	
		<a href="studentHomeAction">Home</a>&nbsp;&nbsp;
		<a href="gradeAction">Grades</a>&nbsp;&nbsp;
		<a href="subjectsAction">Subjects</a>&nbsp;&nbsp;
		<a href="enrollCourseShowSemAction">Enroll</a>&nbsp;&nbsp;
		<a href="myfriendAction">MyFriends</a>&nbsp;&nbsp;
	
	</div>
	</s:if>
	<s:else>
	<div style="float:right">
	
		<a href="manageUsersAction">Manage Users</a>&nbsp;&nbsp;
		<a href="updateGradesAction">Update Grades</a>&nbsp;&nbsp;
		<a href="manageSubjectsAction">Manage Subjects</a>&nbsp;&nbsp;
		<a href="assignFacultyPerSubjectAction">Assign Faculty Per Subject</a>&nbsp;&nbsp;
		<a href="manageNewsAction">Manage News</a>&nbsp;&nbsp;
		<a href="manageAnnouncementsAction">Manage Announcements</a>&nbsp;&nbsp;
	
	</div>
	</s:else>
	</div>
</body>
</html>
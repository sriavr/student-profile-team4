<%@page import="com.studentProfile.util.LogMessage"%>
<%@page import="com.studentProfile.model.entity.StudentModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
			href="friendAction?studentNumber=" id="searchLink">Search</a>
	</div>
		<s:if test="%{#session.role.equals('student')}">
			<%
				String username = ((StudentModel) session
							.getAttribute("student")).getStuName();
					LogMessage.log("username is " + username);
			%>

			<div style="float: right">
				Username:
				<%=username%>
			</div>
			<div style="clear: both;"></div>
			<div style="float: right">
				<a href="studentHomeAction">Home</a>&nbsp;&nbsp; <a
					href="gradeAction">Grades</a>&nbsp;&nbsp; <a href="subjectsAction">Subjects</a>&nbsp;&nbsp;
				<a href="enrollCourseShowSemAction">Enroll</a>&nbsp;&nbsp; <a
					href="myFriendsAction">MyFriends</a>&nbsp;&nbsp; <a
					href="logoutAction">Logout</a>
			</div>
		</s:if>
		<s:else>
			<div style="float: right">

				<a href="manageUsersAction">Manage Users</a>&nbsp;&nbsp; <a
					href="updateGradesAction">Update Grades</a>&nbsp;&nbsp; <a
					href="manageSubjectsAction">Manage Subjects</a>&nbsp;&nbsp; <a
					href="assignFacSub">Assign Faculty Per Subject</a>&nbsp;&nbsp; <a
					href="manageNewsAction">Manage News</a>&nbsp;&nbsp; <a
					href="manageAnouncementsAction">Manage Announcements</a>&nbsp;&nbsp;
					<a href="addFaculty">Add Faculty</a>
				<a href="logoutAction">Logout</a>
			</div>
		</s:else>
	</div>
</body>
</html>

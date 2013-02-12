<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage Subjects</title>
</head>
<body>
	<div id="add">
		<s:form action="addSubjectAction">
			<s:textfield name="subCode" placeholder="Subject Code" />
			<s:textfield name="subjectName" />
			<s:textarea name="Syllabus" />
			<s:select list="semList" name="semID" />
			<s:select list="facList" name="facID"></s:select>
			<s:submit value="Add Subject"/>
		</s:form>
	</div>
	<div id="edit"></div>
	<div id="delete"></div>
</body>
</html>
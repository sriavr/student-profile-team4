<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="upGrade" method="post" >
	<s:select label="SUBJECT NAME" 
		headerKey="-1" headerValue="Select Subject"
		list="#{'Networking':'Networking', 'DataBase':'DataBase'}" 
		name="subjectname" 
		value="2" />
    <s:textfield name="studentroll" key="STUDENT ROLLNO" />
<s:select label="GRADES" 
		headerKey="-1" headerValue="Select Grade"
		list="#{'A':'A', 'A-':'A-', 'B+':'B+', 'B':'B', 'B-':'B-', 'C+':'C+', 'C':'C', 'D':'D'}" 
		name="studentgrade" 
		value="2" />
    <s:submit method="execute"  value="UpdateGrades" align="center" />
</s:form>
</body>
</html>
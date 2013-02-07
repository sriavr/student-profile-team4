<!--  
	File Name	:	enrollCourse.jsp
	DEscription	:	Student can enroll in more than one subject that has been offered in particular 
					Semester , before deadline.
	Author		:	Pratibind Jha
	Created Date:	4 Feb 2013
	
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enroll Course</title>
</head>
<body>
		
		<s:actionmessage/> 
		<s:form name="enrollForm" action="enrollCourseShowCourseAction" method="post">
			
				<%-- <s:if test="enrollButton=='selectSem'"> --%>
					
						
							 <s:select list="sem" headerKey="-1" headerValue="-select-" name="semID" 
								listKey="semID" listValue="semName" label=""   onchange="this.form.submit();">
							</s:select> 
						
						
							<s:if test="enrollButton=='showSubject'">
								 <s:checkboxlist list="subject" listKey="subID" listValue="subName" 
								 	name="selectedCourse" label="Courses" required="true">
								 </s:checkboxlist> 
								 
								 <s:submit name="enrollButton" value="Submit" ></s:submit>
								
							</s:if>
								
			
		</s:form>
		

</body>
</html>
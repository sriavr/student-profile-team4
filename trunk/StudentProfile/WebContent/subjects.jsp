<!--  
	File Name	:	subjects.jsp
	Description	:	show the subject information subject name, faculty,grade,enroll and so. 
	Author		:	Pratibind Jha
	Created Date:	6 Feb 2013
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/enrollTable.css">
<title>Subjects</title>
</head>
<body>
	<s:actionmessage/>
	<s:if test="actionName=='showSubject' "> 
		<s:form name="subjectForm" action="subjectsAction" method="post">
			<%-- <s:if test="actionName=='' "> --%>
				<s:select label="" 
					headerKey="-1" headerValue="-Select Course-"
					list="#{'1':'Show Enroll Course', '2':'Show All'}" 
					name="course" value="-1" onchange="this.form.submit()" > 
				</s:select>
			<%-- </s:if> --%>
			
		</s:form>
		
		<table id="datatable">
			<tr>
				
				<th id="th_background"><s:text name="Subject_Code"/></th>
				<th id="th_background"><s:text name="Subject"/></th>
				<th id="th_background"><s:text name="Faculty_name" /></th>
				<th id="th_background"><s:text name="Sem" /></th>
				<th id="th_background"><s:text name="Enrolled"/></th>
				<th id="th_background"><s:text name="Grade"/></th>
				
			</tr>
			<s:iterator value="subjectsInfo" status="status">
				
				<tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
				
					<td><a href="<s:url action="subjectsAction">
						<s:param name="subCode" value="subCode"/>
						<s:param name="subSyllabus" value="subSyllabus"/>
						<s:param name="actionName" value="'showSyllabus'"/> </s:url>">
							<s:property value="subCode"/>
						</a>
					</td>
					<td><s:property value="subName"/></td>
					<td><s:property value="facName"/></td>
					<td><s:property value="semName"/></td>
					<td><s:property value="isEnroll"/> </td>
					<td><s:property value="enrGrade"/></td>
				
				</tr>
	
			</s:iterator>
		</table>
	</s:if> 
	<s:if test="actionName=='subSyllabus' "> 
	<table>
		<tr>
			<td><s:text name="Course Code: "></s:text></td>
			<td><s:property value="subCode"/></td>
		</tr>
		<tr>
			<td><s:text name="Syllabus: "></s:text></td>
			<td><s:property value="subSyllabus"/></td>
		</tr>
	</table>
	</s:if>
	

</body>
</html>
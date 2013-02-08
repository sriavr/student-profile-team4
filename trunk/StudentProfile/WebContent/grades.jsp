<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script language="javascript" type="text/javascript">
	function refresh() {
		document.getElementById("myform").action = "gradeAction";
		document.getElementById("myform").method="post";
		document.getElementById("myform").submit();
	}
</script>
<link rel="stylesheet" href="css/table_new.css">
</head>
<body>
<s:form method="post" action="gradeAction"  id="myform">

<table>
 <tr >
 <td>
   Semester
 </td>
   <td>
   
  <s:select list="semesterList" listKey="semID" listValue="semName" headerKey="0" headerValue="--Select Semester--"
							name="selectedSemesterId" cssClass="label" theme="simple" onchange="javascript:refresh();"/>
   
   
</td>
<td>
  Subject
</td>
<td>   <s:select list="subjectList" listKey="subID" listValue="subName"
							headerKey="0" headerValue="--All--"
							name="selectedSubjectId" cssClass="label" theme="simple" onchange="javascript:refresh();"/>    </td>
   

 </tr>
 
 <tr>
   <td><input type="submit" value="Search"/></td>   
 
 </tr>

</table>
  <table  class="imagetable" align="center">
			<tr>
				<th colspan="2">
					<h1>Student Grades</h1>
				</th>
			</tr>
			<tr>

				<th width="170"><h2>Subject</h2></th>
				<th width="170"><h2>Subject Code</h2></th>
				<th width="170"><h2>Grade</h2></th>
				<th width="170"><h2>Result</h2></th>
				
			</tr>


		<s:iterator value="gradesList" status="stat" >
		<tr>
				
			
			<td><s:property value="subject"/></td>
			<td><s:property value="subject_code"/></td>
			<td><s:property value="grade"/></td>
			<td><s:property value="result"/></td>
		</tr>
	</s:iterator>
		</table>
</s:form>
</body>
</html>
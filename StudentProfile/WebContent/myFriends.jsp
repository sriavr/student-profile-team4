<!--  
	File Name	:	enrollCourse.jsp
	DEscription	:	Student can enroll in more than one subject that has been offered in particular 
					Semester , before deadline.
	Author		:	Pavan Kumar Y	
	Created Date:	12 Feb 2013
	
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyFriends</title>
<script language="javascript" type="text/javascript" src="paging.js"></script>
</head>
<body>
	
	
	<table align="center" id="myId">
	   
	   
		<tr ><th><strong>Friends</strong></th></tr>
		<s:iterator value="friendsList">
			<tr align="center"> 
				<td align="center">
					<s:property value="stuID"/>
					<s:property value="stuName"/>
						<!--<s:property value="title"/>-->
					
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<div id="pageNavPosition"></div>
	 <script type="text/javascript"><!--
        var pager = new Pager('myId', 1); 
        pager.init(); 
        pager.showPageNav('pager', 'pageNavPosition'); 
        pager.showPage(1);
    //--></script>
</body>
</html>
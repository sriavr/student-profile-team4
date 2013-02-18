<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/table_new.css">
<title>Manage Subjects</title>

<script language="javascript" type="text/javascript">
	
	function tryFunc(node){
	    var root = node.parentNode.parentNode;
	    alert(root);
	    var allRows = root.getElementsByTagName('tr');
	    var cRow = allRows[2].cloneNode(true);
	    root.appendChild(cRow);
	}
	
	function addRow(tableID) {

		
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;
		
		var row = table.insertRow(rowCount);
        rowCount = parseInt(rowCount)-2;
       
		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name="subjectList["+rowCount+"].selected";
		element1.value="true";
		element1.checked = 'checked';
		element1.onclick="javascript:onSelect(this.id);";
		cell1.appendChild(element1);

		

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "subjectList["+rowCount+"].subName";
		element2.size = 50;
		element2.id="namein["+rowCount+"]";
		
		cell2.appendChild(element2);
		
		
		var cell3 = row.insertCell(2);
		var element4 = document.createElement("input");
		element4.type = "text";
		element4.name = "subjectList["+rowCount+"].subCode";
		element4.size=30;
		
		cell3.appendChild(element4);
		
		var cell4 = row.insertCell(3);
		var element5 = document.createElement("input");
		element5.type = "text";
		element5.name = "subjectList["+rowCount+"].subSyllabus";
		element5.size=50;
		
		cell4.appendChild(element5);
		
		
		var cell5 = row.insertCell(4);
		var element6 = document.getElementById("facList").cloneNode(true);
		element6.name = "subjectList["+rowCount+"].facID";
		
		cell5.appendChild(element6);
		
		var cell6 = row.insertCell(5);
		var element7 = document.getElementById("semList").cloneNode(true);
		element7.name = "subjectList["+rowCount+"].semID";
		
		cell6.appendChild(element7);
		
		
		var cell7 = row.insertCell(6);
		var element8 = document.createElement("input");
		element8.type = "hidden";
		element8.name = "subjectList["+rowCount+"].subID";
		element8.value= "0";
		
		cell7.appendChild(element8);
		
    
		 

	}
	
	function onSelect(checkId)
	{
		
		var elements=checkId.split("_");
		
		var select = document.getElementById(checkId);
		
		if(select.checked==true)
	    {
			
			document.getElementById("namein["+elements[2]+"]").style.display="block";
			document.getElementById("nameout["+elements[2]+"]").style.display="none";
			document.getElementById("syllabusin["+elements[2]+"]").style.display="block";
			document.getElementById("syllabusout["+elements[2]+"]").style.display="none";
			
	    }
		else
		{
			document.getElementById("nameout["+elements[2]+"]").style.display="block";
			document.getElementById("namein["+elements[2]+"]").style.display="none";
			document.getElementById("syllabusout["+elements[2]+"]").style.display="block";
			document.getElementById("syllabusin["+elements[2]+"]").style.display="none";
		}	
		
	}

	
</script>
</head>
<body>
	
		<s:form action="manageSubjectsSaveAction">
			<table  class="imagetable" align="center" id="newTable">
			<tr>
				<th colspan="2">
					<h1>Subjects</h1>
				</th>
			</tr>
			<tr>

				<th width="4"><h2>Select</h2></th>
				<th width="170"><h2>Subject</h2></th>
				<th width="170"><h2>Subject Code</h2></th>
				<th width="170"><h2>Syllabus</h2></th>
				<th width="170"><h2>Faculty</h2></th>
				<th width="170"><h2>Semester</h2></th>
				
			</tr>


		<s:iterator value="subjectList" status="stat" >
		<tr>
				
			
		    <td><s:checkbox value="%{selected}" name="subjectList[%{#stat.index}].selected" cssClass="label"
								theme="simple" onclick="javascript:onSelect(this.id);"/></td>
			<td><s:textfield id="namein[%{#stat.index}]"
								name="subjectList[%{#stat.index}].subName"
								value="%{subName}" cssClass="label" theme="simple" style="display:none" size="100" />
								
			<a href="viewFacSub?subID=<s:property value="subID"/>"> <s:label id="nameout[%{#stat.index}]"
								name="subjectList[%{#stat.index}].subName"
								value="%{subName}" cssClass="label" theme="simple" style="display:block" /></a>
								
								
		   </td>
		   
		   <td>
		   
		      <s:property value="subCode"/>
		      
		      <s:hidden name="subjectList[%{#stat.index}].subCode" value="%{subCode}" />
		   </td>
		   <td>
		      <s:textfield id="syllabusin[%{#stat.index}]"
								name="subjectList[%{#stat.index}].subSyllabus"
								value="%{subSyllabus}" cssClass="label" theme="simple" style="display:none;width:170" />
								
			 <s:label id="syllabusout[%{#stat.index}]"
								name="subjectList[%{#stat.index}].subSyllabus"
								value="%{subSyllabus}" cssClass="label" theme="simple" style="display:block;width:170" />
		   </td>
		   <td>
		     <s:select list="facultylist" id="facList"   listKey="facID" listValue="facName" name="subjectList[%{#stat.index}].facID" cssClass="label" theme="simple"/>
		   </td>
		   <td>
		     <s:select list="semesterLst" id="semList"  listKey="semID" listValue="semName" name="subjectList[%{#stat.index}].semID" cssClass="label" theme="simple"/>
		   </td>
		   <s:hidden name="subjectList[%{#stat.index}].subID" value="%{subID}" />
		</tr>
	</s:iterator>
		</table>
		 <table align="center">
			<tr>
				<td height="10"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><INPUT type="button" value="Add" onclick="javascript:addRow('newTable');" /></td>
                  <td colspan="2" align="right"><input type="submit" name="button" value="Save" size="10"
					style="width: 100px" id="mysubmit" /></td>
               <td colspan="2" align="right"><input type="submit" name="button" value="Delete" size="10"
					style="width: 100px" id="mysubmit" /></td>
			</tr>
		</table>
		</s:form>
	
</body>
</html>
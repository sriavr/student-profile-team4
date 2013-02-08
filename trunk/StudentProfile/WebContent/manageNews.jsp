<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/table_new.css">
<title>Manage News</title>

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
		element1.name="newlist["+rowCount+"].selected";
		element1.value="true";
		element1.checked = 'checked';
		element1.onclick="javascript:onSelect(this.id);";
		cell1.appendChild(element1);

		

		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "newlist["+rowCount+"].newName";
		element2.size = 100;
		element2.style.display = "block";
		element2.id="newsin["+rowCount+"]";
		
		
		var element3 = document.createElement("input");
		element3.type = "label";
		element3.name = "newlist["+rowCount+"].newName";
		element3.style.display = "none";
		element3.id="newsout["+rowCount+"]";
		cell2.appendChild(element2);
		cell2.appendChild(element3);
		
		var cell3 = row.insertCell(2);
		var element4 = document.createElement("input");
		element4.type = "hidden";
		element4.name = "newlist["+rowCount+"].newID";
		element4.value= "0";
		
		cell3.appendChild(element4);


	}
	
	function onSelect(checkId)
	{
		
		var elements=checkId.split("_");
		
		var select = document.getElementById(checkId);
		
		if(select.checked==true)
	    {
			
			document.getElementById("newsin["+elements[2]+"]").style.display="block";
			document.getElementById("newsout["+elements[2]+"]").style.display="none";
			
	    }
		else
		{
			document.getElementById("newsout["+elements[2]+"]").style.display="block";
			document.getElementById("newsin["+elements[2]+"]").style.display="none";
		}	
		
	}

	
</script>
</head>
<body>
  <s:form name="myNews" action="saveNews" method="GET" id="myform">
    <table  class="imagetable" align="center" id="newTable">
			<tr>
				<th colspan="2">
					<h1>Manage News</h1>
				</th>
			</tr>
			<tr>

				<th width="2"><h2>Select</h2></th>
				<th width="500"><h2>News</h2></th>
				
				
			</tr>


		<s:iterator value="newlist" status="stat" >
		<tr>
				
			
			<td><s:checkbox value="%{selected}" name="newlist[%{#stat.index}].selected" cssClass="label"
								theme="simple" onclick="javascript:onSelect(this.id);"/></td>
			<td><s:textfield id="newsin[%{#stat.index}]"
								name="newlist[%{#stat.index}].newName"
								value="%{newName}" cssClass="label" theme="simple" style="display:none" size="100" />
								
			 <s:label id="newsout[%{#stat.index}]"
								name="newlist[%{#stat.index}].newName"
								value="%{newName}" cssClass="label" theme="simple" style="display:block" />
		   </td>
		   <s:hidden name="newlist[%{#stat.index}].newID" value="%{newID}" />
			
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
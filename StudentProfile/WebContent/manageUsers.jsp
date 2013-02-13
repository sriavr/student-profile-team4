<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" language="javascript">
	function editUser() {
	
		//alert("edit User");
		var uname, pwd;
		var d,child;
		var parentDiv;
		//disabling all the buttons
		document.getElementById("editButton").disabled="true";
		document.getElementById("addButton").disabled="true";	
		document.getElementById("removeButton").disabled="true";		
		var group = document.getElementsByName("chk_group");
		for(var i = 0; i < group.length; i++){
				if(group[i].checked){
					//alert(group[i].id);
					//checked.push(group[i].id);
					//making uname editable
					//alert(group[i].id);
					uname=group[i].id+":name";
					//alert(uname);
					d=document.getElementById(uname);
					//alert("uname selected: "+d.innerText);
					child=document.createElement("input");
					//alert(child.value);
					child.value=d.innerText;
					//alert(child.value);
					child.id=d.id;
					//alert(child.id);
					parentDiv = d.parentNode;
					parentDiv.replaceChild(child,d);

					//making pwd editable
					pwd=group[i].id+":pass";
					//alert(pwd);
					d=document.getElementById(pwd);
					//alert(d.innerText);
					child=document.createElement("input");
					//alert(child.value);
					child.value=d.innerText;
					//alert(child.value);
					child.id=d.id;
					//alert(child.id);
					parentDiv = d.parentNode;
					parentDiv.replaceChild(child,d);
					}
				}
		}
	function addUser(maxStudentId){
		
		var nextStudentId = ++maxStudentId;
		//alert(nextStudentId);
		
		//disabling all the buttons
		document.getElementById("editButton").disabled="true";
		document.getElementById("addButton").disabled="true";	
		document.getElementById("removeButton").disabled="true";

		
		var tableRef = document.getElementById("user_details");
		 
	    //var newRow   = tableRef.insertRow(-1);
		 var rowCount = tableRef.rows.length;
            var newRow = tableRef.insertRow(rowCount);
 
	    var cell0 = newRow.insertCell(0);
        var element0= document.createElement("input");
        element0.type = "checkbox";
        element0.name="chk_group";
        element0.id="MT2012_"+nextStudentId;  
        element0.checked = true;
        cell0.appendChild(element0);

	    
        var cell1 = newRow.insertCell(1);
        var element1 = document.createElement("input");
        element1.type = "text";
        element1.value="MT2012_"+ nextStudentId;
        element1.disabled=true;
        cell1.appendChild(element1);

        var cell2 = newRow.insertCell(2);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.id="MT2012_"+nextStudentId+":name"; 
        cell2.appendChild(element2);

        var cell3 = newRow.insertCell(3);
        var element3 = document.createElement("input");
        element3.type = "text";
        element3.id="MT2012_"+nextStudentId+":pass"; 
        cell3.appendChild(element3);
	
	}
	function removeUser() {

		//alert("remove");
		//disabling all the buttons
		document.getElementById("editButton").disabled="true";
		document.getElementById("addButton").disabled="true";	
		document.getElementById("removeButton").disabled="true";		
		
		var stuID,count=0;
		var url="manageUsersRemoveAction?&";
		var group = document.getElementsByName("chk_group");
			for(var i = 0; i < group.length; i++){
				if(group[i].checked){
					//alert(group[i].id);
					stuID = group[i].id.split("_")[1];
					//alert(stuID);		
					url=url+"studentArray["+(count++)+"]="+stuID+"&";
				}
			}
			url = url.substring(0,url.length-1);
			//alert(url);
			window.location.href=url;
		}
	function submit(){
		var uname,pwd,count=0;
		var stuID,stuName,stuPassword,stuRollNo;
		var group = document.getElementsByName("chk_group");
		var url="manageUsersUpdationAction?&";
		for(var i = 0; i < group.length; i++){
				if(group[i].checked){
					//alert(group[i].id);
					stuID = group[i].id.split("_")[1];
					//alert("stuID: "+stuID);
					stuRollNo = group[i].id;
					uname = group[i].id+":name";
					pwd = group[i].id+":pass";
					stuName = document.getElementById(uname).value;
					stuPassword = document.getElementById(pwd).value;
					url = url + "Selectedstudents["+(count)+"].stuID="+stuID+"&";
					url = url + "Selectedstudents["+(count)+"].stuName="+stuName+"&";
					url = url + "Selectedstudents["+(count)+"].stuPassword="+stuPassword+"&";
					url = url + "Selectedstudents["+(count++)+"].stuRollNo="+stuRollNo+"&";
				}
		}

		url = url.substring(0,url.length-1);
		window.location.href=url;	
	}
	
</script>
</head>
<body>
	<table border=3 id="user_details">
		<tr>
			<th></th>
			<th>User Id</th>
			<th>User Name</th>
			<th>Password</th>
		</tr>

		<s:iterator value="students" var="item">
			<tr>
				
				<td><input type="checkbox" name="chk_group"
					id="<s:property value="%{#item.stuRollNo}" />" class="messageCheckbox"/></td>
				
				<td><div >
						<s:property value="%{#item.stuRollNo}" />
					</div></td>
				
				
				<td><div id="<s:property value="%{#item.stuRollNo}" />:name">
						<s:property value="%{#item.stuName}" />
					</div></td>
				
				<td><div id="<s:property value="%{#item.stuRollNo}" />:pass">
						<s:property value="%{#item.stuPassword}" />
					</div>
				<td>

			</tr>
		</s:iterator>
	</table>
	<input type="button" value="Edit" id="editButton" onclick="javascript:editUser();" />
	<input type="button" value="Add" id="addButton" onclick="addUser('<s:property value="maxStudentId" />')" />
	<input type="button" value="Remove" id="removeButton" onclick="removeUser()"/><br>
	<input type="button" value="Submit" id="submitButton" onclick="submit()"/>
</body>
</html>
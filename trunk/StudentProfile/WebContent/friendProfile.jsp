<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="Javascript" type="text/javascript">  

function enable(){  
 if (document.agreement_form.agreed.checked==''){
	 
  document.agreement_form.submit_button.disabled=true;  
 }else{  
	 
  document.agreement_form.submit_button.disabled=false;  
 }  
}  

function removeFriend(){  
	 alert('Inside removeFriend');
	 var url="RemoveFriendAction";
	 window.location.href=url;
	}  
	
function addFriend(){  
	 var url="AddFriendAction";
	 window.location.href=url;
	}  
</script>  

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form name="agreement_form" method="post">
	Name <s:textfield name="studentname"  disabled="1" value="%{studentname}"  theme="simple"/>
	<br><br>
	Photo <a href="profilePicAction?stuID=<s:property value="stuID"/>"> <img
						src="getImage?stuID=<s:property value="stuID"/>" height="50"
						width="50" /></a>
	<br><br>
     Date Of Birth <s:textfield name="studentdob"  disabled="1" value="%{studentdob}" theme="simple"/>
	<br><br>
	Interests <s:textfield name="studentinterest"  disabled="1" value="%{studentinterest}" theme="simple"/>
	<br><br>
	<s:if test="%{enableFlag=='disabled'}" >
	<s:checkbox name="agreed"  label="Friends"  disabled="disabled"/>
		<input type="submit" disabled="disabled" value="Add as Friend"/>
		<s:submit action="RemoveFriendAction" value="REMOVE FRIEND" > </s:submit>
	</s:if>
	
	<s:else>
		<s:checkbox name="agreed"  label="Friends" />
		<s:submit action="AddFriendAction" value="ADD FRIEND" > </s:submit>
	</s:else>
	
</s:form>
<s:actionmessage/>

</body>
</html>





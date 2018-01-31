<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
                   <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
            
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <style type="text/css">
 
/*  
body {
    background-image: url("images/User/feedback.jpg");
    background-repeat: no-repeat;
    background-position: right center;
    margin-right: 200px;
} */
#upleft { 
   width:500px; 
   height: 600px; 
   background:; float:left; 
}

#upright { 
   width:700px; 
   height:600px; 
   background:; 
   float:left
}
</style>
<style type="text/css">
.background1 {
box-sizing: border-box;
width: 100%;
height: 150px;
padding: 3px;
background-color:white;
border: 1px solid black;
background-size: 100% 100%;
}
</style>
</head>
<script type="text/javascript">
function login()
{
	alert("login");
	
	
}
</script>
<style>
 .error{
 color: #ff0000;
 }
 .txt {
 	border:2px solid #b3b3b3;
	width: 160px;
    heigth:25px; 
    border-radius:10px;
}
.button{
border:1px solid #999999; -webkit-border-radius: 42px; -moz-border-radius: 42px;border-radius: 42px;font-size:12px;font-family:times new roman, helvetica, sans-serif; padding: 5px 15px 5px 15px; text-decoration:none; display:inline-block;text-shadow: 1px 1px 0 rgba(255,255,255,0.3);font-weight:bold; color: #000000;
 background-color: #FFFFFF; background-image: -webkit-gradient(linear, left top, left bottom, from(#FFFFFF), to(#CFCFCF));
 background-image: -webkit-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -moz-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -ms-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: -o-linear-gradient(top, #FFFFFF, #CFCFCF);
 background-image: linear-gradient(to bottom, #FFFFFF, #CFCFCF);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#FFFFFF, endColorstr=#CFCFCF);
}

.button:hover{
 border:1px solid #7A7A7A;
 background-color: #EEEEEE; background-image: -webkit-gradient(linear, left top, left bottom, from(#EEEEEE), to(#C7C7C7));
 background-image: -webkit-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -moz-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -ms-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: -o-linear-gradient(top, #EEEEEE, #C7C7C7);
 background-image: linear-gradient(to bottom, #EEEEEE, #C7C7C7);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#EEEEEE, endColorstr=#C7C7C7);
}
 </style>
 
  <script type="text/javascript">
      function reset(){
    	  
/*     	  document.getElementById("employeeid").value="";
 */    	  document.getElementById("email").value="";
    	  document.getElementById("comments").value="";
    	 
	  
 



      }
      </script>
        
<body background="images/User/feedback.png">
<sec:authorize ifAllGranted="ROLE_USER">

<h2 align="center">Add Feedback</h2>
<form:form action="userfeedbacksave.html" commandNamne="command">
<!-- <div id="upleft" class="background1" style="height:600px;"><br>
<img src="images/User/feedback.png" alt="sales View" style="width:500px;height:550px;"> -->
<!-- </div> 
<div id="upright" class="background1" style="height:600px;"> -->

<table align="center"><tr>
<td align="center"><br>
<!-- <h1><font color="blue"><img src="images/Home/9.jpg" alt="sales View" style="width:250px;height:120px;"></font></h1></td></tr>
 -->
<form:hidden path="id"  />
<%-- <tr><td cssStyle="height:20px">Name*</td><td cssStyle="width:18px;">:</td>
<td><form:input path="name" cssClass="txt" cssStyle="height:18px;"/></td><td><form:errors path="name" cssClass="error"></form:errors></td></tr>

<tr><td cssStyle="height:20px">Email Id*</td><td cssStyle="width:18px;">:</td>
<td><form:input path="email" cssClass="txt" cssStyle="height:18px;"/></td><td><form:errors path="email" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">City*</td><td cssStyle="width:18px;">:</td>
<td><form:input path="city" cssClass="txt" cssStyle="height:18px;"/></td><td><form:errors path="city" cssClass="error"></form:errors></td></tr>
 --%>
<tr><td cssStyle="height:20px">Comments*</td><td cssStyle="width:18px;">:</td>
<td><form:textarea path="comments" cssClass="txt" cssStyle="height:70px;"/></td><td><form:errors path="comments" cssClass="error"></form:errors></td></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td><td></td>
<td colspan="2" align="left"><input type="submit" value="Submit" Class="button"/>
  &nbsp&nbsp&nbsp&nbsp
 <input type="button" value="Reset" onClick="reset();" Class="button"/></td>
 
 </tr>
</table>



</div>
</form:form>
 </sec:authorize>

</body>
</html>
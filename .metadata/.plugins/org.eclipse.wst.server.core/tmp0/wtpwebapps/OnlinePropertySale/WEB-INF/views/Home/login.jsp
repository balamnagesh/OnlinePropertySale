<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoginPage</title>
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script>
function resetfg(){
	
	 document.getElementById("username").value="";
		document.getElementByTd("password").value="";
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
</head>
<body>
<h1 align="center">Login Page</h1>

<center>
<br>
 <form:form action="loginsuccess.html" method="POST">
 <table border="0" align="center" cellpadding="3" cellspacing="2">
<tr><td cssStyle="height:20px">Username</td><td cssStyle="width:18px;">:</td>
<td><form:input path="username" cssClass="txt" cssStyle="height:18px;" id="username"/></td><td><form:errors path="username" cssClass="error"></form:errors></td></tr>
<tr><td cssStyle="height:20px">Password</td><td cssStyle="width:18px;">:</td>
<td><form:password path="password" cssClass="txt" cssStyle="height:18px;"/></td><td><form:errors path="password" cssClass="error"></form:errors></td></tr>
<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td>
<td colspan="2" align="center"><input type="submit" Class="button" value="Login" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="button" value="Reset" onClick="resetfg()" Class="button"/></td></tr>
<tr><td></td><td colspan="2" align="center"><a href="forgotpassword.html" style="color:black;background: lightblue" >Forgot Password?</a></td></tr>
<tr><td></td><td colspan="2" align="center"><a href='registration.html'>New User? Register here</a></td></tr>


 
</table>
</form:form>
</center>
</body>
</html>
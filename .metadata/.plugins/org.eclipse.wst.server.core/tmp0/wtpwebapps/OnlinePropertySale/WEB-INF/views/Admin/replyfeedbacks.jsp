<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>        
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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

<h1 align="center">Reply FeedBack</h1>
<br>
<form:form action="replyfeedbacksuccess.html" method="POST">

<table align="center"><tr>
<td border="0" align="center" cellpadding="3" cellspacing="2">

<form:hidden path="id"  />

<tr><td cssStyle="height:20px">Email Id*</td><td cssStyle="width:18px;">:</td>
<td><form:input path="email" cssClass="txt" cssStyle="height:18px;" readonly="true"/></td></tr>

<tr><td cssStyle="height:20px">Comments*</td><td cssStyle="width:18px;">:</td>
<td><form:textarea path="comments" cssClass="txt" cssStyle="height:70px;" readonly="true"/></td></tr>

<tr><td cssStyle="height:20px">Reply</td><td cssStyle="width:18px;">:</td>
<td><form:textarea path="reply" cssClass="txt" cssStyle="height:70px;" name="reply"/></td><td><form:errors path="reply" cssClass="error"></form:errors></td></tr>

<tr><td><form:hidden path="type"/></td></tr>
<tr><td><form:hidden path="status"/></td></tr>
<tr><td><form:hidden path="date"/></td></tr>

<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr><td></td><td></td>
<td colspan="2" align="left"><input type="submit" value="Reply" Class="button"/>
  &nbsp&nbsp&nbsp&nbsp
 <input type="button" value="Cancel" onClick="window.close()" Class="button"/></td>
 
 </tr>
</table>

</form:form>
</body>
</html>
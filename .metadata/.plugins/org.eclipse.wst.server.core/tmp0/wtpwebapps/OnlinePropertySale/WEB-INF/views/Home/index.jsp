<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Property Sales</title>
</head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>  
    </head>
    <body background="images/cp.png">
        <table border="0" cellpadding="1" cellspacing="1" align="center">
            <tr>
                <td height="70px" width="1200px" colspan="2">
                    <tiles:insertAttribute name="header" ignore="true" />
                </td>
            </tr>
            <tr>
                <td height="50px" width="1200px" colspan="2">
                    <tiles:insertAttribute name="menu" />
                </td></tr>
                <tr><td height="500px" width="1200px" colspan="2">
                    <tiles:insertAttribute name="body" />
                </td>
            </tr>
            <tr>
                <td height="30px" width="1200px" colspan="2">
                    <tiles:insertAttribute name="footer" />
                </td>
            </tr>
        </table>
    </body>
</html>
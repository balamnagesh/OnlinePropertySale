<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
        <%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DateFormat"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en-US">
<head>
<title>All Users</title>
  <meta charset="UTF-8">
 <link rel="stylesheet" type="text/css" href="jquery/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery/themes/color.css">
    <link rel="stylesheet" type="text/css" href="jquery/demo/demo.css">
    <script type="text/javascript" src="jquery/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
    <!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script> -->
    <style>
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
     function cellStyler(value,row,index){
    			if (row.status=='Pending'){
    				return 'color:black;font-weight:bold';
    				
    			}
    			else if(row.status=='Close'){
    				
    				return 'color:red;font-weight:bold';
    			}
else if(row.status=='Approved'){
    				
    				return 'color:block;font-weight:bold';
    			}
    		}
     
    </script>
    
<script>
function reply(){
	
	var row = $('#tb').datagrid('getSelected');
    if (row){
    	
		if(row.status=="Close"){
			 $.messager.alert('Warning','Access is denied');
		}	
		else{
     window.open('replyfeedbackadmin.html?id='+row.id,'ReplyFeedBack','height=450,width=700,left=200,top=100,overflow: scroll');                              
                }
    }
               else
             {
            $.messager.alert('Warning','Select atleast one row');
             }
 
           }
   </script>

	<script>
        function doSearch(value){
        alert("doSearch(value)");
        	$('#tb').datagrid({
        		
            	url:"adminfeedbackgridsearch.html?value="+value
            });


			}
    </script>
    
    <script>
    function reload(){
    	$('#tb').datagrid({
    		
    		url:'adminfeedbackgrid.html'
    	});
    }
    </script>
<script>
function dateSearch(){
	/* alert("hi date"); */
	var fr=$('#fromdate').datebox('getValue');
	/* alert("hello..."+fr); */
	var to=$('#todate').datebox('getValue');
	
	if(new Date(fr)>new Date(to)){
		alert("To Date Should not be less than from date");
	}
	/* alert(to); */
	/* var m = document.getElementById('fromdate').value;
	var from = new Date(m);//converts string to date object
	alert(from);
	
	var f=from.toDateString();
    alert(f);
	var t=document.getElementById('todate').value;
	var to1=new Date(t);
	var to=to1.toDateString();
	alert(to); */
	/* window.location.href="date.html?from="+f+"&to="+t;  */
	else{
	$('#tb').datagrid({
		url:"adminfeedbackgriddate.html?from="+fr+"&to="+to

	});}
	}

</script>      
<script>
$(document).ready(function() {
var cd=new Date();
/* alert(cd); */
var cdy=cd.getFullYear();
var cdd=cd.getDate();
var cdm=cd.getMonth()+1;
var td=""+cdm+"/"+cdd+"/"+cdy;
/* alert(td); */
$('#fromdate').datebox('setValue',"01/01/"+cdy);
$('#todate').datebox('setValue',td);

});
</script>

</head>
<body>
<sec:authorize ifAllGranted="ROLE_ADMIN">
<br>

<center>
  
              <table id="tb" class="easyui-datagrid" title="ViewFeedBacks" style="width:1100px;height:250px" singleSelect="false"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:false,url:'adminfeedbackgrid.html',onDblClickRow:function(index,row){update()},method:'get'">
          
        <thead> 
        <!-- <div>
            Search:<input class="easyui-searchbox" data-options="prompt:'Username or Firstname',searcher:doSearch" style="width:150px">
</div> -->
<div>
Search:<input class="easyui-searchbox" data-options="prompt:'Status or Type',searcher:doSearch" style="width:150px">
DateofFrom:<input id="fromdate" class="easyui-datebox"  style="width:100px;"
data-options="onSelect:dateSearch,editable:true">
To:<input id="todate" class="easyui-datebox"  style="width:100px;"
data-options="onSelect:dateSearch,editable:true">
<!-- <input type="button" value="Search" style="width:60px;" onclick="dateSearch()"> 
 --><input type="button" value="Refresh" style="width:60px;" onclick="reload()">

<!--  <a href="date.html" class="easyui-linkbutton" iconCls="icon-search" onclick="dateSearch()">Search</a> 
 --> </div>
&nbsp;
&nbsp;
<tr>
        		<th align="center" data-options="field:'id',width:70">ID</th>
        		<th align="center" data-options="field:'status',width:90,styler:cellStyler">Status</th>
        		
                <th align="center" data-options="field:'email',width:200">EmailID</th>
                <th align="center" data-options="field:'comments',width:250,align:'right'">Comments</th>
               
                <th align="center" data-options="field:'date',width:90">Date</th>
                 <th align="center" data-options="field:'reply',width:250">Reply</th>
                <th align="center" data-options="field:'type',width:90">Type</th>
                
                
            </tr>
            	
            	
	      
	        </thead> 
    </table></center>
      <div style="margin:20px 0;"  align="center"> 
    
        
        <input type="button" name="Delete" value="Reply" onclick="reply()" class="button">&nbsp;&nbsp;&nbsp; 
       </div>
      
    <br>   <br>   <br>   <br>   <br>   <br>   <br>
   <div id="google_translate_element"></div>

<script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element');
}
</script>

<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
   

        
 <!-- <div style="margin:20px 0;"></div>
    <div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;">
        <input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">
    </div>
    <script>
        function doSearch(value){
            alert('You input: ' + value);
            window.location.href="search.html?value="+value;
        }
    </script> -->
  
        
       <%@page import="java.util.*" %>
    <h3><font color="blue"> Display Current Date and Number based on client request locale</font> </h3>
    <%
     Locale locale = request.getLocale();
     Date currentDate= new Date();
     DateFormat dateFormat= DateFormat.getDateInstance(DateFormat.FULL, locale);
     NumberFormat numberFormat =  NumberFormat.getNumberInstance(locale);
    %>
    Locale is  <%= locale.getDisplayCountry() %>
    <br/> 
    Current date ::  
   <%=
     dateFormat.format(currentDate) 
   %>
   <br/>
   Number (100045.34) ::
   <%= 
     numberFormat.format(100045.34)
   %>
     </sec:authorize>
</body>
</html>
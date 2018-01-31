<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
 


   
           <script>
           function muldel()
           {
          /*    alert("multiple delete valuessss");  */
            
             var row= $('#tb').datagrid('getSelections');

            /*  alert(row.length); */
            
            
            
             if(row.length>0)
             {
           	  var err=[];
           	  for(var i=0;i<row.length;i++)
           	  {
           	      err.push(row[i].username);
           	  } 
           	  
           	  
             
             $.messager.confirm('My Title', 'Are you sure you want to delete this user?', function(r){
                 if (r)
                 {
             window.location.href="admindeluser.html?username="+err
                 }
                });
             }
             else
              {
              $.messager.alert('Warning','Please select atleast one row!');
              }   
             
           } 
   </script>
    

	<script>
	function doSearch(value)
	{
		/* alert("datesearch"); */
		 $('#tb').datagrid({
			 
		     url:"adminusergridsearch.html?value="+value
		 });
		 
	}
    </script>
    
    <script>
    function reload(){
    	$('#tb').datagrid({
    		
    		url:'usersgrid.html'
    	});
    }
    </script>
<script>
function dateSearch(){
	
	var fr=$('#fromdate').datebox('getValue');
	
	var to=$('#todate').datebox('getValue');
	
	if(new Date(fr)>new Date(to)){
		alert("To Date Should not be less than from date");
	}
	
	else{
	$('#tb').datagrid({
		url:"adminusergriddate.html?from="+fr+"&to="+to

	});}
	}

</script>      
<script>
$(document).ready(function() {
var cd=new Date();
/* alert(cd);  */
var cdy=cd.getFullYear();
var cdd=cd.getDate();
var cdm=cd.getMonth()+1;
var td=""+cdm+"/"+cdd+"/"+cdy;
/* alert(td);  */
$('#fromdate').datebox('setValue',"01/01/"+cdy);
$('#todate').datebox('setValue',td);

});
</script>

</head>
<body>
<br>

<center>
   <!--  <table id="tb" class="easyui-datagrid" title="All users" style="width:900px;height:300px" 
    
    	   onCheck="true" singleSelect="true" 
    	
          rownumbers="true" pagination="true" pageList="[10,20,30,40,50,60]"  showPageList="true" fitColumns="false"  data-options="singleSelect:false,url:'usersgrid.html',onDblClickRow:function(index,row){update()},method:'get'"> -->
          
           <table id="tb" class="easyui-datagrid" title="UsersList" style="width:1100px;height:250px" singleSelect="false"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:false,url:'usersgrid.html',onDblClickRow:function(index,row){update()},method:'get'">
          
        <thead> 
        <!-- <div>
            Search:<input class="easyui-searchbox" data-options="prompt:'Username or Firstname',searcher:doSearch" style="width:150px">
</div> -->
<div>
Search:  <input class="easyui-searchbox" data-options="prompt:'Please Input Username',searcher:doSearch" style="width:150px"/>
Date Of Joining From:<input id="fromdate" class="easyui-datebox"  style="width:100px;"
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
                 <th align="center" data-options="field:'firstname',width:90">Firstname</th>
                <th align="center" data-options="field:'middlename',width:90,align:'right'">Middlename</th>
                <th align="center" data-options="field:'lastname',width:90,align:'right'">Lastname</th>
                <th align="center" data-options="field:'username',width:90">Username</th>
                 <!-- <th align="center" data-options="field:'password',width:80">Password</th>
                <th align="center" data-options="field:'conformpassword',width:90">Conformpassword</th> -->
                <th align="center" data-options="field:'dateofbirth',width:90,align:'right'">Dateofbirth</th>
                <th align="center" data-options="field:'gender',width:90,align:'right'">Gender</th>
                <th align="center" data-options="field:'email',width:150">EmailId</th>
          
               <th align="center" data-options="field:'mobileno',width:90">Mobilenumber</th>
                <th align="center" data-options="field:'address',width:90">Address</th>
                <th align="center" data-options="field:'pincode',width:90,align:'right'">Pincode</th>
                <th align="center" data-options="field:'country',width:90,align:'right'">Country</th>
                <th align="center" data-options="field:'state',width:90">State</th>
                <th align="center" data-options="field:'city',width:90">City</th>
                  <th align="center" data-options="field:'city',width:90">Languages Knwon</th>
                <th align="center" data-options="field:'registerdate',width:90,align:'right'">RegisterDate</th>
                  
                
            </tr>
            	
            	
	      
	        </thead> 
    </table></center>
   

        
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
    <div style="margin:20px 0;"  align="center"> 
    
        <!-- <input type="button" name="Add" value="Add" onclick="add()" class="button">&nbsp;&nbsp;&nbsp; 
         <input type="button" name="Edit" value="Edit" onclick="update()" class="button">&nbsp;&nbsp;&nbsp;  -->
        <input type="button" name="Delete" value="Delete" onclick="muldel()" class="button">&nbsp;&nbsp;&nbsp; 
       </div>
       
</body>
</html>
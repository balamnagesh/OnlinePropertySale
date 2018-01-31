<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
             <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


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
function add()
{
/* window.location.href="addsubadmin.html"; */
window.open('propertyadd.html', 'AddAgent','height=850,width=900,left=200,top=100,overflow: scroll');


}  
</script> 
<script>
function update(){
	//window.open('updateagent.html', 'AddUser','height=700,width=700,left=200,top=100,overflow: scroll');

     var row = $('#tb').datagrid('getSelected');
        if (row){
        	

         window.open('agentupdateproperty.html?id='+row.id+'&path='+row.filepath,'UpdateAgent','height=850,width=800,left=200,top=100,overflow: scroll');                              
                    }
                   else
                 {
                $.messager.alert('Warning','Select atleast one row');
                 } 
     
               }
   </script>
   
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
           	      err.push(row[i].id);
           	  } 
           	  
           	  
             
             $.messager.confirm('My Title', 'Are you sure you want to delete this user?', function(r){
                 if (r)
                 {
             window.location.href="propertyagentdeletegrid.html?id="+err
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
        function doSearch(value){
        	/* alert("hi");  
 */
        	$('#tb').datagrid({
        		
            	url:"agentpropertygrididserach.html?value="+value
            });


			}
    </script>
    
    <script>
    function reload(){
    	$('#tb').datagrid({
    		
    		url:'agentpropertyrefresh.html'
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
		url:"agentpropertygriddate.html?from="+fr+"&to="+to

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
<sec:authorize ifAllGranted="ROLE_AGENT">


<br>

<center>
   <!--  <table id="tb" class="easyui-datagrid" title="All Properties" style="width:1000px;height:600px" 
    
    	   onCheck="true" singleSelect="true" 
    	
          rownumbers="true" pagination="true" pageList="[10,20,30,40,50,60]"  showPageList="true" fitColumns="false"  data-options="singleSelect:false,url:'agentpropertylist.html',onDblClickRow:function(index,row){update()},method:'get'">
           -->
                      <table id="tb" class="easyui-datagrid" title="All Properties" style="width:1000px;height:600px" singleSelect="false"  rownumbers="true" pagination="true" fitColumns="false" data-options="singleSelect:false,url:'agentpropertylist.html',onDblClickRow:function(index,row){update()},method:'get'">
          
       <thead >  
        <!-- <div>
            Search:<input class="easyui-searchbox" data-options="prompt:'Username or Firstname',searcher:doSearch" style="width:150px">
</div> -->

<div>
Search:<input class="easyui-searchbox" data-options="prompt:'City',searcher:doSearch" style="width:150px">
Property Registred Date From:<input id="fromdate" class="easyui-datebox"  style="width:100px;"
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
          
                  <th align="center"   data-options="field:'id',width:90,align:'right'">Property Id</th>
      <th align="center"   data-options="field:'username',width:90,align:'right'">username</th>
                <th align="center" data-options="field:'gender',width:90,align:'right'">Gender</th>
                <!-- <th align="center" data-options="field:'locality',width:150">Locality</th> -->
               <th align="center" data-options="field:'propertyregisterdate',width:90,align:'right'">Property Registerdate</th>
               <th align="center" data-options="field:'mobileno',width:90">Mobilenumber</th>
                <th align="center" data-options="field:'address',width:90">Address</th>
                <th align="center" data-options="field:'pincode',width:90,align:'right'">Pincode</th>
                <th align="center" data-options="field:'country',width:90,align:'right'">Country</th>
                <th align="center" data-options="field:'state',width:90">State</th>
                <th align="center" data-options="field:'city',width:90">City</th>
                  <th align="center" data-options="field:'propertytype',width:90">Property Type</th>
                   <th align="center" data-options="field:'plotarea',width:90">plot Area</th>
                    <th align="center" data-options="field:'propertyprice',width:90">property Price</th>
                  
              
            </tr>
            	
            	
	      
	         </thead>  
    </table></center>
    
    
    <script>
        var cardview = $.extend({}, $.fn.datagrid.defaults.view, {
        
            renderRow: function(target, fields, frozen, rowIndex, rowData){
                var cc = [];
                cc.push('<td colspan=' + fields.length + ' style="padding:10px 5px;border:0;">');
                if (!frozen && rowData.filepath){
                    var aa = rowData.filepath.split('/');
                   
                    var img =  aa[2] ;
                  //  alert(img+" hellow  ");
                   // alert(cc.push('<img src="E:/NAGESH_WORK_SPACE/OnlinePropertySale/WebContent/images/User/' + img + '" style="width:150px;float:left">')+"hiiiiiiiiiiiiiiiiiii");
                    cc.push('<img src="images/User/' + img + '" style="width:500px;height:400px;float:left">');
                     cc.push('<div style="float:left;margin-left:40px;">'); 
                    
                 
                    
                    for(var i=0; i<fields.length; i++){
                        var copts = $(target).datagrid('getColumnOption', fields[i]);
                        
                        cc.push('<p><span class="c-label">' + copts.title + ':</span> ' + rowData[fields[i]] + '</p>');
                    }
                    cc.push('</div>');
                }
                cc.push('</td>');
                return cc.join('');
            }
        });
        $(function(){
            $('#tb').datagrid({
                view: cardview
                
            });
        });
    </script>

   
 <style type="text/css">
        .c-label{
            display:inline-block;
            width:100px;
            font-weight:bold;
            color:#ff0080;
        }
    </style>
    
    

    <style type="text/css">
	
      .datagrid-header-row {
	  
    visibility: collapse;

        }
    </style>
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
    
        <input type="button" name="Add" value="PropertyAdd" onclick="add()" class="button">&nbsp;&nbsp;&nbsp; 
         <input type="button" name="Edit" value="PropertyEdit" onclick="update()" class="button">&nbsp;&nbsp;&nbsp;  
       <input type="button" name="Delete" value="Delete" onclick="muldel()" class="button">&nbsp;&nbsp;&nbsp;  
       </div>
       </sec:authorize>
       
</body>
</html>
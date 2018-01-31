<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
        <script type="text/javascript">
var slideimages=new Array();
function slideshowimages()
{
for (i=0;i<slideshowimages.arguments.length;i++)
{
slideimages[i]=new Image();
slideimages[i].src=slideshowimages.arguments[i];
}
}
</script>
    </head>
    <body >
    
    
<img alt="online property sales" title="online property" name="slide" border=0 width=1200 height=600>
<script type="text/javascript">
slideshowimages("images/Home/images.jpg","images/Home/houses.jpg","images/Home/image2.jpg","images/Home/image3.jpg","images/Home/image4.jpg")
var slideshowspeed=3500;
var whichimage=0;
function slideit()
{
if (!document.images)
return
document.images.slide.src=slideimages[whichimage].src
if (whichimage<slideimages.length-1)
whichimage++
else
whichimage=0
setTimeout("slideit()",slideshowspeed)
}
slideit()
</script>

    
    
</body>
</html>


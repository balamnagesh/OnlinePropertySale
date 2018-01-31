<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
      <style>
ul {
    list-style-type: none;
    margin: ;
    padding: ;
    overflow: hidden;
    background-color: #333;
}
li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 16px 16px;
    text-decoration: none;
}
a:hover:not(.active) {
    background-color: #111;
}
.active { 
background-color:#4CAF50;
}




ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: black;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color:#000000 ;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: black;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: white;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #999999}

.dropdown:hover .dropdown-content {
    display: block;
}



</style>

</head>
<ul id="menu-bar">
  <li><a href="adminhome.html" >Home</a></li>
  <li><a href="viewusers.html">Users</a></li>
  <li><a href="viewagents.html">Agents</a></li>
<li><a href="adminviewproperties.html">View Properties</a></li>
    <!--  <li><a href="viewadminbookings.html">View Bookings</a></li> -->
    <li><a href="viewadminfeedbacks.html">View Feedbacks</a></li>
    
   <li class="dropdown" style="float:right"><a href="#">My Account</a>
   <div class="dropdown-content">
   <a href="adminupdateprofile.html">Update Profile</a>
   <a href="adminchangepassword.html">Change Password</a>
    <a href="adminlogout.html">Logout</a>
    <li class="dropdown">
    <a href="#" class="dropbtn">DataBase</a>
    <div class="dropdown-content">
      <a href="exportdb.html">Export</a>
      <a href="importdb.html">Import</a>
      </div></li> 
  
   </div>
  </ul>
  </li>  
  
  
 

  
</body>
</html>

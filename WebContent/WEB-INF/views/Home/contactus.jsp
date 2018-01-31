<html>
  <head>
    <title>Place searches</title>
    
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.4.5/demo.css">
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.min.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
    
  
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
    .google{
     margin-bottom:40px;
    
    }
     .contact{
        float: right;
        margin-top:-540px;
      
      } 
    </style>
    <script src="http://maps.google.com/maps/api/js?key=AIzaSyA_OrVkHL73W5gANIjH7mOankhAYPvi3m4&sensor=false" 
          type="text/javascript"></script>
    </head>
   <body>
   <div class="google">
<div id="map" style="width: 700px; height: 600px;"></div>

  <script type="text/javascript">
    var locations = [
      ['vissnapeta', 16.941686, 80.772364, 2],
      ['vijayawada,Schimatic Technologies Pvt Ltd,Ashoke nager, near Time Hospital,vijayawada', 16.485, 80.6865, 1],
      
    ];

    var lat_center = 16.485,
        long_center = 80.6865;

	var lat_center = 16.941686,
        long_center = 80.772364;

    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 7	,
      center: new google.maps.LatLng(lat_center, long_center),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i, text;

    for (i = 0; i < locations.length; i++) {  

      marker = new google.maps.Marker({
          position: new google.maps.LatLng(locations[i][1], locations[i][2]),
          map: map
      });

      text = locations[i][0];
      

      if(locations[i][1] === lat_center && locations[i][2] === long_center) {

          marker.setAnimation(google.maps.Animation.DROP);
               marker.setIcon('http://maps.google.com/intl/en_us/mapfiles/ms/micons/purple.png');
        text += '<br>'+ 'Schimatic Technologies Pvt Ltd Ambedkar center,Beside ysr statue';
        
        
       
      }

      google.maps.event.addListener(marker, 'click', (function(marker, text) {
        return function() {
          infowindow.setContent(text);
          infowindow.open(map, marker);
        }
      })(marker, text));
    }

  </script>
  </div>
     <div class="contact" >
    <div class="body">
<div class="pic"><img  src="images/Home/call.jpg"  width="250px"> </div>
<div >
<h1 class="con">Contact us</h1>
<p class="con">+91-8096121946, 08096121946
Monday - Friday | 9am - 6pm</p>
<p class="con">online@property.com</p>
</div>
<div>
<p class="con">

onlinepropertysales. Pvt. Ltd. 
vissannpeta,Krishna, India, Pin - 508244
</p>
</div>
</div>
 </div> 
    
   
  </body>
</html>
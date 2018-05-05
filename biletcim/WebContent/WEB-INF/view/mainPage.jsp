
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.biletcim.entities.Port"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="tr">
<head>
  <title> Uygun Fiyatlı Biletin Adresi | Biletcim </title>
  
  <jsp:include page="/WEB-INF/view/include/header.jsp" />
  
</head>
<body>


<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


<div class="w-full">

	<div class="mh-0">
		<div class=" col-md-12 main-top-view ">
        	<div class="container p-0-left p-0-right p-0-bottom">
        		
                		
        				<div class="col-md-12">
                       		<div class="search-select">
                       			<div>
                       				<input type="button" class="search-select-btn focus-none serch-over-button" id="ticket-1" value="Tek Yön">
                       				<!--<input type="button" class="search-select-btn focus-none serch-over-button-deactive-center" id="ticket-2" value="Gidiş - Dönüş">-->
                       				<input type="button" class="search-select-btn focus-none serch-over-button-deactive-end" id="ticket-3" value="Gidiş - Dönüş">
                       			</div>
                       		</div>
                        	<div class="search-left">
                            <div class="row">
                            	<div id="one-way">
                            	<div class="col-md-4">
                            		<div class="form-group">
 									 <label class="green">Nereden</label>
 									 
 									 <div id="bloodhound">
 									 <input class="Text-plane-from typeahead " placeholder="Şehir veya Havalimanı" id="airline-from-Tek" required="required"/>
                                		
                                  	 </div>
 									 
								</div>
                            </div>
                            
                            <div class="col-md-4">
                            	<div class="form-group">
 									 <label class="green">Nereye</label>
 									  <div id="bloodhound">
 									 	<input class="Text-plane-to typeahead " placeholder="Şehir veya Havalimanı" id="airline-to-Tek" required="required"/>
                                  	  </div>
 									 
								</div>
                            </div>
                            <div class="col-md-2">
                            	<div class="form-group">
 									 <label class="green">Yolculuk Tarihi</label>
 									 <input class="Text-calender " placeholder="Tarih" id="date-depart-one" data-theme="calender-custom-style" data-lang="tr" data-large-mode="true" data-format="d.m.Y" data-jump="0" data-init-set="true" data-lock="from" onchange="control()" required="required"/>
								</div>
                            </div>
                            
                            
                            <div class="col-md-2 ">
                           <button type="button" class="btn btn-success btn-block bilet-search"  id="BiletAra-Tek"> Bilet Ara</button>
								</div>
                            	</div>
                            	
                            	
                            	<div id="two-way" hidden="true">
                            	<div class="col-md-3">
                            		<div class="form-group">
 									 <label class="green">Nereden</label>
 									 <input class="Text-plane-from" placeholder="Şehir veya Havalimanı" />
 									 
								</div>
                            </div>
                            
                            <div class="col-md-3">
                            	<div class="form-group">
 									 <label class="green">Nereye</label>
 									 <input class="Text-plane-to" placeholder="Şehir veya Havalimanı" />
								</div>
                            </div>
                            <div class="col-md-2">
                            	<div class="form-group">
 									 <label class="green">Yolculuk Tarihi</label>
 									 <input class="Text-calender" placeholder="Tarih" id="date-depart" data-theme="calender-custom-style" data-lang="tr" data-large-mode="true" data-format="d.m.Y" data-jump="0" data-init-set="true" data-lock="from" onchange="control()"/>
								</div>
                            </div>
                            <div class="col-md-2">
                            	<div class="form-group">
 									 <label class="green">Dönüş Tarihi</label>
 									 <input class="Text-calender" placeholder="Tek Yön" id="date-return" data-theme="calender-custom-style" data-lang="tr" data-large-mode="true" data-format="d.m.Y" data-jump="0" data-init-set="true" data-lock="from"/>
								</div>
                            </div>
                            
                            <div class="col-md-2 ">
                           <button type="button" class="btn btn-success btn-block bilet-search" id="btnSearch"> Bilet Ara</button>
								</div>
                            	</div>
                            
                           
                            </div>
                            
                            </div>
                        </div>
                		
              		
        	</div>
        
		</div>

	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="header-info"><h3>Yüzlerce Havayolunun Uçak Biletleri</h3></div>
		</div>	
	</div>
	
	<div class="row">
		<div class="col-md-2 col-sm-4 col-xs-4">
			<a href="#">
				<img class="img-responsive img-center" src="${pageContext.request.contextPath }/resources/img/airlines/anadolujet.png"/>
			</a>
		</div>
		<div class="col-md-2 col-sm-4 col-xs-4">
			<a href="#">
				<img class="img-responsive img-center" src="${pageContext.request.contextPath }/resources/img/airlines/atlasglobal.png"/>
			</a>
			
		</div>
		<div class="col-md-2 col-sm-4 col-xs-4">
			<a href="#">
				<img class="img-responsive img-center" src="${pageContext.request.contextPath }/resources/img/airlines/turkishairlines.png"/>
			</a>
			
		</div>
		<div class="col-md-2 col-sm-4 col-xs-4">
			<a href="#">
				<img class="img-responsive img-center" src="${pageContext.request.contextPath }/resources/img/airlines/pegasusairlines.png"/>
			</a>
			
		</div>
		<div class="col-md-2 col-sm-4 col-xs-4">
			<a href="#">
				<img class="img-responsive img-center" src="${pageContext.request.contextPath }/resources/img/airlines/onurair.png"/>
			</a>
			
		</div>
		<div class="col-md-2 col-sm-4 col-xs-4">
			<a href="#">
				<img class="img-responsive img-center" src="${pageContext.request.contextPath }/resources/img/airlines/lutfhansa.png"/>
			</a>
			
		</div>
		
		
	</div>
	<div class="row">
		
		<div class="col-md-12 ">
			<a href="#" >
				<div class="text-right all-airlines">Tüm Havayolu Firmaları <i class="fas fa-angle-right"></i></div>
			</a>
		</div>	
	</div>
	
</div>
	
<div class="container">
 <div class="row">
 	<div class="col-md-12 header-info">
 		<center><h3>Popüler Uçak Seferleri</h3></center>
	 </div>
	</div>
  <div class="row">
    <div class="col-md-4 p-0">
      <div class="mini-listview">
      <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		İstanbul - İzmir
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
     	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 		
      	 	</div>
      	 	<div class="mini-list-item-money">
				<b>196 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      	 <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		Ankara - İzmir
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
      	 		<b>210 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      	 <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		İstanbul - Ankara
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
      	 		<b>196 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      </div>
    </div>
    
    <div class="col-md-4 p-0">
      <div class="mini-listview">
      <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		İstanbul - İzmir
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
				<b>196 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      	 <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		Ankara - İzmir
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
      	 		<b>210 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      	 <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		İstanbul - Ankara
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
      	 		<b>196 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      </div>
    </div>
    
    <div class="col-md-4 p-0">
      <div class="mini-listview">
      <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		İstanbul - İzmir
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
				<b>196 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      	 <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		Ankara - İzmir
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
      	 		<b>210 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      	 <a href="#">
      	<div class="mini-listview-item row">
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 	<div class="mini-list-item-title">
      	 		İstanbul - Ankara
      	 	</div>
      	 	<div class="mini-list-item-info">
      	 		Uçak Bileti
      	 	</div>
      	 </div>
      	 <div class="col-md-6 col-sm-6 col-xs-6">
      	 <div class="mini-list-item-icon">
      	 		<div style="font-size:2em; color:#77bc1f">
 					 <i class="fas fa-angle-right"></i>
				</div>
      	 	</div>
      	 	<div class="mini-list-item-money">
      	 		<b>196 TL</b> 'den
      	 	</div>
      	 	
      	 	</div>
      	 </div>
      	 </a>
      </div>
    </div>
    
  </div>
</div>

<div class="container info-content">
	<div class="row">
		<div class="col-md-12">
		<div class="header-info"><center><h3>Biletcim Nedir?</h3></center></div>
		
		<div class="info-view-content">Biletcim, bütçenize uygun uçak biletini ararken hayatınızı kolaylaştırmak için kurulmuş online uçak bileti satın alma sistemidir. Biletcim internet sitesi ve mobil uygulamaları sayesinde, uçak bileti sorgulayıp, tüm seçenekleri bir arada görebilir, uçak biletinizi Biletcim üzerinden online olarak kolayca satın alabilirsiniz. Üstelik Biletcim bu işlemlerin hiçbiri için sizden komisyon almaz, yani "0 Komisyon" ile çalışır. İhtiyacınız olan her anda Biletcim Canlı Destek’ten 7/24 yardım alabilirsiniz. Firma firma gezmeyin, cam kenarı koltuk bulamayınca üzülmeyin, bayramda uçak bileti bulamayıp ailenizden uzakta kalmayın diye; Biletcim! </div>
		</div>
	</div>
	
</div>



<script type="text/javascript">

var states = [
<%
	ArrayList<Port> list = (ArrayList<Port>) request.getAttribute("Ports");

	//print the information about every category of the list
	for(Port port : list) {
	 
		
	 String Port_visibleName =  port.getPortName().toLowerCase()+"Havalimanı"
+" - "+""+port.getCode()+" - "+port.getCity().toLowerCase();
	 out.println("\""+Port_visibleName+"\",");
	}
	
 %>
 ];

</script>


<jsp:include page="/WEB-INF/view/include/footer.jsp" />

<jsp:include page="/WEB-INF/view/include/js.jsp" />

  
  
  
  <script>
 
  $(document).ready(function(){
	  
	  
	    $("p").click(function(){
	        $(this).hide();
	    });
	    
	    $("#BiletAra-Tek").click(function(){
	    	
	    	
	    	 
	    	 $('#loader').addClass( "is-visible" ).delay(150).fadeIn('slow');
	    	 
	    	var url   =   $(location).attr('host'); 
	    	var AirPortFromTek = "";
	    	var AirlinetoTek = "";
	    	var Datedepartone = "";
	    	
	    	AirPortFromTek = $("#airline-from-Tek").val();
	    	AirlinetoTek = $("#airline-to-Tek").val();
	    	Datedepartone = $("#date-depart-one").val();
	    	
	    	AirlineFromCode = AirPortFromTek.split(" - ");
	    	AirlineToCode = AirlinetoTek.split(" - ");
	    	
	    	DateFormatURL = Datedepartone.replace(/\./g, "");
	    	
	    	var AirlineFromJustCode =  AirlineFromCode[1].replace(/\(/g, "").replace(/\)/g, "");
	    	var AirlineToJustCode =  AirlineToCode[1].replace(/\(/g, "").replace(/\)/g, "");
	    	$('#loader').delay(150).fadeIn('slow');
	    	console.log("URL: "+url+"/ucuslar/"+AirlineFromJustCode+"-"+AirlineToJustCode+"/"+DateFormatURL);
	    	$(location).attr('href', 'http://'+url+"/biletcim/ucuslar/"+AirlineFromJustCode+"-"+AirlineToJustCode+"/"+DateFormatURL)
	    	
	        
	    	//alert($("#airline-from-Tek").val()+" - "+$("#airline-to-Tek").val()+" - "+$("#date-depart-one").val());
	       
	    });
	    
	});
  
  
	 function control() {
		
    var x = $("#date-depart").val;
		 console.log(x);
    $("#date-return").val = x;
		
	}	
	  
	  $(document).ready(function() {
		  $(".it").click(function() {
			  $(".it").addClass("yellow");
			  $(this).removeClass("yellow");
		  });
});
  $('#date-depart-one').dateDropper();
  $('#date-depart').dateDropper();
  $('#date-return').dateDropper();
  
  </script>
  
 
 
 <style type="text/css">
				
				
				/* When the body has the loading class, we turn
				   the scrollbar off with overflow:hidden */
	
	
.loader {
  z-index:99999;
  position: fixed;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
  background-color: rgba(119, 188, 31, 1);
  opacity: 0;
  
 
}

.loader.is-visible {
  opacity: 1 !important;
  visibility: visible !important;
  
}

.loader.is-hidden {
  opacity: 0;
  visibility: hidden;
  
}

svg {

  width: 100%;
  height: 100%;
 
}

               </style>
               
                <script src='http://cdnjs.cloudflare.com/ajax/libs/gsap/1.18.3/TweenMax.min.js'></script>
<script src='http://s3-us-west-2.amazonaws.com/s.cdpn.io/16327/MorphSVGPlugin.min.js'></script>
              
               
               
               <div class="loader is-hidden" role="alert" id="loader">
				 
				<svg class="mainSVG" viewBox="0 0 800 600" xmlns="http://www.w3.org/2000/svg">
				    
					 <defs>   
					   <circle id="dot"  cx="0" cy="0" r="5" fill="#fff"/>   
					</defs>
					
					  <circle id="mainCircle" fill="none" stroke="none" stroke-width="2" stroke-miterlimit="10" cx="400" cy="300" r="70"/>
					  <circle id="circlePath" fill="none" stroke="none" stroke-width="2" stroke-miterlimit="10" cx="400" cy="300" r="80"/>
					
					  <g id="mainContainer" >
					  
					<path id="plane" fill="#FFF"  d="M38.1,19.6c0.2-0.2,0.3-0.5,0.3-0.7s-0.1-0.6-0.3-0.7c-1.2-1-2.8-1.6-4.4-1.6l-8.7,0L12.2,0L8.2,0l6.3,16.5	l-5.9,0c-0.5,0-1.1,0.1-1.6,0.4L3.1,11L0,11l3.1,7.9L0,26.7l3.1,0l3.9-5.9c0.5,0.3,1,0.4,1.6,0.4l5.9,0L8.2,37.7h3.9l13-16.5l8.7,0	C35.4,21.2,36.9,20.6,38.1,19.6"/>      
					  </g>
					</svg>
				 
				</div>
               
				
				<script type="text/javascript">
				
				
				
				TweenMax.set('#circlePath', {
					  attr: {
					    r: document.querySelector('#mainCircle').getAttribute('r')
					  }
					})
					MorphSVGPlugin.convertToPath('#circlePath');

					var xmlns = "http://www.w3.org/2000/svg",
					  xlinkns = "http://www.w3.org/1999/xlink",
					  select = function(s) {
					    return document.querySelector(s);
					  },
					  selectAll = function(s) {
					    return document.querySelectorAll(s);
					  },
					  mainCircle = select('#mainCircle'),
					  mainContainer = select('#mainContainer'),
					  plane = select('#plane'),
					  mainSVG = select('.mainSVG'),
					  mainCircleRadius = Number(mainCircle.getAttribute('r')),
					  //radius = mainCircleRadius,
					  numDots = mainCircleRadius / 2,
					  step = 360 / numDots,
					  dotMin = 0,
					  circlePath = select('#circlePath')

					//
					//mainSVG.appendChild(circlePath);
					TweenMax.set('svg', {
					  visibility: 'visible'
					})
					TweenMax.set([plane], {
					  transformOrigin: '50% 50%'
					})

					var circleBezier = MorphSVGPlugin.pathDataToBezier(circlePath.getAttribute('d'), {
					  offsetX: -19,
					  offsetY: -18
					})

					//console.log(circlePath)
					var mainTl = new TimelineMax();

					function makeDots() {
					  var d, angle, tl;
					  for (var i = 0; i < numDots; i++) {

					    d = select('#dot').cloneNode(true);
					    mainContainer.appendChild(d);
					    angle = step * i;
					    TweenMax.set(d, {
					      attr: {
					        cx: (Math.cos(angle * Math.PI / 180) * mainCircleRadius) + 400,
					        cy: (Math.sin(angle * Math.PI / 180) * mainCircleRadius) + 300
					      }
					    })

					    tl = new TimelineMax({
					      repeat: -1
					    });
					    tl
					    .from(d, 0.2, {
					          attr:{
					            r:dotMin
					          },
					          ease:Power2.easeIn
					        })
					      .to(d, 1.8, {
					      attr: {
					        r: dotMin
					      },
					      ease: Power2.easeOut
					    })

					    mainTl.add(tl, i / (numDots / tl.duration()))
					  }
					  var planeTl = new TimelineMax({
					    repeat: -1
					  });
					  planeTl.to(plane, tl.duration(), {
					    bezier: {
					      type: "cubic",
					      values: circleBezier,
					      autoRotate: true
					    },
					    ease: Linear.easeNone
					  })
					  mainTl.add(planeTl, 0.05)
					}

					makeDots();
					mainTl.time(20);
					TweenMax.to(mainContainer, 30, {
					  rotation: -360,
					  svgOrigin: '400 300',
					  repeat: -1,
					  ease: Linear.easeNone
					})
					mainTl.timeScale(0.7);

					$('#loader').delay(75).fadeOut('fast');
					
				</script>
</body>
</html>

<c:forEach items="${Ports}" var="Port">
${Port.PortName}<br>
${Port.Code}<br>
</c:forEach>


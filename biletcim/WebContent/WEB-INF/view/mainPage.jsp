
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
 									 <input class="Text-plane-from typeahead " placeholder="Şehir veya Havalimanı" />
                                		
                                  	 </div>
 									 
								</div>
                            </div>
                            
                            <div class="col-md-4">
                            	<div class="form-group">
 									 <label class="green">Nereye</label>
 									  <div id="bloodhound">
 									 	<input class="Text-plane-to typeahead " placeholder="Şehir veya Havalimanı" />
                                  	  </div>
 									 
								</div>
                            </div>
                            <div class="col-md-2">
                            	<div class="form-group">
 									 <label class="green">Yolculuk Tarihi</label>
 									 <input class="Text-calender" placeholder="Tarih" id="date-depart-one" data-theme="calender-custom-style" data-lang="tr" data-large-mode="true" data-format="d.m.Y" data-jump="0" data-init-set="true" data-lock="from" onchange="control()"/>
								</div>
                            </div>
                            
                            
                            <div class="col-md-2 ">
                           <button type="button" class="btn btn-success btn-block bilet-search" > Bilet Ara</button>
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
                           <button type="button" class="btn btn-success btn-block bilet-search" > Bilet Ara</button>
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
				<b>28 TL</b> 'den
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
      	 		<b>50 TL</b> 'den
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
      	 		<b>40 TL</b> 'den
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
				<b>28 TL</b> 'den
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
      	 		<b>50 TL</b> 'den
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
      	 		<b>40 TL</b> 'den
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
				<b>28 TL</b> 'den
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
      	 		<b>50 TL</b> 'den
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
      	 		<b>40 TL</b> 'den
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
	 
		
	 String Port_visibleName =  port.getPortName().substring(0,1).toUpperCase() + port.getPortName().substring(1).toLowerCase()
+" "+"("+port.getCode()+") - "+port.getCity();
	 out.println("\""+Port_visibleName+"\",");
	}
	
 %>
 ];

</script>


<jsp:include page="/WEB-INF/view/include/footer.jsp" />

<jsp:include page="/WEB-INF/view/include/js.jsp" />

  
  
  
  <script>
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
</body>
</html>

<c:forEach items="${Ports}" var="Port">
${Port.PortName}<br>
${Port.Code}<br>
</c:forEach>


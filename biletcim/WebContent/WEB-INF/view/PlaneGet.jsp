<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="tr">
<head>
  <title>Üye Girişi | Biletcim </title>
  
  <jsp:include page="/WEB-INF/view/include/header.jsp" />
  
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/style.css">
   <link href="${pageContext.request.contextPath }css/colors/default.css" id="theme"  rel="stylesheet">
  
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/main.css">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/jquery.qtip.min.css">
	
  
  
  
  <!--Date Time Picker Css-->
  
  <style type="text/css">

.item-list {
  display: flex;
  flex-direction: column;
  width: 90%;
  margin: 5% auto;
}
.item {
  display: flex;
  align-items: center;
  padding: 0 10px;
  border-bottom: 1px solid #dddddd;
}
.item:hover {
  background: #dddded;
}
.item h5 {
  width: 80%;
  margin: 0;
  color: #666;
}

.alert-trigger {
  display: block;
  margin: 1em auto;
  text-align: center;
  color: #da0050;
  font-size: 14px;
  font-weight: bold;
  padding: 5px 15px;
  border-radius: 3px;
  background: #ffffff00;
  border: 2px solid;
  text-shadow: 0 1px 0 #ffffff;
  text-decoration: none;
}
.alert-trigger:hover {
  background: #ffffff;
}

.alert {
  position: fixed;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
  background-color: rgba(94, 110, 141, 0.9);
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.3s 0s, visibility 0s 0.3s;
}
.alert.is-visible {
  opacity: 1;
  visibility: visible;
  transition: opacity 0.3s 0s, visibility 0s 0s;
}

.alert-container {
  position: relative;
  width: 90%;
  max-width: 400px;
  top:40%;
  margin: 0em auto;
  background: #fff;
  color: #666;
  border-radius: 0.25em 0.25em 0.4em 0.4em;
  text-align: center;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
  transform: translateY(-40px);
  transition-property: transform;
  transition-duration: 0.3s;
  overflow: hidden;
}
.alert-container p {
  padding: 3em 1em;
}
.alert-container footer {
  display: flex;
  width: 100%;
  justify-content: center;
}
.alert-container footer a {
  display: block;
  height: 60px;
  line-height: 60px;
  text-transform: uppercase;
  color: #fff;
  font-weight: 700;
  text-shadow: 0 1px 0 rgba(0, 0, 0, 0.2);
  flex: 1;
  background: #56af43;
  text-decoration: none;
  transition: background-color 0.2s;
}
.alert-container footer a:hover {
  box-shadow: 0 0 100em 100em rgba(0, 0, 0, 0.2) inset;
}
.alert-container footer .alert-cancel {
  background: #fc5169;
}

.alert-container .alert-close {
  position: absolute;
  top: 8px;
  right: 8px;
  width: 30px;
  height: 30px;
  color: #8f9cb5;
  font-weight: 900;
  font-size: 1.5em;
  text-decoration: none;
}
.is-visible .alert-container {
  transform: translateY(0);
}


 .panel1{
  		background-color: #39434e !important;
  		color:white !important;
  		padding: 5px 10px 5px 10px !important;
  	}
</style>
  
</head>
<body class="container-fluid">

<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


		
<div class="container p-0 ">
			<div class="row ">
					<div class="col-md-12  m-t-15">
						<div class="white-box">
                           
                            <div class="row thin-steps">
                                <div class="col-md-6 column-step active">
                                    <div class="step-number">1</div>
                                    <div class="step-title">Kontrol</div>
                                    <div class="step-info">Yolcu Bilgilerini Doğrulama</div>
                                </div>
                                <div class="col-md-6 column-step">
                                    <div class="step-number">2</div>
                                    <div class="step-title">Check-in</div>
                                    <div class="step-info">Koltuk Seçimi</div>
                                </div>
                                
                            </div>
                        </div>
					</div>
			</div>		
				<div class="row ">
					<div class="col-md-12  m-t-15">
					<div class="panel panel-default block1">
                            <div class="panel-heading panel1"><b><p class="f-s-20 m-t-10">Yolcunun Bilgileri</p></b></div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                   <div class="row">
                                   	<div class="col-md-12">
                                   			
                 <div class="row">
                 	<div class="col-md-6">
                 		<div class="row">
                 			<div class="col-md-6 p-l-10 p-r-10">
                 				<div class="form-group">
				  					<label for="JName">Ad</label>
				  					<input placeholder="" type="text" name="Jname" class="form-control p-l-10 p-r-10" id="JName">
				 					
								</div>
                 			</div>
                 			<div class="col-md-6 p-l-10 p-r-10">
                 				<div class="form-group">
				  					<label for="Surname">Soyad</label>
				  					<input placeholder="" type="text" name="surname" class="form-control p-l-10 p-r-10" id="Surname">
				 					
								</div>
                 			</div>
                		</div>    
                 	</div>
                 	<div class="col-md-6">
	                 		<div class="row">
	                 			<div class="col-md-5 p-l-10 p-r-10" >
	                 				<div class="form-group">
					  					<label for="tcNo">Bilet Numarası</label>
					  					<input placeholder="" type="text" name="tcNo" class="form-control " id="tcNo" >
					 					
									</div>
	                 			</div>
	                 			<div class="col-md-2 p-l-2 p-r-2" >
	                 				<p class="m-t-25 text-center" >Veya</p>
	                 			</div>
	                 			
	                 			<div class="col-md-5  p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label for="bdate">Rezervasyon No(PNR)</label>
					  					<input placeholder="" type="text" name="bdate" class="form-control" id="bdate" >
					 					
									</div>
	                 			</div>
	                 			
	                		</div>  
                 	</div>
                 </div>
                 <div class="row">
                 	<div class="col-md-12">
                 		<img  src="${pageContext.request.contextPath }/resources/img/persons/persons.png" class="img-responsive" >
                 		
                 	</div>
                 </div>
                    
                 
											
											
				
                                   	</div>
                                   	
                                   	
                                   	
                                   </div>
                                </div>
                               
                            </div>
                        </div>
					</div>
			</div>

	
	<div class="row">
		<div class="col-md-12 col-sm-12">
		<div class="main-content boxTop17">
			<div>

				<map id="seatmap" name="seatmap">
				
					<c:forEach var="item" items="${SeatsList}">
					<c:if test="${item.id %2 == 0 }">
						<area class="area" data-info-data="${ item.description}" title="${ item.description}" id="${item.seat_number } ${item.seat_character} N"  shape="rect" coords="${item.coords }" alt="" data-maphilight='{"stroke":false,"fillColor":"545454","fillOpacity":1,"alwaysOn":true}'>
					</c:if>
					<c:if test="${item.id %2 != 0 }">
						<area class="area" data-info-data="${ item.description}" title="${ item.description}" id="${item.seat_number } ${item.seat_character} E"  shape="rect" coords="${item.coords }" alt="" >
					</c:if>
						
					</c:forEach>
				</map>
			</div>
                
            <div class="seat-wrapper">
            
                                <img  class="plane" src="${data}" usemap="#seatmap">



                    </div>
                    
                </div>
                
                
                
                <div class="alert" role="alert">
				  <div class="alert-container is-visible">
				    <p id="select_question"> </p>
				    <footer class="buttons">
				      <a href="#" class="alert-cancel">Hayır</a>
				      <a href="#" class="alert-confirm">Evet</a>
				    </footer>
				    <a href="#" class="alert-close img-replace">&times;</a>
				  </div>
				</div>
               
               
               
		</div>
	</div>
</div>



<jsp:include page="/WEB-INF/view/include/footer.jsp" />

<jsp:include page="/WEB-INF/view/include/js.jsp" />
  
  <script src="${pageContext.request.contextPath }/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath }/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath }/resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath }/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath }/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath }/resources/js/main.js"></script>
	<script src="${pageContext.request.contextPath }/resources/js/jquery.qtip.min.js"></script>
  
  
  <script src="${pageContext.request.contextPath }/resources/js/jquery.maphilight.min.js"></script>
               <script type="text/javascript">$(function() {
		
		
					$('.plane').maphilight({
			            fillColor: '008800',
			            strokeColor: '009e0a',
			        });
					
					
					
				});
               
               
               $(document).ready(function() {
            	    $("area").click(function(e) {
            	        
            	        var item_id = (event.target.id).split(" ");
            	        var seat_info = item_id[2];
            	       
            	        var seat_name = item_id[1];
            	        var seat_number = item_id[0];
            	        console.log(seat_info+" "+ seat_name+ " "+seat_number);
            	        
            	        if(seat_info == "E"){
            	        	 $(".alert").addClass("is-visible");
                       	   $(".alert .alert-confirm")
                       	     .attr("data-action", $(this).attr("data-action"))
                       	     .attr("data-item", $(this).attr("data-item"));
                       	$("#select_question").html("<h4>Seçilen Koltuk Numarası : <b>"+seat_number +""+seat_name +"</b> </h4></br> <h4>Kolduğu Seçmek istediğinize eminmisiniz ?</h4>");
            	        }else if(seat_info == "N"){
            	        	
            	        }
            	        e.preventDefault();
                 	  
            	    });
            	});
               
               
               $(".alert-trigger").on("click", function(e) {
            	   e.preventDefault();
            	   $(".alert").addClass("is-visible");
            	   $(".alert .alert-confirm")
            	     .attr("data-action", $(this).attr("data-action"))
            	     .attr("data-item", $(this).attr("data-item"));
            	 });
               
            	 $(".alert-confirm").on("click", function(e) {
            	   e.preventDefault();
            	   var d = $(this).attr("data-item");
            	   $(`.item-list a[data-item='${d}']`)
            	     .parent()
            	     .remove();
            	   $(".alert").removeClass("is-visible");
            	   console.log("OK");
            	   
            	 });
            	 $(".alert-close, .alert-cancel , .alert").on("click", e => {
            	   e.preventDefault();
            	   $(".alert").removeClass("is-visible");
            	   console.log("NO");
            	 });

            	 //press ESC
            	 $(document).keyup(event => {
            	   if (event.which == "27") $(".alert").removeClass("is-visible");
            	 });
            	 
            	 
            	 $(".area").qtip({
            	        style: {
            	            classes: 'qtip-dark'
            	        },
            	        events: {
            	            show: function(event, api) {
            	                api.set({
            	                    'content.text': api.elements.target.attr('title')
            	                });
            	            }
            	        }
            	    });

            	
            	
               </script>
              
              <jsp:include page="/WEB-INF/view/include/Loader.jsp" />
  
</body>
</html>


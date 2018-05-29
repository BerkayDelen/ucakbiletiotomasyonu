<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="tr">
<head>
  <title>Üye Giriri | Biletcim </title>
  
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
  	
  	.btn_checkin {
 
  cursor: pointer;
 
  border: 1px solid #ffffff;
  -webkit-border-radius: 8px;
  border-radius: 8px;
  
  color: rgba(255,255,255,0.9);
  -o-text-overflow: clip;
  text-overflow: clip;
  background: #77bc1f;
  
  -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
  -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
  -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
  transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);
}

.btn_checkin:hover {
  border: 1px solid rgba(119,188,31,1);
  color: rgba(119,188,31,1);
  background: #ffffff;
}
.check-in-text{
-webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1) !important;
  -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1) !important;
  -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1) !important;
  transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1) !important;
  }
.ckeck-in-text:active{
border: 1px solid rgba(119,188,31,1) !important;
  color: rgba(119,188,31,1) !important;
  background: #ffffff !important;
}
</style>
  
</head>
<body class="container-fluid">

<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


		
<div class="container p-0 ">
<form action="./" method="post">
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
				  					<input placeholder="" type="text" name="name" class="form-control p-l-10 p-r-10 ckeck-in-text" id="JName" required>
				 					
								</div>
                 			</div>
                 			<div class="col-md-6 p-l-10 p-r-10">
                 				<div class="form-group">
				  					<label for="Surname">Soyad</label>
				  					<input placeholder="" type="text" name="surname" class="form-control p-l-10 p-r-10 ckeck-in-text" id="Surname" required>
				 					
								</div>
                 			</div>
                		</div>    
                 	</div>
                 	<div class="col-md-6">
	                 		<div class="row">
	                 			<div class="col-md-6 p-l-10 p-r-10" >
	                 				<div class="form-group">
					  					<label for="tcNo">PNR Numarası</label>
					  					<input placeholder="" type="text" name="ticketNumber" class="form-control ckeck-in-text" id="tcNo" required>
					 					
									</div>
	                 			</div>
	                 			
	                 			
	                 			<div class="col-md-6  p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label for="bdate">&nbsp</label>
					  					<input  type="submit" name="btn_checkinControl" class="form-control btn_checkin" id="btn_checkinControl"  value="Check-in Yap" >
					 					
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

	
	</form>
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
               
              
             <!--  <jsp:include page="/WEB-INF/view/include/Loader.jsp" /> -->
  <script type="text/javascript">
	<%
	
	String Error =(String) request.getAttribute("Error");
	
	if(Error !=null){
		
	
	%>
	swal({
		  type: 'error',
		  title: 'Oops...',
		  text: '<%  out.print(Error);%>',
		  confirmButtonText : "Tamam"
		})
  		
  
	<%} %>
  function $_GET(param) {
		var vars = {};
		window.location.href.replace( location.hash, '' ).replace( 
			/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
			function( m, key, value ) { // callback
				vars[key] = value !== undefined ? value : '';
			}
		);

		if ( param ) {
			return vars[param] ? vars[param] : null;	
		}
		return vars;
	}
  var PNR = decodeURI($_GET('PNR'));
  var Name = decodeURI($_GET('Name'));
  var Surname = decodeURI($_GET('Surname'));
  
  var encodedUrl = encodeURIComponent(Name);
  console.log(decodeURIComponent(encodedUrl));
  
  var encodedUrl2 = encodeURIComponent(Surname);
  console.log(decodeURIComponent(encodedUrl2));
  if(PNR != "null" && Name != "null" && Surname != "null" ){
	  $('#JName').val(Name);
	  $('#Surname').val(Surname);
	  $('#tcNo').val(PNR);
  }
  
  </script>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="tr">
<head>
  <title>Üye Girişi | Biletcim </title>
  
  <jsp:include page="/WEB-INF/view/include/header.jsp" />
  
  
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
  
  
  
  <!--Date Time Picker Css-->
  
  
  <style type="text/css">
  
h1 {
	font-size: 34px;
	margin: 0;
	font-weight: 600;
}

h3 {
	font-size: 16px;
	margin: 0;
	font-weight: 700;
}

h4 {
	font-size: 11px;
	margin: 0;
	font-weight: 400;
}

h5 {
	font-size: 11px;
	font-weight: 600;
	margin: 25px 0 25px 0;
}

h6 {
	font-weight: 600;
	margin: 0;
}



.containerTicket {
	margin: 0 auto;
    width: 300px;
    background-color: white;
    position: relative;
    overflow: hidden;
}

.first {
	margin-top: 70px;
	height: 300px;
}

.second {
	margin-top: 0px;
	
	border-top: 1px solid #77bc1f;
	margin-bottom:35px;
}

.top {
	top: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #77bc1f;
}
.bottom {
	bottom: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #77bc1f;
}
.left {
	left: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #77bc1f;
}
.right {
	right: -10px;
	position: absolute;
    width: 18px;
    height: 18px;
    border-radius: 100%;
    background-color: #77bc1f;
}

.spacer {
	padding: 25px 20px 20px 20px;
}

.spacer2 {
	padding: 15px 20px 20px 20px;
}

.spacer > img {
	width: 45px;
    float: right;
    height: 45px;
    margin-right: 10px;
	
}

.name-flight {
	float: left;
}

.name-flight > h3 {
	text-transform: uppercase;
	color: #4b4091;
}

.name-flight > h4 {
	color: #7c7c7c;
	margin-top: -5px;
}

h4 > span {
	font-size: 15px;
	font-weight: 700;
	color: #d9118d;
}

.destination {
	margin-top: 70px;
}

.from {
	float: left;
	width: 33%;
	color: #5d6474;
}

.center {
	float: left;
	width: 33%;

}

i {
	color: #5d6474;
	padding-top: 15px;
	padding-left: 25%;
}

.to {
	float: left;
	width: 33%;
	color: #5d6474;
}

.from > span {
	font-size: 12px;
	font-weight: 600;
}

.to > span {
	font-size: 12px;
	font-weight: 600;
}

.left-side {
	float: left;
	width: 33%;
}

h5 > span {
	font-weight: 700;
	font-size: 15px;
	color: #da0d8d;
}


.right-side {
	float: right;
	width: 33%;
}



.spacer2 > h3 {
	color: #4b4091;
	text-transform: uppercase;
	text-align: center;
}
.spacer2 > h5 {
	color: #4b4091;
	
	text-align: center;
}

.flight-gate {
	float: left;
	width: 66%;
	margin-top: 15px;
}

.flight-gate > h5 {
	margin: 0 0 5px 0;
}

.text-barcode > img {
	
	width: 100%;
	
}

  </style>
</head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
      
<body class="container-fluid" style=" background-color:  #77bc1f;">

<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


		
<div class="container p-0 ">
	
	<div class="row">
		<div class="col-md-12 col-sm-12">
			
				<div class="containerTicket first">
				<div class="top left corner"></div>
			    <div class="top right corner"></div>
			    <div class="bottom left corner"></div>
			    <div class="bottom right corner"></div>
			    <div class="spacer">
			    	<img class="center-block" src="${pageContext.request.contextPath }/resources/img/airlineslogos/${data_Seat.ticket.company.companyImg }"  width="30" height="30"/>
			    	
			    	<div class="name-flight">
			    		<h3>${data_Seat.user.sales_user_Name} ${data_Seat.user.sales_user_Surname}</h3>
			    		<br>
			    		<h4>Uçuş Numarası: <span>${data_Seat.ticket.ticketNumber}</span></h4>
			    	</div>
			    	<div class="destination">
			    		<div class="from">
			    			<h1>${data_Seat.ticket.kalkisYeri.substring(data_Seat.ticket.kalkisYeri.length() - 3)}</h1>
			    			<h6>${data_Seat.ticket.kalkisYeri.substring(0,data_Seat.ticket.kalkisYeri.length() - 3)}</h6>
			    		</div>
			    		<div class="center">
			    			<i class="material-icons">flight_takeoff</i>
			    		</div>
			    		<div class="to">
			    			<h1>${data_Seat.ticket.varisYeri.substring(data_Seat.ticket.varisYeri.length() - 3)}</h1>
			    			<h6>${data_Seat.ticket.varisYeri.substring(0,data_Seat.ticket.varisYeri.length() - 3)}</h6>
			    		</div>
			    	</div>
			    	<div class="details">
			    		<div class="left-side">
				    		<h5>Tarih:</br><span>${data_Seat.ticket.ticketDate}</span></h5>
				    		<h5>Sınıf:</br><span>${data_Seat.ticket.sinif}</span></h5>
			    		</div>
			    		<div class="right-side">
				    		<h5>Kalkış Saati:</br><span>${data_Seat.ticket.kalkisZamani}</span></h5>
				    		<h5>Koltuk:</br><span>${data_Seat.seat_Number}</span></h5>
			    		</div>
			    	</div>
			    </div>
			</div>
			<div class="containerTicket second">
				<div class="top left"></div>
			    <div class="top right"></div>
			    <div class="bottom left"></div>
			    <div class="bottom right"></div>
			    <div class="spacer2">
			    	<h3>${data_Seat.user.sales_user_Name} ${data_Seat.user.sales_user_Surname}</h3>
			    	<h5>Uçuş Numarası: <span>${data_Seat.ticket.ticketNumber}</span></h5>
			    	<div class="text-barcode">
			    		<img src="https://chart.googleapis.com/chart?chs=260x260&cht=qr&chl=${data_Seat.user.sales_uuid}&choe=UTF-8">
			    	</div>
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
  
  
  
  
</body>
</html>

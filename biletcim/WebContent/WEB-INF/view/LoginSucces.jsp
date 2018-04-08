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
  
  
  
</head>
<body class="container-fluid">

<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


		
	<div class="row">
	<div class="col-md-4 col-md-offset-4 col-sm-12">
		
			<div class="center-in p-l-15 p-r-15 p-t-55 p-b-20">
				
					<span class="login100-form-title p-b-32">
						<center>Üye Girişi Başarılı</center>
					</span>

					
			</div>
			
			</div>
		</div>
	
<div class="social-networks">
<div class="row">
	
	<span class="register-tittle p-b-32">
						<center>Hesabın yokmu hemen <a href="${pageContext.request.contextPath }/register">Üye Ol</a></center>
					</span>
</div>
<div class="row">
	
		<div class="col-md-4 col-md-offset-4 facebook-btn-div">
    	   
		        <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
			        
			        <span ><i class="fab fa-facebook-square"></i>  Facebook ile Giriş Yap</span>
		        </a>
	        
        	
		</div>
</div>
<div class="row">
	
		<div class="col-md-4 col-md-offset-4 twitter-btn-div">
    	   
		        <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
			        
			        <span ><i class="fab fa-twitter-square"></i>  Twitter ile Giriş Yap</span>
			        
		        </a>
	        
        	
		</div>
</div>
<div class="row">
	
		<div class="col-md-4 col-md-offset-4 google-btn-div">
    	   
		        <a href="#" class="btn btn-lg btn-block omb_btn-facebook">
			        <span ><i class="fab fa-google-plus-g"></i>  Google ile Giriş Yap</span>
		        </a>
	        
        	
		</div>
</div>
ok
<c:out value="${Login}"></c:out>
ok
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
  
  
  
  <jsp:include page="/WEB-INF/view/include/Loader.jsp" />
</body>
</html>

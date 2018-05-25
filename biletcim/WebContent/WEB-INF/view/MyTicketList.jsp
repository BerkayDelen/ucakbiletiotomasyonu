<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="tr">
<head>
  <title>Biletlerim | Biletcim </title>
  
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


		
<div class="container p-0 ">
	
	<div class="row">
		<div class="col-md-12 col-sm-12" style="min-height: 680px ">
		<div class="row">
			<div class="col-md-12 col-sm-12">
				<span>
					<h1>Biletlerim</h1>
					<hr>
				</span>
			</div>
		</div>
				<table class="table table-bordered m-t-5">
    <thead>
      <tr>
      	
        <th>Ad</th>
        <th>Soyad</th>
        <th>Email</th>
        <th>TC</th>
        
        <th>Cinsiyet</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      
      <c:forEach var="ticketItem" items="${TicketsList}">
      <tr>
        <td>${ticketItem.user.sales_user_Name }</td>
       	<td>${ticketItem.user.sales_user_Surname }</td>
       	<td>${ticketItem.user.sales_user_Email }</td>
       	<td>${ticketItem.user.sales_user_TC }</td>
       	<c:if test="${ticketItem.user.sales_user_gender == true }">
					
						<td><p class="text-info">Erkek</p></td>
		</c:if>
		<c:if test="${ticketItem.user.sales_user_gender == false }">
					
						<td><p class="text-danger">Kadın</p></td>
		</c:if>
       	
       	<td><center><a class="btn btn-warning" href ="${pageContext.request.contextPath }/plane/check-in/ticket?Key=${ticketItem.user.sales_uuid }">Detay</a></center></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
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

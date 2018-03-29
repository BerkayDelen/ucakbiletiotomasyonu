<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="tr">
<head>
  <title>Bilet Satınal | Biletcim </title>
  
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
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

 
  
  
  <style type="text/css">

  
  
  
  
  
  
  
  
  .panel1{
  background-color: #39434e !important;
  color:white !important;
  padding: 5px 10px 5px 10px !important;
  }
  </style>
</head>
<body class="container-fluid">


<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


		
<div class="container p-0 m-t-15">
<form action="">
<div class="row">

		<div class="col-md-12 m-0 p-0">
						<div class="panel panel-default block1">
                            <div class="panel-heading panel1"><b><h4>Seçilen Bilet</h4></b></div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                   		
                                   		<div class="row">
											<div class="col-md-4 col-sm-4 col-xs-3 ">
												<div class="TicketLDTInfo ">
													<div class="TicketLDTLogo ">
														<img class="center-block" src="${pageContext.request.contextPath }/resources/img/airlineslogos/${biletim.company.companyImg }"  width="30" height="30"/>
													</div>
													<div class="TicketLDTName">
														<div class="center-block text-center">
														
															${biletim.company.companyName }
														
															
														</div>
													</div>
												</div>
											</div>
											<div class="col-md-4 col-sm-4 col-xs-6">
												<div class="TicketTimeInfo row">
													<div class="col-xs-12 text-center ">
														<span>${biletim.kalkisZamani}</span>	
														<img   src="${pageContext.request.contextPath }/resources/img/icons/plane-to.png"  width="21" height="21" style="margin-top: -2px;"/>
														<span>${biletim.varisZamani}</span>
													</div>
												</div>
												<div class="TicketDurationInfo row">
													<div class="col-xs-12 text-center">
													<span>${biletim.sure}</span>
													</div>
												</div>
												<div class="TicketAirportsInfo row">
													<div class="col-xs-12 text-center">
														<span >${biletim.kalkisYeri} </span><span class="hidden-xs"></span>	
														<i class="fas fa-angle-right"></i>
														<span >${biletim.varisYeri} </span><span class="hidden-xs"></span>
													</div>
												</div>
											</div>
											<div class="col-md-4 col-sm-4 col-xs-3 ">
												<div class="TicketMoneyInfo row">
													<div class="col-md-12 p-0">
														<div class="w-full">
														<div class="money-big text-center">${biletim.fiyat}<span class="money-kuru">TL</span></div>
														</div>
																
																
														
														
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
		<div class="col-md-8 p-r-15">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-12">
					<div class="panel panel-default block1">
                            <div class="panel-heading panel1"><b><h4>Bilet Bilgileri (Ekonomik)</h4></b></div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                   <div class="row">
                                   	<div class="col-md-4">
                                   			<p><b>Bilet hakkında</b></p>
											<p>Uçuş No : ${biletim.ticketNumber}</p>
											
											<p>Uçuş Şirketi : ${biletim.company.companyName }</p>
											
											<p>Uçuş Güzergahı : 
											<span >${biletim.kalkisYeri} </span>
											<span class="hidden-xs"></span>	
											<i class="fas fa-angle-right"></i>
											<span >${biletim.varisYeri} </span><span class="hidden-xs"></span></p>
											
											<p>Kalkış Saati : ${biletim.kalkisZamani}</p>
											<p>Varış Saati : ${biletim.varisZamani}</p>
											
											
											
				
                                   	</div>
                                   	
                                   	<div class="col-md-4">
                                   			<p><b>Ücret Kuralları</b></p>
                                   			<p><i class="fas fa-times" style="color:Tomato"></i> Değişiklik yapılamaz</p>
											<p><i class="fas fa-times" style="color:Tomato"></i> İade edilemez</p>
											
											<p><i class="fas fa-check" style=" color: #53c172;"></i> Uçulabilir</p>
											
											
				
                                   	</div>
                                   	
                                   	<div class="col-md-4">
                                   	
											<p><b>Uçuş kabini hakkında</b></p>
											
											<p>Uçak Model: ${biletim.ucakModelName}</p>
											<p>Uçak Model Tipi: ${biletim.ucakModelType}</p>
				
                                   	</div>
                                   	
                                   </div>
                                </div>
                               
                            </div>
                        </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
					<div class="panel panel-default block1">
                            <div class="panel-heading panel1"><b><h4>Bilet Kişi Bilgileri</h4></b></div>
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
	                 			<div class="col-md-6 p-l-10 p-r-10" >
	                 				<div class="form-group">
					  					<label for="tcNo">TC Kimlik No</label>
					  					<input placeholder="" type="text" name="tcNo" class="form-control " id="tcNo">
					 					
									</div>
	                 			</div>
	                 			
	                 			<div class="col-md-6  p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label for="bdate">Doğum Tarihi</label>
					  					<input placeholder="" type="date" name="bdate" class="form-control" id="bdate">
					 					
									</div>
	                 			</div>
	                 			
	                		</div>  
                 	</div>
                 </div>  
                    
                 <div class="row">
                 	<div class="col-md-6">
                 		<div class="row">
                 			<div class="col-md-12 p-l-10 p-r-10">
                 				<div class="form-group">
				  					<label for="JName">E-Mail</label>
				  					<input placeholder="" type="text" name="Jname" class="form-control p-l-10 p-r-10" id="JName">
				 					
								</div>
                 			</div>
                 			
                		</div>    
                 	</div>
                 	<div class="col-md-6">
	                 		<div class="row">
	                 			
	                 			<div class="col-md-12 p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label >Cinsiyet</label>
					  					<div class="row">
					  						<div class="col-md-4 m-l-r-auto">
					  					<label class="radio-inline  sizefull p-t-7">
					      					<input type="radio" name="optradio">Erkek
					    				</label>
					  						</div>
					  						<div class="col-md-4 m-l-r-auto">
					  					<label class="radio-inline sizefull p-t-7">
									      <input type="radio" name="optradio">Kadın
									    </label>
					  						</div>
					  					</div>
					  					
									    
					 					
									</div>
	                 			</div>
	                		</div>  
                 	</div>
                 </div>             			
            	
				
				
				
				
				
				
				
				
				
				
				
				
				
											
											
											
				
                                   	</div>
                                   	
                                   	
                                   	
                                   </div>
                                </div>
                               
                            </div>
                        </div>
					</div>
				</div>
			</div>
		</div>
						
		</div>
	
		<div class="col-md-4 p-0">
		<div class="panel panel-default block1">
                            <div class="panel-heading panel1"><b><h4>Ödeme Bilgileri</h4></b></div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                   		
                                   		<div class="card-wrapper"></div>

        <div class="form-container active m-t-15 p-l-5 p-r-5">
            
            	<div class="form-group">
  					<label for="cardnumber">Kart Numarası :</label>
  					<input placeholder="**** **** **** ****" type="tel" name="Cardnumber" class="form-control" id="cardnumber">
 					
				</div>
				<div class="form-group">
  					<label for="fullname">Ad Soyad :</label>
  					<input placeholder="" type="text" name="Cardname" class="form-control" id="fullname">
 					
				</div>
			
				<div class="row">
					<div class="col-md-7  col-sm-7 p-r-5">
				
						<div class="form-group">
		  					<label for="validthru">Son Kullanma Tarihi :</label>
		  					<input placeholder="__ /__ " type="tel" name="Cardexpiry" class="form-control" id="validthru" maxlength="7" style="width: 70px !important">
		 					
						</div>
				
					</div>
					<div class="col-md-2 col-sm-2"></div>
					<div class="col-md-3  col-sm-3 p-l-5">
					
						<div class="form-group">
		  					<label for="cvc">CVC :</label>
		  					<input placeholder="" type="number" name="Cardcvc" class="form-control" id="cvc" maxlength="3" style="width: 70px !important">
		 					
						</div>
					
					</div>
					
				</div>
				<div class="form-group">
  					<input type="submit" value="Satın Al" class="login100-form-btn form-control">
 					<!--<button class="login100-form-btn form-control">
							<div clas="row">
							<div class="col-md-3">
							 <img alt="" src="${pageContext.request.contextPath }/resources/img/icons/guardsc.png" style="
    width: 25px;
    height: 30px;
"> 
							</div>
							<div class="col-md-6">
							<p class="text-center">Satın Al</p>
							</div>
							<div class="col-md-3">
								
							</div>
							</div>
						</button>
						-->
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
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath }/resources/js/card.js"></script>
	
	
	
	
	<script>
        new Card({
            form: document.querySelector('form'),
            container: '.card-wrapper',
            formSelectors: {
                numberInput: 'input[name="Cardnumber"]', // optional — default input[name="number"]
                expiryInput: 'input[name="Cardexpiry"]', // optional — default input[name="expiry"]
                cvcInput: 'input[name="Cardcvc"]', // optional — default input[name="cvc"]
                nameInput: 'input[name="Cardname"]' // optional - defaults input[name="name"]
            },
            debug:true
        });
    </script>
  
  
  
  
</body>
</html>

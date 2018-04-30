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

  
  
  
  
  
  
  
  
 
  </style>
</head>
<body class="container-fluid">


<jsp:include page="/WEB-INF/view/include/navbartop.jsp" />


		
<div class="container p-0 m-t-15">
<form action="" method="post">
<input type="hidden" name="ticketNumber" value="${biletim.ticketNumber }">
<div class="row">

		<div class="col-md-12 ">
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
		<div class="col-md-8 p-0">
		<div class="row">
			<div class="col-md-12 p-0">
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
											<p>Uçuş Günü : ${biletim.ticketDate}</p>
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
					<div class="col-md-12 ">
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
				  					<input placeholder="" type="text" name="name" class="form-control p-l-10 p-r-10" id="JName" required="required">
				 					
								</div>
                 			</div>
                 			<div class="col-md-6 p-l-10 p-r-10">
                 				<div class="form-group">
				  					<label for="Surname">Soyad</label>
				  					<input placeholder="" type="text" name="surname" class="form-control p-l-10 p-r-10" id="Surname" required="required">
				 					
								</div>
                 			</div>
                		</div>    
                 	</div>
                 	<div class="col-md-6">
	                 		<div class="row">
	                 			<div class="col-md-6 p-l-10 p-r-10" >
	                 				<div class="form-group">
					  					<label for="tcNo">TC Kimlik No</label>
					  					<input placeholder="" type="text" name="tcNo" class="form-control " id="tcNo" >
					 					
									</div>
	                 			</div>
	                 			
	                 			<div class="col-md-6  p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label for="bdate">Doğum Tarihi</label>
					  					<input placeholder="" type="date" name="bdate" class="form-control" id="bdate" >
					 					
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
				  					<input placeholder="" type="text" name="Email" class="form-control p-l-10 p-r-10" id="Email" required="required">
				 					
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
					      					<input type="radio" name="optradio" value="1">Erkek
					    				</label>
					  						</div>
					  						<div class="col-md-4 m-l-r-auto">
					  					<label class="radio-inline sizefull p-t-7">
									      <input type="radio" name="optradio" value="0">Kadın
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
	
		<div class="col-md-4">
		<div class="panel panel-default block1">
                            <div class="panel-heading panel1"><b><h4>Ödeme Bilgileri</h4></b></div>
                            <div class="panel-wrapper collapse in">
                                <div class="panel-body">
                                   		
                                   		<div class="card-wrapper"></div>

        <div class="form-container active m-t-15 p-l-5 p-r-5">
            
            	<div class="form-group">
  					<label for="cardnumber">Kart Numarası :</label>
  					<input placeholder="**** **** **** ****" type="tel" name="Cardnumber" class="form-control" id="cardnumber" required="required"> 
 					
				</div>
				<div class="form-group">
  					<label for="fullname">Ad Soyad :</label>
  					<input placeholder="" type="text" name="Cardname" class="form-control" id="fullname" required="required">
 					
				</div>
			
				<div class="row">
					<div class="col-md-7  col-sm-7 p-0">
				
						<div class="form-group">
		  					<label for="validthru">Son Kullanma Tarihi :</label>
		  					<input placeholder="__ /__ " type="tel" name="Cardexpiry" class="form-control" id="validthru" maxlength="7" style="width: 70px !important" required="required">
		 					
						</div>
				
					</div>
					<div class="col-md-2 col-sm-2"></div>
					<div class="col-md-3  col-sm-3 p-l-5">
					
						<div class="form-group">
		  					<label for="cvc">CVC :</label>
		  					<input placeholder="" type="number" name="Cardcvc" class="form-control" id="cvc" maxlength="3" style="width: 70px !important" required="required">
		 					
						</div>
					
					</div>
					
				</div>
				<div class="form-group">
  					<input type="submit" value="Satın Al" class="login100-form-btn form-control" id="btn_Buy">
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
        
       
        $(document).ready(function(){
        	
        	var b_name 		= false;
        	var b_surname	= false;
        	//var b_tcNo		= false;
        	var b_Email		= false;
        	var b_optradio	= false;//aa
        	var b_Cardnumber= false;
        	var b_Cardname	= false;
        	var b_Cardexpiry= false;
        	var b_Cardcvc	= false;
        	var b_bdate	= false;
        	
        	function controlAll(){
        		if(b_name && b_surname 
        				
        				&& b_Email
        				&& b_Cardnumber
        				&& b_Cardname
        				&& b_Cardexpiry
        				&& b_Cardcvc
        				&& b_bdate
        				&& b_optradio){
        			console.log("YES")
        			return true;
        		}else{
        			
        			console.log("no")
        			return false;
        		}
        	}
        	
        	
        	function validationControler($elementInputName){
        		if($("input[name="+$elementInputName+"]").val().trim() == ""){
        		
        			$(this).css("border","red solid 1px");
        		}
        		/*
        		$("input[name="+$elementInputName+"]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		$("#btn_Buy").attr("disabled", false);
                	}
            	});*/
        		
        	}
        	
        	function validationControlers(){
        		$("input[name=name]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_name=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_name=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		
        		$("input[name=surname]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_surname=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_surname=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		
        		/*$("input[name=tcNo]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_tcNo=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_tcNo=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});*/
        		
        		$("input[name=Email]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_Email=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_Email=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		
        		$("input[name=Cardnumber]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_Cardnumber=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_Cardnumber=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		
        		$("input[name=Cardname]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_Cardname=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_Cardname=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		$("input[name=Cardexpiry]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_Cardexpiry=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_Cardexpiry=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		$("input[name=Cardcvc]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_Cardcvc=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_Cardcvc=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		$("input[name=bdate]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_bdate=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_bdate=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		
        		
        		$("input[name=bdate]").focusout(function(e){
            		if($(this).val().trim() == ""){
            			$(this).css("border","red solid 1px");
            			$("#btn_Buy").attr("disabled", true);
            			b_bdate=false;
                	}else{
                		$(this).css("border","#ccc solid 1px");
                		b_bdate=true;
                		if(controlAll()){
                			$("#btn_Buy").attr("disabled", false);
                		}
                		
                	}
            	});
        		
        		$( "input[name=optradio]" ).on( "click", function() {
        			b_optradio=true;
           		 console.log($( "input:checked" ).val() + " is checked!" );
           		if(controlAll()){
        			$("#btn_Buy").attr("disabled", false);
        		}
           		});
        		
        		
        	}
        	
        	
        	console.log($( "input:checked" ).val() + " is checked!" );
        	console.log($("input[name=optradio]").val());
        	console.log($("input[name=bdate]").val());
        	validationControlers();
        	/*
        	validationControler("name");
        	validationControler("surname");
        	validationControler("tcNo");
        	validationControler("Email");
        	validationControler("optradio");
        	validationControler("Cardnumber");
        	validationControler("Cardname");
        	validationControler("Cardexpiry");
        	validationControler("Cardcvc");
        	
        	$("input[name=name]").val(  "Berkay");
        	$("input[name=surname]").val( "Delen");
        	$("input[name=tcNo]").val( "18581279012");
        	$("input[name=bdate]").val( "1997-09-08");
        	$("input[name=Email]").val( "berkaydelen@hotmail.com");
        	//$("input[name=optradio]").val( "1");
        	$("input[name=Cardnumber]").val( "3551513513513513");
        	$("input[name=Cardname]").val( "Berkay DELEN");
        	$("input[name=Cardexpiry]").val( "0809");
        	$("input[name=Cardcvc]").val( "123");
        	*/
        	$( "form" ).submit(function( event ) {
        		if($("input[name=tcNo]").val().trim() != ""){
        			$("input[name=tcNo]").css("border","red solid 1px");
            		return;
        			
            	}
        		event.preventDefault();
            		
            	
        		 
        		});
        	
        	
        	
            $("#btn_Buy").click(function(){
            	
            	validationControlers();
            	
            	validationControler("name");
            	validationControler("surname");
            	//validationControler("tcNo");
            	validationControler("Email");
            	validationControler("optradio");
            	validationControler("Cardnumber");
            	validationControler("Cardname");
            	validationControler("Cardexpiry");
            	validationControler("Cardcvc");
            	
            	if(controlAll()){
            		$("#btn_Buy").submit();
        		}
            	
            	
            	
                /*$.post("http://localhost:8080/biletcim/Buy/",
                {
                	name: 		$("input[name=name]").val(),
                	surname: 	$("input[name=surname]").val(),
                	tcNo: 		$("input[name=tcNo]").val(),
                	bdate: 		$("input[name=bdate]").val(),
                	Email: 		$("input[name=Email]").val(),
                	optradio: 	$("input[name=optradio]").val(),
                	Cardnumber: $("input[name=Cardnumber]").val(),
                	Cardname: 	$("input[name=Cardname]").val(),
                	Cardexpiry: $("input[name=Cardexpiry]").val(),
                	Cardcvc: 	$("input[name=Cardcvc]").val()
                },
                function(data,status){
                    alert("Data: " + data + "\nStatus: " + status);
                });*/
            });
        });
        
    </script>
  
  
  
 <!--  <jsp:include page="/WEB-INF/view/include/Loader.jsp" /> -->
</body>
</html>

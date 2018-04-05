<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Api Page</title>
</head>
<body>

<form:form action="" method="post" modelAttribute="login" cssClass="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-32">
						<center>Üye Girişi</center>
					</span>

					<span class="txt1 p-b-11">
						Email
					</span>
					<div class="wrap-input100 validate-input m-b-36" data-validate = "Email is required">
						<form:input path="User_ticket_Name" cssClass="input100"/>
						<span class="focus-input100"></span>
					</div>
					
					<span class="txt1 p-b-11">
						Şifre
					</span>
					<div class="wrap-input100 validate-input m-b-12" data-validate = "Password is required">
						<span class="btn-show-pass">
							<i class="fa fa-eye"></i>
						</span>
						<form:password path="User_ticket_Surname" cssClass="input100"/>
						<span class="focus-input100"></span>
					</div>
					
					<div class="flex-sb-m w-full p-b-48">
						<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="rememberMe" value="false">
							
							
							<label class="label-checkbox100" for="ckb1">
								Beni Hatırla
							</label>
						</div>

						<div>
							<a href="#" class="txt3">
								Şifremi unuttum.
							</a>
						</div>
					</div>
					
					<div clas="col-md-12">
						<p class="error">${ LoginError }<p>
					</div>
					
					<div class="col-md-12 p-0">
						<button class="login100-form-btn">
							Giriş Yap
						</button>
					</div>

				</form:form>
				
				
				<form:form action="" method="post" modelAttribute="login" cssClass="login100-form validate-form flex-sb flex-w">	
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
				  					<form:input path="User_ticket_Name" placeholder="" type="text" name="Jname" class="form-control p-l-10 p-r-10" id="JName"/>
				 					
								</div>
                 			</div>
                 			<div class="col-md-6 p-l-10 p-r-10">
                 				<div class="form-group">
				  					<label for="Surname">Soyad</label>
				  					<form:input path="User_ticket_Surname" placeholder="" type="text" name="surname" class="form-control p-l-10 p-r-10" id="Surname"/>
				 					
								</div>
                 			</div>
                		</div>    
                 	</div>
                 	<div class="col-md-6">
	                 		<div class="row">
	                 			<div class="col-md-6 p-l-10 p-r-10" >
	                 				<div class="form-group">
					  					<label for="tcNo">TC Kimlik No</label>
					  					<form:input path="User_ticket_TC" placeholder="" type="text" name="tcNo" class="form-control " id="tcNo" />
					 					
									</div>
	                 			</div>
	                 			
	                 			<div class="col-md-6  p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label for="bdate">Doğum Tarihi</label>
					  					<form:input path="User_ticket_Birthday" placeholder="" type="date" name="bdate" class="form-control" id="bdate" />
					 					
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
				  					<form:input path="User_ticket_Email" placeholder="" type="text" name="Jname" class="form-control p-l-10 p-r-10" id="JName"/>
				 					
								</div>
                 			</div>
                 			
                		</div>    
                 	</div>
                 	<div class="col-md-6">
	                 		<div class="row">
	                 			
	                 			<div class="col-md-12 p-l-10 p-r-10">
	                 				<div class="form-group">
					  					<label >Cinsiyet</label>
					  					
					  					
									    
					 					
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
	
	
	</form:form>
</body>
</html>
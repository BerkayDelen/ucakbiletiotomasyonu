// JavaScript Document
$(document).ready(function() {
	
	
	
	$("#ticket-1").click(function() {
		$("#one-way").show();
		$("#two-way").hide();
		
		$("#ticket-1").addClass("serch-over-button");
		$("#ticket-1").removeClass("serch-over-button-deactive");
		
		$("#ticket-2").addClass("serch-over-button-deactive-center");
		$("#ticket-2").removeClass("serch-over-button-center");
		
		$("#ticket-3").addClass("serch-over-button-deactive-end");
		$("#ticket-3").removeClass("serch-over-button-end");
		
	
	});
	$("#ticket-2").click(function() {
		$("#ticket-1").addClass("serch-over-button-deactive");
		$("#ticket-1").removeClass("serch-over-button");
		
		$("#ticket-2").addClass("serch-over-button-center");
		$("#ticket-2").removeClass("serch-over-button-deactive-center");
		
		$("#ticket-3").addClass("serch-over-button-deactive-end");
		$("#ticket-3").removeClass("serch-over-button-end");
	
	});
	
	$("#ticket-3").click(function() {
		$("#one-way").hide();
		$("#two-way").show();
		
		$("#ticket-1").addClass("serch-over-button-deactive");
		$("#ticket-1").removeClass("serch-over-button");
		
		$("#ticket-2").addClass("serch-over-button-deactive-center");
		$("#ticket-2").removeClass("serch-over-button-center");
		
		$("#ticket-3").addClass("serch-over-button-end");
		$("#ticket-3").removeClass("serch-over-button-deactive-end");
		
		
	
	});
	
	
	
	
	
  
	
});
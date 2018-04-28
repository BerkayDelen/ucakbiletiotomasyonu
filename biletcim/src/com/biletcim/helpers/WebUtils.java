package com.biletcim.helpers;



import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.biletcim.entities.Ticket;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebUtils {

    private static HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    private static String getClientIp() {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
    
    
    
    public String FirstUpper(String text) {
    
    	String textc  = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
    	System.out.println(text);
    
    	return	textc;
    
    }
    
    public  void MailSender(Ticket bilet, String userFullName, String email) {
    	final String username = "biletcim.berkaydelen@gmail.com";
	final String password = "Biletcim.123";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
	  new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	  });

	try {

		MimeMessage  message = new MimeMessage(session);
		message.setFrom(new InternetAddress("biletcim.berkaydelen@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(email	));
		
		message.setSubject("Biletcim Uçak Bileti Satýn Alým");
		message.setText("<head>\r\n" + 
				"<title>Biletcim</title>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"/*<![CDATA[*/\r\n" + 
				"      /* Client-specific Styles */\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"html {\r\n" + 
				"	width: 100%;\r\n" + 
				"}\r\n" + 
				"#outlook a {\r\n" + 
				"	padding: 0;\r\n" + 
				"} /* Force Outlook to provide a \"view in browser\" menu link. */\r\n" + 
				"body {\r\n" + 
				"	width: 100% !important;\r\n" + 
				"	-webkit-text-size-adjust: 100%;\r\n" + 
				"	-ms-text-size-adjust: 100%;\r\n" + 
				"	-webkit-font-smoothing: antialiased;\r\n" + 
				"	margin: 0;\r\n" + 
				"	padding: 0;\r\n" + 
				"} /* Prevent Webkit and Windows Mobile platforms from changing default font sizes, while not breaking desktop design. */\r\n" + 
				".ExternalClass {\r\n" + 
				"	width: 100%;\r\n" + 
				"} /* Force Hotmail to display emails at full width */\r\n" + 
				".ExternalClass, .ExternalClass p, .ExternalClass span, .ExternalClass font, .ExternalClass td, .ExternalClass div {\r\n" + 
				"	line-height: 100%;\r\n" + 
				"} /* Force Hotmail to display normal line spacing. */\r\n" + 
				"#backgroundTable {\r\n" + 
				"	margin: 0;\r\n" + 
				"	padding: 0;\r\n" + 
				"	width: 100% !important;\r\n" + 
				"	line-height: 100% !important;\r\n" + 
				"}\r\n" + 
				"img {\r\n" + 
				"	outline: none;\r\n" + 
				"	text-decoration: none;\r\n" + 
				"	border: none;\r\n" + 
				"	-ms-interpolation-mode: bicubic;\r\n" + 
				"}\r\n" + 
				"a img {\r\n" + 
				"	border: none;\r\n" + 
				"}\r\n" + 
				"table td {\r\n" + 
				"	border-collapse: collapse;\r\n" + 
				"}\r\n" + 
				"table {\r\n" + 
				"	border-collapse: collapse;\r\n" + 
				"	mso-table-lspace: 0pt;\r\n" + 
				"	mso-table-rspace: 0pt;\r\n" + 
				"}\r\n" + 
				"sup {\r\n" + 
				"	vertical-align: top;\r\n" + 
				"	line-height: 100%;\r\n" + 
				"}\r\n" + 
				".appleLinksGrey a {color: #36495A !important; text-decoration: none;}\r\n" + 
				".appleLinksBlue a {color: #0061AB !important; text-decoration: none;}\r\n" + 
				"\r\n" + 
				" \r\n" + 
				" @media screen and (max-width:480px) {\r\n" + 
				"table[class=nomob], span[class=nomob], td[class=nomob], img[class=nomob] {\r\n" + 
				"	display: none !important;\r\n" + 
				"}\r\n" + 
				"/* Mobile width resize */\r\n" + 
				"*[class=emailphoneresize] {\r\n" + 
				"	width: 320px !important;\r\n" + 
				"}\r\n" + 
				"*[class=footerResize] {\r\n" + 
				"	width: 320px !important;\r\n" + 
				"	background-color: #ffffff !important;\r\n" + 
				"}\r\n" + 
				"*[class=email300resize] {\r\n" + 
				"	width: 300px !important;\r\n" + 
				"}\r\n" + 
				"*[class=email280resize] {\r\n" + 
				"	width: 280px !important;\r\n" + 
				"}\r\n" + 
				"*[class=email127resize] {\r\n" + 
				"	width: 127px !important;\r\n" + 
				"}\r\n" + 
				"*[class=appResize] {\r\n" + 
				"	width: 280px !important;\r\n" + 
				"	border: 0px solid #ebeff0 !important;\r\n" + 
				"	border-bottom-left-radius: 3px !important;\r\n" + 
				"	border-bottom-right-radius: 3px !important;\r\n" + 
				"}\r\n" + 
				"*[class=newsletterresize] {\r\n" + 
				"	width: 300px !important;\r\n" + 
				"	padding-left: 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Wemail130resize] {\r\n" + 
				"	width: 130px !important;\r\n" + 
				"	height: 52px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Wemail170resize] {\r\n" + 
				"	width: 170px !important;\r\n" + 
				"	height: 52px !important;\r\n" + 
				"}\r\n" + 
				"*[class=emailtable1resize] {\r\n" + 
				"	width: 50% !important;\r\n" + 
				"}\r\n" + 
				"*[class=email300resizecta] {\r\n" + 
				"	width: 300px !important;\r\n" + 
				"	padding: 10px !important;\r\n" + 
				"	line-height: 50px !important;\r\n" + 
				"	font-size: 15px !important;\r\n" + 
				"	letter-spacing: 2px !important;\r\n" + 
				"}\r\n" + 
				"*[class=email280resizecta] {\r\n" + 
				"	width: 280px !important;\r\n" + 
				"	line-height: 35px !important;\r\n" + 
				"	font-size: 14px !important;\r\n" + 
				"	letter-spacing: 2px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize80px] {\r\n" + 
				"	width: 80px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize114px] {\r\n" + 
				"	width: 114px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize120px] {\r\n" + 
				"	width: 120px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize130px] {\r\n" + 
				"	width: 130px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize137px] {\r\n" + 
				"	width: 137px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize140px] {\r\n" + 
				"	width: 140px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize140pxPadL10px] {\r\n" + 
				"	width: 140px !important;\r\n" + 
				"	padding-left: 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize143px] {\r\n" + 
				"	width: 143px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize150px] {\r\n" + 
				"	width: 150px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize160px] {\r\n" + 
				"	width: 160px !important;\r\n" + 
				"}\r\n" + 
				"*[class=resize140pxPadL10px] {\r\n" + 
				"	width: 140px !important;\r\n" + 
				"	padding-left:10px !important;\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"/* Spacer Images Resize */\r\n" + 
				"\r\n" + 
				"*[class=Resizeto10w] {\r\n" + 
				"	width: 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizeto30w] {\r\n" + 
				"	width: 30px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resize42header] {\r\n" + 
				"	width: 42px !important;\r\n" + 
				"	height: 42px !important;\r\n" + 
				"}\r\n" + 
				"/* Showing hidden Elements*/\r\n" + 
				"*[class=Show_one_world] {\r\n" + 
				"	width: 32px !important;\r\n" + 
				"	height: 32px !important;\r\n" + 
				"	display: inline !important;\r\n" + 
				"	margin: 17px 0px 0px 60px;\r\n" + 
				"}\r\n" + 
				"/*Image Resizing*/\r\n" + 
				"*[class=resizeimageto320] {\r\n" + 
				"	width: 320px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"}\r\n" + 
				"*[class=resizeimageto250] {\r\n" + 
				"	width: 250px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"}\r\n" + 
				"*[class=resizeimageto300] {\r\n" + 
				"	width: 300px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"}\r\n" + 
				"*[class=resizeimageto200] {\r\n" + 
				"	width: 200px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"}\r\n" + 
				"/*Font Size Change */\r\n" + 
				"*[class=bullets14px] {\r\n" + 
				"	font-size: 14px !important;\r\n" + 
				"}\r\n" + 
				"*[class=font14px] {\r\n" + 
				"	font-size: 14px !important;\r\n" + 
				"	line-height: 14px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto28hd] {\r\n" + 
				"	font-size: 28px !important;\r\n" + 
				"	line-height: 28px !important;\r\n" + 
				"	padding: 15px 10px 15px 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=headline21px] {\r\n" + 
				"	font-size: 21px !important;\r\n" + 
				"	line-height: 21px !important;\r\n" + 
				"	padding: 24px 20px 15px 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto20hd] {\r\n" + 
				"	font-size: 20px !important;\r\n" + 
				"	line-height: 20px !important;\r\n" + 
				"	padding: 15px 10px 15px 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto17] {\r\n" + 
				"	font-size: 17px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto17pad10] {\r\n" + 
				"	font-size: 17px !important;\r\n" + 
				"	padding-left: 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto16subhd] {\r\n" + 
				"	font-size: 16px !important;\r\n" + 
				"	line-height: 22px !important;\r\n" + 
				"	padding: 0px 10px 20px 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto16] {\r\n" + 
				"	font-size: 16px !important;\r\n" + 
				"	line-height: 18px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto13] {\r\n" + 
				"	font-size: 13px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto12] {\r\n" + 
				"	font-size: 12px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto14] {\r\n" + 
				"	font-size: 14px !important;\r\n" + 
				"	line-height: 15px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto15] {\r\n" + 
				"	font-size: 15px !important;\r\n" + 
				"	line-height: 17px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto10] {\r\n" + 
				"	font-size: 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto9] {\r\n" + 
				"	font-size: 9px !important;\r\n" + 
				"	line-height: 12px !important;\r\n" + 
				"}\r\n" + 
				"*[class=Resizefontto8] {\r\n" + 
				"	font-size: 8px !important;\r\n" + 
				"}\r\n" + 
				"*[class=smcolor] {\r\n" + 
				"	color: #999999;\r\n" + 
				"}\r\n" + 
				"*[class=showmobile320] {\r\n" + 
				"	display: block !important;\r\n" + 
				"	width: 320px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"	padding: 0;\r\n" + 
				"	max-height: inherit !important;\r\n" + 
				"	overflow: visible !important;\r\n" + 
				"}\r\n" + 
				"*[class=showmobile310] {\r\n" + 
				"	display: block !important;\r\n" + 
				"	width: 310px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"	padding: 0;\r\n" + 
				"	max-height: inherit !important;\r\n" + 
				"	overflow: visible !important;\r\n" + 
				"}\r\n" + 
				"*[class=showmobile300] {\r\n" + 
				"	display: block !important;\r\n" + 
				"	width: 300px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"	padding: 0;\r\n" + 
				"	max-height: inherit !important;\r\n" + 
				"	overflow: visible !important;\r\n" + 
				"	color: #999999;\r\n" + 
				"}\r\n" + 
				"*[class=showmobile280] {\r\n" + 
				"	display: block !important;\r\n" + 
				"	width: 280px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"	padding: 0;\r\n" + 
				"	max-height: inherit !important;\r\n" + 
				"	overflow: visible !important;\r\n" + 
				"}\r\n" + 
				"table[class=\"stack\"] {\r\n" + 
				"	width: 100%;\r\n" + 
				"	display: block;\r\n" + 
				"	box-sizing: border-box;\r\n" + 
				"}\r\n" + 
				"*[class=showmobile30] {\r\n" + 
				"	display: block !important;\r\n" + 
				"	margin: auto !important;\r\n" + 
				"	width: 30px !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"	padding: 0;\r\n" + 
				"	max-height: inherit !important;\r\n" + 
				"	overflow: visible !important;\r\n" + 
				"}\r\n" + 
				" *[class=iphone6hide] {\r\n" + 
				"	 display:none !important;\r\n" + 
				" }\r\n" + 
				"/* Padding Resize*/\r\n" + 
				"*[class=mobpadoneworld] {\r\n" + 
				"	padding: 0 !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadnav] {\r\n" + 
				"	padding: 5px 0px 5px 0px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadcopy] {\r\n" + 
				"	padding: 2px 10px 2px 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpad0] {\r\n" + 
				"	padding-left: 0px !important;\r\n" + 
				"	padding-right: 0px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadl] {\r\n" + 
				"	padding-left: 10px !important;\r\n" + 
				"	font-size: 14px !important;\r\n" + 
				"}\r\n" + 
				"*[class=padleft10] {\r\n" + 
				"	padding-left: 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadr] {\r\n" + 
				"	padding-right: 10px !important;\r\n" + 
				"	font-size: 10px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadheader] {\r\n" + 
				"	padding-left: 0px !important;\r\n" + 
				"	padding-right: 0px !important;\r\n" + 
				"}\r\n" + 
				"*[class=showmobilebutton] {\r\n" + 
				"	display: table !important;\r\n" + 
				"	margin: auto !important;\r\n" + 
				"	width: 100% !important;\r\n" + 
				"	height: auto !important;\r\n" + 
				"	text-align: center !important;\r\n" + 
				"	max-height: inherit !important;\r\n" + 
				"	overflow: visible !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingLR20px] {\r\n" + 
				"	padding-left: 20px !important;\r\n" + 
				"	padding-right: 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingDisclaimer] {\r\n" + 
				"	padding: 24px 24px 24px 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingR20px] {\r\n" + 
				"	padding-right: 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingL20px] {\r\n" + 
				"	padding-left: 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingL20pxFont14px] {\r\n" + 
				"	padding-left: 20px !important;\r\n" + 
				"	font-size: 14px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingB30px] {\r\n" + 
				"	padding-bottom: 30px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingT30pxB0px] {\r\n" + 
				"	padding-bottom: 0px !important;\r\n" + 
				"	padding-top: 30px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingB30pxLR20px] {\r\n" + 
				"	padding-bottom: 30px !important;\r\n" + 
				"	padding-left: 20px !important;\r\n" + 
				"	padding-right: 20px !important;\r\n" + 
				"	font-size:14px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingAppIcon] {\r\n" + 
				"	padding: 0 11px 0 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=paddingGoogleIcon] {\r\n" + 
				"	padding: 0 18px 0 11px !important;\r\n" + 
				"}\r\n" + 
				"/*NEWSLETTER RESIZE */\r\n" + 
				"*[class=newsletterHeadline] {\r\n" + 
				"	padding: 0px 0px 5px 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=newsletterColumnContainer] {\r\n" + 
				"	display: block !important;\r\n" + 
				"	width: 100% !important;\r\n" + 
				"}\r\n" + 
				"*[class=newsletterLeftColumn] {\r\n" + 
				"	padding: 5px 0px 0px 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=newsletterRightColumn] {\r\n" + 
				"	padding: 5px 0px 0px 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadnewsletter] {\r\n" + 
				"	padding: 5px 0px 20px 20px !important;\r\n" + 
				"}\r\n" + 
				"*[class=mobpadimage] {\r\n" + 
				"	padding: 0 29px 20px 29px !important;\r\n" + 
				"}\r\n" + 
				"*[class=oneWorldPad] {\r\n" + 
				"	padding: 0 20px 0 0 !important;\r\n" + 
				"}\r\n" + 
				"*[class=AAlogoPad] {\r\n" + 
				"	padding: 0 0 0 5px !important;\r\n" + 
				"}\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"/* ]]> */\r\n" + 
				".btn_checkin {\r\n" + 
				"  display: inline-block;\r\n" + 
				"  -webkit-box-sizing: content-box;\r\n" + 
				"  -moz-box-sizing: content-box;\r\n" + 
				"  box-sizing: content-box;\r\n" + 
				"  cursor: pointer;\r\n" + 
				"  padding: 10px 20px;\r\n" + 
				"  border: 1px solid #ffffff;\r\n" + 
				"  -webkit-border-radius: 8px;\r\n" + 
				"  border-radius: 8px;\r\n" + 
				"  font: normal 16px/normal Arial, Helvetica, sans-serif;\r\n" + 
				"  color: rgba(255,255,255,0.9);\r\n" + 
				"  -o-text-overflow: clip;\r\n" + 
				"  text-overflow: clip;\r\n" + 
				"  background: #0061AB;\r\n" + 
				"  text-shadow: -1px -1px 0 rgba(15,73,168,0.66) ;\r\n" + 
				"  -webkit-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);\r\n" + 
				"  -moz-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);\r\n" + 
				"  -o-transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);\r\n" + 
				"  transition: all 300ms cubic-bezier(0.42, 0, 0.58, 1);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".btn_checkin:hover {\r\n" + 
				"  border: 1px solid #0061AB;\r\n" + 
				"  color: #0061AB;\r\n" + 
				"  background: #ffffff;\r\n" + 
				"}"+
				"</style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body bgcolor=\"#ebeff0\">\r\n" + 
				"<table align=\"center\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" bgcolor=\"#ebeff0\">\r\n" + 
				"  <tbody><tr>\r\n" + 
				"    <td align=\"center\"><table align=\"center\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#ffffff\">\r\n" + 
				"        <tbody><tr>\r\n" + 
				"          <td align=\"center\">\r\n" + 
				"          <table align=\"center\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#ebeff0\">\r\n" + 
				"<tbody><tr>\r\n" + 
				"<td class=\"mobpadnav\" style=\"padding: 20px 30px 20px 30px;\" bgcolor=\"#ebeff0\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"  \r\n" + 
				"<table class=\"nomob\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"left\" bgcolor=\"#ebeff0\">\r\n" + 
				"<tbody><tr>\r\n" + 
				"<td class=\"padleft10\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#374959;\">\r\n" + 
				"<a href=\"#\" style=\"color:#374959; text-decoration:none;\" target=\"_blank\"></a></td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody></table>\r\n" + 
				" \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</td>\r\n" + 
				"\r\n" + 
				"</tr>\r\n" + 
				"</tr>\r\n" + 
				"</tbody></table>\r\n" + 
				"         \r\n" + 
				"            \r\n" + 
				"            <table align=\"center\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#ffffff\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td class=\"paddingLR20px\" style=\"padding:20px 30px 24px 30px;\" bgcolor=\"#ffffff\" align=\"left\"><table class=\"stack\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\" bgcolor=\"#ffffff\">\r\n" + 
				"                          <tbody><tr align=\"left\">\r\n" + 
				"                            <td bgcolor=\"#ffffff\"><table class=\"resize140px\" width=\"325\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"left\" bgcolor=\"#ffffff\">\r\n" + 
				"                                <tbody><tr>\r\n" + 
				"                                  <td class=\"Resizefontto13\" bgcolor=\"#ffffff\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:14px; color:#36495A;\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">Merhaba "+userFullName+",</span></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                              </tbody></table>\r\n" + 
				"                               \r\n" + 
				"                              <!--[if gte mso 9]>\r\n" + 
				"        				</td>\r\n" + 
				"        				<td valign=\"top\">\r\n" + 
				"        				<![endif]-->\r\n" + 
				"                             \r\n" + 
				"                              \r\n" + 
				"                              \r\n" + 
				"</td>\r\n" + 
				"                          </tr>\r\n" + 
				"                        </tbody></table></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            <table align=\"center\" class=\"nomob\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#ffffff\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td class=\"resizeimageto320\" align=\"center\" width=\"600\"><a href=\"http://localhost:8080/biletcim/plane/check-in/control\" target=\"_blank\"><img style=\"display:block;\" src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/check_in_banner_600_desktop.png\" border=\"0\" alt=\"It's time to check in\" title=\"It's time to check in\" class=\"nomob\" width=\"600\" height=\"166\"></a></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            \r\n" + 
				"            <!--[if !mso]><!-->\r\n" + 
				"            \r\n" + 
				"            <div align=\"center\" style=\"display:none; width:0px; max-height:0px; overflow:hidden;\" class=\"showmobile320\">\r\n" + 
				"              <table align=\"center\" class=\"showmobile320\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"320\" bgcolor=\"#ffffff\">\r\n" + 
				"                <tbody><tr>\r\n" + 
				"                  <td align=\"center\" width=\"320\"><a href=\"http://localhost:8080/biletcim/plane/check-in/control\" target=\"_blank\"><img style=\"display:block;\" src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/check_in_banner_320_mobile.png\" border=\"0\" alt=\"It's time to check in\" title=\"It's time to check in\" width=\"320\" height=\"135\"></a></td>\r\n" + 
				"                </tr>\r\n" + 
				"              </tbody></table>\r\n" + 
				"            </div>\r\n" + 
				"            \r\n" + 
				"            <!--<![endif]--> \r\n" + 
				"            <table align=\"center\" style=\"font-size:1px; line-height:1px; border-collapse:collapse;\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#ffffff\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td height=\"30\" style=\"padding:0px; background-color:#ffffff; font-size:0px; line-height:0px; border-collapse:collapse;\"><img src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/spacer50.gif\" border=\"0\" alt=\"\" width=\"1\" height=\"30\" style=\"display:block;\"></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            <table bgcolor=\"#ffffff\" class=\"emailphoneresize\" align=\"center\" width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"              <td style=\"padding: 0 112px 0 113px;\" class=\"mobpad0\" bgcolor=\"#ffffff\">\r\n" + 
				"            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"375\" bgcolor=\"#ffffff\" class=\"nomob\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td width=\"375\" height=\"86\" align=\"center\" bgcolor=\"#ffffff\" style=\"padding:0 0 36px 0;\" class=\"paddingB30px\">\r\n" + 
				"                 <a href=\"http://localhost:8080/biletcim/plane/check-in/control\" class=\"\" target=\"_blank\"><input type=\"button\" class=\"btn_checkin\" value=\"Check-in Yap\" /></a>\r\n" + 
				"\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            \r\n" + 
				"            <!--[if !mso]><!-->\r\n" + 
				"<div style=\"display:none; width:0px; max-height:0px; overflow:hidden;\" class=\"showmobile280\">\r\n" + 
				"            <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"280\"  class=\"showmobile280\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td width=\"280\" height=\"65\" align=\"center\" style=\"padding:0 20px 30px 20px;\">\r\n" + 
				"                 <a href=\"http://localhost:8080/biletcim/plane/check-in/control\" class=\"\" target=\"_blank\"><input type=\"button\" class=\"btn_checkin\" value=\"Check-in Yap\" /></a>\r\n" + 
				"\r\n" + 
				"                </td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            </div>\r\n" + 
				"<!--<![endif]-->\r\n" + 
				"\r\n" + 
				"            </td>\r\n" + 
				"            </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            <table align=\"center\" style=\"font-size:1px; line-height:1px; border-collapse:collapse;\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#bfbfbf\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td height=\"1\" style=\"padding:0px; background-color:#bfbfbf; font-size:0px; line-height:0px; border-collapse:collapse;\"><img src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/spacer50.gif\" border=\"0\" alt=\"\" width=\"1\" height=\"1\" style=\"display:block;\"></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            <table style=\"\r\n" + 
				"    background-color:  #ffffff;\r\n" + 
				"\" bgcolor=\"#ffffff\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" align=\"center\">\r\n" + 
				"  <tbody><tr>\r\n" + 
				"    <td bgcolor=\"#ffffff\" class=\"paddingB30pxLR20px\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:18px; line-height:18px; color:#36495A; font-weight:bold;padding:30px 30px 34px 30px;\" align=\"left\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\"><!--Begin SPOTLIGHT HEADING--> Bilet Numarasý : "+bilet.getTicketNumber()+"</span></td>\r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td bgcolor=\"#ffffff\" class=\"paddingLR20px\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:30px; line-height:30px; color:#0061AB; padding:0 30px 3px 30px;\" align=\"left\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">"+bilet.getTicketDateMMMMTR()+"</span></td>\r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td bgcolor=\"#ffffff\" class=\"paddingLR20px\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:16px; line-height:16px; color:#0061AB; padding:0 30px 36px 30px;\" align=\"left\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;color: #0061AB !important; text-decoration: none;\" class=\"appleLinksBlue\">"+bilet.getKalkisYeri()+" <span style=\"font-size:18px;\">></span> "+bilet.getVarisYeri()+"</span></td>\r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td bgcolor=\"#ffffff\" style=\"padding: 0 30px 15px 30px;\" align=\"left\" class=\"paddingLR20px\">\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    <table class=\"email280resize\" cellspacing=\"0\" cellpadding=\"0\" width=\"306\" style=\"border-collapse:collapse;\">\r\n" + 
				"        <tbody><tr>\r\n" + 
				"          <td bgcolor=\"#ffffff\" class=\"resize140px\" width=\"166\" align=\"left\" valign=\"top\">\r\n" + 
				"          <table class=\"resize140px\" cellspacing=\"0\" cellpadding=\"0\" width=\"156\" style=\"border-collapse:collapse;\">\r\n" + 
				"        <tbody><tr>\r\n" + 
				"          <td bgcolor=\"#ffffff\" class=\"resize114px\" width=\"130\" align=\"left\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:27px; color:#36495A; text-align:left; text-decoration: none; line-height:27px; padding: 0 10px 7px 0; text-transform:uppercase;\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;color: #36495A !important; text-decoration: none;\" class=\"appleLinksGrey\">"+bilet.getKalkisZamani()+"</span></td>\r\n" + 
				"          \r\n" + 
				"          <td width=\"26\" align=\"left\" style=\"padding: 0 0 7px 0;\"><img src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/grey_arrow.png\" border=\"0\" alt=\"\" title=\"\" width=\"26\" height=\"20\"></td>\r\n" + 
				"        </tr>\r\n" + 
				"      </tbody></table>\r\n" + 
				"      <table class=\"resize140px\" cellspacing=\"0\" cellpadding=\"0\" width=\"166\" style=\"border-collapse:collapse;\">\r\n" + 
				"        <tbody><tr>\r\n" + 
				"          <td bgcolor=\"#ffffff\" class=\"resize140px\" width=\"166\" align=\"left\" style=\"font-family: Arial, Helvetica, sans-serif; font-size:14px; line-height:14px; color:#36495A; text-align:left; text-decoration: none; padding: 0 0 0 0; border-collapse:collapse;\"><span class=\"Resizefontto12\" style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">"+bilet.getKalkisYeri()+"</span></td>\r\n" + 
				"          \r\n" + 
				"          \r\n" + 
				"        </tr>\r\n" + 
				"      </tbody></table>\r\n" + 
				"          \r\n" + 
				"          </td>\r\n" + 
				"          \r\n" + 
				"          <td bgcolor=\"#ffffff\" class=\"resize140px\" width=\"140\" align=\"left\" valign=\"top\">\r\n" + 
				"          <table class=\"resize140px\" cellspacing=\"0\" cellpadding=\"0\" width=\"166\" style=\"border-collapse:collapse;\">\r\n" + 
				"        <tbody><tr>\r\n" + 
				"          <td bgcolor=\"#ffffff\" class=\"resize140pxPadL10px\" width=\"140\" align=\"left\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:27px; color:#36495A;text-align:left; text-decoration: none; line-height:27px; padding: 0 0 7px 20px; text-transform:uppercase;\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;color: #36495A !important; text-decoration: none;\" class=\"appleLinksGrey\">"+bilet.getVarisZamani()+"</span></td>\r\n" + 
				"          \r\n" + 
				"          \r\n" + 
				"        </tr>\r\n" + 
				"                <tr>\r\n" + 
				"          <td bgcolor=\"#ffffff\" class=\"resize140pxPadL10px\" width=\"140\" align=\"left\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:14px; line-height:14px; color:#36495A; text-align:left; text-decoration: none; padding: 0 0 0 20px;\"><span class=\"Resizefontto12\" style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">"+bilet.getVarisYeri()+"</span></td>\r\n" + 
				"          \r\n" + 
				"          \r\n" + 
				"        </tr>\r\n" + 
				"      </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"        </tr>\r\n" + 
				"      </tbody></table>\r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"    \r\n" + 
				"      </td>\r\n" + 
				"  </tr>\r\n" + 
				"  <tr>\r\n" + 
				"    <td bgcolor=\"#ffffff\" class=\"paddingLR20px\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:14px; line-height:14px; color:#36495A; padding:0 30px 0 30px;\" align=\"left\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\" class=\"appleLinksGrey\">Detay </span></td>\r\n" + 
				"  </tr>\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"  <tr>\r\n" + 
				"  <td>\r\n" + 
				"  <table align=\"center\" style=\"font-size:1px; line-height:1px; border-collapse:collapse;\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"1\" bgcolor=\"#ffffff\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td height=\"36\" style=\"padding:0px; background-color:#ffffff; font-size:0px; line-height:0px; border-collapse:collapse;\"><img src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/spacer50.gif\" border=\"0\" alt=\"\" width=\"1\" height=\"36\" style=\"display:block;\"></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            </td>\r\n" + 
				"            </tr>\r\n" + 
				"\r\n" + 
				"</tbody></table>\r\n" + 
				"\r\n" + 
				"            <table align=\"center\" style=\"font-size:1px; line-height:1px; border-collapse:collapse;\" class=\"emailphoneresize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" bgcolor=\"#bfbfbf\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td height=\"1\" style=\"padding:0px; background-color:#bfbfbf; font-size:0px; line-height:0px; border-collapse:collapse;\"><img src=\"http://www.aa.com/content/images/email/marketingOneOff/PDP/spacer50.gif\" border=\"0\" alt=\"\" width=\"1\" height=\"1\" style=\"display:block;\"></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"          \r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            <table class=\"emailphoneresize\" align=\"center\" width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td style=\"font-family:Arial, Helvetica, sans-serif; font-size:16px; color:#0078D2; padding:36px 0 36px 0;\" align=\"center\" bgcolor=\"#ffffff\"><a href=\"http://localhost:8080/biletcim/\" style=\"color:#137acf; text-decoration:underline;\" target=\"_blank\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">Destek</span></a> &nbsp;&nbsp;<span style=\"color:#36495A; text-decoration:none;\">|</span>&nbsp;&nbsp; <a href=\"http://localhost:8080/biletcim/\" style=\"color:#0078D2; text-decoration:underline;\" target=\"_blank\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">Gizlilik&nbsp;Politikasý</span></a></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            <table class=\"emailphoneresize\" align=\"center\" width=\"600\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"              <td style=\"padding:0 150px 0 150px;\" class=\"mobpad0\">\r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"            </td>\r\n" + 
				"            </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"          </td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"          <td align=\"center\" style=\"background-color:#ebeff0; padding-bottom:10px;\">\r\n" + 
				"          <table align=\"center\" class=\"footerResize\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"600\" style=\"background-color:#ebeff0;\">\r\n" + 
				"              <tbody><tr>\r\n" + 
				"                <td class=\"paddingLR20px\" style=\"font-family:Arial, Helvetica, sans-serif; font-size:12px; color:#999999; padding:20px 30px 40px 30px;\" align=\"left\"><span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">Lütfen Bu E-Postaya cevap göndermeyiniz , E-Posta nýn yanlýþ geldiðini düþünüyorsanýz iletiþime geçiniz. <a href=\"#\" style=\"color:#0078D2; text-decoration:none;\" target=\"_blank\">biletcim.berkaydelen@gmail.com </a></span><br>\r\n" + 
				"                  <br>\r\n" + 
				"                  <span style=\"font-family:'Helvetica Neue', Helvetica, Arial, sans-serif !important;mso-line-height-rule:exactly;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;\">\r\n" + 
				"                  © Biletcim.com</span></td>\r\n" + 
				"              </tr>\r\n" + 
				"            </tbody></table>\r\n" + 
				"          </td>\r\n" + 
				"          </tr>\r\n" + 
				"      </tbody></table></td>\r\n" + 
				"  </tr>\r\n" + 
				"</tbody></table>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>", "utf-8", "html");

		Transport.send(message);

		System.out.println("Done");

	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
     }
    
public String convertDateTR(String date) {
		
		String dateM=date;
		System.out.println("Date : "+dateM);
		
		
		if(dateM.equals("01")) {
			return "Ocak".toUpperCase();
		}else if(dateM.equals("02")) {
			return "Þubat".toUpperCase();
		}
		else if(dateM.equals("03")) {
			return "Mart".toUpperCase();
		}
		else if(dateM.equals("04")) {
			return "Nisan".toUpperCase();
		}
		else if(dateM.equals("05")) {
			return "Mayýs".toUpperCase();
		}
		else if(dateM.equals("06")) {
			return "Haziran".toUpperCase();
		}
		else if(dateM.equals("07")) {
			return "Temmuz".toUpperCase();
		}
		else if(dateM.equals("08")) {
			return "Aðustos".toUpperCase();
		}
		else if(dateM.equals("09")) {
			return "Eylül".toUpperCase();
		}
		else if(dateM.equals("10")) {
			return "Ekim".toUpperCase();
		}
		else if(dateM.equals("11")) {
			return "Kasým".toUpperCase();
		}
		else if(dateM.equals("12")) {
			return "Aralýk".toUpperCase();
		}else {
			return "Error";
		}
		
		//System.out.println("DateD:"+dateD);
		//System.out.println("DateM:"+dateM);
		
		
		
	}

	public String PlaneGetImgUrl(String PlaneName,String PlaneModel) {
		
		if(PlaneName.equals("A320-200")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Airbus_A330-200_C.php";
		}
		else if(PlaneName.equals("AIRBUS A321-200")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Airbus_A321_C_new.php";
		}
		else if(PlaneName.equals("AIRBUS A320")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Airbus_A320.php";
		}
		else if(PlaneName.equals("AIRBUS A321-231")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Airbus_A321_D.php";
		}
		else if(PlaneName.equals("BOEING B737-900ER")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Boeing_737-900ER_B.php";
		}
		else if(PlaneName.equals("BOEING 737-800")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Boeing_737-800_A.php";
		}
		else if(PlaneName.equals("UNKNOWN_PLANE")) {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Boeing_737-900ER_B.php";
		}else {
			return "https://www.seatguru.com/airlines/Turkish_Airlines/Turkish_Airlines_Boeing_737-900ER_B.php";
		}
		
		
	}
	
	public ModelAndView  FailureControl(ModelAndView model,String ErrorCode) {
		String Hata = "";
		
		
		
		if(ErrorCode.equals("TK-BWS-25016")) {
			Hata = "Lütfen Geçerli Bir Tarih Aralýðý Giriniz.";
			System.err.println(Hata);
			model.addObject("Error", Hata);
		}else if(ErrorCode.equals("TK-BWS-25015")) {
			Hata = "Lütfen Kalkýþ ve Varýþ Havalimanlarýný Farklý Seçiniz.";
			System.err.println(Hata);
			model.addObject("Error", Hata);
		}else if(ErrorCode.equals("TK-BWS-10000")) {
			Hata = "Lütfen Kalkýþ veya Varýþ Havalimanýný Kontol Edip Düzgün Giriniz.";
			System.err.println(Hata);
			model.addObject("Error", Hata);
		}else {
			Hata = "Bilinmeyen Bir Hata Oluþtu  (JP04)";
			System.err.println(Hata);
			model.addObject("Error", Hata);
		}
		
		return model;
	}

}
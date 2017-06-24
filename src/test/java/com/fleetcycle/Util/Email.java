package com.fleetcycle.Util;

import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
    
	public static void sendEmail() {
	    
	    ZipCreationforScreenshots obj1=new ZipCreationforScreenshots();
        obj1.zipResultOutput();
        
		final String username = "caprusqa@yahoo.com";
		final String password = "123456!Q";
		// "," is to used to add Multiple user in Receiver Mail id
		String receiver = "shivaprasad.adirala@caprusit.com";
		//String receiverCC = "rajendiran.pandurangan@caprusit.com";

		System.out.println(receiver);
		//System.out.println(receiverCC);

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.ssl.enable", true);
		props.put("mail.smtp.starttls.enable", true);
		//props.put("mail.smtp.host", "secure.emailsrvr.com");
		props.put("mail.smtp.host", "smtp.mail.yahoo.com");
		props.put("mail.smtp.port", "465");
		 
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
			//msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(receiverCC));
			//msg.setText("Test");
			//Mail Subject
			msg.setSubject("Automation Test Result");
			MimeBodyPart messageContent = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			//1st MimeBody to attach Emailable Report
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			//DataSource source = new FileDataSource(System.getProperty("user.dir")+"\\src\\Results\\XPSmokeTest.html");
			DataSource source = new FileDataSource(Util.REPORTPATH);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Automation_Result.html");
			multipart.addBodyPart(messageBodyPart);

			//3rd MimeBody to attach for Error screenshots 
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
			DataSource source2 = new FileDataSource(Util.STRDIRECTORY + ".zip");
			messageBodyPart2.setDataHandler(new DataHandler(source2));
			messageBodyPart2.setFileName("Output.zip");
			multipart.addBodyPart(messageBodyPart2);


			String MailBody= "Hi Shiva,"+"\n"+
					"Automation is completed. Please find the attachment of test results."+"\n"+"\n"+"Thank You"+"\n"+"Automation Team";

			System.out.println(MailBody);
			messageContent.setText(MailBody);
			multipart.addBodyPart(messageContent);
			msg.setContent(multipart);
			System.out.println("Sending...");
			Transport.send(msg);
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}	
	}
	
    public static void afterTest() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public synchronized void start() {
                sendEmail();
            }
        });

    }
    
}

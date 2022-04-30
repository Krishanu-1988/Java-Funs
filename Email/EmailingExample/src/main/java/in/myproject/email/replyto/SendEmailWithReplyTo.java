package in.myproject.email.replyto;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmailWithReplyTo
{
public static void email(String to,String from,String replyTo, String host)
{

   // Get system properties
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));
      
   // Set Reply To: header field of the header.
      message.setReplyTo(InternetAddress.parse(replyTo));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("TEST REPORT");

      // Now set the actual message
      message.setText("Test successful :) " +
    		"\r\n"+
      		"\r\nRegards," +
      		"\r\nKrishanu");

      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully !!");
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
}

public static void main(String[] args)
{
	String to,from,replyTo,emailHost;
	Scanner scan=new Scanner(System.in);
	try {
		System.out.println("Enter the email id to whom you want to send mail");
		to=scan.next();
		System.out.println("Enter from email id");
		from=scan.next();
		System.out.println("Enter 'Reply to' email id");
		replyTo=scan.next();
		System.out.println("Enter Email server host");
		emailHost=scan.next();
		email(to, from, replyTo, emailHost);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		scan.close();
	}
}
}


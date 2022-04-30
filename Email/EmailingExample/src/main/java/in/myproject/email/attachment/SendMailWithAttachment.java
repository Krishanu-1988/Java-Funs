package in.myproject.email.attachment;

//File Name SendEmail.java

import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


public class SendMailWithAttachment
{
public static void email(String[] arg)
{
  if(arg.length!=0 && arg.length>=7)
  {
   // Assuming you are sending email from localhost
   String host = arg[0];

   // Sender's email ID needs to be mentioned
   String from = arg[1];
   
   //Subject of mail
   String subject=arg[2];
   
   //Body of the mail 
   String body=arg[3];
   
   //Setting up of To address
   ArrayList<String> to=new ArrayList<String>();
   for(int i=6;i<arg.length;i++)
   {
	   to.add(arg[i]);
   }
   
   //Logging
   System.out.println("\n");
   System.out.println("EMAIL DETAILS");
   System.out.println("============= \n");
   System.out.println("SMTP Server : "+arg[0]);
   System.out.println("Sending email address : "+arg[1]);
   System.out.println("Email subject : "+arg[2]);
   System.out.println("Email body : "+arg[3]);
   System.out.println("Email Attacment : "+arg[4]);
   System.out.println("Preffered file name for the attachment : "+arg[5]);
   System.out.println("Recipients' list : ");

   for(int i=0;i<to.size();i++)
	  {
	   System.out.println(to.get(i).toString());
	  }   
   // Get system properties
   Properties properties = System.getProperties();
   // Setup mail server
   properties.setProperty("mail.smtp.host", host);
   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
	   
	  for(int i=0;i<to.size();i++)
	  {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);
      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));
      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(to.get(i).toString()));
      // Set Subject: header field
      message.setSubject(subject);

      // Create the message part 
      BodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText(body);
      
   // Create a multipart message
      Multipart multipart = new MimeMultipart();

      // Set text message part
      multipart.addBodyPart(messageBodyPart);
      // Part two is attachment
      messageBodyPart = new MimeBodyPart();
      String filename = arg[4];
      DataSource source = new FileDataSource(filename);
      messageBodyPart.setDataHandler(new DataHandler(source));
      messageBodyPart.setFileName(arg[5]);
      multipart.addBodyPart(messageBodyPart);

      // Send the complete message parts
      message.setContent(multipart );
      // Send message
      Transport.send(message);
	  }
      System.out.println("\nMessage sending is successful.... :)");
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
  }
  else
  {
	  System.out.println("\n");
	  System.out.println("USAGE");
	  System.out.println("===== \n");
	  System.out.println("Argument 1 : Email server");
	  System.out.println("Argument 2 : Sender's email address");
	  System.out.println("Argument 3 : Email subject");
	  System.out.println("Argument 4 : Email body");
	  System.out.println("Argument 5 : Email attachment with full path");
	  System.out.println("Argument 6 : Attached filename (your preffered) with file extentsion");
	  System.out.println("Argument 7,8... : Recipients' email addresses");
	  System.out.println("Example: java -jar testMail.jar \"<smtp_host>\" \"norly@abc.com\" \"Test Email\" \"Test email body\" \"/home/testuser/doc.txt\" \"TestReport.txt\" \"recipient1@abc.com\" \"recipient2@abc.com\" \"recipient3@abc.com\" .. \n");
	  System.out.println("Please supply proper arguments.\n");
  }
}

public static void main(String[] args)
{
	email(args);
}
}


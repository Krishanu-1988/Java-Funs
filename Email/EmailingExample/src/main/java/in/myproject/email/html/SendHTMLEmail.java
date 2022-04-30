package in.myproject.email.html;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendHTMLEmail
{
   public static void main(String [] args) throws MalformedURLException, IOException
   {
      
      // Recipient's email ID needs to be mentioned.
      String to = args[0];

      // Sender's email ID needs to be mentioned
      String from = args[1];

      // Assuming you are sending email from localhost
      String host = args[2];

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

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Send the actual HTML message, as big as you like
         message.setContent(getContentResult(new URL("http://localhost:8080/")),"text/html");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
   
   public static String getContentResult(URL url) throws IOException{

	    InputStream in = url.openStream();
	    StringBuffer sb = new StringBuffer();

	    byte [] buffer = new byte[256];

	    while(true){
	        int byteRead = in.read(buffer);
	        if(byteRead == -1)
	            break;
	        for(int i = 0; i < byteRead; i++){
	            sb.append((char)buffer[i]);
	        }
	    }
	    return sb.toString();
	}
}
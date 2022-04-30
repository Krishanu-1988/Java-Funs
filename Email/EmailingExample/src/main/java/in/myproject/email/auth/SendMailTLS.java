package in.myproject.email.auth;

import java.io.IOException;
//import java.net.ProxySelector;
import java.net.UnknownHostException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailTLS {
 
	public static void main(String[] args) throws UnknownHostException, IOException {
 
		
		//ProxySelector.setDefault(null);
		System.setProperty("java.net.useSystemProxies", "true");
		final String username = args[0];
		final String password = args[1];
		final String recipient = args[2];

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		props.put("mail.smtp.socketFactory.port", "587");  
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.socketFactory.fallback", "false");  
		
		/*props.setProperty("proxySet","true");  
		props.setProperty("socksProxyHost","proxy");  
		props.setProperty("socksProxyPort","8080");*/ 
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipient));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
package selenium;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class sendmail {

	public static void sendMail()
	{
		String to=interface1.username;
        String from="anadimailbox4@gmail.com";
        String OrderHistory="Order Hiistory";

        Properties properties=new Properties();
                        properties.put("mail.smtp.auth", "true");
                        properties.put("mail.smtp.starttls.enable","true");
                        properties.put("mail.smtp.host","smtp.gmail.com");
                        properties.put("mail.smtp.port",587);

                                
        
        
        Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator()
        {
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication("anadimailbox4@gmail.com","clax@a2jakaspeedfreak");
                }
        });
        try{
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Your Flipkart order History");
            BodyPart messageBodyPart=new MimeBodyPart();
            messageBodyPart.setText("Dear customer,\nHere is the list of items that you have ordered so far:");
            Multipart multipart=new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart=new MimeBodyPart();
            String filename="C:\\Users\\anadi\\eclipse-workspace\\selenium\\orders.html";
            javax.activation.DataSource source=new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(OrderHistory);         

            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Message sent successfully");
            
        }catch(MessagingException me)
        {
            me.printStackTrace();
        }
	}
}

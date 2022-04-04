
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

public class Send_Mail {
	public static void main(String[] args) {
		sendMail();   
	}
	
	public static void sendMail() {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "localhost");
			Session session = Session.getInstance(props, null);

			MimeMessage msg = new MimeMessage(session);
			msg.setFrom("labrat@localhost");
			msg.setRecipients(Message.RecipientType.TO,"labrat@localhost");
			msg.setSubject("42");
			msg.setSentDate(new Date());
			msg.setText("#42 Hello, world! #42\n");

			Transport.send(msg, "labrat@localhost", "kn1lab");

			System.out.println("Subject : " + msg.getSubject());
			System.out.println("From : " + msg.getFrom()[0]);
			System.out.println("--------------");
			System.out.println("Body : " +  msg.getContent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

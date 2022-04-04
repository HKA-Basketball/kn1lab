import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.MimeMessage;

public class Receive_Mail {
	public static void main(String[] args) throws Exception {
		fetchMail();
	}
	
	public static void fetchMail() {
		try {
			Properties props = new Properties();
			props.put("mail.store.protocol", "pop3");
			props.put("mail.pop3.host", "localhost");
			//props.put("mail.from", "labrat@localhost");
			//props.put("mail.debug", "true");
			//props.put("mail.debug.quote", "true");
			Session session = Session.getInstance(props, null);
			//session.setDebug(true);

			Store store = session.getStore();
			store.connect("localhost", "labrat", "kn1lab");

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);

			Message[] messages = folder.getMessages();

			int icount = 1;
			for (Message msg : messages)
			{
				System.out.println("Email #" + (icount++) + ":");
				System.out.println("--------------");
				System.out.println("\tSubject : " + msg.getSubject());
				System.out.println("\tFrom : " + msg.getFrom()[0]);
				System.out.println("\tDate : " + msg.getSentDate());
				System.out.println("--------------");
				System.out.println("\tBody : " +  msg.getContent());
			}
			
			folder.close();
			store.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

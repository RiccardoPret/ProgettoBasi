package test;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class TestMail {

	public static void main(String[] args) {
		String mail="riky.pret@gmail.com";
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("driveitunivr@gmail.com ", "pifsoldi"));
		email.setStartTLSEnabled(true);
		email.setFrom("driveitunivr@gmail.com ");
		email.setSubject("Notifica DriveIT");
		email.setMsg("test Mail");

		email.addTo(mail);
		email.send();
	}

}

package ec.edu.ups.appdis.g1.negocio;

import javax.ejb.Remote;
import javax.mail.MessagingException;


public interface CorreoONRemoto {
	public void sendAsHtml(String to, String title, String html) throws MessagingException;
}

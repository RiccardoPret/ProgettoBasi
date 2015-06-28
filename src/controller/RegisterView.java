package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import util.InsertHelper;
import model.ClienteDataBean;

@ManagedBean(name = "register")
@ViewScoped
public class RegisterView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6407552727135983059L;
	private ClienteDataBean user;
	
	public RegisterView(){
		
	}
	
	@PostConstruct
	public void initialize(){
		this.user=new ClienteDataBean();
	}
	
	public String register(){
		boolean result=InsertHelper.insertUser(this.user.getNome(), this.user.getCognome(), this.user.getResidenza()
								, this.user.getDocumento_tipo(), this.user.getDocumento_ente()
								, this.user.getDocumento_numero(), this.user.getEmail()
								, this.user.getLogin(), this.user.getPassword());
		if(!result){
			return user.getLogin()==null?"":"Username o email già esistente!";
		}
		else{
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(587);
			email.setAuthenticator(new DefaultAuthenticator("pigiadiresort@gmail.com ", "apensa1212"));
			email.setStartTLSEnabled(true);
			try {
				email.setFrom("pigiadiresort@gmail.com ");
				email.setSubject("Benvenuto in PigiadiResort");
				email.setMsg("Ecco le sue credenziali:\nLogin: "+user.getLogin()+"\nPassword: "+user.getPassword());
				email.addTo(user.getEmail());
				email.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}
			this.user=new ClienteDataBean();
			return "Registrazione avvenuta con successo! Riceverà una mail con login e password";
		}
	}
	
	

	public ClienteDataBean getUser() {
		return user;
	}

	public void setUser(ClienteDataBean user) {
		this.user = user;
	}
	
}

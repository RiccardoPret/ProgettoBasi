package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.InsertHelper;
import model.ClienteDataBean;

@ManagedBean(name = "register")
@SessionScoped
public class RegisterView implements Serializable{
	
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
			return "Registrazione fallita!";
		}
		else{
			this.user=new ClienteDataBean();
			return "Registrazione avvenuta con successo!";
		}
	}
	
	

	public ClienteDataBean getUser() {
		return user;
	}

	public void setUser(ClienteDataBean user) {
		this.user = user;
	}
	
}

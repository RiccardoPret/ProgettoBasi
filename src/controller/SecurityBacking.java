package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "auth")
@SessionScoped
public class SecurityBacking implements Serializable{
	
	public String invalidateSession(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/client/index.jsf?faces-redirect=true";
	}
	
	public String getWelcome(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		return "Buongiorno "+request.getUserPrincipal().getName();
	}
	
	public String getUsername(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		return request.getUserPrincipal().getName();
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

		request.getSession().invalidate();
		return "/client/index.jsf?faces-redirect=true";
	}
}
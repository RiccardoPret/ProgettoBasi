package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped

public class SecurityBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2809921352461594333L;

	public String invalidateSession() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/index.jsf?faces-redirect=true";
	}
	
	public boolean isLoggedIn() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		return request.getUserPrincipal() != null;
	}
	
	public String getUsername(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		return request.getUserPrincipal().getName();
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();

		request.getSession().invalidate();
		return "/index.jsf?faces-redirect=true";
	}
}
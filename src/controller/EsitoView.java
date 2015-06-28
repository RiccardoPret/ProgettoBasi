package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.ClienteDataBean;
import model.DataBean;
import model.PostoSpiaggiaDataBean;
import util.AltriLiberiStrategy;
import util.CheckLiberoStrategy;
import util.ClienteByUsernameStrategy;
import util.InsertHelper;

@ManagedBean(name="esito")
@SessionScoped
public class EsitoView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4630450511530386684L;

	@ManagedProperty(value = "#{securityBacking}")
	private SecurityBacking securityBacking;
	
	private boolean esito;
	private Date data_inizio,data_fine;
	
	private List<PostoSpiaggiaDataBean> alternative;
	
	public EsitoView(){
		
	}
	
	@PostConstruct
	public void initialize(){
		
	}
	
	
	public void setEsito(long data_inizio, long data_fine,String stabName,int posto){
		this.setEsito(new Date(data_inizio), new Date(data_fine), stabName, posto);
	}
	
	public void setEsito(String data_inizio,String data_fine,String stabName,int posto){
		SimpleDateFormat parserSDF=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.setEsito(parserSDF.parse(data_inizio), parserSDF.parse(data_fine)
								, stabName, posto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	//cliente si tira gi� da login
	//magari nel security backing segnarsi anche l'id utente?
	public void setEsito(Date data_inizio, Date data_fine,String stabName,int posto){
		int cliente=0;
		this.data_inizio=data_inizio;
		this.data_fine=data_fine;
		//estraggo l'id dell'utente
		String username=this.securityBacking.getUsername();
		ClienteByUsernameStrategy cbus=new ClienteByUsernameStrategy(username);
		try {
			List<DataBean> list=cbus.getSelectedBeans();
			if(list.size()==1){
				cliente=((ClienteDataBean)list.get(0)).getId();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//estratto id utente
		
		CheckLiberoStrategy cls=new CheckLiberoStrategy(stabName, posto
								, new java.sql.Date(data_inizio.getTime())
								, new java.sql.Date(data_fine.getTime()));
		
		try {
			this.esito=cls.getSelectedBeans().isEmpty() 
					&& cls.postospiaggiaExists(posto)
					&& data_fine.compareTo(data_inizio)>=0;
			if(this.esito){
				InsertHelper.insertPrenotazione(cliente, data_inizio, data_fine, stabName, posto);
				this.alternative=new ArrayList<PostoSpiaggiaDataBean>(0);
				return;
			}
			else{
				if(data_fine.compareTo(data_inizio)<0){
					this.alternative=new ArrayList<PostoSpiaggiaDataBean>(0);
					return;
				}
				AltriLiberiStrategy als=
						new AltriLiberiStrategy(new java.sql.Date(data_inizio.getTime())
												, new java.sql.Date(data_fine.getTime()));
				List<DataBean> listAlternative=als.getSelectedBeans();
				this.alternative=new ArrayList<PostoSpiaggiaDataBean>(listAlternative.size());
				for (DataBean dataBean : listAlternative) {
					this.alternative.add((PostoSpiaggiaDataBean)dataBean);
				}
				
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.esito=false;
		this.alternative=new ArrayList<PostoSpiaggiaDataBean>(0);
		
	}
	
	public String prenotaSu(PostoSpiaggiaDataBean psdb){
		this.setEsito(this.data_inizio, this.data_fine, psdb.getStabilimento(), psdb.getNumero());
		return "/client/esito.jsf?faces-redirect=true";
	}

	public boolean getEsito() {
		return esito;
	}

	public List<PostoSpiaggiaDataBean> getAlternative() {
		return alternative;
	}

	public SecurityBacking getSecurityBacking() {
		return securityBacking;
	}

	public void setSecurityBacking(SecurityBacking securityBacking) {
		this.securityBacking = securityBacking;
	}

	
	
}

package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.DataBean;
import model.PrezzoFilaDataBean;
import model.StabilimentoDataBean;
import util.PrezzoFileStrategy;
import util.StabilimentoDetailStrategy;

@ManagedBean(name = "stab_detail")
@SessionScoped
public class StabilimentoView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8265962058594555799L;
	private StabilimentoDataBean stab;
	private int numeroPosti;
	private List<PrezzoFilaDataBean> prezzi;
	
	private String data_inizio,data_fine;
	private int postoDaPrenotare;
	
	@ManagedProperty(value="#{esito}")
	private EsitoView esito;
	
	public StabilimentoView(){
		
	}

	@PostConstruct
	public void initialize(){
		//this.setStabilimento("");//o uso GET e lo setto qua
								 //o faccio chiamare set dal main
		this.stab=new StabilimentoDataBean();
	}
	
	public void setStabilimento(String nomestab){
		StabilimentoDetailStrategy sds=new StabilimentoDetailStrategy(nomestab);
		PrezzoFileStrategy pfs=new PrezzoFileStrategy(nomestab);
		try {
			List<DataBean> listDetail=sds.getSelectedBeans();
			if(listDetail.size()==1){
				this.stab=(StabilimentoDataBean)listDetail.get(0);
				
				this.numeroPosti=sds.getNumeroPosti();
				
				List<DataBean> listPrezzi=pfs.getSelectedBeans();
				this.prezzi=new ArrayList<PrezzoFilaDataBean>(listPrezzi.size());
				for (DataBean db : listPrezzi) {
					this.prezzi.add((PrezzoFilaDataBean)db);
				}
				
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.stab=new StabilimentoDataBean();
		this.numeroPosti=0;
	}
	
	public String goToEsito(){
		this.esito.setEsito(this.data_inizio, this.data_fine, this.stab.getNome(), this.postoDaPrenotare);
		return "/client/esito.jsf?faces-redirect=true";
	}
	
	//***********************GETTERS E SETTERS***************

	public StabilimentoDataBean getStab() {
		return stab;
	}

	public void setStab(StabilimentoDataBean stab) {
		this.stab = stab;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public List<PrezzoFilaDataBean> getPrezzi() {
		return prezzi;
	}

	public void setPrezzi(List<PrezzoFilaDataBean> prezzi) {
		this.prezzi = prezzi;
	}

	public EsitoView getEsito() {
		return esito;
	}

	public void setEsito(EsitoView esito) {
		this.esito = esito;
	}

	public String getData_inizio() {
		return data_inizio;
	}

	public void setData_inizio(String data_inizio) {
		this.data_inizio = data_inizio;
	}

	public String getData_fine() {
		return data_fine;
	}

	public void setData_fine(String data_fine) {
		this.data_fine = data_fine;
	}

	public int getPostoDaPrenotare() {
		return postoDaPrenotare;
	}

	public void setPostoDaPrenotare(int postoDaPrenotare) {
		this.postoDaPrenotare = postoDaPrenotare;
	}
	
}

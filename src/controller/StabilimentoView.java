package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.DataBean;
import model.PrezzoFilaDataBean;
import model.StabilimentoDataBean;
import util.PrezzoFileStrategy;
import util.StabilimentoDetailStrategy;

@ManagedBean(name = "stab_detail")
@SessionScoped
public class StabilimentoView implements Serializable{
	
	private StabilimentoDataBean stab;
	private int numeroPosti;
	private List<PrezzoFilaDataBean> prezzi;
	
	public StabilimentoView(){
		
	}

	@PostConstruct
	public void initialize(){
		//this.setStabilimento("");//o uso GET e lo setto qua
								 //o faccio chiamare set dal main
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
	
	
	
}

package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import util.StabilimentiCorrentiStrategy;
import model.DataBean;
import model.StabilimentoDataBean;

@ManagedBean(name = "main")
@SessionScoped
public class MainView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7026650632022943058L;

	private List<StabilimentoDataBean> apertiOggi;
	private List<StabilimentoDataBean> allStabilimenti;
	
	@ManagedProperty(value = "#{stab_detail}")
	private StabilimentoView stab_detail;
	
	
	public MainView(){
		
	}
	
	@PostConstruct
	public void initialize(){
		this.setApertiOggi();
		this.setAllStabilimenti();
	}
	
	public List<StabilimentoDataBean> getAllStabilimenti(){
		return this.allStabilimenti;
	}
	
	public void setAllStabilimenti() {
		StabilimentiCorrentiStrategy scs=
				new StabilimentiCorrentiStrategy("all_stabs", new ArrayList<Object>(0));
		
		try {
			List<DataBean> list=scs.getSelectedBeans();
			List<StabilimentoDataBean> toRet=new ArrayList<StabilimentoDataBean>(list.size());
			for (DataBean db : list) {
				toRet.add((StabilimentoDataBean)db);
			}
			this.allStabilimenti=toRet;
			return ;
		} catch (SQLException e) {
			e.printStackTrace();
			this.allStabilimenti= new ArrayList<StabilimentoDataBean>(0);
			return ;
		}
		
	}

	public List<StabilimentoDataBean> getApertiOggi(){
		return this.apertiOggi;
	}
	
	private void setApertiOggi(){
		StabilimentiCorrentiStrategy scs=new StabilimentiCorrentiStrategy();
		try {
			List<DataBean> list=scs.getSelectedBeans();
			List<StabilimentoDataBean> toRet=new ArrayList<StabilimentoDataBean>(list.size());
			for (DataBean db : list) {
				toRet.add((StabilimentoDataBean)db);
			}
			this.apertiOggi=toRet;
			return ;
		} catch (SQLException e) {
			e.printStackTrace();
			this.apertiOggi= new ArrayList<StabilimentoDataBean>(0);
			return ;
		}
	}
	
	public String goToDetail(String stabname){
		this.stab_detail.setStabilimento(stabname);
		return "/client/stabilimento_detail.jsf?faces-redirect=true";
	}

	public StabilimentoView getStab_detail() {
		return stab_detail;
	}

	public void setStab_detail(StabilimentoView stab_detail) {
		this.stab_detail = stab_detail;
	}
	
	
}

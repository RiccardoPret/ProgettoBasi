package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import util.StabilimentiCorrentiStrategy;
import model.DataBean;
import model.StabilimentoDataBean;

@ManagedBean(name = "main")
@SessionScoped
public class MainView implements Serializable{
	
	private List<StabilimentoDataBean> apertiOggi;
	
	public MainView(){
		
	}
	
	@PostConstruct
	public void initialize(){
		this.setApertiOggi();
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
}

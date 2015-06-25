package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DataBean;
import model.StabilimentoDataBean;

public class StabilimentoDetailStrategy extends DataBeanGetStrategy{

	public StabilimentoDetailStrategy(String stabname) {
		List<Object> pars=new ArrayList<Object>(1);
		pars.add(stabname);
		this.queryName="dettaglio_stab";
		this.params=pars;
	}
	
	@Override
	protected DataBean buildDataBean(ResultSet rs) throws SQLException {
		StabilimentoDataBean sdb=new StabilimentoDataBean();
		sdb.setNome(rs.getString("nome"));
		sdb.setLocalita(rs.getString("localita"));
		sdb.setVia(rs.getString("via"));
		sdb.setCivico(rs.getString("civico"));
		sdb.setCitta(rs.getString("citta"));
		sdb.setTelefono(rs.getString("telefono"));
		
		sdb.setResponsabile(rs.getString("responsabile"));
		sdb.setData_apertura(rs.getDate("data_apertura"));
		sdb.setData_chiusura(rs.getDate("data_chiusura"));
		sdb.setHa_salagiochi(rs.getBoolean("ha_salagiochi"));
		sdb.setHa_volley(rs.getBoolean("ha_volley"));
		sdb.setHa_bocce(rs.getBoolean("ha_ristorante"));
		sdb.setH_apertura(rs.getTime("h_apertura"));
		sdb.setH_chiusura(rs.getTime("h_chiusura"));
		sdb.setSpecialita(rs.getString("specialita"));
		return sdb;
	}
	
}

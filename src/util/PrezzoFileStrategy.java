package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DataBean;
import model.PrezzoFilaDataBean;

public class PrezzoFileStrategy extends DataBeanGetStrategy{
	
	public PrezzoFileStrategy(String stabname){
		List<Object> pars=new ArrayList<Object>(1);
		pars.add(stabname);
		this.queryName="prezzo_fila";
		this.params=pars;
	}

	@Override
	protected DataBean buildDataBean(ResultSet rs) throws SQLException {
		PrezzoFilaDataBean pfdb=new PrezzoFilaDataBean();
		pfdb.setFila(rs.getInt("mfila"));
		pfdb.setPeriodo_nome(rs.getString("periodo_nome"));
		pfdb.setPrezzo(rs.getBigDecimal("prezzo"));
		pfdb.setMinPosto(rs.getInt("minposto"));
		pfdb.setMaxPosto(rs.getInt("maxposto"));
		return pfdb;
	}
	
}

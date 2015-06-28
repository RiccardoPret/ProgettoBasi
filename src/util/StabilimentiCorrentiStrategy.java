package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DataBean;
import model.StabilimentoDataBean;

public class StabilimentiCorrentiStrategy extends DataBeanGetStrategy {

	public StabilimentiCorrentiStrategy() {
		super("stab_aperti_oggi",new ArrayList<Object>(0));
	}
	
	public StabilimentiCorrentiStrategy(String queryalt, List<Object> args){
		super(queryalt,args);
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
		return sdb;
	}

}

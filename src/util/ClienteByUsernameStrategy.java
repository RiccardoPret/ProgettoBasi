package util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ClienteDataBean;
import model.DataBean;

public class ClienteByUsernameStrategy extends DataBeanGetStrategy{

	public ClienteByUsernameStrategy(String username) {
		this.queryName="get_by_username";
		this.params=new ArrayList<Object>(1);
		this.params.add(username);
	}
	
	@Override
	protected DataBean buildDataBean(ResultSet rs) throws SQLException {
		ClienteDataBean cdb=new ClienteDataBean();
		cdb.setId(rs.getInt("codice"));
		return cdb;
	}

}

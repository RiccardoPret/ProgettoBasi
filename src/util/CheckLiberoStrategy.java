package util;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DataBean;
import model.NoleggioGiornalieroDataBean;

public class CheckLiberoStrategy extends DataBeanGetStrategy {

	public CheckLiberoStrategy(String stabname,int numPosto,Date startDate,Date endDate) {
		List<Object> pars=new ArrayList<Object>(1);
		pars.add(stabname);
		pars.add(numPosto);
		pars.add(startDate);
		pars.add(endDate);
		this.queryName="check_prenotabile";
		this.params=pars;
	}
	
	//torno null perch� tanto mi interessa solo che ritorni righe o no
	@Override
	protected DataBean buildDataBean(ResultSet rs) throws SQLException {
		return null;
	}

}

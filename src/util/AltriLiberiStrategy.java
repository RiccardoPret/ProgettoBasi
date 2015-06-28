package util;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DataBean;
import model.PostoSpiaggiaDataBean;

public class AltriLiberiStrategy extends DataBeanGetStrategy{

	public AltriLiberiStrategy(Date dataInizio,Date dataFine) {
		this.queryName="posti_liberi_periodo";
		this.params=new ArrayList<Object>(2);
		this.params.add(dataInizio);
		this.params.add(dataFine);
		}
	
	@Override
	protected DataBean buildDataBean(ResultSet rs) throws SQLException {
		PostoSpiaggiaDataBean psdb=new PostoSpiaggiaDataBean();
		psdb.setStabilimento(rs.getString("stabilimento"));
		psdb.setNumero(rs.getInt("numero"));
		psdb.setFila(rs.getInt("fila"));
		psdb.setNumero_sdraio(rs.getInt("numero_sdraio"));
		return psdb;
	}

}

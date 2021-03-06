package test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DataBean;

import org.junit.Test;

import util.DatabaseDriver;
import util.Query;
import util.StabilimentoDetailStrategy;

public class DettaglioStabTest {

	@Test
	public void test() {
		String stab="Bagno Maria";
		StabilimentoDetailStrategy strat=new StabilimentoDetailStrategy(stab);
		try {
			for(DataBean db:strat.getSelectedBeans()){
				System.out.println(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String qText=Query.getInstance().getQuery("n_posti_stab");
		DatabaseDriver dbd=new DatabaseDriver();
		dbd.openConnection();
		try {
			PreparedStatement ps=dbd.getOpenedConnection().prepareStatement(qText);
			ps.setObject(1, stab);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				System.out.println(rs.getInt("numeropostispiaggia"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

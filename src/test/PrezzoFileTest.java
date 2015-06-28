package test;

import java.sql.SQLException;

import model.DataBean;

import org.junit.Test;

import util.PrezzoFileStrategy;

public class PrezzoFileTest {

	@Test
	public void test() {
		String stab="Bagno Maria";
		PrezzoFileStrategy strat=new PrezzoFileStrategy(stab);
		try {
			for(DataBean db:strat.getSelectedBeans()){
				System.out.println(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.DataBean;

import org.junit.Test;

import util.StabilimentiCorrentiStrategy;

public class StabilimentiOggiTest {

	@Test
	public void test() {
		StabilimentiCorrentiStrategy strat=new StabilimentiCorrentiStrategy();
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

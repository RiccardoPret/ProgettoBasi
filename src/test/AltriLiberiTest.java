package test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import model.DataBean;

import org.junit.Test;

import util.AltriLiberiStrategy;

public class AltriLiberiTest {

	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			AltriLiberiStrategy strat=
					new AltriLiberiStrategy(new Date(sdf.parse("10/06/2015").getTime())
											, new Date(sdf.parse("10/08/2015").getTime()));
			for (DataBean db : strat.getSelectedBeans()) {
				System.out.println(db);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import model.DataBean;

import org.junit.Test;

import util.CheckLiberoStrategy;
import util.StabilimentiCorrentiStrategy;

public class CheckLiberoTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//secondo gli insert di default questo � libero
		CheckLiberoStrategy strat=null;
				
		try {
			strat=new CheckLiberoStrategy("Bagno Maria", 15
					, new Date(sdf.parse("10/08/2015").getTime())
					, new Date(sdf.parse("16/08/2015").getTime()));
			assertTrue(strat.getSelectedBeans().isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//secondo gli insert di default questo � occupato
		
		try {
			strat=new CheckLiberoStrategy("Bagno Maria", 1
					, new Date(sdf.parse("18/06/2015").getTime())
					, new Date(sdf.parse("24/06/2015").getTime()));
			assertTrue(!strat.getSelectedBeans().isEmpty());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

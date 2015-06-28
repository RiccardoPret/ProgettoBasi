package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import util.InsertHelper;

public class InsertTest {

	@Test
	public void insertUser() {
		InsertHelper.insertUser("asd", "asd", "asd", "passaporto", "asd", "asd", "asd7"
								, "asd7", "asd");
		
	}
	
	@Test
	public void insertPrenotation(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			InsertHelper.insertPrenotazione(1, new Date(sdf.parse("10/07/2015").getTime())
								, new Date(sdf.parse("20/07/2015").getTime())
								, "Stabilimento Silver", 7);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import util.InsertHelper;

public class InsertTest {

	@Test
	public void insertUser() {
		InsertHelper.insertUser("asd", "asd", "asd", "passaporto", "asd", "asd", "asd6"
								, "asd6", "asd");
		
	}
	
	@Test
	public void insertPrenotation(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			InsertHelper.insertPrenotazione(1, new Date(sdf.parse("10/07/2015").getTime())
								, new Date(sdf.parse("20/07/2015").getTime())
								, "Stabilimento Silver", 4);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

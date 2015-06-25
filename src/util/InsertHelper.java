package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertHelper {
	
	public boolean insertUser(String nome,String cognome, String residenza, String tipoDoc
			,String enteDoc,String numDoc,String email, String user,String password){
		String qText=Query.getInstance().getQuery("new_utente");
		DatabaseDriver.getInstance().openConnection();
		PreparedStatement ps;
		try {
			ps = DatabaseDriver.getInstance().getOpenedConnection().prepareStatement(qText);
			ps.setObject(1, nome);
			ps.setObject(2, cognome);
			ps.setObject(3, residenza);
			ps.setObject(4, tipoDoc);
			ps.setObject(5, enteDoc);
			ps.setObject(6, numDoc);
			ps.setObject(7, email);
			ps.setObject(8, user);
			ps.setObject(9, password);
		
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		DatabaseDriver.getInstance().closeConnection();
		return true;
	}
	
	
}

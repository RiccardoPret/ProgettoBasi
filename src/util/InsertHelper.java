package util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class InsertHelper {
	
	public static boolean insertUser(String nome,String cognome, String residenza, String tipoDoc
			,String enteDoc,String numDoc,String email, String user,String password){
		String qText=Query.getInstance().getQuery("new_utente");
		DatabaseDriver dbd=new DatabaseDriver();
		dbd.openConnection();
		PreparedStatement ps;
		try {
			ps = dbd.getOpenedConnection().prepareStatement(qText);
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
			ps.close();
		} catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		dbd.closeConnection();
		return true;
	}
	
	public static boolean insertPrenotazione(int cliente,Date data_inizio, Date data_fine
							,String stabName,int posto){
		String qText=Query.getInstance().getQuery("new_prenota");
		DatabaseDriver dbd=new DatabaseDriver();
		dbd.openConnection();
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = dbd.getOpenedConnection()
					.prepareStatement(qText, Statement.RETURN_GENERATED_KEYS);
			ps.setObject(1,cliente);
			ps.setObject(2,new java.sql.Date(data_inizio.getTime()));
			ps.setObject(3,new java.sql.Date(data_fine.getTime()));
			ps.execute();
			rs=ps.getGeneratedKeys();
			if(rs.next()){
				int codPrenotazione=rs.getInt(1);
				ps.close();
				rs.close();
				dbd.closeConnection();
				
				Date data_cursor=new Date(data_inizio.getTime());
				while(data_cursor.compareTo(data_fine)<=0 
						&& InsertHelper.insertNoleggioGiornaliero(data_cursor, stabName
															, posto, codPrenotazione)){
					Calendar c=Calendar.getInstance();
					c.setTime(data_cursor);
					c.add(Calendar.DATE, 1);
					data_cursor=c.getTime();
				}
				return true;
			}
			else{
				System.out.println("PRENOTAZIONE ERRATA");
				ps.close();
				rs.close();
				dbd.closeConnection();
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean insertNoleggioGiornaliero(Date data	,String stabName,int posto,int idPren){
		String qText2=Query.getInstance().getQuery("new_prenota_singolo");
		DatabaseDriver dbd=new DatabaseDriver();
		try {
			dbd.openConnection();
			PreparedStatement ps = dbd.getOpenedConnection()
					.prepareStatement(qText2);
			ps.setObject(1, new java.sql.Date(data.getTime()));
			ps.setObject(2, posto);
			ps.setObject(3, stabName);
			ps.setObject(4, idPren);
			ps.execute();
			ps.close();
			dbd.closeConnection();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbd.closeConnection();
		return false;
	}
	
	
	
	
}

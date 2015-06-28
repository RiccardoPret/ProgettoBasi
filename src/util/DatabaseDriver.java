package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import login.MyLoginModule;


/*
 * Classe che si occupa di interfacciare le query disponibili in modo semplice e leggibile
 */

public class DatabaseDriver {
	private Connection connection;

	private static ReservedReader DBCredential; // Evito le credenziali
												// hard-coded. Esse sono in un
												// file inaccessibile
	private static String dbFile = "credential.txt";
	private static String separator = "=>";

	public DatabaseDriver() {
		super();
		if(DBCredential==null){
			 DBCredential=new ReservedReader(MyLoginModule.class, dbFile, separator);
		}
	}

	/*
	 * L'utene ha la possibilit� di aprirsi e chiudersi la connessione a
	 * piacere. In questo modo se deve eseguire pi� query non deve continuamente
	 * aprire e chiudere la connessione. Questo metodo, apre la connessione e poi la ritorna
	 */
	public void openConnection() {
		try {
			Driver myDriver = (Driver) Class.forName(
					DBCredential.getValue("driver").replace(" ", "")).newInstance();
			DriverManager.registerDriver(myDriver);
			// creazione della connessione
			connection = DriverManager.getConnection(
					DBCredential.getValue("url").replace(" ", ""),
					DBCredential.getValue("username").replace(" ", ""),
					DBCredential.getValue("password").replace(" ", ""));
		} catch (ClassNotFoundException e) {
			System.out.println("Driver non trovato");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Conessione al database non riuscita");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getOpenedConnection(){
		if(this.connection!=null){
			return this.connection;
		}
		System.out.println("Connessione non aperta!");
		return null;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			while (e.getNextException() instanceof SQLException)
				e.printStackTrace();
		}
	}

}

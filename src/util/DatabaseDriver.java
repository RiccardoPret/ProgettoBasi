package util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import login.MyLoginModule;

import org.postgresql.geometric.PGpoint;


/*
 * Classe che si occupa di interfacciare le query disponibili in modo semplice e leggibile
 */

public class DatabaseDriver {
	private static DatabaseDriver instance;
	private Connection connection;

	private static ReservedReader DBCredential; // Evito le credenziali
												// hard-coded. Esse sono in un
												// file inaccessibile
	private static String dbFile = "credential_local.txt";
	private static String separator = "=>";

	private DatabaseDriver() {
		super();
	}

	public static DatabaseDriver getInstance() {
		if (instance == null) {
			instance = new DatabaseDriver();
			DBCredential = new ReservedReader(MyLoginModule.class, dbFile, separator);

			System.out.println("Inizio Credenziali lette da DatabaseDriver***************");
			System.out.println(DBCredential.getValue("driver"));
			System.out.println(DBCredential.getValue("url"));
			System.out.println(DBCredential.getValue("username"));
			System.out.println(DBCredential.getValue("password"));
			System.out.println("Fine Credenziali lette da DatabaseDriver***************");
		}
		return instance;
	}

	private void checkInstantiation() {
		if (instance == null) {
			System.out
					.println("Non aprire connessioni senza prima avere istanziato l'oggetto!");
			instance = new DatabaseDriver();
		}
	}

	/*
	 * L'utene ha la possibilità di aprirsi e chiudersi la connessione a
	 * piacere. In questo modo se deve eseguire più query non deve continuamente
	 * aprire e chiudere la connessione. Questo metodo, apre la connessione e poi la ritorna
	 */
	public void openConnection() {
		checkInstantiation();
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

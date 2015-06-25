package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ReservedReader {

	private HashMap<String, String> map;
	private Object startingPointClass;
	private String fileName;
	private String separator;

	public ReservedReader(Object obj, String fileName) {
		this.startingPointClass = obj;
		this.fileName = fileName;
		this.separator = "=>";

		mapInstantiate();
	}

	public ReservedReader(Object obj, String fileName, String separator) {
		this.startingPointClass = this;
		this.fileName = fileName;
		this.separator = separator;

		mapInstantiate();
	}

	/*
	 * Carica nell'hashmap tutte le coppie chiave valore nel file
	 */
	private void mapInstantiate() {
		String qName = "";
		String qText = "";
		map = new HashMap<String, String>();
		BufferedReader in = null;
		//Importante: non mettere commenti in mezzo a una query, perchè in questo caso viene preso anche quello
		try {
			in = new BufferedReader(new FileReader(getReservedPath()));
			String line = "";
			while ((line = in.readLine()) != null) {
				if (line.contains(separator)) {
					String parts[] = line.split(this.separator);
					qName = parts[0];
					qText = parts[1]+" ";
				} else {
					qText += line+" ";
					if (line.contains(";")) {
						map.put(qName, qText);
						qName="";
					}
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// apertura del file fallita
			e.printStackTrace();
		} catch (IOException e) {
			// lettura del file o chiusura del file fallita
			e.printStackTrace();
		}
	}

	/*
	 * Restituisce il nome della classe senza il package completo e con il
	 * .class
	 */
	private String getObjectClassName() {
		String s = this.startingPointClass.getClass().getName();

		s = s.substring(s.lastIndexOf(".") + 1);
		s += ".class";
		return s;
	}

	/*
	 * Da il percorso completo del file riservato da dove leggere i dati
	 */

	private String getReservedPath() {
		Path path = null;

		try {
			path = Paths.get(startingPointClass.getClass()
					.getResource(getObjectClassName()).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		// Vado indietro fino alla cartella WEB-INF, la quale contiene la
		// cartella reserved
		while (!(path = path.getParent()).getFileName().toString()
				.equals("WEB-INF"))
			;

		return path.getParent().toString() + "/queries/" + this.fileName;
	}

	public String getValue(String key) {
		return map.get(key);
	}
}
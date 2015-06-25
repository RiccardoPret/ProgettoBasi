package util;

import login.MyLoginModule;

public class TestQueryReader {

	public static void main(String[] args) {
		ReservedReader r= new ReservedReader(MyLoginModule.class, "credential.txt", "=>");
		//ReservedReader r= new ReservedReader(MyLoginModule.class, "query.sql", "=}");
		//System.out.println(r.getValue("driver")+r.getValue("username"));
		System.out.println("*********" + r.getValue("url")
				+ r.getValue("username") + r.getValue("password"));
	}

}
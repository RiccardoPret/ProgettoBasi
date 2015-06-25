package util;

public class TestQueryReader {

	public static void main(String[] args) {
		System.out.println(Query.getInstance().getQuery("new_prenota"));
		System.out.println(Query.getInstance().getQuery("posti_liberi_periodo"));
	}

}
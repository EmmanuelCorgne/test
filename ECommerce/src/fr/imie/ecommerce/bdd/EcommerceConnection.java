package fr.imie.ecommerce.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EcommerceConnection {
	
	private String url = "jdbc:mysql://127.0.0.1:3306/Ecommerce";
	private String user = "root";
	private String passwd = "";
	private static Connection connect;

	private EcommerceConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		try {
			
			connect = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() throws ClassNotFoundException {
		if (connect == null) {
			new EcommerceConnection();
		}
		return connect;
	}
}

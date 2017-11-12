package br.com.caelum.agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "123456";
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			} 
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return connection;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} 
	}
}

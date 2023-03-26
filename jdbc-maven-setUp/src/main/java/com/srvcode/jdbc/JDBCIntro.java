package com.srvcode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * While using maven, we can directly add jdbc driver dependency
 * in pom.xml instead of add externa jar.
 * 
 */
public class JDBCIntro {
	
	public static void main(String[] args) {
		/*
		 * databaseUrl pattern = "jdbc:db_type://host:port/db_name";
		 */
		String databaseUrl = "jdbc:mysql://localhost:3307";
		String user = "root";
		String password = "admin";
		Connection con = null;

		try {
			/*
			 * To register a specific JDBC driver(available in our package) with our
			 * application
			 */
			Class.forName("com.mysql.cj.jdbc.Driver"); // Throws ClassNotFound exception

			/*
			 * Creating connection object by calling DriverManager.getConnection(url,
			 * username, pass)
			 */
			con = DriverManager.getConnection(databaseUrl, user, password); // Throws SQLException

			if (con != null) {
				System.out.println("The connection has been succesfully established!");
			}
		} catch (SQLException e) {
			System.out.println("A connection error has occured.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

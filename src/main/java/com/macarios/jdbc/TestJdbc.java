package com.macarios.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main( String[] args ) {
		String jdbcUrl = "jdbc:mysql://192.168.99.100:3306/spring?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String user = "spring";
		String password = "spring";
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection sucessful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package com.read.csv.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	public static DBConnector d1;
	public static Connection connection;

	private DBConnector() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser", "qweQWe123!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		if (d1 == null) {
			
			d1 = new DBConnector();
		}
		return connection;

	}
}

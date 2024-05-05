package com.read.csv.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDatabaseConnectivity2 {

	public static void main(String[] args) throws SQLException {

		// Connect to the DATABASE\
		//VAULT 
		Connection connection = DriverManager.getConnection("jdbc:mysql://139.59.91.96:3306/SR_DEV", "produser",
				"qweQWe123!");

		// Read Data from tables

		Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery("SELECT * from mst_oem;");
		int total = 0;
		while (rs.next()) {
			total =total+1;
			System.out.println(rs.getString("name") + "\t" + rs.getString("code"));
		}
		
		System.out.println("total entries"+total);
		
		
		statement.executeQuery("INSERT INTO SR_DEV.mst_oem\r\n"
				+ "(name, code, is_active, created_at, modified_at)\r\n"
				+ "VALUES('Demo', 'demo', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);\r\n"
				+ "");
		
		
		statement.executeQuery("UPDATE INTO SR_DEV.mst_oem\r\n"
				+ "(name, code, is_active, created_at, modified_at)\r\n"
				+ "VALUES('Demo', 'demo', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);\r\n"
				+ "");

		
		statement.execute("DELETE FROM SR_DEV.mst_oem\r\n"
				+ "WHERE id=0;\r\n"
				+ "");
		
		
				}
}

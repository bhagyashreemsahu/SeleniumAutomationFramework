package com.read.csv.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MST_OEM_DAO {
	Connection connection;
	Statement statement;
	MST_OEM_POJO data;

	public MST_OEM_DAO() {
		// TODO Auto-generated constructor stub
		connection = DBConnector.getConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void insertOEM() {
//
//	}

	public MST_OEM_POJO getOEMInfoBy(int id, String name) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT id, name, code, is_active, created_at, modified_at\r\n"
				+ "FROM SR_DEV.mst_oem\r\n" + "WHERE id=" + id + "and name=\"" + name + "\"");

		int total = 0;
		while (rs.next()) {
			total = total + 1;
			data = new MST_OEM_POJO(id, rs.getString("name"), rs.getString("code"));
			// System.out.println(rs.getString("name") + "\t" + rs.getString("code"));
		}

		return data;
	}

	public MST_OEM_POJO getOEMInfoBy(int id) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT id, name, code, is_active, created_at, modified_at\r\n"
				+ "FROM SR_DEV.mst_oem\r\n" + "WHERE id=" + id + ";\r\n" + "");

		int total = 0;
		while (rs.next()) {
			total = total + 1;
			data = new MST_OEM_POJO(id, rs.getString("name"), rs.getString("code"));
		}

		return data;
	}

	public void updateOEMInfoWith(String id) {

	}

	public void deleteOEMBy(String id) {

	}
}

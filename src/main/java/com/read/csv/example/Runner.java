package com.read.csv.example;

import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) throws SQLException {

		MST_OEM_DAO mstDao = new MST_OEM_DAO();
		MST_OEM_POJO myData = mstDao.getOEMInfoBy(8);
		System.out.println(myData.getCode());
		System.out.println(myData.getName());
		System.out.println(myData);
	}
}

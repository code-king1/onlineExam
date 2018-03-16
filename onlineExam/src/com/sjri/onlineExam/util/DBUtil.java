package com.sjri.onlineExam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn != null) // if there is a connection already return it,
							// otherwise establish one
			return conn;
		else {
			try {
				Class.forName(AppConstant.DRIVER);
				conn = DriverManager.getConnection(AppConstant.URL, AppConstant.USERNAME, AppConstant.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();

			}
			return conn;
		}

	}
}
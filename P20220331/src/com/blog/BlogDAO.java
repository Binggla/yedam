package com.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogDAO {
	static Connection conn;
	static ResultSet rs;
	static PreparedStatement psmt;

	public static Connection getConnect() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return conn;
	}

	public static void disconnect() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

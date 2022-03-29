package com.prod.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement psmt;
	
	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결 성공!");
		return conn;
	}
	
	public static void disconnect() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

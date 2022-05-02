package co.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	static Connection conn;
	static ResultSet rs;
	static PreparedStatement psmt;
	static Statement stmt;

	public static Connection getConnect() {
		
		System.out.println("서버 연결 완");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost", "hr", "hr"); // 192.168.0.109
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
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

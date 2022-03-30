package com.prod.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	static Connection conn;
	static ResultSet rs;
		// getType(Type bar) : 현재 커서 위치에 있는 행으로부터 데이터를 읽어온다.
		// execute() : 리턴값이 ResultSet일 경우 true, ResultSet이 아닌 경우 false 반환.
		// executeQuery(String sql) : ResultSet 타입으로 쿼리 결과값 반환.
		// next() : 커서의 다음 행이 존재할 경우 true를 리턴한 후 그 행으로 이동.
		//			마지막 행에 도달하면 false를 리턴한다.
		// executeUpdate() : insert/delete/update 관련 구문에서는 반영된 레코드의 건수를 반환.
		//					 create/drop 관련 구문에서는 -1을 반환.
	
	static Statement stmt;
	static PreparedStatement psmt;	
		// Statement와 달리 PreparedStatement는 객체를 캐시에 담아 재사용한다.
		// 반복적으로 쿼리를 수행한다면 Statement에 비해 성능이 좋다.
	
	public static Connection getConnect() {	// DB 연결 하기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void disconnect() {	// DB 연결 닫기
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

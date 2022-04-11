package com.prod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// ojdbc6 라이브러리 추가, 오라클DB 연결(db접속주소, hr, hr), connection객체
// query 실행(Statement, PreparedStatement)
public class JDBCSample {
	
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement psmt = null;
	
	// Statement와 PreparedStatement의 차이점 알아두기!
	
	public static Connection getConnect() {
		
		// DriverManager
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		} catch (ClassNotFoundException  | SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("연결 성공!");
		return conn;
		
	}
	
	public static void disconnect( ) {
		
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.addSuppressed(e);
		}
		
	}
	
	public static void main(String[] args) {
		
		conn = getConnect();
		
		// Statement 객체 생성 (쿼리 결과를 가져온다)
		
		try {
			
			// delete (삭제)
			
			int emp_id = 301;
		
			
			String sql = "delete emp_java "
					+ "where employee_id = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp_id);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
			
			// update (수정)
//			int emp_id = 301;
//			String first_name = "subin";
//			String phone_number = "010-5678-5678";
//			int salary = 10000;
//			
//			String sql = "update emp_java "
//					+ "set first_name = ?, "
//					+ "    phone_number = ?, "
//					+ "    salary = ? "
//					+ "where employee_id = ? ";
//			
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, first_name);
//			psmt.setString(2, phone_number);
//			psmt.setInt(3, salary);
//			psmt.setInt(4, emp_id);
//			
//			int r = psmt.executeUpdate();
//			System.out.println(r + "건 입력됨.");
			
			// insert (입력)
//			int emp_id = 301;
//			String last_name = "subin";
//			String email = "subin@email.com";
//			String hire_date = "2020-03-05";
//			String job = "IT_PROG";
//			
//			String sql = "insert into emp_java (employee_id, last_name, email, hire_date, job_id)\r\n"
//						+ "values ("+emp_id+", '"+last_name+"', '"+email+"', '"+hire_date+"', '"+job+"')";
//			int r = stmt.executeUpdate(sql);
//			System.out.println(r + "건 입력됨.");
			
			
			// select (조회)
//			rs = stmt.executeQuery("select * from emp_java order by employee_id");
//				// executeQuery() : SQL문을 이용하여 결과값을 받아오는 메소드
//			while(rs.next()) { // next() : 가져올 건이 있다면, 한 건 가져오기
//				System.out.println("사원번호 : " + rs.getInt("employee_id")); 	// getInt() : 가져온 값이 정수형일 때
//				System.out.println("이름 : " + rs.getString("first_name")); // getString() : 가져온 값이 문자열일 때
//			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		disconnect();
		
		
	}
}

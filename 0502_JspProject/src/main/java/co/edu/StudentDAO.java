package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {

	// id로 한 건 조회
	public Student searchStudent(String id) {
		
		conn = getConnect();
		String sql = "SELECT * FROM student_info WHERE student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Student stud = new Student();
				stud.setStudentNo(rs.getInt("student_no"));
				stud.setStudentName(rs.getString("student_name"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setKorScore(rs.getInt("kor_score"));
				
				return stud;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 학생 정보 수정
	public boolean modStudent(Student stud) {
		conn = getConnect();
		String sql = "UPDATE student_info SET student_name=?, eng_score=?, kor_score=? WHERE student_no=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, stud.getStudentName());
			psmt.setInt(2, stud.getEngScore());
			psmt.setInt(3, stud.getKorScore());
			psmt.setInt(4, stud.getStudentNo());
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r+"건 변경");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			disconnect();
		}
		
		System.out.println("fail");
		return false;
	}
	
	// 한 건 삭제
	public boolean delStudent(String id) {
		conn = getConnect();
		String sql = "DELETE FROM student_info WHERE student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r+"건 삭제");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}
	
	// 한 건 추가
	public boolean addStudent(Student stud) {
		conn = getConnect();
		String sql = "INSERT INTO student_info VALUES(?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stud.getStudentNo());
			psmt.setString(2, stud.getStudentName());
			psmt.setInt(3, stud.getEngScore());
			psmt.setInt(4, stud.getKorScore());
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r+"건 입력");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return false;
	}
	
	// 전체 조회
	public List<Student> stuList() {
		conn = getConnect();
		List<Student> stuList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("SELECT * FROM student_info ORDER BY student_no");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Student stu = new Student();
				stu.setStudentNo(rs.getInt("student_no"));
				stu.setStudentName(rs.getString("student_name"));
				stu.setEngScore(rs.getInt("eng_score"));
				stu.setKorScore(rs.getInt("kor_score"));
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	return stuList;
	}
	
}

package co.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {

	// 전체 조회
	public List<Student> stuList() {
		conn = getConnect();
		System.out.println("연결완료");
		List<Student> stuList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from student_info");
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

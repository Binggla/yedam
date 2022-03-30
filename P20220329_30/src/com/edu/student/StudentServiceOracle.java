package com.edu.student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceOracle extends DAO implements StudentService {

	@Override
	public String sameOrNot(int stuNo) {
		List<Student> list = studentList();
		for (Student s : list) {
			if (s.getStuNo() == stuNo) {
				return "same";
			}
		}
		return "not same";
	}
	
	@Override
	public void insertStudent(Student stu) {
		conn = getConnect();
		String sql = "insert into student_info " + "values (?, ?, ?, ?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stu.getStuNo());
			psmt.setString(2, stu.getStuName());
			psmt.setInt(3, stu.getEngScore());
			psmt.setInt(4, stu.getKorScore());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 등록!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public List<Student> studentList() {

		conn = getConnect();
		List<Student> students = new ArrayList<>();
		String sql = "select * from student_info " + "order by student_no";

		try {

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Student stu = new Student();
				stu.setStuNo(rs.getInt("student_no"));
				stu.setStuName(rs.getString("student_name"));
				stu.setEngScore(rs.getInt("eng_score"));
				stu.setKorScore(rs.getInt("kor_score"));

				students.add(stu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return students;
	}
	
	@Override
	public void searchStudentNo(int stuNo) {

		conn = getConnect();
		Student stu = null;
		String sql = "select * from student_info " + "where student_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stuNo);
			rs = psmt.executeQuery();

			if (rs.next()) {
				stu = new Student();
				stu.setStuNo(rs.getInt("student_no"));
				stu.setStuName(rs.getString("student_name"));
				stu.setEngScore(rs.getInt("eng_score"));
				stu.setKorScore(rs.getInt("kor_score"));

			}
			System.out.println(stu);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public List<Student> searchStudentName(String name) {

		List<Student> students = new ArrayList<>();
		
		conn = getConnect();
		Student stu = null;
		String sql = "select * from student_info " + "where student_name = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();

			while (rs.next()) {
				stu = new Student();
				stu.setStuNo(rs.getInt("student_no"));
				stu.setStuName(rs.getString("student_name"));
				stu.setEngScore(rs.getInt("eng_score"));
				stu.setKorScore(rs.getInt("kor_score"));
				students.add(stu);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return students;
	}

	@Override
	public void modifyStudent(Student stu) {
		conn = getConnect();
		String sql = "update student_info " + "set eng_score = ?, " + "    kor_score = ? " + "where student_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stu.getEngScore());
			psmt.setInt(2, stu.getKorScore());
			psmt.setInt(3, stu.getStuNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void removeStudent(int stuNo) {
		conn = getConnect();
		String sql = "delete student_info " + "where student_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stuNo);

			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void saveToFile() {

	}

}

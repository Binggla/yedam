package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FullDAO extends DAO {
	
	//리스트
	
	public List<FullVO> getList() {
		String sql = "SELECT * FROM full_calendar";
		getConnect();
		
		List<FullVO> list = new ArrayList<>();
		try {
			
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				FullVO vo = new FullVO(rs.getString("title"), rs.getString("start_date"), rs.getString("end_date"));
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
		
	}
	
	
	//한건입력
	public void insertSchedule(FullVO vo) {
		String sql = "INSERT INTO full_calendar VALUES (?,?,?)";
		getConnect();
		
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getStartDate());
			psmt.setString(3, vo.getEndDate());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	
	//한건삭제
	public void deleteSchedule(String title) {
		String sql = "DELETE FROM full_calendar WHERE title=?";
		getConnect();
		
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
}

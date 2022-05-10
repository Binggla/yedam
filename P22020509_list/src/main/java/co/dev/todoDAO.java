package co.dev;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class todoDAO extends DAO {
	
	// 한 건 입력
	public void insertTodo(String title) {
		getConnect();
		
		String sql = "INSERT INTO todo(id, title) VALUES(todo_seq.NEXTVAL, ?)";
		
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r + "건 입력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
//	// 한 건 조회 (아이디 값 반환)
//	public int selectId()
	
	
	// 한 건 삭제
	public void deleteTodo(String id) {
		getConnect();
		
		String sql = "DELETE FROM todo WHERE id = ?";
		
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r +"건 삭제");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	
	// 체크표시
	public void todoChecked(String id) {
		
		getConnect();
		
		String sql = "UPDATE todo SET checked='checked' WHERE id=?";
		
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);			
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r + "건 체크 완");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	// 체크표시 삭제
	public void todoUnchecked(String id) {
			
		getConnect();
			
		String sql = "UPDATE todo SET checked='unchecked' WHERE id=?";
			
		try {
				
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);		
			
			int r = psmt.executeUpdate();
			if (r > 0) {
				System.out.println(r + "건 체크 해제 완");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
			
	}
	
	// 전체 리스트
	public List<todoVO> todoList() {
		
		
		getConnect();
		
		String sql = "SELECT * FROM todo ORDER BY id";
		List<todoVO> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				todoVO vo = new todoVO(rs.getString("id"), rs.getString("title"), rs.getString("checked"));
				list.add(vo);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return list;
	}
	
	
}

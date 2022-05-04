package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVo;

public class MemberDAO extends DAO {
	
	// 한 건 수정
	public void updateMember(MemberVo member) {
		conn = getConnect();
		String sql = "UPDATE member SET pwd=?, name=?, email=? WHERE id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getEmail());
			psmt.setString(4, member.getId());
			
			int r = psmt.executeUpdate();
			
			if (r > 0) {
				System.out.println(r + "건 수정");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	// 한 건 삭제
	public void deleteMember(String id) {
		conn = getConnect();
		String sql = "DELETE FROM member WHERE id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			
			if (r > 0) {
				System.out.println(r + "건 삭제");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}
	
	// 한 건 조회
	public MemberVo searchMember(String id) {
		conn = getConnect();
		String sql = "SELECT * FROM member WHERE id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				return vo;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	// 한 건 추가
	public void insertMember(MemberVo member) {
		conn = getConnect();
		String sql = "INSERT INTO member(id, name, pwd, email) VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPwd());
			psmt.setString(4, member.getEmail());
			
			int r = psmt.executeUpdate();
			
			if(r > 0 ) {
				System.out.println(r+"건 입력");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}

	// 모든 회원 조회
	public List<MemberVo> searchMembers() {

		conn = getConnect();
		List<MemberVo> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement("SELECT * FROM member ORDER BY id");
			rs = psmt.executeQuery();
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
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

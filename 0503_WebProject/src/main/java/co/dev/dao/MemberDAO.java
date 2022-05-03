package co.dev.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dev.DAO;
import co.dev.vo.MemberVo;

public class MemberDAO extends DAO {
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

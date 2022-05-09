package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVo;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public void memberDelete(String id) {
		dao.deleteMember(id);
	}
	
	public void memberUpdate(MemberVo member) {
		dao.updateMember(member);
	}
	
	public MemberVo memberSearch(String id) {
		return dao.searchMember(id);
	}
	
	public void memberInsert(MemberVo member) {
		dao.insertMember(member);
	}

	public List<MemberVo> memberList() {
		return dao.searchMembers();
		
	}
}

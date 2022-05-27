package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.StudentVO;

public interface StudentService {
	
	// 기본 CRUD; 모두 studentVO 객체로 파라미터를 넘겨준다.
	List<StudentVO> studentSelectList();	// 학생 리스트
	StudentVO studentSelect(StudentVO vo);	// 1명 데이터 조회 or 로그인 체크
	int studentInsert(StudentVO vo);
	int studentUpdate(StudentVO vo);
	int studentDelete(StudentVO vo);
	
	boolean studentIdCheck(String id);		// 아이디 중복 체크
}

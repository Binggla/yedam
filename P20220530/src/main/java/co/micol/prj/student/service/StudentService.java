package co.micol.prj.student.service;

import java.util.List;

import co.micol.prj.student.vo.StudentVO;

public interface StudentService {
	
	List<StudentVO> studentSelectList();
	StudentVO studentSelect(StudentVO vo);
	int studentInsert(StudentVO vo);
	int studentUpdate(StudentVO vo);
	int studentDelete(StudentVO vo);
	
	boolean idCheck(String id);
	
}

package co.micol.prj.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.student.service.StudentService;
import co.micol.prj.student.vo.StudentVO;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentDao;
	
	@RequestMapping("/studentList.do")
	public String studentList(Model model) {
		model.addAttribute("students", studentDao.studentSelectList());
		return "student/studentList";
	}
	
	@RequestMapping("/studentJoinForm.do")
	public String studentJoinForm() {
		return "student/studentJoinForm";
	}
	
	@PostMapping("/studentJoin.do")
	public String studentJoin(StudentVO vo, Model model) {
		// getParameter같은 것 필요없이, form에서 넘어온 name 변수의 값이 자동으로 vo에 담긴다.
		// vo가 가지고 있는 변수와 name 변수가 동일해야 한다. ex) vo의 id = input의 name="id"
		int n = studentDao.studentInsert(vo);
		if (n != 0) {
			model.addAttribute("message", "학생 등록이 완료되었습니다.");
		} else {
			model.addAttribute("message", "학생 등록 실패!");
		}
		return "student/studentJoin";
	}
	
	@GetMapping("/ajaxIdCheck.do")
	@ResponseBody
	public String ajaxIdCheck(String id) {
		boolean b = studentDao.idCheck(id);
		String data = "N";	// 사용 불가능
		
		if(!b) {
			data = "Y";	// false 값이 넘어오면, 사용 가능 아이디
		}
		
		return data;
	}
}

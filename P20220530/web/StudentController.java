package co.micol.prj.student.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/studentLoginForm.do")
	public String studentLoginForm() {
		return "student/studentLoginForm";
	}
	
	@PostMapping("/studentLogin.do")
	public String studentLogin(HttpServletRequest request, StudentVO vo, Model model, HttpSession session) {
		vo = studentDao.studentSelect(vo); 
		if (vo != null) {
			session.setAttribute("student", vo);
			model.addAttribute("message", "님 환영합니다.");
		} else {
			model.addAttribute("message", "잘못된 아이디 혹은 패스워드입니다.");
		}
		return "student/studentLogin";
	}
	
	@RequestMapping("/studentLogout.do")
	public String studentLogout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("message", "로그아웃 완료");
		return "student/studentLogout";
	}
}

package co.micol.prj.student.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.student.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentDao;	// DAO 객체를 자동 주입
	
	@RequestMapping("/studentList.do")
	public String studentList(Model model) {	// 모델 객체를 통해서 집어넣자. 모델 객체? 찾아보기.
		model.addAttribute("students", studentDao.studentSelectList());
		return "student/studentList";	// do, method, jsp 이름 일치시킨다.
	}
}

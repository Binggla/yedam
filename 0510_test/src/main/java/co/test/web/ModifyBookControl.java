package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.service.BookService;
import co.test.vo.BookVO;

public class ModifyBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BookService service = new BookService();
		
		String bookCode = request.getParameter("bookCode");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		int price = 0;
		
		try {
			price = Integer.valueOf(request.getParameter("price"));
		} catch(NumberFormatException e) {
			String sprice = request.getParameter("price");
			
			if (title.isBlank() || author.isBlank() || press.isBlank() || sprice.isBlank()) {
				request.setAttribute("error", "모든 항목을 입력하세요.");
				request.getRequestDispatcher("view/modify.jsp").forward(request, response);
				return;
			}
		}
		
		BookVO vo = new BookVO(bookCode, title, author, press, price);
		service.modifyBook(vo);
		
		request.setAttribute("modVO", vo);

		request.getRequestDispatcher("result/modifyOutput.jsp").forward(request, response);
	}

}

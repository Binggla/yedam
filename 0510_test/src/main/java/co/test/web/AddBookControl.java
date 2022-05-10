package co.test.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.test.dao.BookDAO;
import co.test.service.BookService;
import co.test.vo.BookVO;

public class AddBookControl implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
				request.getRequestDispatcher("view/add.jsp").forward(request, response);
				return;
			}
			
		}
		
		
		BookVO vo = new BookVO(null, title, author, press, price);
		
		BookService service = new BookService();
		service.addBook(vo);
		
		request.setAttribute("title", vo.getBookTitle());
		
		request.getRequestDispatcher("result/addOutput.jsp").forward(request, response);

	}

}

package co.dev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/todoServ")
public class todoServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public todoServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		todoDAO dao = new todoDAO();
		List<todoVO> list = dao.todoList();
		
		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String job = request.getParameter("job");
		System.out.println("job = " + job);
		todoDAO dao = new todoDAO();
		
		if (job.equals("insert")) {
			
			String title = request.getParameter("title");
			System.out.println("title : " + title);
			dao.insertTodo(title);
			
		} else if (job.equals("delete")) {
			
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			dao.deleteTodo(id);
			
		} else if (job.equals("checked")) {
			
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			dao.todoChecked(id);
			
		} else if (job.equals("unchecked")) {
			
			String id = request.getParameter("id");
			System.out.println("id : " + id);
			dao.todoUnchecked(id);
			
		}
		
		
		
	}

}

package co.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.Content;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FileUploadServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// multipart 요청
		// 매개값 5개를 넣어주어야 한다. -> request, 저장위치, 최대 사이즈, 인코딩, 리네임 정책
		
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		
		// parameter로는 값을 읽어올 수 없다.
		// String title = request.getParameter("title");
		// String contetn = request.getParameter("content");
		
		
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());	
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String profile = multi.getOriginalFileName("profile"); // 실제 파일 이름
		String fileName = multi.getFilesystemName("profile"); // 리네임 정책에 의한 이름
		System.out.println("title : " + title + ", content : "+ content + ", profile : " + profile + ", fileName : " + fileName);
	}

}

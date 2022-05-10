package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

//	BookVO
//	private String bookCode; book_code
//	private String bookTitle; book_title
//	private String bookAuthor; book_author
//	private String bookPress; book_press
//	private int bookPrice; book_price
	
	public List<BookVO> bookList() {
		conn();
		List<BookVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM book_info ORDER BY book_code";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return list;
	}

	public BookVO selectBook(String bookCode) {
		conn();
		String sql = "SELECT * FROM book_info WHERE book_code=?";
		BookVO vo = new BookVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			
			int r = psmt.executeUpdate();
			
			if (r>0) {
				System.out.println(r + "건 조회");
				
				rs = psmt.executeQuery();
				while (rs.next()) {
					vo.setBookCode(rs.getString("book_code"));
					vo.setBookTitle(rs.getString("book_title"));
					vo.setBookAuthor(rs.getString("book_author"));
					vo.setBookPress(rs.getString("book_press"));
					vo.setBookPrice(rs.getInt("book_price"));
				}
				
				return vo;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			disconn();
		}
		
		return null;
	}

	public void insertBook(BookVO book) {
		conn();
		String sql = "INSERT INTO book_info\r\n"
				+ "VALUES (create_bookcode,?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			
			int r = psmt.executeUpdate();
			
			if(r>0) {
				System.out.println(r + "건 입력");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}

	public void updateBook(BookVO book) {
		conn();
		String sql = "UPDATE book_info\r\n"
				+ "SET book_title = ?,\r\n"
				+ "      book_author = ?,\r\n"
				+ "      book_press =? ,\r\n"
				+ "      book_price = ?\r\n"
				+ "WHERE book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());
			
			int r = psmt.executeUpdate();
			
			if(r>0) {
				System.out.println(r + "건 수정");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}

	}

	public void deleteBook(String bookCode) {
		
		conn();
		String sql = "DELETE FROM book_info\r\n"
				+ "WHERE book_code = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);

			
			int r = psmt.executeUpdate();
			
			if(r>0) {
				System.out.println(r + "건 삭제");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}
}

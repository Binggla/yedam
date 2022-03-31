package com.blog;

import java.util.List;

public interface BlogService {

	// 블로그 로그인
	
	// 1. 아이디 입력
	// 1.1 비밀번호 입력 -> 등록된 회원이 맞는 지 check
	public boolean login(User user);
	
	// 2. 회원 가입 
	// 2.1. 아이디(userId) 입력
	// 2.2. 비밀번호(userPw) 입력
	// 2.3. user_info table에 insert
	public boolean insertUser(User user);
	
	
	// 블로그 접속
	
	// 1. 전체 게시글 목록 ( 메뉴 : 1. 게시글 보기 2. 게시글 조회 3. 게시글 등록 )
	public List<Writing> getList();
	
	// 1.1. 게시글 보기 -> 게시글 번호 입력하여 글 상세보기
	// 1.1.1. 게시글 ( 수정 / 삭제 / 댓글 달기 / 뒤로 가기 )
	
		// 게시글 수정 updatePost()
		// 1. 수정할 게시글 번호 입력  -> 해당하는 번호 있는 지 check
		// 2. 제목 입력
		// 3. 글 입력
		public boolean updatePost(Writing writing);
		
		// 게시글 삭제 deletePost()
		// 1. 게시판 선택
		// 2. 삭제할 게시글 번호 입력   -> 해당하는 번호 있는 지 check
		public boolean deletePost(int writingNo);
		
		// 댓글 달기 
		public boolean commenting();
		
	// 1.2. 게시글 조회 ( 메뉴 : 1. 게시판별 조회 2. 글 번호 조회 3. 제목 조회 4. 날짜 조회 )
	
		// 1.2.1. 게시판별 조회 selectListName()
		// 		( 메뉴 : 1. diary 2. life info 3. food info )
		public List<Writing> selectListName(String boardName);
		// 1.2.2. 게시글 번호로 조회 selectListNo() -> Primary key
		// 		게시글 번호 입력
		public List<Writing> selectListNo(int writingNo);
		// 1.2.3. 제목으로 조회 selectListSubject()
		//		제목 입력
		public List<Writing> selectListSubject(String writingSub);
		// 1.2.4. 날짜로 조회 selectListDate()
		//		검색할 첫번째 날짜, 두번째 날짜 입력
		public List<Writing> selectListDate(String writingDate1, String writingDate2);
	
	// 1.3. 게시글 등록 insertPost() -> 게시판(boardName), 게시글 번호(writingNo), 작성 일시(writingDate), 작성자(userId), 제목(writingSub), 글(writing)
	// 1.3.1. 게시판 선택
	// 1.3.2. 게시글 번호 입력 -> 중복된 번호 있는 지 check
	// 1.3.3. 제목 입력
	// 1.3.4. 글 입력
	public boolean insertPost(Writing writing);
		
	
	// 유저 체크 checkUser()
	// 본인이 작성한 글만 수정, 삭제할 수 있도록 체크한다.
	public boolean checkUser(User user, int writingNo);
	
	// 중복 체크 searchWriting()
	// 동일한 번호의 게시글이 있는 지 체크.
	public boolean searchWriting(int writingNo);


	

}

package com.blog;

import java.util.List;

public interface BlogService {
	
	// 클래스
	// User -> userId, userPw, userName, userBirth, userPhone
	// Writing extends User -> User.userId, boardName, writingNo, writingDate,  writingSub, writing
	// Comment extends Writing -> User.userId, Writing.writingNo, commentNo, commentDate, userComment
	// ReComment extends Comment -> Comment.commentNo, reUserId, reCommentNo, reCommentDate, userReComment
	
	
	// 블로그 로그인 ( 메뉴 :  1. 로그인 2. 회원가입 3. 종료 )
	
	// 1. 로그인
	public boolean login(User user);
	// 1.2 아이디 입력
	// 1.3 비밀번호 입력
	//	; 등록된 회원이 맞는 지 체크
	
	// 2. 회원 가입 
	public boolean insertUser(User user);
	// 2.1 아이디 입력
	//	; 중복된 아이디 있는 지 체크
	// 2.2 비밀번호 입력
	// 2.3 성명
	
	// 3. 비밀번호 찾기
	
	
	// 블로그 접속
	
	// 전체 게시글 목록 ( 메뉴 : 1. 게시글 상세보기 2. 게시글 조회 3. 게시글 등록 4. 마이페이지 5. 로그아웃 )
	public List<Writing> getList();
	
	// 1. 게시글 상세보기
	//		; 게시글 번호 입력
	public Writing getWriting(int writingNo);
	public List<Comment> getComment(int writingNo);
	public List<ReComment> getReComment(int commentNo);
		// 게시글 ( 메뉴 : 1. 글 수정 / 2. 글 삭제 / 3. 댓글 등록 / 4. 댓글 수정 / 4. 댓글 삭제 / 9. 뒤로 가기 )
		// 1. 게시글 수정
		public boolean updatePost(Writing writing);
		// 1.1 수정할 게시글 번호 입력
		//		; 본인이 작성한 게시글만 수정 가능
		// 1.2 제목 수정 입력
		// 1.3 글 수정 입력
		
		// 2. 게시글 삭제
		public boolean deletePost(int writingNo);
		// 2.1. 삭제할 게시글 번호 입력
		//	 	; 본인이 작성한 게시글만 삭제 가능
		//	 	; 정말로 삭제하시겠습니까? 선택
		
		// 3.1 댓글 등록 ( 메뉴 : 1. 새 댓글 등록 / 2. 답글 등록 )
		// 3.1.1 새 댓글 등록
		public boolean commenting(Comment comment);
		// 3.1.2 답글 등록
		public boolean reCommenting(ReComment reCom);
		
		// 3.2 댓글 수정
		public boolean updateComment(Comment comment);
		public boolean updateReComment(Comment recomment);
		// 3.2.1 수정할 댓글 번호 입력
		//		; 본인이 작성한 댓글만 수정 가능
		// 3.2.2 댓글 수정 입력

		// 3.3 댓글 삭제
		public boolean deleteComment(int commentNo);
		
		public boolean deleteReComment(int recommentNo);
		// 3.3.1 삭제할 댓글 번호 입력
		//		; 본인이 작성한 댓글만 삭제 가능
		//		; 정말로 삭제하시겠습니까? 선택
		
	// 2. 게시글 조회 ( 메뉴 : 1. 말머리 조회 2. 작성자 조회 3. 제목 조회 4. 작성일 조회 )
		// 2.1 말머리 조회 ( 메뉴 : 1. 일기 2. 생활정보 3. 맛집정보 )
		public List<Writing> selectListName(String boardName);
		// 2.2 제목 조회
		public List<Writing> selectListSub(String subWord);
		// 2.3 작성자 조회
		// 		작성자 입력
		public List<Writing> selectListUser(String userId);
		// 2.4 작성일 조회
		// 		검색할 첫번째 날짜, 두번째 날짜 입력
		public List<Writing> selectListDate(String writingDate1, String writingDate2);
	
	// 3. 게시글 등록
	public boolean insertPost(Writing writing);
	// 3.1 카테고리 선택 ( 메뉴 : 1. 일기 2. 생활정보 3. 맛집정보 )
	// 3.2 제목 입력
	// 3.3 글 입력
		
	// 4. 마이페이지 ( 메뉴 : 1. 내 정보 2. 내 게시글 3. 내 댓글 )
		// 4.1 내 정보 ( 메뉴 : 1. 내 정보 수정 2. 회원 탈퇴 )
		public User selectMyInfo(String userId);
		// 4.1.1 내 정보 수정
		public boolean updateMyInfo(User user);
		// 4.1.2 비밀번호 수정
		public boolean checkMyPw(User user, String currentPw);
		public boolean updateMyPw(User user);
		// 4.1.3 회원 탈퇴
		public boolean deleteUser(User user, String userPw);
		
		// 4.2 내 게시글
		public List<Writing> selectMyPost(User user);
		// 4.3 내 댓글
		public List<Comment> selectMyComment(User user);

	
	// 유저 체크(회원가입) checkUser()
	// 이미 생성된 아이디가 있는 지 체크
	public boolean checkUser(String userId);
	
	// 유저 체크(글) checkUser()
	// 본인이 작성한 글만 수정, 삭제할 수 있도록 체크
	public boolean checkUser(User user, int writingNo);
	
	// 유저 체크(댓글) checkUserComment()
	// 본인이 작성한 댓글만 수정, 삭제할 수 있도록 체크
	public boolean checkUserComment(User user, int comentNo);
	public boolean checkUserReComment(User user, int recommentNo);

//	public boolean searchComment(int writingNo, int commentNo);
	

}

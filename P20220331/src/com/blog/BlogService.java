package com.blog;

import java.util.List;

public interface BlogService {

	// 전체 게시글 보기
	public List<Writing> getList();
	
	// 게시글 조회 
	// 1. 게시판 이름으로 조회 selectListName() -> 일기(diaryBoard), 생활정보(lifeInfoBoard), 맛집정보(foodInfoBoard)
	public List<Writing> selectListName();
	// 2. 게시글 번호로 조회 selectListNo() -> Primary key
	public List<Writing> selectListNo();
	// 3. 제목으로 조회 selectListSubject() -> %String%
	public List<Writing> selectListSubject();
	// 4. 날짜로 조회 selectListDate()
	public List<Writing> selectListDate();
			
	// 게시글 등록 insertPost() -> 게시판(boardName), 게시글 번호(writingNo), 제목(writingSubject), 작성 날짜와 시간(writingDate), 글(writing)
	// 1. 게시판 선택
	// 2. 게시글 번호 입력
	// 3. 제목 입력
	// 4. 글 입력
	public boolean insertPost();
		
	// 게시글 수정 updatePost()
	// 1. 수정할 게시글 번호 입력
	// 2. 제목 입력
	// 3. 글 입력
	public boolean updatePost();
			
	// 게시글 삭제 deletePost()
	// 1. 게시판 선택
	// 2. 삭제할 게시글 번호 입력
	public boolean deletePost();

}

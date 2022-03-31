package com.blog;

public class Writing extends User {

	private String boardName;
	private int writingNo;
	private String writingDate;
	private String writingSub;
	private String writing;
	private String userIdComment;
	private String userComment;
	private String userCommentDate;

	public Writing() {
		super();
	}

	public Writing(String boardName, int writingNo, String writingSub, String userId, String writingDate,
			String writing) {
		super(userId);
		this.boardName = boardName;
		this.writingNo = writingNo;
		this.writingSub = writingSub;
		this.writingDate = writingDate;
		this.writing = writing;
	}

	public Writing(String userIdComment, String userComment, String userCommentDate) {
		this();
		this.userIdComment = userIdComment;
		this.userComment = userComment;
		this.userCommentDate = userCommentDate;
	}

	public String getUserIdComment() {
		return userIdComment;
	}

	public void setUserIdComment(String userIdComment) {
		this.userIdComment = userIdComment;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getWritingNo() {
		return writingNo;
	}

	public void setWritingNo(int writingNo) {
		this.writingNo = writingNo;
	}

	public String getWritingSub() {
		return writingSub;
	}

	public void setWritingSub(String writingSub) {
		this.writingSub = writingSub;
	}

	public String getWritingDate() {
		return writingDate;
	}

	public void setWritingDate(String writingDate) {
		this.writingDate = writingDate;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public String getUserCommentDate() {
		return userCommentDate;
	}

	public void setUserCommentDate(String userCommentDate) {
		this.userCommentDate = userCommentDate;
	}

	@Override
	public String toString() {

		String str = "\n\t게시판\t" + boardName + "\r\n" //
				+ "\t글 번호\t" + writingNo + "\r\n" //
				+ "\t날짜\t" + writingDate + "\r\n" //
				+ "\t작성자\t" + super.getUserId() + "\r\n" //
				+ "\t제목\t" + writingSub + "\r\n" //
				+ "\t\t" + writing; //

		return str;
	}

}

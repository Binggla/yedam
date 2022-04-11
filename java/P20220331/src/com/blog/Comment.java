package com.blog;

public class Comment extends Writing {

	private int commentNo;
	private String commentDate;
	private String userComment;

	public Comment() {
		super();
	}

	public Comment(int writingNo, String userId, String userComment, String userNickname) {
		super(writingNo, userId);
		this.userComment = userComment;
		super.setUserNickname(userNickname);
	}
	
	public Comment(int writingNo, String userId, int commentNo, String userComment) {
		super(writingNo, userId);
		this.commentNo = commentNo;
		this.userComment = userComment;
	}
	
	public Comment(String userId, int commentNo) {
		super(userId);
		this.commentNo = commentNo;
	}


	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	@Override
	public String toString() {
		String str = " [" + commentNo + "] [" +  super.getUserNickname() + "] " + userComment + " (" + commentDate.substring(0, 10) + ")"; //

		return str;
	}
	
	public String printMyComment() {
		String str = " " + super.getWritingNo() + "\t" + this.getCommentNo() + "\t" + this.getCommentDate().substring(0, 10) + "\t" + this.getUserComment();
		return str;
	}

}

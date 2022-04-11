package com.blog;

public class ReComment extends Comment {

	private String reUserId;
	private int reCommentNo;
	private String reCommentDate;
	private String userReComment;

	public ReComment() {
		
	}
	
	public ReComment(int writingNo, String userId, int commentNo, String userComment) {
		super(writingNo, userId, commentNo, userComment);
	}
	
	public ReComment(String userId, int commentNo, String userReComment, String userNickname) {
		super(userId, commentNo);
		this.userReComment = userReComment;
		super.setUserNickname(userNickname);
	}
	
	public String getReUserId() {
		return reUserId;
	}

	public void setReUserId(String reUserId) {
		this.reUserId = reUserId;
	}

	public int getReCommentNo() {
		return reCommentNo;
	}

	public void setReCommentNo(int reCommentNo) {
		this.reCommentNo = reCommentNo;
	}

	public String getReCommentDate() {
		return reCommentDate;
	}

	public void setReCommentDate(String reCommentDate) {
		this.reCommentDate = reCommentDate;
	}

	public String getUserReComment() {
		return userReComment;
	}

	public void setUserReComment(String userReComment) {
		this.userReComment = userReComment;
	}

	@Override
	public String toString() {
		return "  ㄴ [" + reCommentNo + "] [" + super.getUserNickname() + "] " + userReComment + " (" + reCommentDate.substring(0, 10) + ")";
	}
	
//	public String printComment() {
//		String str = "\t[" + super.getCommentNo() + "] " +  super.getUserId() + " : " + super.getUserComment() + "\t" + super.getCommentDate(); //
//		
//		return str;
//	}
//	
//	public String printReComment() {
//		String str = "\t[" + super.getCommentNo() + "] " +  super.getUserId() + " : " + super.getUserComment() + "\t" + super.getCommentDate() //
//					+ "\n\t ㄴ[" + reCommentNo + "] " + reUserId + " : " + userReComment + "\t" + reCommentDate; //
//		
//		return str;
//	}
	
	
	
	

}

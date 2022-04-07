package com.blog;

public class Writing extends User {

	private String boardName;
	private int writingNo;
	private String writingDate;
	private String writingSub;
	private String writing;

	public Writing() {
		
	}
	
	public Writing(String userId) {
		super(userId);
	}

	public Writing(String boardName, String writingSub, String userId, String writing, String userNickname) {
		super(userId);
		this.boardName = boardName;
		this.writingSub = writingSub;
		this.writing = writing;
		super.setUserNickname(userNickname);
	}
	
	public Writing(String boardName, int writingNo, String writingSub, String userId, String writing, String userNickname) {
		super(userId);
		this.boardName = boardName;
		this.writingNo = writingNo;
		this.writingSub = writingSub;
		this.writing = writing;
		super.setUserNickname(userNickname);
	}
	
	public Writing(int writingNo, String userId) {
		super(userId);
		this.writingNo = writingNo;
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

	public void writingList() {
		System.out.printf(" %-11s%-6s%-15s%-17s%-20s\n", boardName, writingNo, writingDate.substring(0, 10), super.getUserNickname(), writingSub);
//		System.out.printf(" " + boardName + "\t  " + writingNo + "\t" + writingDate.substring(0, 10) + "\t%-10s" + "\t" + writingSub + "\n", super.getUserNickname());

	}
	
	@Override
	public String toString() {

		String str = "\n----------------------------------------------------------------\n" //
				+ " " + writingSub + "          |  " + boardName + "  |  " + super.getUserNickname() + "  |  " + writingDate.substring(0,10) + "\n"
				+ "----------------------------------------------------------------\n"
				+ writing;
	

		return str;
	}
}

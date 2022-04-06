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

	public Writing(String boardName, String writingSub, String userId, String writing) {
		super(userId);
		this.boardName = boardName;
		this.writingSub = writingSub;
		this.writing = writing;
	}
	
	public Writing(String boardName, int writingNo, String writingSub, String userId, String writing) {
		super(userId);
		this.boardName = boardName;
		this.writingNo = writingNo;
		this.writingSub = writingSub;
		this.writing = writing;
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

	public String writingList() {
		String str =" " + boardName + "\t  " + writingNo + "\t" + writingDate.substring(0, 10) + "\t" + super.getUserNickname() + "\t" + writingSub; //

		return str;
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

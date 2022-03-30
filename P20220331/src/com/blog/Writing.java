package com.blog;

public class Writing {
	private String boardName;
	private int writingNo;
	private String writingSubject;
	private String writingDate;
	private String writing;

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

	public String getWritingSubject() {
		return writingSubject;
	}

	public void setWritingSubject(String writingSubject) {
		this.writingSubject = writingSubject;
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

	@Override
	public String toString() {
		return "Writing [boardName=" + boardName + ", writingNo=" + writingNo + ", writingSubject=" + writingSubject
				+ ", writingDate=" + writingDate + ", writing=" + writing + "]";
	}
	
	

}

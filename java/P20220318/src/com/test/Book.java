package com.test;

// Book클래스를 선언(필드:책제목, 저자, 출판사, 금액) 
public class Book {
	
	// 필드
	private String bTitle;
	private String bWriter;
	private String bPub;
	private int bPrice;
	
	// 생성자
	public Book(String bTitle, String bWriter, String bPub, int bPrice) {
		this.bTitle = bTitle;
		this.bWriter = bWriter;
		this.bPub = bPub;
		this.bPrice = bPrice;
	}
	
	// 메소드
	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbPub() {
		return bPub;
	}

	public void setbPub(String bPub) {
		this.bPub = bPub;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}
	
	public void printInfo() {
		
		String str = "------------------\n" //
				+ " 제목\t" + this.bTitle + "\n" //
				+ " 저자\t" + this.bWriter + "\n" //
				+ " 출판사\t" + this.bPub + "\n" //
				+ " 금액\t" + this.bPrice + "\n" //
				+ "------------------";
		System.out.println(str);
	}

}

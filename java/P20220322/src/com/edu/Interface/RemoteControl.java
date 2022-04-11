package com.edu.Interface;

public interface RemoteControl {
	
	// 필드 변수 생성 불가
	//private String maxVolume;
	
	// 상수는 생성 가능
	public static final int maxVolume = 10;
	
	// 생성자 생성 불가
	//public Tv() {}
	
	// 추상 메소드
	public void powerOn();
	public void powerOff();
}

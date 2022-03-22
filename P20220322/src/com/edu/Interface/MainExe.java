package com.edu.Interface;

public class MainExe {

	public static void main(String[] args) {
		// 리모컨 -> 라디오, 냉장고, 티비
		
		RemoteControl rm = new Tv();
		rm.powerOn();
		rm.powerOff();
		
		rm = new Radio();
		rm.powerOn();
		rm.powerOff();
		
		rm = new Phone();
		rm.powerOn();
		rm.powerOff();
		
	}

}

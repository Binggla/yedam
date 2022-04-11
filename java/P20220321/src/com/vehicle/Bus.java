package com.vehicle;

public class Bus extends Vehicle {

	public Bus() {
		super.setMaxSpeed(110);
	}
	
	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	}

	@Override
	public void stop() {
		System.out.println("버스가 멈춥니다.");
	}

	@Override
	public String toString() {
		return "Bus의 최고 속도는 " + this.getMaxSpeed() + "km/h입니다.";
	}
}

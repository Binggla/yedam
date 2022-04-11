package com.vehicle;

public class Taxi extends Vehicle {
	
	public Taxi() {
		super.setMaxSpeed(120);
	}
	
	@Override
	public void run() {
		System.out.println("택시가 달립니다.");
	}
	
	@Override
	public void stop() {
		System.out.println("택시가 멈춥니다.");
	}
	
	@Override
	public String toString() {
		return "Taxi의 최고 속도는 " + this.getMaxSpeed() + "km/h입니다.";
	}
	
}

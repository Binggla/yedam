package com.vehicle;

public class Vehicle {

	private int maxSpeed;
	
	public Vehicle() {
		this.maxSpeed = 100;
	}
	
	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void run() {
		System.out.println("탈 것이 달립니다.");
	}
	
	public void stop() {
		System.out.println("탈 것이 멈춥니다.");
	}
	
	@Override
	public String toString() {
		return "Vehicle의 최고 속도는 " + this.getMaxSpeed() + "km/h입니다.";
	}

}

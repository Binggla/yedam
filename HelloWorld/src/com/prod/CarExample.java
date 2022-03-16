package com.prod;

class Car {
	private String model;
	private int speed;
	private int maxSpeed;
	
	public void setModel(String model) {
		this.model = model;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void addSpeed() {
		if (this.speed > this.maxSpeed) {
			System.out.println("최대 속도입니다. 더 빨리 달릴 수 없습니다.");
			return;
		}
		System.out.println("10km 가속합니다. 현재 속도 : " + this.speed);
		this.speed += 10;
	}
	
	public void minusSpeed() {
		if (this.speed <= 0) {
			System.out.println("현재 멈춰 있습니다. 속도를 낮출 수 없습니다.");
			return;
		}
		System.out.println("10km 감속합니다. 현재 속도 : " + this.speed);
		this.speed -= 10;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	
	
}

public class CarExample {

	public static void main(String[] args) {
		
		Car sonata = new Car();
		
		sonata.setModel("Sonata DN8");
		sonata.setSpeed(0);
		sonata.setMaxSpeed(180);
		
		sonata.addSpeed();
		sonata.addSpeed();
		sonata.minusSpeed();
		sonata.minusSpeed();
		sonata.minusSpeed();
		sonata.minusSpeed();



	
		

	}

}

package com.prod_220315;

import java.util.Scanner;

class Car {
	private String model;
	private int speed;
	private int maxSpeed;

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return this.model;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
		while (true) {
			if (0 <= this.speed && this.speed <= 300) {
				this.speed = speed;
				break;
			} else {
				System.out.println("300km/h까지 속도가 제한됩니다. 다시 입력하세요.");
				break;
			}
		}
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		while (true) {
			if (0 <= this.maxSpeed && this.maxSpeed <= 300) {
				this.maxSpeed = maxSpeed;
				break;
			} else {
				System.out.println("300km/h까지 속도가 제한됩니다. 다시 입력하세요.");
				break;
			}
		}
	}

	public void addSpeed() {
		if (this.speed + 10 > this.maxSpeed) {
			System.out.println("최대 속도입니다. 더 빨리 달릴 수 없습니다.");
			return;
		}
		this.speed += 10;
		System.out.println(this.model + "의 속도를 10km/h 증가시킵니다. 현재 속도 : " + this.speed);
	}

	public void minusSpeed() {
		if (this.speed <= 0) {
			System.out.println("현재 멈춰 있습니다. 속도를 낮출 수 없습니다.");
			return;
		}
		this.speed -= 10;
		System.out.println(this.model + "의 속도를 10km/h 감속시킵니다. 현재 속도 : " + this.speed);
	}

	public int getSpeed() {
		return this.speed;
	}

	public int getMaxSpeed() {
		return this.maxSpeed;
	}

}

public class CarExample {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Car car1 = new Car();

		System.out.print("차량 모델을 입력해 주세요. > ");
		car1.setModel(scan.nextLine());
		while (true) {
			System.out.print("처음 속도를 입력해 주세요. (300km/h 제한) > ");
			car1.setSpeed(scan.nextInt());
			if (0 <= car1.getSpeed() && car1.getSpeed() <= 300) {
				break;
			}
		}

		while (true) {
			System.out.print("최대 속도를 입력해 주세요. (300km/h 제한) > ");
			car1.setMaxSpeed(scan.nextInt());
			if (0 <= car1.getMaxSpeed() && car1.getMaxSpeed() <= 300) {
				break;
			}
		}

		System.out.println(car1.getModel() + "가 출발합니다.");
		while (true) {
			System.out.println("--------------------");
			System.out.println("1:가속 2:감속 3:운행종료");
			System.out.println("--------------------");
			int button = scan.nextInt();

			if (button == 1) {
				car1.addSpeed();
			} else if (button == 2) {
				car1.minusSpeed();
			} else if (button == 3) {
				System.out.println("운행이 종료되었습니다.");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 시도하세요.");
				continue;
			}
		}
		
		scan.close();
	}
	

}

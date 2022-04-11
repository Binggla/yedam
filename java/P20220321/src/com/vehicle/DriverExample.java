package com.vehicle;

public class DriverExample {

	public static void main(String[] args) {
		
		Vehicle v1  = new Vehicle();
		v1 = new Taxi();
		v1 = new Bus();
		
		Driver driver = new Driver();
		driver.drive(v1);	// 매개변수의 다형성.
		
		Vehicle vehicle = new Vehicle();
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		System.out.println("Vehicle의 최고 속력 : " + vehicle.getMaxSpeed());
		System.out.println("Taxi의 최고 속력 : " + taxi.getMaxSpeed());
		System.out.println("Bus의 최고 속력 : " + bus.getMaxSpeed());
		System.out.println();
		
		Vehicle[] vehicles = new Vehicle[3];
		
		vehicles[0] = vehicle;
		vehicles[1] = taxi;
		vehicles[2] = bus;
		
		// 속도가 제일 빠른 탈 것의 값부터 정렬.
		
		for (int i = 0; i < vehicles.length; i++) {
			for (int j = i+1; j < vehicles.length; j++) {
				
				int leftNum = vehicles[i].getMaxSpeed();
				int rightNum = vehicles[j].getMaxSpeed();
				
				if (leftNum < rightNum) {
					int temp = leftNum;
					vehicles[i].setMaxSpeed(rightNum);
					vehicles[j].setMaxSpeed(temp);
				}
			}
			System.out.println(vehicles[i].toString());
		}
		

	}

}

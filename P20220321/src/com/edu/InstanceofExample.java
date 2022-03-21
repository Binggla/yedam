package com.edu;

class Shape {

	private int x, y;

	public double getArea() {
		return 0;
	}
}

class Ractangle extends Shape {

	private double width;
	private double height;

	public void setWidth(double width) {
		this.width = width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

}

class Circle extends Shape {

	private double radious;

	public void setRadious(double radious) {
		this.radious = radious;
	}

	@Override
	public double getArea() {
		return radious * radious * 3.14;
	}

}

class Triangle extends Shape {

	private double base;
	private double height;

	public void setBase(double base) {
		this.base = base;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return base * height / 2;
	}
}

public class InstanceofExample {

	public static void main(String[] args) {
		
		Shape s1 = new Ractangle();
		Shape s2 = new Circle();
		Shape s3 = new Triangle();
		
		if (s1 instanceof Ractangle) {
			Ractangle r1 = (Ractangle) s1;
			r1.setWidth(12.3);
			r1.setHeight(7.8);
			System.out.println(r1.getArea());
		}
		
		if (s2 instanceof Circle) {
			Circle r2 = (Circle) s2;
			r2.setRadious(7);
			System.out.println(r2.getArea());
		}

	}

}

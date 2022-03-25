package com.edu.nested;

public class OuterExample {

	public static void main(String[] args) {

		Outer outer = new Outer();
//		outer.method1();
		
		Outer.InstanceInner iInner = outer.new InstanceInner();
		
//		iInner.method2();
		
		outer.method4();
	}

}

package com.edu.generic;

// <T> : 어떤 타입인지는 아직 모르겠거든? 인스턴스가 생성될 때 <> 안에 선언한 타입을 T에 넣어줘.
public class Box<T> {
	T obj;
	
	public void setObj(T obj) {
		this.obj = obj;
	}
	
	public T getObj() {
		return this.obj;
	}

}

package com.edu.Interface2;

import com.edu.Interface.RemoteControl;

public interface Dao extends RemoteControl, Run { // 인터페이스는 상속 가능, 다중 상속도 가능
	
	public abstract void select();	
	public void insert();
	void update();					// public abstract는 생략 가능
	void delete(); 
	
	
}

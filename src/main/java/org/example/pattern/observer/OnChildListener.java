package org.example.pattern.observer;

public interface OnChildListener {

	void hungry();
	
	void fulled(String msg);
	
	void sleepy(int num);
	
}
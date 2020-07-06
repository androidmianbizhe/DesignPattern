package org.example.pattern.observer;

public class Father implements OnChildListener {

	public void cook(){
		System.out.println("Father cook");
	}
	
	public void narrative(){
		System.out.println("Father narrative");
	}
	
	public void cradling(){
		System.out.println("Father cradling");
	}

	@Override
	public void hungry() {
		cook();
	}

	@Override
	public void fulled(String msg) {
		narrative();
	}

	@Override
	public void sleepy(int num) {
		cradling();
	}
}

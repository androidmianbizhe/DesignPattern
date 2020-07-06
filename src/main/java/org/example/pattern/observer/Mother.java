package org.example.pattern.observer;

public class Mother implements OnChildListener {

	public void cook(){
		System.out.println("Mother cook");
	}
	
	public void narrative(){
		System.out.println("Mother narrative");
	}
	
	public void cradling(){
		System.out.println("Mother cradling");
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

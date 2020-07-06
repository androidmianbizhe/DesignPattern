package org.example.pattern.observer;

public class Uncle implements OnChildListener {

	public void cook(){
		System.out.println("Uncle cook");
	}
	
	public void narrative(){
		System.out.println("Uncle narrative");
	}
	
	public void cradling(){
		System.out.println("Uncle cradling");
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

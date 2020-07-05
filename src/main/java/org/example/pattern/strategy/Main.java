package org.example.pattern.strategy;

public class Main {

	public static void main(String[] args) {
		
		Main m = new Main();
		m.eat(new Apple());
		System.out.println("=======================");
		m.eat(new Watermelon());
	}

	public void eat(IFruit ob){
		ob.beEaten();
	}

}

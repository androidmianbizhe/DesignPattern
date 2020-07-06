package org.example.pattern.observer;

public class Main {

	public static void main(String[] args) {


		Child child = new Child();

		final Mother mother = new Mother();

		final Father father = new Father();

		final Uncle uncle = new Uncle();
		
		child.addOnChildListener(mother);
		child.addOnChildListener(father);
		child.addOnChildListener(uncle);

		child.hungry();
		
		child.satiate();
	}

}

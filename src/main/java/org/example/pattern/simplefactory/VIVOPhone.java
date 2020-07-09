package org.example.pattern.simplefactory;

public class VIVOPhone extends BasePhone{

	public VIVOPhone(int id, String name, String identifer) {
		super(id, name, identifer);
	}

	@Override
	public void start() {
		System.out.println("VIVO手机开机!");
	}

	@Override
	public void stop() {
		System.out.println("VIVO手机关机!");
	}
}

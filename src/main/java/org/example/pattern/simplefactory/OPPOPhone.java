package org.example.pattern.simplefactory;

public class OPPOPhone extends BasePhone{

	public OPPOPhone(int id, String name, String identifer) {
		super(id, name, identifer);
	}

	@Override
	public void start() {
		System.out.println("OPPO手机开机!");
	}

	@Override
	public void stop() {
		System.out.println("OPPO手机关机!");
	}

}

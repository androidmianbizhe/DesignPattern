package org.example.pattern.simplefactory;

public class HUAWEIPhone extends BasePhone{

	public HUAWEIPhone(int id, String name, String identifer) {
		super(id, name, identifer);
	}

	@Override
	public void start() {
		System.out.println("HUAWEI手机开机!");
	}

	@Override
	public void stop() {
		System.out.println("HUAWEI手机关机!");
	}
}

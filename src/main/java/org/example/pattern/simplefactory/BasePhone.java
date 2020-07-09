package org.example.pattern.simplefactory;

/**
 * @author Administrator
 *
 */
public abstract class BasePhone {

	protected int id;
	
	public String identifier;

	public String name;
	
	public BasePhone(int id, String name, String identifier){
		this.id = id;
		this.name = name;
		this.identifier = identifier;
	}
	
	public abstract void start();

	public void run(){
		System.out.println(this.name + "手机运行");
		System.out.println("id:" + this.id + "手机名称:" + this.name + "标识:" + this.identifier);
	}

	public abstract void stop();
	
}

package org.example.pattern.singleton;

public class SingleTon1 {

	private String name = "SingleTon1";

	/**
	 * 声明私有静态变量
	 */
	private static SingleTon1 singleIns = new SingleTon1();

	/**
	 * 私有化构造函数
	 */
	private SingleTon1(){

	}

	/**
	 * 实现静态 获取单例的 函数
	 * @return
	 */
	public static SingleTon1 getInstance(){
		return singleIns;
	}

	public void say(){
		System.out.println("恶汉模式"+name);
	}
}


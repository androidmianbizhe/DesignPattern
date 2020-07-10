package org.example.pattern.singleton;

public class SingleTon2 {

	/**
	 * 单纯的属性
	 */
	private String name = "SingleTon2";

	/**
	 * 声明私有静态变量
	 */
	private static SingleTon2 singleIns = null;

	/**
	 * 私有化构造函数
	 */
	private SingleTon2(){

	}

	/**
	 * 实现静态 获取单例的 函数
	 * @return
	 */
	public static synchronized SingleTon2 getInstance(){


		if(singleIns == null){
			singleIns = new SingleTon2();
		}

		return singleIns;

	}

	public void say(){
		System.out.println("懒汉模式"+name);
	}

}

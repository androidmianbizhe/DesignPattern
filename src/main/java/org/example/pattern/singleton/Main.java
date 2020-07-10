package org.example.pattern.singleton;

public class Main {
	
	
	public static void main(String[] args) {

		/**
		 * 饿汉模式
		 */
		SingleTon1.getInstance().say();

		/**
		 * 懒汉模式
		 */
		SingleTon2.getInstance().say();


		/**
		 * 双重锁 模式
		 */
		SingleTon.getInstance().say();

		SingleTon.getInstance().setName("你好呀！！！");

		SingleTon.getInstance().say();
	}

}

package org.example.pattern.singleton;

public class SingleTon {

	/**
	 * 单纯的属性
	 */
	private String name = "SingleTon";

	/**
	 * 声明私有静态变量
	 */
	private static SingleTon singleIns = null;

	/**
	 * 私有化构造函数
	 */
	private SingleTon(){

	}

	/**
	 * 实现静态 获取单例的 函数
	 * @return
	 */
	public static SingleTon getInstance(){

		/**
		 * synchronized 是获取当前的资源，
		 * 如果当前的资源是空闲状态，则给他加上锁；
		 * 如果当前资源已经被其他锁占用，则当前锁则会一直等待，
		 * 直到其他资源释放锁，然后当前锁占用它（或者抛出异常退出）
		 */

		/**
		 * 第一个非空判断是避免当 singleIns不为空时  去获取锁，这样会消耗时间和内存
		 * 想想：如果没有加第一道非空判断，当singleIns有实例时 也会去获取锁
		 * 所以加了这一步非空判断就会避免这种情况
		 */
		if(singleIns == null){

			/**
			 * 获取当前资源的锁
			 */
			synchronized (SingleTon.class) {

				/**
				 * 这次是判断是否有实例
				 */
				if(singleIns == null){
					singleIns = new SingleTon();
				}
			}
		}

		return singleIns;

	}

	public void say(){
		System.out.println("双重锁模式"+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
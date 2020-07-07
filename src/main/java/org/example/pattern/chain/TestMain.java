package org.example.pattern.chain;

import java.util.ArrayList;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * 创建拦截链集合
		 */
		ArrayList<Interceptor> interceptors = new ArrayList<Interceptor>();

		/**
		 * 添加四个拦截链实体
		 */
		interceptors.add(new CustomInterceptor());
		interceptors.add(new GroupLeaderInterceptor());
		interceptors.add(new ManagerInterceptor());
		interceptors.add(new DepartmentHeaderInterceptor());

		/**
		 * 创建请求
		 */
		Request req = new Request.Builder()
				.setName("mike")
				.setReason("看电影")
				.setDays(3)
				.build();

		/**
		 * 获取第一个拦截链实体
		 * 传入请求
		 * 拦截器实体集合
		 * 拦截器实体下标
		 */
		RealChain chain = new RealChain(req,interceptors,0);

		/**
		 * 执行处理
		 */
		Result proceed = chain.proceed(req);

		/**
		 * 输出处理结果
		 */
		System.out.println(proceed.toString());
	}
}

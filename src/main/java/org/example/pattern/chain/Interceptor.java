package org.example.pattern.chain;


/**
 * 拦截器接口
 * @author Administrator
 *
 */
public interface Interceptor {

	/**
	 *
	 * 拦截器  拦截
	 */
	public Result intercept(Chain chain);

	/**
	 * 拦截链
	 * @author Administrator
	 *
	 */
	public interface Chain {

		/**
		 * 请求
		 */
		Request request();

		/**
		 * 执行 返回请求结果
		 */
		Result proceed(Request request);

	}

}
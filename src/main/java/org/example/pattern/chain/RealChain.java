package org.example.pattern.chain;

import java.util.ArrayList;

/**
 * 拦截链 实体
 *
 */
public class RealChain implements Interceptor.Chain {

	/**
	 * 请求 属性
	 */
	public Request request;
	/**
	 * 拦截器实体 集合
	 */
	public ArrayList<Interceptor> interceptors;

	/**
	 * 拦截链实体 下标
	 */
	public int index;


	/**
	 * 拦截链实体  构造方法
	 * @param request 构造函数对应的请求
	 * @param interceptors 构造函数对应的拦截器集合
	 * @param index 构造函数对应的拦截链实体下标
	 */
	public RealChain(Request request,ArrayList<Interceptor> interceptors,int index){
		this.request = request;
		this.interceptors = interceptors;
		this.index = index;
	}

	/**
	 * 获取请求
	 */
	@Override
	public Request request() {
		return request;
	}

	/**
	 * 执行请求 并返回 处理结果
	 */
	@Override
	public Result proceed(Request request) {

		Result res = null;

		/**
		 * 如果 当前拦截链实体下标  小于 当前拦截链集合大小
		 */
		if(interceptors.size() >= index){

			/**
			 * 创建新的拦截链实体（下一个拦截链实体） 并将当前的拦截器实体集合 传入 ， 拦截链实体下标加一
			 */
			RealChain realchain = new RealChain(request,interceptors,index+1);

			/**
			 * 获取当前的拦截器实体
			 */
			Interceptor interceptor = interceptors.get(index);

			/**
			 * 执行当前拦截器实体的  拦截函数  并传入下一个拦截链实体
			 * 并获得返回值
			 */
			res = interceptor.intercept(realchain);

		}

		/**
		 * 并返回结果
		 */
		return res;
	}

}

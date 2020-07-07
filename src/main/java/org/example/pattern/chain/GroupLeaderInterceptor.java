package org.example.pattern.chain;

/**
 * 项目组组长
 * @author Administrator
 *
 */
public class GroupLeaderInterceptor implements Interceptor {

	@Override
	public Result intercept(Chain chain) {

		Request request = chain.request();
		Result res = null;

		//加工小组长的请求
		Request newRquest = new Request.Builder()
				.newRequest(request)
				.setGroupLeaderInfo("GroupLeader:我问问Manager")
				.build();
		System.out.println("2：GroupLeaderReqest===>"+newRquest.groupLeaderInfo());

		//询问上级项目经理  处理请求
		res = chain.proceed(newRquest);

		/**
		 * 获取上级项目经理返回的结果
		 */
		Result.Builder newresBuilder = new Result.Builder()
				.newResult(res);
		//加工上级项目经理返回的结果
		newresBuilder.setGroupRatify(res.managerRatify());
		System.out.println("-2：GroupLeaderReqest");
		//返回结果
		return newresBuilder.build();
	}

}

package org.example.pattern.chain;

/**
 * 项目经理
 * @author Administrator
 *
 */
public class ManagerInterceptor implements Interceptor {

	@Override
	public Result intercept(Chain chain) {

		Request request = chain.request();
		Result res = null;

		//加工项目组组长的请求
		Request newRquest = new Request.Builder()
				.newRequest(request)
				.setManagerInfo("Manager:我问问DepartmentHeader")
				.build();
		System.out.println("3：ManagerReqest===>"+newRquest.managerInfo());

		//询问上级部门经理  处理请求
		res = chain.proceed(newRquest);

		Result.Builder newresBuilder = new Result.Builder()
				.newResult(res);
		//加工部门经理返回的结果
		newresBuilder.setManagerRatify(res.departRatify());
		System.out.println("-3：ManagerReqest");
		//返回结果
		return newresBuilder.build();
	}

}
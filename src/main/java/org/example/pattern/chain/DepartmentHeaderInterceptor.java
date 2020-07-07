package org.example.pattern.chain;

/**
 * 部门经理
 * @author Administrator
 *
 */
public class DepartmentHeaderInterceptor implements Interceptor {

	@Override
	public Result intercept(Chain chain) {

		/**
		 * 项目经理的请求
		 */
		Request request = chain.request();
		/**
		 * 加工项目经理的请求
		 */
		Result.Builder resbuilder = new Result.Builder();
		System.out.println("4：DepartmentHeader");

		//处理项目经理的请求
		//如果是mike  那就可以
		//其他人 不干拉倒
		if(request.name().equals("mike")){
			resbuilder.setInfo("好好干");
			resbuilder.setDepartRatify(true);
		}else{
			resbuilder.setInfo("不干拉倒");
			resbuilder.setDepartRatify(false);
		}
		//返回请求结果
		return resbuilder.build();
	}

}

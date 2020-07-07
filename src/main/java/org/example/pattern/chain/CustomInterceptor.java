package org.example.pattern.chain;

/**
 * 小组长
 *
 * @author Administrator
 */
public class CustomInterceptor implements Interceptor {


    @Override
    public Result intercept(Chain chain) {

        Request request = chain.request();
        Result res = null;

        //对mike的请求进行加工
        Request newRquest = new Request.Builder()
                .newRequest(request)
                .setCustomInfo("Custom:我问问GroupLeader")
                .build();

        System.out.println("1：customRequest===>" + newRquest.customInfo());

        //询问上级项目组组长   处理请求
        res = chain.proceed(newRquest);

        /**
         * 获取到上级项目组组长返回的结果
         */
        Result.Builder newresBuilder = new Result.Builder()
                .newResult(res);
        //加工上级项目组组长返回的结果
        newresBuilder.setCustomRatify(res.groupRatify());

        System.out.println("-1：customResult");

        //返回结果
        return newresBuilder.build();

    }
}

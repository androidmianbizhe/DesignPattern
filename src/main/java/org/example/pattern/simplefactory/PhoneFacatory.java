package org.example.pattern.simplefactory;

public class PhoneFacatory {

	public static final int HUAWEI = 0;
	public static final int VIVO = 1;
	public static final int OPPO = 2;
	/**
	 *
	 * @param signal     手机品种
	 * @param id         手机id
	 * @param name       名称
	 * @param identifer  标识符
	 * @return
	 */
	public static BasePhone createPhone(int signal, int id, String name, String identifer){

		switch (signal) {

			case HUAWEI:
				return new HUAWEIPhone(id,name,identifer);
			case VIVO:

				return new VIVOPhone(id,name,identifer);
			case OPPO:

				return new OPPOPhone(id,name,identifer);
			default:
				throw new IllegalArgumentException("参数错误");
		}
	}
}

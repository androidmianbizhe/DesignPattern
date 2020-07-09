package org.example.pattern.simplefactory;

public class Main {

    public static void main(String[] args) {

        /**
         * 创建huawei手机
         */
        BasePhone huawei = PhoneFacatory
                .createPhone(PhoneFacatory.HUAWEI, 1000, "华为mate11", "HUAWEI-MATE11-askuhrd8792893yr9q3hr9yr329rh");

        huawei.start();

        huawei.run();

        huawei.stop();

        System.out.println("==========================================================================");

        /**
         * 创建oppo手机
         */
        BasePhone oppo = PhoneFacatory
                .createPhone(PhoneFacatory.OPPO, 1000, "oppo-r11", "OPPO-R11-239rufonsdfhw7834ryqdnadaerf");

        oppo.start();

        oppo.run();

        oppo.stop();
    }
}

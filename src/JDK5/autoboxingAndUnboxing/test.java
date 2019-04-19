package JDK5.autoboxingAndUnboxing;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/18 15:36
 * @Version 1.0
 * @Type
 */
public class test {

    public static void main(String[] args) {
        //自动装箱
        Integer total = 99;

        //自定拆箱
        int totalprim = total;
        /**
         *  javap -c StringTest 反编译后
         *  Integer total = 99;
         * 执行上面那句代码的时候，系统为我们执行了：
         * Integer total = Integer.valueOf(99);
         *
         * int totalprim = total;
         * 执行上面那句代码的时候，系统为我们执行了：
         * int totalprim = total.intValue();
         */

        System.out.println(totalprim);
    }
}

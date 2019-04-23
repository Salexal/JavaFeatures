package JDK8;

import JDK8.Interface.DefaultFunctionInterface;
import JDK8.Interface.StaticFunctionInterface;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/22 21:27
 * @Version 1.0
 * @Type   Lambda表达式的基础用法  以及  接口的静态方法和默认方法的使用
 */
public class LambdaTest implements DefaultFunctionInterface,StaticFunctionInterface {


    /**
     *  线程新旧之分
     */
    public static void oneTest() {
        //旧
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        }).start();

        //新
        new Thread(()-> System.out.println("Hello1")).start();
    }

    public static void twoTest() {
        //创建实例化对象
        LambdaTest test = new LambdaTest();
        //使用接口默认方法 (可改写！) 这里改写了默认方法
        System.out.println(test.defaultFunction());
        //使用静态方法
        System.out.println(StaticFunctionInterface.staticFunction());
    }

    @Override
    public String defaultFunction() {
        return "这是改写后的默认方法";
    }

    public static void main(String[] args) {

        //线程
        oneTest();

        //使用静态和默认接口方法
        twoTest();

        //
    }
}

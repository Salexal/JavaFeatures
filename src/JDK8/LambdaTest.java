package JDK8;

import JDK8.Interface.DefaultFunctionInterface;
import JDK8.Interface.StaticFunctionInterface;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/22 21:27
 * @Version 1.0
 * @Type   Lambda表达式的基础用法  以及  接口的静态方法和默认方法的使用
 */
public class LambdaTest implements DefaultFunctionInterface,StaticFunctionInterface {


    /**
     *  1.lambda一般写法
     *  (Type1 param1, Type2 param2, ..., TypeN paramN) -> {
     *       statment1;
     *       statment2;
     *       //.............
     *       return statmentM;
     *  }
     *
     *  2.单参数写法
     *  param1 -> {
     *       statment1;
     *       statment2;
     *       //.............
     *       return statmentM;
     *  }
     *  3.单语句写法
     *  param1 -> statment
     */


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


    @Override
    public String defaultFunction() {
        return "这是改写后的默认方法";
    }

    /**
     *  接口的静态方法和默认方法的使用
     */
    public static void twoTest() {
        //创建实例化对象
        LambdaTest test = new LambdaTest();
        //使用接口默认方法 (可改写！) 这里改写了默认方法
        System.out.println(test.defaultFunction());
        //使用静态方法
        System.out.println(StaticFunctionInterface.staticFunction());
    }

    /**
     *  sort的排序的变化
     */
   public static void threeTest() {

       List<String> list = Arrays.asList(new String[] {"b","z","c","a"});

       //匿名内部类写法
//       Collections.sort(list, new Comparator<String>() {
//           @Override
//           public int compare(String o1, String o2) {
//               return o1.compareTo(o2);
//           }
//       });

       //lambda
       Collections.sort(list,String::compareTo);

       //尝试使用 Stream API
       List<String> upList = list.stream().map(str->(str.toUpperCase())).collect(Collectors.toList());

       for (int i = 0; i < list.size(); i++) {
           System.out.println(list.get(i)+"  "+upList.get(i));
       }
   }

   public static void fourTest() {

   }

    public static void main(String[] args) {

        //线程
        oneTest();

        //使用静态和默认接口方法
        twoTest();

        //sort的排序
        threeTest();

        //


    }
}

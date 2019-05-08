package JDK8.MethodReferences.InstanceMethodRef;

import java.util.function.BiPredicate;

/**
 * @Author: Shimizu
 * @Description: Lambda 表达式的 方法引用
 * @Date: Create in 14:16 2019/4/26
 */
public class LambdaMethodRefDemo {

    public static void main(String[] args) {
        //  若Lambda表达式的参数列表的第一个参数，是实例方法的调用者，
        //第二个参数(或无参)是实例方法的参数时，就可以使用这种方法，如

        //BiPredicate<String, String> b = (x,y) -> x.equals(y);
        BiPredicate<String, String> b = String::equals;
        BiPredicate<Integer,Integer> c=Integer::equals;

        BiPredicate<Integer,Integer> c1= (e1,e2)->e1>10&&e1>e2;

        System.out.println(c.and(c1).test(10,2));
        System.out.println(b.test("abc", "abcd"));
        System.out.println(c1.test(1,2));
    }


}

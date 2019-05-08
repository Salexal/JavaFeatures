package JDK8.MethodReferences.ConstructorRef;

import java.util.function.Function;

/**
 * @Author: Shimizu
 * @Description: 引用构造器
 * @Date: Create in 14:31 2019/4/26
 */
public class constructorRefDemo {
    public static void main(String[] args) {

        //Fuction 一个函数式接口 apply 将此函数应用于指定参数
        //Function<Integer, StringBuffer> fun = n -> new StringBuffer(n);
        Function<Integer, StringBuffer> fun = StringBuffer::new;

        StringBuffer buffer = fun.apply(10);

        System.out.println(buffer.append(10));

        System.out.println(buffer.append(23));
    }
}

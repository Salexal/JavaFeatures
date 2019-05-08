package JDK8.MethodReferences.ConstructorRef.ArrayRef;

import java.util.function.Function;

/**
 * @Author: Shimizu
 * @Description: 引用数组
 * @Date: Create in 14:41 2019/4/26
 */
public class ArrayRefDemo {

    public static void main(String[] args) {
        /**
         * 和引用构造器感觉差不多
         */
        Function<Integer,int[]>function=int[]::new;
        int []arr =function.apply(3);

        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        for (int a:arr) {
            System.out.println(a);
        }
    }
}

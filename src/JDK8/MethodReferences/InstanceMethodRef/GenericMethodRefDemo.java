package JDK8.MethodReferences.InstanceMethodRef;

/**
 * @Author: Shimizu
 * @Description: 在泛型类或泛型方法中，使用方法引用。
 * @Date: Create in 10:48 2019/4/24
 */
public class GenericMethodRefDemo {
    public static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }
    public static void main(String[] args){
        Integer[] vals = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};
        int count;
        //泛型方法引用
        count=myOp(MyArrayOps::<Integer>countMatching, vals, 4);
        System.out.println("vals contains "+count+" 4s");
        count=myOp(MyArrayOps::<String>countMatching, strs, "Two");
        System.out.println("strs contains "+count+" Twos");
    }
}

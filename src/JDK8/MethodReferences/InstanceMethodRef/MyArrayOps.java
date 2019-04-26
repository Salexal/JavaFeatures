package JDK8.MethodReferences.InstanceMethodRef;

/**
 * @Author: Shimizu
 * @Description: 泛型方法
 * @Date: Create in 10:46 2019/4/24
 */
public class MyArrayOps {
    public static <T> int countMatching(T[] vals, T v) {
        //计数
        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) {
                count++;
            }
        }
        return count;
    }
}

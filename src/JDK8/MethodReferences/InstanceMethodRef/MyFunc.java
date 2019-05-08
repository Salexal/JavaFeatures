package JDK8.MethodReferences.InstanceMethodRef;

/**
 * @Author: Shimizu
 * @Description: 泛型接口
 * @Date: Create in 10:45 2019/4/24
 */
public interface MyFunc<T> {
    int func(T[] args, T v);
}

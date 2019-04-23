package JDK8.Interface;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/23 9:05
 * @Version 1.0
 * @Type  接口默认方法
 */
public interface DefaultFunctionInterface {
    default String defaultFunction() {
        return "default function";
    }
}

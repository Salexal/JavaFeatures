package JDK5; /**
 * @Author: Salexal.fww
 * @Date: 2019/4/15 9:37
 * @Version 1.0
 * @Type  静态导入  导入静态包
 */
import static java.lang.Math.*;

public class StaticImport {

    public static void main(String[] args) {
        //Math.pow() 可以省略Math
        double d = pow(3,2);
        System.out.println(abs(-2));
        System.out.println(d);
    }
}

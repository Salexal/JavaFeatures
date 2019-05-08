package JDK8.OptionalClass;

import JDK8.Person;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @Author: Shimizu
 * @Description: Optional 类的作用功能，以及相应的基础用法
 * @Date: Create in 14:53 2019/4/26
 */
public class OptionalDemo {

    public static void main(String[] args) {

        /* 创建Optional对象 -> empty(),of(),ofNullable() 三种静态方法 */

        //1.empty()方法
        Optional<String>opl1= Optional.empty();

        //empty()方法创建的对象没有值,如果执行
        System.out.println(opl1.isPresent());//->>返回false

        //调用get()方法则会抛出NullPointException异常
        //System.out.println(opl1.get());//->>java.util.NoSuchElementException: No value present

        //2.of()方法使用一个非空的值创建Optional
        String str="Hello world!";
        Optional<String>opl2=Optional.of(str);

        //3.ofNullable()方法接收一个可以为null的值
        Object obj=null;
        Optional<Object>opl3=Optional.ofNullable(obj);


    }
}

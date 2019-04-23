package JDK5.TesttAnnotation;

import java.lang.annotation.*;

/**
 * @author Shimizu
 *
 * 简单诠释了四个元注解的作用：
 */

//Target说明了Annotation所修饰的对象范围
@Target(ElementType.FIELD)

//注解表明这个注解应该被 javadoc工具记录. 默认情况下,javadoc是不包括注解的.
//在Java 反射中自定义注解需要添加，因为如果不使用,则isAnnotationPresent() 方法不会认识该自定义注解
@Documented

//@Retention(保留)注解说明,这种类型的注解会被保留到那个阶段

//RUNTIME —— 这种类型的Annotations将被JVM保留,所以他们能在运行时被JVM或其他使用反射机制的代码所读取和使用.
//CLASS —— 这种类型的Annotations编译时被保留,在class文件中存在,但JVM将会忽略
//SOURCE —— 这种类型的Annotations只在源代码级别保留,编译时就会被忽略
@Retention(RetentionPolicy.RUNTIME)

//@Inherited表示该注解是否对类的子类继承的方法等起作用
@Inherited
public @interface MyAnnotation {

    //这样的写法并不是方法，而是一个属性， 当属性名字为value 并且只有一个时，默认可以不写如:@MyAnnotation("Hello World")
    //default 为当属性不赋值时默认为null
    String value()default "";

    /**
     * 注解参数的可支持数据类型：
     *  1.所有基本数据类型（int,float,boolean,byte,double,char,long,short)
     *  2.String类型
     *  3.Class类型
     *  4.enum类型
     *  5.Annotation类型
     *  6.以上所有类型的数组
     */



}

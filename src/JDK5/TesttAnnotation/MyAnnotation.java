package JDK5.TesttAnnotation;

import java.lang.annotation.*;

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
    String value()default "";
}

package JDK5.TesttAnnotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Documented
//@Re
@Retention(RetentionPolicy.RUNTIME)
//@Inherited表示该注解是否对类的子类继承的方法等起作用
@Inherited
public @interface MyAnnotation {
    String value()default "";
}

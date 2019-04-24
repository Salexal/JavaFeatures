package JDK8.RepeatedNotes;

import java.lang.annotation.*;

/**
 * @Author: Shimizu
 * @Description: 重复注解的简单运用，Java8以前的版本使用注解有一个限制是相同的注解在同一位置只能使用一次，不能使用多次。
 * @Date: Create in 8:16 2019/4/24
 */
public class RepeatingAnnotations {

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Filters {
        Filter[] value();
    }

    @Target( ElementType.TYPE )
    @Retention( RetentionPolicy.RUNTIME )
    //使用重复注解时所必须使用的一个注解
    //实际上，重复注解不是一个语言上的改变，只是编译器层面的改动，技术层面仍然是一样的。
    @Repeatable( Filters.class )
    public @interface Filter {
        String value();
    };

    @Filter( "filter1" )
    @Filter( "filter2" )
    public interface Filterable {
    }

    //@analyze： 注释Filter被@Repeatable( Filters.class )注释。Filters 只是一个容器，它持有Filter, 编译器尽力向程序员隐藏它的存在。
    //通过这样的方式，Filterable接口可以被Filter注释两次。另外，反射的API提供一个新方法getAnnotationsByType() 来返回重复注释的类
    //型（注意Filterable.class.getAnnotation( Filters.class )将会返回编译器注入的Filters实例）。

    public static void main(String[] args) {
        for( Filter filter: Filterable.class.getAnnotationsByType( Filter.class ) ) {
            System.out.println( filter.value() );
        }
    }


}

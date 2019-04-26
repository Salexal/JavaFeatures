package JDK8.OptionalClass;

import JDK8.Person;

import java.util.Optional;

/**
 * @Author: Shimizu
 * @Description: Optional主要用以解决程序中常见的NullPointerException异常问题
 * @Date: Create in 15:10 2019/4/26
 */
public class OptionalDemo2 {

    public static void main(String[] args) {
        /*提取Optional对象中的值,如果我们要获取Person对象中的name属性值，常见的方式是直接获取：*/

        Person person=new Person("张三");
        if (person!=null){
            System.out.println(person.getName());
        }

        //使用Optional中提供的map()方法可以以更简单的方式实现：
        Optional<Person> personOpt=Optional.ofNullable(person);

        //此处还使用了方法实例引用->为Java8新特性
        Optional<String>strOpt=personOpt.map(Person::getName);
        System.out.println(
                strOpt.get()
        );

        /* 使用orElse()方法获取值 */
        String str = "Hello World";
        Optional<String> strOpt1 = Optional.of(str);

        //1.orElse()：如果有值就返回，否则返回一个给定的值作为默认值；
        String orElseResult = strOpt1.orElse("Hello Shanghai");

        //2.orElseGet()：与orElse()方法作用类似，区别在于生成默认值的方式不同。该方法接受一个Supplier<? extends T>函数式接口参数，用于生成默认值；
        String orElseGet = strOpt1.orElseGet(() -> "Hello Shanghai");

        //3.orElseThrow()：与前面介绍的get()方法类似，当值为null时调用这两个方法都会抛出NullPointerException异常，区别在于该方法可以指定抛出的异常类型。
        String orElseThrow = strOpt1.orElseThrow(
                () -> new IllegalArgumentException("Argument 'str' cannot be null or blank."));

        /* Optional类还提供了一个ifPresent()方法，该方法接收一个Consumer<? super T>函数式接口，一般用于将信息打印到控制台：*/
        strOpt1.ifPresent(System.out::println);


        /* 使用filter()方法过滤 */
        //在下面的代码中，如果filter()方法中的Lambda表达式成立，filter()方法会返回当前Optional对象值，否则，返回一个值为空的Optional对象。
        Optional<String>optional=Optional.ofNullable("1047791704@qq.com");
        optional=optional.filter(strs->strs.contains("104"));
        strOpt=optional.filter(s -> s.contains("d"));
        System.out.println(optional.get());
        System.out.println(strOpt + " "/* + strOpt.get()*/);//抛出空指针异常

    }
    //简化代码样例
    /**
     * 简化if-else
     * User user = ...
     * if (user != null) {
     *     String userName = user.getUserName();
     *     if (userName != null) {
     *         return userName.toUpperCase();
     *     } else {
     *         return null;
     *     }
     * } else {
     *     return null;
     * }
     * 上面的代码可以简化成：
     *
     * User user = ...
     * Optional<User> userOpt = Optional.ofNullable(user);
     *
     * return userOpt.map(User::getUserName)
     *             .map(String::toUpperCase)
     *             .orElse(null);
     */
}

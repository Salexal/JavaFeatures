package JDK5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/12 8:53
 * @Version 1.0
 * @Type
 */
public class Reflection {

    /**
     * 通过Class类中的静态方法forName，直接获取到一个类的字节码文件对象，此时该类还是源文件阶段，并没有变为字节码文件。
     * 1、Class clazz1 = Class.forName("全限定类名");　
     */

    /**
     * 当类被加载成.class文件时，此时Person类变成了.class，在获取该字节码文件对象，也就是获取自己， 该类处于字节码阶段。
     * 2、Class clazz2  = Person.class;　　　
     *
     */

    /**
     * 通过类的实例获取该类的字节码文件对象，该类处于创建对象阶段　
     * 3、Class clazz3 = p.getClass();　　　
     */

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        oneTest();
        twoTest();
        threeTest();
        fourTest();
        fiveTest();
        sixTest();
        sevenTest();
    }
    /**
     * 1.通过字节码对象创建实例对象
     */
    public static void oneTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //在User类还在源文件时就直接获取他的字节码文件对象
        Class clazz1 = Class.forName("JDK5.reflection.User");
        // 通过User的无参数的构造函数来创建对象
        User user = (User) clazz1.newInstance();

        user.setId(2);
        user.setName("love");
        System.out.println("Test1:");
        System.out.println(user.getId() + " " + user.getName());
    }

    /**
     * 2.获取指定构造器方法。
     */
    public static void twoTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取字节码
        Class clazz1 = Class.forName("JDK5.reflection.User");
        //先获取有参构造器 parameterTypes 表示参数列表 可以写 也可以不写，不写默认调用无参构造器  (参数必须是你已有的构造函数对齐)
        Constructor constructor = clazz1.getConstructor(int.class,String.class,String.class);

        User user = (User) constructor.newInstance(20,"magic","mo");
        System.out.println("Test2:");
        System.out.println(user.getId() + " " + user.getName());
    }

    /**
     * 3.获取全部构造器方法
     */

    public static void threeTest() throws ClassNotFoundException {
        //获取字节码
        Class clazz1 = Class.forName("JDK5.reflection.User");
        Constructor[] constructors = clazz1.getConstructors();
        System.out.println("Test3:");
        for(int i = 0;i<constructors.length;i++){
            Class[] parameterTypes = constructors[i].getParameterTypes();
            System.out.println("第"+(i+1)+"个构造函数");
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.print(parameterTypes[j]+",");
            }
            if(parameterTypes.length==0) {
                System.out.print("无参数");
            }
            System.out.println();
        }
    }

    /**
     * 4.获取成员变量并使用
     */

    public static void fourTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //获取字节码
        Class clazz1 = Class.forName("JDK5.reflection.User");
        User user = (User) clazz1.newInstance();
        //获取非私有的成员变量 用getField
        Field field1 = clazz1.getField("status");
        //如果成员变量是私有的 则用getDeclaredField
        Field field2 = clazz1.getDeclaredField("id");
        //由于属性为私有的 获取其属性后，让其打开可见权限
        field2.setAccessible(true);
        // 对其变量进行赋值操作
        field2.setInt(user,99);
        field1.setInt(user,1);
        System.out.println("Test4:");
        System.out.println(user.getId()+" "+user.getStatus());
    }

    /**
     *  5.获取所有成员变量
     * @throws ClassNotFoundException
     */
    public static void fiveTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取字节码
        Class clazz1 = Class.forName("JDK5.reflection.User");
        User user = (User) clazz1.newInstance();

        user.setStatus(1);
        Field[] fields = clazz1.getDeclaredFields();
        System.out.println("Test5:");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].get(user));
        }
    }

    /**
     * 6.获取方法并使用
     */
    public static void sixTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("Test6:");
        //获取字节码
        Class clazz1 = Class.forName("JDK5.reflection.User");
        User user = (User) clazz1.newInstance();
        /**
         * clazz.getMethod(name, parameterTypes)
         *      name:方法名
         *      parameterTypes：方法的参数类型 没有则不填
         */
        Method method = clazz1.getMethod("sing");

        /**
         * method.invoke(obj,args)
         *      obj:方法的对象
         *      args：实际的参数值没有则不填
         */
        method.invoke(user);

        method = clazz1.getMethod("setName", String.class);
        method.invoke(user,"设置的名字");
        System.out.println(user.toString());

        Method method1 = clazz1.getDeclaredMethod("eat");
        method1.setAccessible(true);
        method1.invoke(user);
    }

    /**
     *  7.获取所有方法
     */
    public static void sevenTest() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("Test7:");
        //获取字节码
        Class clazz1 = Class.forName("JDK5.reflection.User");
        User user = (User) clazz1.newInstance();
        Method[] methods = clazz1.getDeclaredMethods();

        for(Method method : methods){
            System.out.print(method.getName()+" ");

            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getName()+",");
            }
            if(parameterTypes.length == 0) {
                System.out.print("无参数");
            }
            System.out.println();
        }
    }

    /**
     * 8.
     */

}

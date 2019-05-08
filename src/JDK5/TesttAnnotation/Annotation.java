package JDK5.TesttAnnotation;

import java.lang.reflect.Field;

/**
 * @author Shimizu
 *
 * @date 2019年4月19日15:05:03
 *
 * 自定义注解的使用，传入值
 */
public class Annotation {

    public static void main(String[] args) {
        //创建Apple实例
        Apple apple =new Apple();
        try {

            //使用反射获取class
            Class cls=Class.forName("JDK5.TesttAnnotation.Apple");

            //获取class相应的字段
            Field[] declaredFields=cls.getDeclaredFields();

            //增强for循环 遍历
            for (Field field:declaredFields){
                //获取相应的注解
                FruitColor fruitColor=field.getAnnotation(FruitColor.class);
                MyAnnotation annotation=field.getAnnotation(MyAnnotation.class);

                //判断注解是否存在，并进行逻辑操作
                if (fruitColor!=null){
                    apple.setFruitColor(fruitColor.fruitColor().toString());
                }
                if (annotation!=null){
                    apple.setFuritName(annotation.value());
                }
            }
            //抛出所有异常(比较方便)
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出操作后的结果
        System.out.println(apple.toString());

    }

}

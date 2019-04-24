package JDK8.MethodReferences.InstanceMethodRef;

import java.util.*;

/**
 * @Author: Shimizu
 * @Description: 这种语法与用于静态方法的语法类似，只不过这里使用对象引用而不是类名
 * @Date: Create in 9:15 2019/4/24
 */
public class ComparisonProvider {

    public  int compareByName(Person a, Person b){
        return b.getName().compareTo(a.getName());
    }

    public int compareByAge(Person a, Person b){
        return a.getBirthday().compareTo(b.getBirthday());
    }

    public static void main(String[] args) {
        ComparisonProvider myComparisonProvider = new ComparisonProvider();

        Person rosterAsArray[]=new Person[5];

        for (int i=0;i<5;i++){
            //初始化Person
            rosterAsArray[i] = new Person();
            rosterAsArray[i].setName("张三"+i);
        }

        System.out.println("排序前 : ");
        for (Person p:rosterAsArray) {
            System.out.println(p.getName());
        }
        //实例上的实例方法引用
        Arrays.sort(rosterAsArray,myComparisonProvider::compareByName);

        System.out.println("排序后 : ");
        for (Person p:rosterAsArray) {
            System.out.println(p.getName());
        }
    }
}

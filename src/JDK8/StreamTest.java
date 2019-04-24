package JDK8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/23 15:31
 * @Version 1.0
 * @Type
 */
public class StreamTest {

    public static void main(String[] args) {

        //forEach limit
        oneTest();

        //map
        twoTest();

        //filter
        threeTest();

        //sorted
        fourTest();

        //parallelStream
        fiveTest();

        //统计
        sixTest();

        //统计
        sevenTest();

        //计数
        eightTest();
    }

    /**
     * 计数功能的实现
     */

    private static void eightTest() {
        List<Fruit> fruitList = Arrays.asList(new Fruit("apple", 6),
                new Fruit("apple", 6),
                new Fruit("banana", 7), new Fruit("banana", 7),
                new Fruit("banana", 7), new Fruit("grape",8));

        Map<String, Long> map = fruitList.stream().
                collect(Collectors.groupingBy(Fruit::getName,Collectors.counting()));
//        Map<String, Long> map = fruitList.stream().map(Fruit::getName).
//                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // 结果是 {banana=3, apple=2, grape=1}
        System.out.println(map.size());
    }

    /**
     * Collectors
     */

    private static void sevenTest() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


    }

    /**
     * 统计功能的实现
     */

    private static void sixTest() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

    }

    /**
     * 平行处理 parallelStream
     */

    private static void fiveTest() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 处理的过程会分而治之，也就是将一个大任务切分成多个小任务 输出并不会按顺序输出
        // 有点并行的感觉 分成多个任务 每个任务并行执行
        numbers.parallelStream()
                .forEach(System.out::println);
        //使用上 forEachOrdered 最后会按照顺序执行
        numbers.parallelStream()
                .forEachOrdered(System.out::println);

    }

    /**
     * stream流 sorted
     */
    private static void fourTest() {
        List<String>strings = Arrays.asList("abc", "eeee", "bc", "efg", "abcd","dddd", "jkl");
        //对前6个字符串进行排序并输出
        strings.stream().limit(6).sorted().forEach(System.out::println);
    }


    /**
     * stream流 filter
     */
    private static void threeTest() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    /**
     * stream流 map
     */
    private static void twoTest() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);
    }

    /**
     * stream流 foreach  limit
     */
    private static void oneTest() {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}

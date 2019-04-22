package JDK7;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Salexal.fww
 * @Date: 2019/4/22 10:21
 * @Version 1.0
 * @Type
 */
public class JDK7Test {

    public static final int[] phases = {
            0b00110001,
            0b01100010,
            0b11000100,
            0b10001001,
            0b00010011,
            0b00100110,
            0b01001100,
            0b10011000
    };
    public static final int[] hexadecimal = {
            0x31, 0x62, 0xC4, 0x89, 0x13, 0x26, 0x4C, 0x98
    };


    /**
     *  Java7前支持十进制（123）、八进制（0123）、十六进制（0X12AB）
     *
     *  Java7增加二进制表示（0B11110001、0b11110001）
     */

    public static void binaryTest(){
        //数字开头0可以省略
        //一个8位'byte'值：
        byte aByte = (byte)0b00100001;

        //一个16位'short'值:
        short aShort = (short)0b1010000101000101;

        //一些32位'int'值:
        int intNum1 = 0b10100001010001011010000101000101;
        int intNum2 = 0b101;
        int intNum3 = 0B101; // B可以是大写也可以是小写.

        //一个64位的'long'值. 注意"L"结尾:
        long longNum = 0b1010000101000101101000010100010110100001010001011010000101000101L;

        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi =  3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;

//        float pi1 = 3_.1415F;      // 无效; 不能和小数点相邻
//        float pi2 = 3._1415F;      // 无效; 不能和小数点相邻
//        long socialSecurityNumber1 = 999_99_9999_L;         // 无效; 不能放在L后缀之前

//        int x1 = _52;              // 无效；这是个标识符，不是数字的字面量
        int x2 = 5_2;              // OK
//        int x3 = 52_;              // 无效; 不能放在数字的结尾
        int x4 = 5_______2;        // OK

//        int x5 = 0_x52;            // 无效; 不能放在 0x 中间
//        int x6 = 0x_52;            // 无效; 不能放在数字的开头
        int x7 = 0x5_2;            // OK
//        int x8 = 0x52_;            // 无效; 不能放在数字的结尾

        int x9 = 0_52;             // OK
        int x10 = 05_2;            // OK
//        int x11 = 052_;            // Invalid; 不能放在数字的结尾
        System.out.println(aByte);

        System.out.println(getTypeOfDayWithSwitchStatement("Monday"));
    }

    /**
     *
     * @param dayOfWeekArg
     * @return
     */


    //switch 可以使用string作为参数
    public static String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
        String typeOfDay;
        switch (dayOfWeekArg) {
            case "Monday":
                typeOfDay = "Start of work week";
                break;
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
                typeOfDay = "Midweek";
                break;
            case "Friday":
                typeOfDay = "End of work week";
                break;
            case "Saturday":
            case "Sunday":
                typeOfDay = "Weekend";
                break;
            default:
                throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
        }
        return typeOfDay;
    }

    public static void main(String[] args) {
        // 增加二进制表示  数字之间可以添加分隔符
        binaryTest();

        // switch中使用String
        System.out.println(getTypeOfDayWithSwitchStatement("Monday"));

        // 泛型实例化类型自动推断
        //JDK7以前                 观察这个String
        List<String> list1 = new ArrayList<String>();
        //JDK7以后
        List<String> list2 = new ArrayList<>();

        // 捕获多个异常 可以使用 | 分割
        try {
            System.out.println("Hello");
            // 请注意这里的异常是随便写的！！！！！
        } catch (IllegalArgumentException | EnumConstantNotPresentException e) {
            e.printStackTrace();
        }
    }
}

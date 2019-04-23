package JDK5.TesttAnnotation;

/**
 * @author Shimizu
 *
 * 自定义类Apple
 *
 */
public class Apple {

    //注解赋值
    @MyAnnotation("Apple")
    private String FuritName;

    @FruitColor(fruitColor = JDK5.TesttAnnotation.FruitColor.Color.RED)
    private String FruitColor;

    public String getFuritName() {
        return FuritName;
    }

    public void setFuritName(String furitName) {
        FuritName = furitName;
    }

    public String getFruitColor() {
        return FruitColor;
    }

    public void setFruitColor(String fruitColor) {
        FruitColor = fruitColor;
    }

    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }

    @Override
    public String toString() {
        return "Apple{" +
                "FuritName='" + FuritName + '\'' +
                ", FruitColor='" + FruitColor + '\'' +
                '}';
    }
}

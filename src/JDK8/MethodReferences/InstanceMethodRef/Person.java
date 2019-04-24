package JDK8.MethodReferences.InstanceMethodRef;

/**
 * @Author: Shimizu
 * @Description: 辅助描述类
 * @Date: Create in 9:16 2019/4/24
 */
public class Person {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

package innerClass.test4;

/**
 * <p>
 *     静态内部类：声明为static的内部类
 *     不需要外围类的对象即可以创建嵌套类
 *      嵌套类对象不可访问非静态的外围类对象
 * </p>
 */
public class TestStaticsInnerClass {
    //静态内部类
    public static class Contents{
    }
    //非静态内部类
    class Destination{
    }

    public static void main(String[] args) {
        TestStaticsInnerClass p = new TestStaticsInnerClass();
        //非静态内部类，需要外围类的引用来创建
        TestStaticsInnerClass.Destination d = p.new Destination();
        //静态内部类，通过外围类名来直接创建
        TestStaticsInnerClass.Contents c = new TestStaticsInnerClass.Contents();
    }
}
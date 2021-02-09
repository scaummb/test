package innerClass.test6;

import innerClass.test5.Destination;

/**
 * <p>
 *     方法和作用域中的内部类
 * </p>
 */
public class TestMethodInnerClass {
    public Destination destination() {
        //方法域的内部类(局部内部类：在方法作用域内创建的类),看上去像是“接口实例化”
        class PDestination implements Destination {
            @Override
            public String readLabel() {
                return "label";
            }
        }
        return new PDestination();
    }

    public static void main(String[] args) {
        //外围类的方法调用,获取到内部类的引用
        TestMethodInnerClass p = new TestMethodInnerClass();
        Destination d = p.destination();
    }
}

package iniliazation;

import Utils.PrintUtils;
import jvm.Test;

/**
 * <p>
 *     this关键字：
 *      构造器使用
 *      1、super()任何子类最终都会调用的，你用了this()调用本类构造器，最终还是会执行某个super()的。
 *      2、在构造方法中，只能通过this调用一次其他构造方法。多次调用会重复初始化，导致资源浪费
 * </p>
 * @author momoubin
 * @date 2020/5/3
 */
public class TestThisConstructor {
    int petalCount = 0;
    String s = "initial value";

    public TestThisConstructor(int petalCount) {
        this.petalCount = petalCount;
        PrintUtils.printObjects("int arg only, petalCount = " + petalCount);
    }

    public TestThisConstructor(String s) {
        this.s = s;
        PrintUtils.printObjects("int string only, s = " + s);
    }

    public TestThisConstructor(String s,int petalCount) {
        this(petalCount);
//        this(s);
// 编译报错：在构造方法中，只能通过this调用一次其他构造方法。多次调用会重复初始化，导致资源浪费
// 总得说来就是，super()任何子类最终都会调用的，你用了this()调用本类构造器，最终还是会执行某个super()的。
        this.s = s;
        PrintUtils.printObjects("int & string args, petalCount = " + petalCount
            + "s=" + s);

    }

    public TestThisConstructor() {
        this("hi", 47);
    }

    void printPetalCount (){
       PrintUtils.printObjects();
    }

    public static void main(String[] args) {
        TestThisConstructor testThisConstructor = new TestThisConstructor();
        testThisConstructor.printPetalCount();
    }
}

package innerClass.test3;

/**
 * <p>
 *    若要生成对外部对象的引用，使用类名+“.this”的方式。
 * </p>
 */
public class DotThis {
    //外围类方法1
    void f() {
        System.out.println("DotThis.f()");
    }
    //外围类方法2:创建内部类
    public Inner inner() {
        return new Inner();
    }

    //内部类
    public class Inner {
        // 返回外部类的引用
        public DotThis outerClass() {
            return DotThis.this;
        }
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        //创建了一个内部类
        DotThis.Inner dti = dotThis.inner();
        //根据内部类获取到它的外围类
        dti.outerClass().f();
        //比较下这两个对象是否一致？肯定一样呀
        System.out.println("dotThis == dti.outerClass()? result = " + dotThis.equals(dti.outerClass()));
    }
}
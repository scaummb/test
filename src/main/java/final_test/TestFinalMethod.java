package final_test;

/**
 * <p>private方法不属于基类接口一部分</p>
 * @author momoubin
 * @date 2020/5/5
 */
public class TestFinalMethod {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        OverridingPrivate op = op2;
//        op.f();
//        op.g();
    }
}
class WithFinals{
    private final void f(){
        System.out.println("withfinals.f()");
    }

    private void g(){
        System.out.println("withfinals.g()");
    }
}

class OverridingPrivate extends WithFinals{
    // 不是覆盖父类方法，而是只属于子类的私有方法
    private final void f(){
        System.out.println("OverridingPrivate.f()");
    }
    public void g(){
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate{
    // 不是覆盖父类方法，而是只属于子类的私有方法
    public final void f(){
        System.out.println("OverridingPrivate2.f()");
    }
    public void g(){
        System.out.println("OverridingPrivate2.g()");
    }
}
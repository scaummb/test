package polymorphic.polymorphic.bug;

/**
 * @author momoubin
 * @date 2020/5/10
 */
public class PrivateOverride {
    private void f(){
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        // 编译器认为是private 方法
        po.f();
        // 强制转型，向下转型，则使用public 方法
        ((Derived) po).f();
    }
}

class Derived extends PrivateOverride {
    public void f(){
        System.out.println("public f()");
    }
}
package innerClass.test10;

class WithInner{
    class Inner{
    }
}
// 内部类继承，但是需要指明继承关系
public class InheritInner extends WithInner.Inner {
    public InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}

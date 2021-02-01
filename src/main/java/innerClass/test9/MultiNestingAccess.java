package innerClass.test9;

/**
 * <p>
 *     内部类嵌套
 * </p>
 */
class MNA{
    private void f() {}
    class A {
        private void g() {}
        public class B {
            void h() {
                g();
                f();
            }
        }
    }
}
public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        //通过外围类引用才能继续创建内部类A类
        MNA.A mnaa = mna.new A();
        //通过A类引用才能继续创建A类的内部类
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
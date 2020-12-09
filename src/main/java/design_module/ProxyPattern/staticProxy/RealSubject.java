package design_module.ProxyPattern.staticProxy;

/**
 * Date: 2019/7/27 15 :17
 *
 * @author moubin.mo
 */

public class RealSubject implements Subject {

    private String name = "mmb";

    @Override
    public void visit() {
        System.out.println("my name is "+name);
    }

    @Override
    public void gohome() {
        System.out.println("i am "+name + ",i want to go back home.");
    }
}

package design.ProxyPattern.staticProxy;

/**
 * Date: 2019/7/28 10 :47
 *
 * @author moubin.mo
 */

public class RealSubject2 implements Subject {

    private String name = "mmb2";

    @Override
    public void visit() {
        System.out.println("my name is "+name);
    }

    @Override
    public void gohome() {
        System.out.println("i am "+ name + ",i do not want to go back home.");
    }

}

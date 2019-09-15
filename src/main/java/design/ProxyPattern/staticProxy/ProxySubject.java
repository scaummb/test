package design.ProxyPattern.staticProxy;

/**
 * Date: 2019/7/27 15 :18
 *
 * @author moubin.mo
 */

public class ProxySubject implements Subject {

    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }

    @Override
    public void gohome() {
        subject.gohome();
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

package design_module.ProxyPattern.staticProxy;

/**
 * <p>
 *     代理类
 * </p>
 */
public class ProxyHuman {
    private Subject subject;
    public ProxyHuman(Subject subject) {
        this.subject = subject;
    }
    public void visit() {
        subject.visit();
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}

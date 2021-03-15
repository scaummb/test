package design_module.ObserverPattern;

/**
 * Date: 2019/4/26 16 :30
 *
 * @author moubin.mo
 */

public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal String: "
				+ Integer.toOctalString(subject.getState()));
	}
}

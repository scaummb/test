package design_module.ProxyPattern.staticProxy;

/**
 * Date: 2019/7/27 15 :17
 *
 * @author moubin.mo
 */

public class UserDao implements Subject {
	private String name = "name-1";

	@Override
	public void visit() {
		System.out.println("my name is " + name);
	}
}

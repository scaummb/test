package design_module.ProxyPattern.staticProxy;

/**
 * Date: 2019/7/28 10 :47
 *
 * @author moubin.mo
 */

public class WomanDao implements Subject {
	private String name = "name-2";

	@Override
	public void visit() {
		System.out.println("my name is " + name);
	}
}

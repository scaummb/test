package design_module.ProxyPattern.dynamicProxy;

/**
 * Date: 2019/7/28 11 :14
 *
 * @author moubin.mo
 */

public class RealDynamicSubject2 implements DynamicSubject {

	private String name = "mmb2";

	@Override
	public void visit() {
		System.out.println("my dynamic name is " + name);
	}

	@Override
	public void gohome() {
		System.out.println("i am dynamic " + name + ",i don not want to go home.");
	}
}

package design_module.ProxyPattern.dynamicProxy;

/**
 * Date: 2019/7/27 15 :26
 *
 * @author moubin.mo
 */

public class RealDynamicSubject implements DynamicSubject {

	private String name = "mmb";

	@Override
	public void visit() {
		System.out.println("my dynamic name is " + name);
	}

	@Override
	public void gohome() {
		System.out.println("i am dynamic " + name + ",i want to go home.");
	}
}

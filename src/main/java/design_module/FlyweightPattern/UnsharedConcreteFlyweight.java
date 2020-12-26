package design_module.FlyweightPattern;

/**
 * <p>
 *     指那些不需要共享的Flyweight子类。
 * </p>
 */

public class UnsharedConcreteFlyweight implements Flyweight {

	private String code = "UnsharedConcreteFlyweight";

	public UnsharedConcreteFlyweight(final String code) {
		this.code = code;
	}

	@Override
	public void operate() {
		System.out.println("不共享的具体Flyweight:" + this.code);
	}
}

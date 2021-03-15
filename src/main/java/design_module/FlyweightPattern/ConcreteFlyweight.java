package design_module.FlyweightPattern;

/**
 * <p>
 * 继承Flyweight超类或实现Flyweight接口，并为其内部状态增加存储空间。
 * </p>
 */

public class ConcreteFlyweight implements Flyweight {

	private String code = "ConcreteFlyweight";

	public ConcreteFlyweight(final String code) {
		this.code = code;
	}

	@Override
	public void operate() {
		System.out.println("具体Flyweight:" + this.code);
	}
}

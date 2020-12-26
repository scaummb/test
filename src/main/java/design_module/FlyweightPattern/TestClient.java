package design_module.FlyweightPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 20:24
 */

public class TestClient {
	public static void main(String[] args) {
		Flyweight concreteFlyweight1 = FlyweightFactory.getFlyway("ConcreteFlyweight");
		Flyweight concreteFlyweight2 = FlyweightFactory.getFlyway("ConcreteFlyweight");
		Flyweight concreteFlyweight3 = FlyweightFactory.getFlyway("UnsharedConcreteFlyweight");
		Flyweight concreteFlyweight4 = FlyweightFactory.getFlyway("UnsharedConcreteFlyweight");
	}
}

package design_module.FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 一个享元工厂，用来创建并管理Flyweight对象，主要是用来确保合理地共享Flyweight，当用户请求一个Flyweight时，FlyweightFactory对象提供一个已创建的实例或创建一个实例。
 * </p>
 */

public class FlyweightFactory {

	private static final Map<String, Flyweight> pool = new HashMap<String, Flyweight>();

	public static Flyweight getFlyway(String extrinsic) {
		Flyweight flyweight = null;
		if (pool.containsKey(extrinsic)) {
			//池中有该对象
			flyweight = pool.get(extrinsic);
			System.out.println("已有 " + extrinsic + " 直接从池中取---->" + flyweight.toString());
		} else {
			//根据外部状态创建享元对象
			flyweight = new ConcreteFlyweight(extrinsic);
			//放入池中
			pool.put(extrinsic, flyweight);
			System.out.println("创建 " + extrinsic + " 并从池中取出---->" + flyweight.toString());
		}

		return flyweight;
	}

}

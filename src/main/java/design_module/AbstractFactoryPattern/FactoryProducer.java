package design_module.AbstractFactoryPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 22:37
 */

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice){
		if(choice.equalsIgnoreCase("SHAPE")){
			return new ShapeFactory();
		} else if(choice.equalsIgnoreCase("COLOR")){
			return new ColorFactory();
		}
		return null;
	}
}
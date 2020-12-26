package design_module.AbstractFactoryPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 22:35
 */

public abstract class AbstractFactory {
	public abstract Color getColor(String color);
	public abstract Shape getShape(String shape) ;
}

package design_module.PrototypePattern;

import java.util.Hashtable;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:05
 */

public class ShapeCacheFactory {

	//缓存池，保存多种图形的唯一对象。
	private static Hashtable<String, Shape> shapeMap
			= new Hashtable<String, Shape>();

	//结合工厂方法模式使用：当需要相同类型的图形时，从缓存池中取出对应的图形，然后复制一份给客户端。
	public static Shape getShape(String shapeId) {
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

	// 添加三种形状到缓存池：三角形、圆形、矩形
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setType("Circle");
		shapeMap.put(circle.getType(),circle);

		Square square = new Square();
		square.setType("Square");
		shapeMap.put(square.getType(),square);

		Rectangle rectangle = new Rectangle();
		rectangle.setType("Rectangle");
		shapeMap.put(rectangle.getType(),rectangle);
	}
}

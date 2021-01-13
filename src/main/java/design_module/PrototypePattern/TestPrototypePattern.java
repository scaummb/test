package design_module.PrototypePattern;

/**
 * @author moubin.mo
 * @date: 2020/12/26 23:05
 */

public class TestPrototypePattern {
	public static void main(String[] args) {
		//initialization
		ShapeCacheFactory.loadCache();

		//Circle Square Rectangle
		Shape clonedShape = (Shape) ShapeCacheFactory.getShape("Circle");
		System.out.println("Shape : " + clonedShape.getType());

		Shape clonedShape2 = (Shape) ShapeCacheFactory.getShape("Square");
		System.out.println("Shape : " + clonedShape2.getType());

		Shape clonedShape3 = (Shape) ShapeCacheFactory.getShape("Rectangle");
		System.out.println("Shape : " + clonedShape3.getType());
	}
}

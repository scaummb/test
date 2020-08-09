package reflect.childrenParentClassFieldReflect;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;

/**
 * @author moubin.mo
 * @date: 2020/8/8 21:29
 */

public class Test {
	public static void main(String[] args) throws IllegalAccessException {
		Parent parent = new Parent(60);
		Son son = new Son(20, "son");
		Parent parentSon = new Son(20, "son");
		Field[] parentFields = FieldUtils.getAllFields(parent.getClass());
		Field[] sonFields = FieldUtils.getAllFields(son.getClass());
		Field[] parentSonFields = FieldUtils.getAllFields(parentSon.getClass());

		System.out.println(parentFields);
		for (Field field : parentFields) {
			field.setAccessible(true);
			System.out.println("parent => " + field.getName() + " " + field.getType() + " " + field.get(parent));
		}
		System.out.println(sonFields);
		for (Field field : sonFields) {
			field.setAccessible(true);
			System.out.println("son => " + field.getName() + " " + field.getType() + " " + field.get(son));
		}
		System.out.println(sonFields);
		for (Field field : sonFields) {
			field.setAccessible(true);
			System.out.println("son => " + field.getName() + " " + field.getType() + " " + field.get(son));
		}
		System.out.println(parentSonFields);
		for (Field field : parentSonFields) {
			field.setAccessible(true);
			System.out.println("parentSon => " + field.getName() + " " + field.getType() + " " + field.get(son));
		}
	}
}

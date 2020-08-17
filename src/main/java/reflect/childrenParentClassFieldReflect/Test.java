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

//		System.out.println(parentFields);
//		for (Field field : parentFields) {
//			field.setAccessible(true);
//			System.out.println("parent => " + field.getName() + " " + field.getType() + " " + field.get(parent));
//		}
//		System.out.println(sonFields);
//		for (Field field : sonFields) {
//			field.setAccessible(true);
//			System.out.println("son => " + field.getName() + " " + field.getType() + " " + field.get(son));
//		}
//		System.out.println(sonFields);
//		for (Field field : sonFields) {
//			field.setAccessible(true);
//			System.out.println("son => " + field.getName() + " " + field.getType() + " " + field.get(son));
//		}
//		System.out.println(parentSonFields);
//		for (Field field : parentSonFields) {
//			field.setAccessible(true);
//			System.out.println("parentSon => " + field.getName() + " " + field.getType() + " " + field.get(son));
//		}


		Daughter girl = new Daughter(19, "girl1");
		Parent girl2 = new Daughter(19, "girl2");
		Parent girl3 = new Parent(19);

		Field[] girlFields = FieldUtils.getAllFields(girl.getClass());
		Field[] girlFields2 = FieldUtils.getAllFields(girl2.getClass());
		Field[] girlFields3 = FieldUtils.getAllFields(girl3.getClass());

//		testField(girlFields, girl);
//		testField(girlFields2, girl2);
		testField(girlFields3, girl3);


	}

	private static void testField(Field[] girlFields, Object object) throws IllegalAccessException {
		System.out.println(object.getClass());
		for (Field field : girlFields) {
			field.setAccessible(true);
			System.out.println("testObject => " + field.getName() + " " + field.getType() + " " + field.get(object) + " clase : " + field.getDeclaringClass());
		}
	}

	/**
	 * 得出结论：父类对象，正常读取；子类如果覆盖基类的属性
	 */
}

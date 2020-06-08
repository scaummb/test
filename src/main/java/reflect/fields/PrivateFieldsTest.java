package reflect.fields;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

/**
 * <p>
 *     继承了父类的对象，通过Object.getDeclaredFields()无法获取属性
 *     		class.getDeclaredMethods() 获取类的所有方法（public、protected、default、private），但不包括继承的方法；
 * 			class.getMethods() 获取当前类和父类的public方法。
 * </p>
 * @author moubin.mo
 * @date: 2020/6/6 16:22
 */

public class PrivateFieldsTest {
	public static void main(String[] args) {
		getFields(new SubBus());
	}
	private static Field[] getFields(Object obj){
		if (!ObjectUtils.isEmpty(obj)){
			Field[] fields = obj.getClass().getFields();
			Field[] declaredFields = obj.getClass().getDeclaredFields();
//			System.out.println(fields);
//			System.out.println(declaredFields);
			Class<?> currentClass = obj.getClass();
			Field[] allFields = FieldUtils.getAllFields(currentClass);
			for (Field field : allFields) {
				System.out.println(field);
			}
		}
		return null;
	}
}

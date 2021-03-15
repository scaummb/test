package reflect;/**
 * <p$description</p>
 */

import Utils.PrintUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author moubin.mo
 * @date: 2020/3/18 20:53
 */

public class ReflectTest {
	public static void main(String[] args) {
		Class<Person> personClass = Person.class;
		try {
			Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
			Person person = constructor.newInstance("mmb", 25);
			Method method = personClass.getMethod("say", String.class);
			method.invoke(person, "hello world!!");
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
			PrintUtils.printObjects(e);
		}
	}
}

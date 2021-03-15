package multiThread;

/**
 * @author moubin.mo
 * @date: 2019/8/14 15:32
 */

public class StaticClass {
	private static String name;

	public static void staticName(String name) {
		setName(name);
	}

	public synchronized static String getName() {
		return name;
	}

	public synchronized static void setName(String name) {
		StaticClass.name = name;
	}
}

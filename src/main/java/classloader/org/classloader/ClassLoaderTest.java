package classloader.org.classloader;

/**
 * @author moubin.mo
 * @date: 2021/1/15 23:48
 */

public class ClassLoaderTest {
	public static void main(String[] args) {
//		ClassLoader classLoader = sun.security.ec.SunEC.class.getClassLoader();
//		System.out.println(classLoader);
//		System.out.println(classLoader.getParent());

//		ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//		System.out.println(classLoader);
//		classLoader = classLoader.getParent();
//		System.out.println(classLoader);
	}

	//sun.misc.Launcher$AppClassLoader@18b4aac2
	//sun.misc.Launcher$ExtClassLoader@35851384
	//null
	//第一行结果说明：ClassLoaderTest的类加载器是AppClassLoader。
	//第二行结果说明：AppClassLoader的类加器是ExtClassLoader，即parent=ExtClassLoader。
	//第三行结果说明：ExtClassLoader的类加器是Bootstrap ClassLoader，因为Bootstrap ClassLoader不是一个普通的Java类，所以ExtClassLoader的parent=null，所以第三行的打印结果为null就是这个原因。

	// javac -encoding utf-8 ClassLoaderTest.java
	// jar -cvf ClassLoaderTest.jar ClassLoaderTest.class
	// 打jar包，并且放到Extension ClassLoader的加载目录下（JAVA_HOME/jre/lib/ext）
}

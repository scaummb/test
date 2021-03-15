package classloader.org.classloader;

/**
 * <p>
 * BootStrap ClassLoader：称为启动类加载器，是Java类加载层次中最顶层的类加载器，负责加载JDK中的核心类库，如：rt.jar、resources.jar、charsets.jar等。
 * <p>
 * Extension ClassLoader：称为扩展类加载器，负责加载Java的扩展类库，默认加载JAVA_HOME/jre/lib/ext/目下的所有jar。
 * <p>
 * App ClassLoader：称为系统类加载器，负责加载应用程序classpath目录下的所有jar和class文件。
 * <p>
 * 注意： 除了Java默认提供的三个ClassLoader之外，用户还可以根据需要定义自已的ClassLoader，而这些自定义的ClassLoader都必须继承自java.lang.ClassLoader类，也包括Java提供的另外二个ClassLoader（Extension ClassLoader和App ClassLoader）在内，但是Bootstrap ClassLoader不继承自ClassLoader，因为它不是一个普通的Java类，底层由C++编写，已嵌入到了JVM内核当中，当JVM启动后，Bootstrap ClassLoader也随着启动，负责加载完核心类库后，并构造Extension ClassLoader和App ClassLoader类加载器。
 *
 * </p>
 *
 * @author moubin.mo
 * @date: 2021/1/15 23:43
 */

public class NetWorkClassLoader {
	private String url;

	public NetWorkClassLoader(String url) {
		this.url = url;
	}

//	private Class<?> loadClass(String className) {
//
//	}
//
//	public static void main(String[] args) {
//		try {
//
//			//测试加载网络中的class文件
//
//			String rootUrl = "http://localhost:8080/httpweb/classes";
//
//			String className = "org.classloader.simple.NetClassLoaderSimple";
//
//			NetWorkClassLoader ncl1 = new NetWorkClassLoader(rootUrl);
//			NetWorkClassLoader ncl2 = new NetWorkClassLoader(rootUrl);
//
//			Class<?> clazz1 = ncl1.loadClass(className);
//
//			Class<?> clazz2 = ncl2.loadClass(className);
//
//			Object obj1 = clazz1.newInstance();
//
//			Object obj2 = clazz2.newInstance();
//
//			clazz1.getMethod("setNetClassLoaderSimple", Object.class).invoke(obj1, obj2);
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//		}
//
//	}
}

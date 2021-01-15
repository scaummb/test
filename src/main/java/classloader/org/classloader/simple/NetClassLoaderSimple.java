package classloader.org.classloader.simple;

/**
 * <p>org.classloader.simple.NetClassLoaderSimple类的setNetClassLoaderSimple方法接收一个Object类型参数，并将它强制转换成org.classloader.simple.NetClassLoaderSimple类型。</p>
 * @author moubin.mo
 * @date: 2021/1/15 23:42
 */

public class NetClassLoaderSimple {
	private NetClassLoaderSimple instance;

	public void setNetClassLoaderSimple(Object obj) {

		this.instance = (NetClassLoaderSimple)obj;

	}
}

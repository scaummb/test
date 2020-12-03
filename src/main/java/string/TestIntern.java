package string;

/**
 * @author moubin.mo
 * @date: 2020/12/3 17:28
 */

public class TestIntern {
	public static void main(String[] args){
		testIntern();
	}
	private static void testIntern() {
		// 两种初始化方式有何区别？
		//回答：
		// 1）"def"，在编译器已经放到类文件常量池了，因此会被自动加载到JVM的方法区的常量池内。调用intern方法返回的是编译器已经创建好的对象，跟x不是一个对象。所以结果是true
		// 2）而new char[]{'a','b','c'}，是动态创建的字符串类，此前并未提前加载到JVM的方法区的常量池内。因此String对象a创建完成之后，JVM(jdk7)会优先将这个字符串对象拷贝到JVM的方法区的常量池内（a对象的引用），再调用intern方法之后返回的是JVM的方法区的常量池内（a对象的引用）。所以结果是true
		String x =new String("def");
		String y = x.intern();
		System.out.println(x == y);

		String a =new String(new char[]{'a','b','c'});
		String b = a.intern();
		System.out.println(a == b);
	}

}

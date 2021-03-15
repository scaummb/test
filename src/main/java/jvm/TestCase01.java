package jvm;

import java.util.List;

/**
 * REMARK 《JVM》10-4
 *
 * @author: mmb
 * @date: 19-12-17
 */
public class TestCase01 {
	public static void main(String[] args) {

	}

	// 这里的方法重载，JVM编译后会进行类型擦除，List<String> list 和 List<Long> list 都会编译为List<E> list
	// 导致两个方法的特征签名一样（signature），这样不能合法的存在于一个class文件
//    public static void method(List<String> list){
	public static void method(List<String> list, Long a) {
		System.out.println(list);
	}

	public static void method(List<Long> list) {

	}
}

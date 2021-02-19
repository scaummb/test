package bigdecimal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author moubin.mo
 * @date: 2020/11/2 16:43
 */

public class TestByte {
		public static void main(String[] args) {
			test2();
		}

	private static void test2() {
		byte b1 = 1,b2 = 2, b3, b6;
		final byte b4 =4, b5 = 5; //final 限制不能转换类型,被final修饰都是常量。b6编译时就是10了。
		b6 = b4 + b5;
//		b3 = b1 + b2; //(short,char)byte计算会被升级为int！！
	}


	private static void test1() {
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<230; i++){
			list.add(i);
		}
		byte len = (byte) list.size(); // 无符号=1110 0110,补码=1001 1001 + 0000 0001 = 1001 1010 (-26)
		System.out.println(list.size());
		System.out.println(len);
		System.out.println((int)len);
		System.out.println((int)len+256);// ?加256
	}
}

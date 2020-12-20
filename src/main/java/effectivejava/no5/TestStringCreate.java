package effectivejava.no5;

/**
 * @author moubin.mo
 * @date: 2020/12/20 12:22
 */

public class TestStringCreate {
	public static void main(String[] args) {
		String s1 = new String("stringette");//反例
		String s2 = "stringette";//正解
	}
}

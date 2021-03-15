package iniliazation;

/**
 * @author moubin.mo
 * @date: 2021/1/21 23:56
 */

public class TestIntegerInitialize {

	public static void main(String[] args) {
		Integer i1 = 59;//对象指向常量池的值
		int i2 = 59; //常量池的值
		Integer i3 = Integer.valueOf(59);//从cache缓存取出对象
		Integer i4 = new Integer(59);//构造器新建一个对象
		System.out.println(i1 == i2);

		int a = Integer.parseInt("1023");
		int b = Integer.valueOf("1023").intValue();
		System.out.println(a == b);
	}

}

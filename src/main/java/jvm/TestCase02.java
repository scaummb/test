package jvm;

/**
 * 自动装箱的陷阱，10-8
 * <ul>Integer的缓存机制： Integer是对小数据（-128~127）是有缓存的，再jvm初始化的时候，数据-128~127之间的数字便被缓存到了本地内存中，如果初始化-128~127之间的数字，会直接从内存中取出，不需要新建一个对象.</ul>
 *
 * @author moubin.mo
 * @date: 2019/12/18 09:06
 */

class Case02 {
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = 2;
		Integer c = 3;
		Integer d = 3;
		Integer e = -129;
		Integer f = -129;
		Long g = 3L;

//		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());short
//		System.out.println(c.hashCode());
//		System.out.println(d.hashCode());
//		System.out.println(e.hashCode());
//		System.out.println(f.hashCode());


		//test
		System.out.println("c == d : " + (c == d));//包装类的“==”，没有算术运算不拆箱比较，比较的是两个包装类对象的内存地址，ture
		System.out.println("c.equals d : " + (c.equals(d)));//包装类的“equals”，没有算术运算不拆箱比较，比较的是两个包装类对象的内存地址，ture
		System.out.println("e == f : " + (e == f));// 包装类的“==”，没有算术运算不拆箱比较，比较的是两个包装类对象的内存地址，false（数值在[-128-127]范围内，jvm的缓存机制）
		System.out.println("e.equals f : " + (e.equals(f)));// 包装类的“equals”，不会转换数据类型，比较两者的封装属性值
		System.out.println("c == (a + b) : " + (c == (a + b))); // 包装类的“==”，遇到算术运算会自动拆箱
		System.out.println("c.equals(a + b) : " + (c.equals(a + b)));// 包装类的“equals”不处理数据类型转换
		System.out.println("g == (a + b) : " + (g == (a + b)));// ==，后面是数值运算，拆箱比较数值
		System.out.println("g.equals(a + b) : " + (g.equals(a + b)));// 包装类的“equals”，入参是不同数据类型，直接返回false，源码！

		/**
		 c == d : true
		 e == f : false
		 c == (a + b) : true
		 c.equals(a + b) : true
		 g == (a + b) : true
		 g.equals(a + b) : false
		 */
	}
}

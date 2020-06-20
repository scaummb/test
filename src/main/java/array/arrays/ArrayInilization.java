package array.arrays;

import java.util.Arrays;

/**
 * <p>
 *     初始化数组：如何对指向数组的引用赋值；
 *     对象数组跟基本类型数组在使用上几乎是相同的，唯一区别是对象数组保存引用，基本类型直接保存基本类型的值。
 * </p>
 * @author moubin.mo
 * @date: 2020/6/20 22:39
 */

public class ArrayInilization {
	public static void main(String[] args) {
		//Arrays of objects
		BerylliumSphere[] a;
		BerylliumSphere[] b = new BerylliumSphere[5];

		// references inside the array are automatically initialized to null.
		System.out.println("b:" + Arrays.toString(b));

		BerylliumSphere[] c = new BerylliumSphere[4];
		for (int i = 0; i < c.length; i++){
			if (c[i] == null){
				c[i] = new BerylliumSphere();
			}
		}

		BerylliumSphere[] d = {new BerylliumSphere(),new BerylliumSphere(), new BerylliumSphere()};

		// dynamic aggregate initialization.
		a = new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()};

		// assignment
		a = d;

		int[] e;
		int[] f = new int[5];
		System.out.println(Arrays.toString(f));

		int[] g = new int[4];
		for (int i = 0; i <g.length; i++){
			g[i] = i*i;
		}

		int[] h = {11, 57, 93};
		System.out.println("f.length" + f.length);
		System.out.println("g.length" + g.length);
		System.out.println("h.length" + h.length);

		e = h;
		System.out.println("e.length" + e.length);
		e = new int[]{1,2};
		System.out.println("e.length" + e.length);

	}
}

class BerylliumSphere{

}

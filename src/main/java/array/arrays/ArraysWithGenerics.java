package array.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>数组与泛型结合使用，初始化与声明</p>
 *
 * @author moubin.mo
 * @date: 2020/6/21 00:02
 */

public class ArraysWithGenerics {
	@SuppressWarnings("enchecked")
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la = new List[5];
		ls = (List<String>[]) la;

		ls[0] = new ArrayList<String>();

		// List<String> is a subtype of Object
		Object[] objects = ls;

		// Complies and runs without complaint
		objects[1] = new ArrayList<Integer>();

		// each element of array ,is an arrayList;
		List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];
		for (int i = 0; i < spheres.length; i++)
			spheres[i] = new ArrayList<BerylliumSphere>();
	}
}

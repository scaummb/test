package array.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>数组中，构成矩阵的每个向量都可以具有任意长度，被称为“粗糙数组”</p>
 *
 * @author moubin.mo
 * @date: 2020/6/20 23:05
 */

public class MultidimensionalArrays {
	public static void main(String[] args) {
		testIntThreeDimensions();
		testObjectThreeDimensions();
	}

	private static void testObjectThreeDimensions() {
		BerylliumSphere[][] spheres = {{new BerylliumSphere(), new BerylliumSphere()},
				{new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere(), new BerylliumSphere()},
				{new BerylliumSphere(), new BerylliumSphere()}};
		System.out.println(Arrays.deepToString(spheres));
	}

	private static void testIntThreeDimensions() {
		Random ran = new Random(57);
		int[][][] a = new int[8][][];
		for (int i = 0; i < a.length; i++) {
			a[i] = new int[ran.nextInt(5)][];
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = new int[ran.nextInt(5)];
			}
		}
		System.out.println(Arrays.deepToString(a));
	}
}

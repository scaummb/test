package effectivejava.no42;

import java.util.Arrays;
import java.util.List;

/**
 * 可变参数是为printf而设计的，为了核心的反射机制而被改造。两者都从可变参数中极大受益。
 * @author moubin.mo
 * @date: 2020/9/27 02:09
 */

public class VarargsTest {

	private static void testArraysAsList(){
		List<String> homophones = Arrays.asList("a", "b");
		System.out.println(homophones);
		int[] args = {3,1,4,1,5,9,2,6,5,4};
		System.out.println(Arrays.asList(args));
		System.out.println(Arrays.toString(args));
	}
	private int min(int firstArg, int... args){
		int min = firstArg;
		for (int i = 1; i < args.length; i++){
			if (args[i] < min){
				min = args[i];
			}
		}
		return min;
	}
	private int min (int... args) throws IllegalAccessException {
		if (args.length == 0){
			throw new IllegalAccessException("Too few arguments.");
		}
		int min = args[0];
		for (int i = 1; i < args.length; i++){
			if (args[i] < min){
				min = args[i];
			}
		}
		return min;
	}
	private static int sum (int... args){
		int sum = 0;
		for (int arg : args){
			sum += arg;
		}
		return sum;
	}
	public static void main(String[] args) {
		testArraysAsList();
	}
}

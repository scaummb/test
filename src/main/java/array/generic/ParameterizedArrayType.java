package array.generic;

/**
 * <p>
 *     参数化方法 比 参数化类 方便之处：不需要为每种类型使用一个参数去实例化该类，且可以设置为静态的方法。
 * </p>
 * @author moubin.mo
 * @date: 2020/6/7 12:38
 */

public class ParameterizedArrayType {
	public static void main(String[] args) {
		Integer[] ints = {1,2,3,4,5};
		Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
		// 参数化类
		Integer[] ints2 = new ClassParameter<Integer>().f(ints);
		Double[] doubles2 = new ClassParameter<Double>().f(doubles);
		// 参数化方法
		ints2 = MethodParameter.f(ints);
		doubles2 = MethodParameter.f(doubles);
	}
}

class ClassParameter<T>{
	public T[] f(T[] arg){
		return arg;
	}
}

class MethodParameter{
	public static <T>T[] f(T[] arg){
		return arg;
	}
}


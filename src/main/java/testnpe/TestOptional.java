package testnpe;

import java.util.Optional;

/**
 * Optional类使用
 *
 * @author moubin.mo
 * @date: 2019/10/27 18:02
 */

public class TestOptional {
	public static void main(String[] args) {
		String result = "1,2,3,4";
		if (result != null) {
			String[] strings = result.split(",");
		}

		// 它是一个容器，装载着非NULL元素(或者没有装载元素)，提供了一系列的方法供我们判断该容器里的对象是否存在(以及后续的操作)。
		String[] all = Optional.ofNullable(result).map(str -> str.split(",")).orElse(new String[]{});
		System.out.println(all);


//		Optional<Object> o = Optional.of(null);
		Optional<Object> o1 = Optional.ofNullable(null);

	}
}

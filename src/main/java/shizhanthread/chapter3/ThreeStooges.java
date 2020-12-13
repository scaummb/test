package shizhanthread.chapter3;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author moubin.mo
 * @date: 2020/12/13 22:31
 */
@Immutable
public final class ThreeStooges {
	//不可变对象的引用，但是Set的数据可以被更新
	private final Set<String> stooges = new HashSet<String>();
	public ThreeStooges() {
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}
	//这是读操作，允许并发读（除非还有并发写的操作，否则就是不安全的）
	public boolean isStooge(String name) {
		return stooges.contains(name);
	}
}

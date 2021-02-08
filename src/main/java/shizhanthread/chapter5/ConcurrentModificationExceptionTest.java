package shizhanthread.chapter5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     实际情况，开发者不希望迭代期间，对容器进行加锁。容器长度很长，导致长时间等待，甚至死锁。
 *     解决方法一是：克隆容器。但是有显著性能消耗。
 *     解决方法二是：对容器加锁（处处迭代加锁，甚至隐藏迭代器）。
 *		容易出发异常的迭代操作:
 *			retainAll
 *			removeAll
 *			containsAll
 * </p>
 */

public class ConcurrentModificationExceptionTest {
	public static void main(String[] args) {
		List<Widget> widgets = Collections.synchronizedList(new ArrayList<Widget>());
		//ConcurrentModificationException maybe throws
		for (Widget widget : widgets){
			dosomething(widget);
		}
	}

	private static void dosomething(Widget widget) {
		//...
	}

	class Widget{}
}

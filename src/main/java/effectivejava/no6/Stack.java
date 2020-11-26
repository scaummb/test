package effectivejava.no6;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.WeakHashMap;

/**
 * @author moubin.mo
 * @date: 2020/11/26 22:52
 */

public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	// 初始化数组长度为16
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	/**
	 * 设置栈顶元素
	 */
	public void push(Object e){
		ensureCapacity();
		elements[size++] = e;
	}

	/**
	 * 弹出栈顶元素
	 */
	public Object pop(){
		if (size == 0){
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null; //释放对象引用
		return result;

	}

	/**
	 * <p>扩容</p>
	 */
	private void ensureCapacity() {
		if (elements.length == size){
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public static void main(String[] args) {
		WeakHashMap weakHashMap = new WeakHashMap();

	}

}

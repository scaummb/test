package shizhanthread.chapter1;

import shizhanthread.annotations.NotThreadSafe;

/**
 * @author moubin.mo
 * @date: 2020/11/17 21:35
 */
@NotThreadSafe
public class UnsafeSequence {
	private int value;

	/**
	 * 返回唯一值
	 **/
	public int getNext() {
		return value++;
	}
}

package shizhanthread.chapter1;

import shizhanthread.annotations.ThreadSafe;

/**
 * @author moubin.mo
 * @date: 2020/11/17 21:39
 */
@ThreadSafe
public class SafeSequence {
	private int value;
	/** 返回唯一值**/
	public synchronized int getNext(){
		return value++;
	}
}

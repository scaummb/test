package shizhanthread.chapter3;

import shizhanthread.annotations.NotThreadSafe;

/**
 * @author moubin.mo
 * @date: 2020/12/13 21:19
 */
@NotThreadSafe
public class PublishObject2 {
	private String[] states = new String[] {"AK","AL"};
	public String[] getStates() { return states; }
}

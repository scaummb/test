package shizhanthread.chapter3;

import shizhanthread.annotations.NotThreadSafe;


/**
 * <p>内部类，this在构造函数中逸出</p>
 */
@NotThreadSafe
public class ThisEscape {
	public static void main(String[] args) {
		EventSource eventSource = new EventSource();
		new ThisEscape(eventSource);
	}
	// ThisEscape 对象的构造器
	public ThisEscape(EventSource source) {
		source.registerListener(
				new EventListener() {
					//发布匿名对象（也发布了ThisEscape实例）
					public void onEvent(Event e) {
						doSomething(e);
					}
				},this);
	}
	private void doSomething(Event e) {
	}
}
package shizhanthread.chapter3;

/**
 * @author moubin.mo
 * @date: 2020/12/13 21:23
 */

public class EventSource {
	public void registerListener(EventListener eventListener, ThisEscape name) {
		System.out.println("EventSource知道了这个类，也会将它告诉 EventListener");
		eventListener.esclape(name);
	}
}

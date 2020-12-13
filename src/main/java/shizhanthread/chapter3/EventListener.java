package shizhanthread.chapter3;

/**
 * @author moubin.mo
 * @date: 2020/12/13 21:27
 */

public class EventListener {
	public void onEvent(Event e) {
	}

	public void esclape(ThisEscape name) {
		System.out.println("这是不安全的对象发布,因为EventSource的告知， EventListener 也知道 ThisEscape 被构建了：" + name.getClass());
	}
}

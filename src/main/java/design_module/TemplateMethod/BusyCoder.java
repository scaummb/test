package design_module.TemplateMethod;

/**
 * @author moubin.mo
 * @date: 2020/12/28 17:38
 */
//勤奋的程序员
public class BusyCoder extends Coding {
	@Override
	void washingHands() {
		System.out.println("busy man washing, 9：00 ~ 9:10");
	}

	@Override
	void havingACoffee() {
		System.out.println("busy man takes a coffee, 9：10 ~ 9:20");
	}

	@Override
	void working() {
		System.out.println("busy man starts working, 9：30 ~ 12:30");
	}

	@Override
	void chatting() {
		System.out.println("busy man has no chatting.focus on working...");
	}
}

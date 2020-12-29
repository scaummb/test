package design_module.TemplateMethod;

/**
 * @author moubin.mo
 * @date: 2020/12/28 17:38
 */

public class LazyCoder extends Coding {
	@Override
	void washingHands() {
		System.out.println("lazy man washing, 9：00 ~ 9:20");
	}

	@Override
	void havingACoffee() {
		System.out.println("lazy man takes a coffee, 9：30 ~ 10:20");
	}

	@Override
	void working() {
		System.out.println("lazy man starts working, 10：30 ~ 11:00");
	}

	@Override
	void chatting() {
		System.out.println("lazy man has a chat, 11：00 ~ 12:30");
	}
}

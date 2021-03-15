package design_module.TemplateMethod;

/**
 * @author moubin.mo
 * @date: 2020/12/28 17:26
 */

public abstract class Coding {
	//一套组合操作
	abstract void washingHands();

	abstract void havingACoffee();

	abstract void working();

	abstract void chatting();

	//开启编码
	void startCoding() {
		washingHands();
		havingACoffee();
		working();
		chatting();
	}
}

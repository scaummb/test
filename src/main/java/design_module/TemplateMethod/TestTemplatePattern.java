package design_module.TemplateMethod;

/**
 * @author moubin.mo
 * @date: 2020/12/28 17:42
 */

public class TestTemplatePattern {
	public static void main(String[] args) {
		BusyCoder busyCoder = new BusyCoder();
		busyCoder.startCoding();
		LazyCoder lazyCoder = new LazyCoder();
		lazyCoder.startCoding();
	}
}

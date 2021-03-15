package design_module.ChainOfResponsibilityPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 00:33
 */
//控制台打印，标准输出
public class ConsoleLogger extends AbstractLogger {
	public ConsoleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Standard Console::Logger: " + message);
	}
}
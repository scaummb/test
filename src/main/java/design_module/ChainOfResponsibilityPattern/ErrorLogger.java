package design_module.ChainOfResponsibilityPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 00:34
 */

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level){
		this.level = level;
	}

	@Override
	protected void write(String message) {
		System.out.println("Error Console::Logger: " + message);
	}
}

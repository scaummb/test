package design_module.ChainOfResponsibilityPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 00:36
 */

public class LoggerPrintChain {
	private static AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
	private static AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
	private static AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

	public static AbstractLogger getLoggerPrintChain() {
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		return errorLogger;
	}
}

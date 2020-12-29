package design_module.ChainOfResponsibilityPattern;

/**
 * @author moubin.mo
 * @date: 2020/12/28 00:41
 */

public class TesChainPattern {
	public static void main(String[] args) {
		AbstractLogger loggerChain = LoggerPrintChain.getLoggerPrintChain();

		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
		loggerChain.logMessage(AbstractLogger.DEBUG,
				"This is a debug level information.");
		loggerChain.logMessage(AbstractLogger.ERROR,
				"This is an error information.");
	}
}

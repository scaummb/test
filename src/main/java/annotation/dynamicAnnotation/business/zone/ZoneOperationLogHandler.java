package annotation.dynamicAnnotation.business.zone;


import annotation.dynamicAnnotation.log.annotation.OpcLogMethodHandler;
import annotation.dynamicAnnotation.log.handler.OperationLogBaseHandler;
import annotation.dynamicAnnotation.log.logger.OperationLogger;

/**
 * @author moubin.mo
 * @date: 2020/5/18 23:36
 */

public class ZoneOperationLogHandler implements OperationLogBaseHandler {


	@Override
	@OpcLogMethodHandler(byClass = ZoneCreateLogger.class)
	public void createLog(OperationLogger logger) {

	}

	@Override
	public void updateLog(OperationLogger logger) {

	}

	@Override
	@OpcLogMethodHandler(byClass = ZoneDeleteLogger.class)
	public void deleteLog(OperationLogger logger) {

	}
}

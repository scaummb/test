package annotation.dynamicAnnotation.business.zone;


import annotation.dynamicAnnotation.log.annotation.OpcLogMethodHandler;
import annotation.dynamicAnnotation.log.handler.OperationLogBaseHandler;
import annotation.dynamicAnnotation.log.logger.OpcLog;
import annotation.dynamicAnnotation.log.logger.OperationBaseLogger;

/**
 * @author moubin.mo
 * @date: 2020/5/18 23:36
 */

public class ZoneOperationLogHandler implements OperationLogBaseHandler {


	@Override
	public OpcLog createOrEnableLog(OperationBaseLogger logger) {
		return null;
	}

	@Override
	public OpcLog updateLog(OperationBaseLogger logger) {
		return null;
	}

	@Override
	public OpcLog deleteOrDisableLog(OperationBaseLogger logger) {
		return null;
	}


	@OpcLogMethodHandler(methodName = "exportZone")
	public OpcLog exportZone(OperationBaseLogger logger) {
		return null;
	}


}

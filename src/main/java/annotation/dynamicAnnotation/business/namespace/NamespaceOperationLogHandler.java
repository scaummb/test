package annotation.dynamicAnnotation.business.namespace;

import annotation.dynamicAnnotation.log.handler.OperationLogBaseHandler;
import annotation.dynamicAnnotation.log.logger.OpcLog;
import annotation.dynamicAnnotation.log.logger.OperationBaseLogger;

/**
 * @author moubin.mo
 * @date: 2020/5/18 23:36
 */

public class NamespaceOperationLogHandler implements OperationLogBaseHandler {

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
}

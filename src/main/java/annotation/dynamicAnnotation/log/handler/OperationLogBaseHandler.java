package annotation.dynamicAnnotation.log.handler;

import annotation.dynamicAnnotation.log.annotation.OpcLogMethodHandler;
import annotation.dynamicAnnotation.log.logger.OpcLog;
import annotation.dynamicAnnotation.log.logger.OperationBaseLogger;

/**
 * <p>日志操作处理类接口</p>
 * @author momoubin
 * @date 2020/5/18
 */
public interface OperationLogBaseHandler {
    /**
     * <p>新增数据日志</p>
     */
    @OpcLogMethodHandler(methodName = "createOrEnableLog")
    OpcLog createOrEnableLog(OperationBaseLogger logger);

    /**
     * <p>更新数据日志</p>
     */
    @OpcLogMethodHandler(methodName = "updateLog")
    OpcLog updateLog(OperationBaseLogger logger);

    /**
     * <p>删除数据日志</p>
     */
    @OpcLogMethodHandler(methodName = "deleteOrDisableLog")
    OpcLog deleteOrDisableLog(OperationBaseLogger logger);
}

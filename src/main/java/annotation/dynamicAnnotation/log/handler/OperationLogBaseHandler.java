package annotation.dynamicAnnotation.log.handler;

import annotation.dynamicAnnotation.log.logger.OperationLogger;

/**
 * <p>日志操作处理类接口</p>
 * @author momoubin
 * @date 2020/5/18
 */
public interface OperationLogBaseHandler {
    /**
     * <p>新增数据日志</p>
     */
    void createLog(OperationLogger logger);
    /**
     * <p>更新数据日志</p>
     */
    void updateLog(OperationLogger logger);
    /**
     * <p>删除数据日志</p>
     */
    void deleteLog(OperationLogger logger);
}

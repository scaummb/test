package annotation.dynamicAnnotation.log.handler;

import annotation.dynamicAnnotation.log.BaseOperationType;
import annotation.dynamicAnnotation.log.OperationType;
import annotation.dynamicAnnotation.log.annotation.OpcLogMethodHandler;
import annotation.dynamicAnnotation.log.logger.OpcLog;
import annotation.dynamicAnnotation.log.logger.OperationBaseLogger;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>策略中转站</p>
 * @author moubin.mo
 * @date: 2020/5/19 11:55
 */

public class OperationLogContext {
	private OperationLogBaseHandler operationLogHandler;

	/**
	 * <p>构造器：注册日志处理类的导出类到环境中</p>
	 */
	public OperationLogContext(OperationLogBaseHandler operationLogHandler) {
		this.operationLogHandler = operationLogHandler;
	}

	public void submitLog(OperationBaseLogger logger, OperationType type){
		//1.处理上下文数据
		buildContextParam(logger);
		//2.业务handler构造日志
		OpcLog opcLog = null;
		if (BaseOperationType.fromType(type.getOperationType()) != null){
			// 获取所有方法
			Method[] methods = operationLogHandler.getClass().getDeclaredMethods();
			for (Method method : methods){
				if(!method.isAccessible()){
					method.setAccessible(true);
				}
				// 获取方法的注解
				OpcLogMethodHandler annotation = method.getAnnotation(OpcLogMethodHandler.class);
				if (annotation.methodName()
						.equals(BaseOperationType.fromType(type.getOperationType()).getMethodName())){
					try {
						// 注解一致则调用方法
						opcLog = (OpcLog) method.invoke(operationLogHandler, logger);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		} else if (BaseOperationType.fromType(type.getOperationType()) == null
				&& !StringUtils.isEmpty(type.getMethod())){
			Method[] methods = operationLogHandler.getClass().getDeclaredMethods();
			for (Method method : methods){
				if(!method.isAccessible()){
					method.setAccessible(true);
				}
				// 获取方法的注解
				OpcLogMethodHandler annotation = method.getAnnotation(OpcLogMethodHandler.class);
				if (annotation.methodName().equals(type.getMethod())){
					try {
						// 注解一致则调用方法
						opcLog = (OpcLog) method.invoke(operationLogHandler, logger);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}

		//3.异步提交日志任务
		if (!ObjectUtils.isEmpty(opcLog)){
			saveLog(logger);
		}
	}

	/**
	 * <p>保存操作日志</p>
	 */
	private void saveLog(OperationBaseLogger logger) {
		//TODO provider saveLog
	}

	/**
	 * <p>操作日志添加上下文信息</p>
	 */
	private void buildContextParam(OperationBaseLogger logger) {
		logger.setOperationTime(System.currentTimeMillis());
		logger.setOperatorName("userName");
		logger.setOperatorUid(1L);
	}
}

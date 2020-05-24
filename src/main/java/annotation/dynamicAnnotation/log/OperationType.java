package annotation.dynamicAnnotation.log;

/**
 * <ul>
 * <li>OperationType: 操作类型{@link BaseOperationType}</li>
 * <li>method: handler处理方法{BaseOperationType.CUSTOM时需要指定方法}</li>
 * </ul>
 */
public class OperationType {
	private String OperationType;
	private String method;

	public String getOperationType() {
		return OperationType;
	}

	public void setOperationType(String operationType) {
		OperationType = operationType;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}

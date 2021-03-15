package annotation.dynamicAnnotation.log;

/**
 * @author moubin.mo
 * @date: 2020/5/19 13:09
 */

public enum BaseOperationType {
	CREATE_OR_ENABLE_LOG("createOrEnableLog"),
	UPDATELOG("updateLog"),
	DELETE_OR_DISABLE_LOG("deleteOrDisableLog"),
	CUSTOM("custom");

	private String methodName;

	BaseOperationType(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodName() {
		return methodName;
	}

	public static BaseOperationType fromType(String type) {
		for (BaseOperationType baseOperationType : BaseOperationType.values()) {
			if (baseOperationType.methodName.equals(type)) {
				return baseOperationType;
			}
		}
		return null;
	}
}

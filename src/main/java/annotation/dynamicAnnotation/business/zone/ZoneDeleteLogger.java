package annotation.dynamicAnnotation.business.zone;

import annotation.dynamicAnnotation.log.annotation.OpcLogData;
import annotation.dynamicAnnotation.log.logger.OperationLogger;

/**
 * @author moubin.mo
 * @date: 2020/5/18 23:37
 */
@OpcLogData(handlerName = "ZoneOperationHandler")
public class ZoneDeleteLogger extends OperationLogger {
	private String logTemplate;
	private String previousObject;
	private String previousObjectName;
	private String followedObject;
	private String followedObjectName;

	public void setLogTemplate(String logTemplate) {
		this.logTemplate = logTemplate;
	}

	public void setPreviousObject(String previousObject) {
		this.previousObject = previousObject;
	}

	public void setPreviousObjectName(String previousObjectName) {
		this.previousObjectName = previousObjectName;
	}

	public void setFollowedObject(String followedObject) {
		this.followedObject = followedObject;
	}

	public void setFollowedObjectName(String followedObjectName) {
		this.followedObjectName = followedObjectName;
	}

	@Override
	public String getLogTemplate() {
		return null;
	}

	@Override
	public String getPreviousObject() {
		return null;
	}

	@Override
	public String getPreviousObjectName() {
		return null;
	}

	@Override
	public String getFollowedObject() {
		return null;
	}

	@Override
	public String getFollowedObjectName() {
		return null;
	}
}

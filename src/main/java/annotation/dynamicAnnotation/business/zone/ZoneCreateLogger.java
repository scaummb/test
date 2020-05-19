package annotation.dynamicAnnotation.business.zone;

import annotation.dynamicAnnotation.log.logger.OperationLogger;
import annotation.dynamicAnnotation.log.annotation.OpcLogData;

/**
 * <p>Zone日志实现类</p>
 * @author momoubin
 * @date 2020/5/18
 */
@OpcLogData(handlerName = "ZoneOperationHandler")
public class ZoneCreateLogger extends OperationLogger {
    private String logTemplate;
    private String previousObject;
    private String previousObjectName;
    private String followedObject;
    private String followedObjectName;

    @Override
    public String getLogTemplate() {
        return null;
    }

    public void setLogTemplate(String logTemplate) {
        this.logTemplate = logTemplate;
    }

    @Override
    public String getPreviousObject() {
        return previousObject;
    }

    public void setPreviousObject(String previousObject) {
        this.previousObject = previousObject;
    }

    public void setPreviousObjectName(String previousObjectName) {
        this.previousObjectName = previousObjectName;
    }

    @Override
    public String getFollowedObject() {
        return followedObject;
    }

    public void setFollowedObject(String followedObject) {
        this.followedObject = followedObject;
    }

    public void setFollowedObjectName(String followedObjectName) {
        this.followedObjectName = followedObjectName;
    }
}

package annotation.dynamicAnnotation.log.logger;

/**
 * <ul>
 * <li>operationTime: operationTime</li>
 * <li>operatorName: operatorName</li>
 * <li>operatorUid: operatorUid</li>
 * <li>logTemplate: logTemplate</li>
 * <li>previousObject: previousObject</li>
 * <li>followedObject: followedObject</li>
 * </ul>
 */
public class OperationBaseLogger {
    // 操作时间
    private Long operationTime;
    // 操作者名称
    private String operatorName;
    // 操作者Uid
    private Long operatorUid;
    // 日志模板
    private String logTemplate;
    // 业务数据修改前
    private Object previousObject;
    // 业务数据修改后
    private Object followedObject;

    public String getLogTemplate() {
        return logTemplate;
    }

    public void setLogTemplate(String logTemplate) {
        this.logTemplate = logTemplate;
    }

    public Object getPreviousObject() {
        return previousObject;
    }

    public void setPreviousObject(Object previousObject) {
        this.previousObject = previousObject;
    }

    public Object getFollowedObject() {
        return followedObject;
    }

    public void setFollowedObject(Object followedObject) {
        this.followedObject = followedObject;
    }

    public void setPreviousObject(String previousObject) {
        this.previousObject = previousObject;
    }


    public void setFollowedObject(String followedObject) {
        this.followedObject = followedObject;
    }

    public Long getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Long operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Long getOperatorUid() {
        return operatorUid;
    }

    public void setOperatorUid(Long operatorUid) {
        this.operatorUid = operatorUid;
    }
}

package annotation.dynamicAnnotation.log.logger;

/**
 * <p>操作日志基类</p>
 * @author momoubin
 * @date 2020/5/18
 */
public class OperationLogger {
    // 操作时间
    private Long operationTime;
    // 操作者名称
    private String operatorObjectName;
    // 操作者Uid
    private Long operatorUid;
    // 日志模板
    private String logTemplate;
    // 前期数据
    private Object previousObject;
    // 后期数据
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

    public Long getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Long operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperatorObjectName() {
        return operatorObjectName;
    }

    public void setOperatorObjectName(String operatorObjectName) {
        this.operatorObjectName = operatorObjectName;
    }

    public Long getOperatorUid() {
        return operatorUid;
    }

    public void setOperatorUid(Long operatorUid) {
        this.operatorUid = operatorUid;
    }
}

package annotation.dynamicAnnotation.log;

/**
 * <p>操作业务类型</p>
 * @author momoubin
 * @date 2020/5/16
 */
public enum OperationBusinessType {
    NAMESPACE("域空间"),
    ZONE("集群"),
    COMMUNITY("项目"),
    SUITE("套餐"),
    APPLICATION("应用"),
    MANAGER("管理员"),
    ;

    private String name;

    OperationBusinessType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package annotation.operation.annotation;

import annotation.dynamicAnnotation.log.OperationBusinessType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *     OPC操作日志注解
 *          operationBusinessType:业务类型 {@link OperationBusinessType}
 *          operator:操作者
 *          operatorObjectName:对象类型
 *          previousObject:操作前数据
 *          previousObjectName:操作前数据对象类型
 *          followedObject:操作后数据
 *          followedObjectName:操作后数据对象类型
 * </p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpcOperationLog {
    int operationBusinessType() default 0;
    int operationType() default 0;
    String operator() default "";
    String operatorObjectName() default "";
    String previousObject() default "";
    String previousObjectName() default "";
    String followedObject() default "";
    String followedObjectName() default "";
}

package annotation.dynamicAnnotation.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>OPC操作日志数据注解</p>
 * <ul>
 *     <li>handlerName：注解作用于handler类生效，用于路由到业务处理类</li>
 * </ul>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpcLogData {
    String handlerName() default "";
}

package annotation.dynamicAnnotation.log.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>OPC操作日志处理方法注解</p>
 * <ul>
 *     <li>byClass：注解作用于handler类的方法生效，用于通过数据类型路由到业务处理类的方法</li>
 * </ul>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OpcLogMethodHandler {
	Class<?> byClass();
}

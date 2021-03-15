package annotation.database.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Constraints {
	boolean primaryKey() default false;

	boolean allowNull() default true;

	boolean unique() default false;
}

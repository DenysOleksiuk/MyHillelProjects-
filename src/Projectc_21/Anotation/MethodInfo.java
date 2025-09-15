package Projectc_21.Anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface MethodInfo {
    String methodName();
    String paramType();
    String description() default "";
    String returnType() default "";
}

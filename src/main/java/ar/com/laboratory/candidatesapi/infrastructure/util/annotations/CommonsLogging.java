package ar.com.laboratory.candidatesapi.infrastructure.util.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CommonsLogging {
    String tag() default "";
    String type() default "";
    String path() default "";

}
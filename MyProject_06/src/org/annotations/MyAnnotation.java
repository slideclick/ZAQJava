package org.annotations;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String hello() default "nanjing";
	String world();
}

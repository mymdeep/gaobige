package deep.com.myapplication.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangfei on 2018/4/26.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD,ElementType.TYPE})
@Documented
@Inherited
public @interface Deep {
    int v() default 1;
    boolean b() default false;
    String k() default "key";
    String methodParam() default "";
}

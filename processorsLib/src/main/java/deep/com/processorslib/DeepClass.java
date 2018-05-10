package deep.com.processorslib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangfei on 2018/4/27.
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD})
public @interface DeepClass {
    String value();
}

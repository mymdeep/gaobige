package deep.com.myapplication.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import android.support.annotation.IntDef;

/**
 * Created by wangfei on 2018/7/19.
 */

public class SourceDeepAnnotation {
    public static final int ON = 1;
    public static final int OFF = 2;
    private static int sStatus = ON;
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({ON, OFF})
    public @interface Status {
    }
    public static void setStatus(@Status int status) {
        sStatus = status;
    }

    public static int getStatus() {
        return sStatus;
    }
    public static String getStatusDesc() {
        if (sStatus == ON) {
            return "打开状态";
        } else {
            return "关闭状态";
        }
    }


}

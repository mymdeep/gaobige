package deep.com.myapplication.utils;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by wangfei on 2018/3/28.
 */

public class MyQueue {
    private static Handler uiHandler;
    public static void runInMain(Runnable runnable) {
        if (uiHandler == null) {
            uiHandler = new Handler(Looper.getMainLooper());
        }
        uiHandler.post(runnable);
    }
    public static void runInBack(Runnable runnable) {
            new Thread(runnable).start();
    }
}

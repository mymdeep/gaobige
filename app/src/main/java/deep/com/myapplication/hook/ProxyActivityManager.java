package deep.com.myapplication.hook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import android.util.Log;

/**
 * Created by wangfei on 2018/5/18.
 */

public class ProxyActivityManager implements InvocationHandler {
    private Object iActivityManagerObject;

    public ProxyActivityManager(Object iActivityManagerObject) {
        this.iActivityManagerObject = iActivityManagerObject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("startActivity".contains(method.getName())) {
            Log.e("hook","Activity 启动被Hook了");
        }

        return method.invoke(iActivityManagerObject, args);
    }
}

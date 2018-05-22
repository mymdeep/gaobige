package deep.com.myapplication.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import android.util.Log;

/**
 * Created by wangfei on 2018/5/16.
 */

public class TeachBookHandler implements InvocationHandler {
    private Object target;
    public TeachBookHandler(Object target) {
        super();
        this.target = target;
    }
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {

        Log.e("proxy","动态代理 读书之前，先预习");
        method.invoke(target);
        Log.e("proxy","动态代理 读书之后，要复习");
        return null;
    }
}

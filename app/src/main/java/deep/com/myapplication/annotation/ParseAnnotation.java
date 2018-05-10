package deep.com.myapplication.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.util.Log;

/**
 * Created by wangfei on 2018/4/26.
 */

public class ParseAnnotation {
    public static void parse(Class<?> _clazz, Object _object) {
        Class<?> clazz = _clazz;
        Field[] fields = clazz.getDeclaredFields();
        try {
            parseField(fields, clazz, _object);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        StackTraceElement stack[] = Thread.currentThread().getStackTrace();

        for(int i=0;i<stack.length;i++){
          Log.e("xxxx",stack[i].getClassName()+" 。"+stack[i].getMethodName()+"-----");
        }



    }

    public static void invoke(Class<?> _clazz, Object _object, String methodName) {

        try {
            Method m = _clazz.getDeclaredMethod(methodName, String.class);
            Log.e("annotation", "m=" + m.getName());
            Deep d = m.getAnnotation(Deep.class);

            if (d != null) {
                m.setAccessible(true);
                Log.e("annotation", "d=" + d);
                m.invoke(_object, d.methodParam());
            }

        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private static void parseField(Field[] fields, Class<?> clazz, Object _object)
        throws IllegalArgumentException, IllegalAccessException {
        for (Field field : fields) {
            Deep d = field.getAnnotation(Deep.class);
            if (d != null) {
                String k = d.k();
                int v = d.v();
                boolean b = d.b();
                Log.e("annotation", "k=" + k + "  v=" + v + "   b=" + b);
                field.setAccessible(true);
                Log.e("annotation", "field.getType().getSimpleName()=" + field.getType().getSimpleName());
                if (field.getName().equals("key")) {
                    field.set(_object, k);
                } else if (field.getName().equals("a")) {
                    field.set(_object, v);
                } else if (field.getName().equals("isB")) {
                    field.set(_object, b);
                }
            }
        }
    }
}

package deep.com.annotationlib;

import java.lang.reflect.Field;

import android.util.Log;

/**
 * Created by wangfei on 2018/4/26.
 */

public class ParseAnnotation {
    public static void parse(Class<?> _clazz, Object _object){
        Class<?> clazz = _clazz;
        Field[] fields = clazz.getDeclaredFields();
        try {
             parseField(fields, clazz, _object);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    private static void parseField(Field[] fields, Class<?> clazz, Object _object) throws IllegalArgumentException, IllegalAccessException{
        for (Field field : fields) {
            Deep d = field.getAnnotation(Deep.class);
            if (d!=null){
                String k = d.k();
                int v = d.v();
                boolean b = d.b();
                Log.e("annotation","k="+k+"  v="+v+"   b="+b);
                field.setAccessible(true);
                Log.e("annotation","field.getType().getSimpleName()="+field.getType().getSimpleName());
                if (field.getName().equals("key")){
                    field.set(_object,k);
                }else if(field.getName().equals("a")){
                    field.set(_object,v);
                }else if(field.getName().equals("isB")){
                    field.set(_object,b);
                }
            }
        }
    }
}

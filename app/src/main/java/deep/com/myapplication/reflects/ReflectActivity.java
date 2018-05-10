package deep.com.myapplication.reflects;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/4/26.
 */

public class ReflectActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);
        findViewById(R.id.reflect_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Class<?> clz = Class.forName("deep.com.myapplication.reflects.DeepReflect");
                    Log.e("reflect",clz.getName());
                    //获取所有方法
                    Method[] methods =  clz.getMethods() ;
                    for (Method m:methods){
                        Log.e("reflect","method:"+m.getName());
                    }

                    //获取所有接口
                    Class<?>[] inters = clz.getInterfaces();
                    for (Class<?> i:inters){
                        Log.e("reflect","method:"+i.getName());
                    }


                    //取得本类的全部属性 不包括父类
                    Field[] fields = clz.getDeclaredFields();
                    for (Field f : fields) {
                        Log.e("reflect","属性值1:"+f.getName());
                    }

                    //取得本类的public属性 包括父类
                    Field[] fields2 = clz.getFields();
                    for (Field f : fields2) {
                        Log.e("reflect","属性值2:"+f.getName());
                    }
                    //创建实例
                    DeepReflect deepReflect1 = (DeepReflect)clz.newInstance();
                    Constructor<?> constructor2 =  clz.getDeclaredConstructor( String.class ) ;
                    DeepReflect deepReflect2  = (DeepReflect)constructor2.newInstance( "1000" );
                    Constructor<?> constructor3 =  clz.getDeclaredConstructor( String.class,String.class ) ;
                    DeepReflect deepReflect3  = (DeepReflect)constructor3.newInstance( "1000" ,"deep");

                    //设置公开属性
                    Field b_p = clz.getDeclaredField( "b" ) ;
                    b_p.set(  deepReflect1 , "b_b_b_b") ;
                    Log.e("reflect","设置后的公有属性值:"+deepReflect1.b);

                    //设置私有
                    Field id_p = clz.getDeclaredField( "id" ) ;
                    id_p.setAccessible( true );
                    id_p.set(  deepReflect1 , "1111") ;
                    Log.e("reflect","设置后的私有属性值:"+deepReflect1.getId());

                    //设置静态
                    Field c_p = clz.getDeclaredField( "c" ) ;
                    Log.e("reflect","获取静态属性值:"+c_p.get( c_p ));
                    c_p.set(  null , "c_c_c") ;
                    Log.e("reflect","设置后的静态属性值:"+DeepReflect.c);



                    // 通过方法设置 int是int.class 不能使用 Integer.class
                    Method setName = clz.getDeclaredMethod( "setName", String.class ) ;
                    setName.setAccessible( true );
                    setName.invoke( deepReflect1 , "deep" ) ;
                    Log.e("reflect","通过反射设置的属性值:"+deepReflect1.getName());
                    Method getName = clz.getDeclaredMethod( "getName" ) ;
                    String name = (String) getName.invoke( deepReflect1) ;
                    Log.e("reflect","通过反射获取的反射设置的属性值:"+deepReflect1.getName());
                    //调用静态方法
                    Method update = clz.getDeclaredMethod( "update") ;
                    update.invoke(null);



                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | NoSuchFieldException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

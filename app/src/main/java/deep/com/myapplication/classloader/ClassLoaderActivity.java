package deep.com.myapplication.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

import android.Manifest.permission;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import dalvik.system.DexClassLoader;
import dalvik.system.InMemoryDexClassLoader;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/5.
 */

public class ClassLoaderActivity extends Activity{
    @RequiresApi(api = VERSION_CODES.M)
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classloader);
        if (ContextCompat.checkSelfPermission(this,permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED
            ||ContextCompat.checkSelfPermission(this,permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{permission.READ_EXTERNAL_STORAGE,permission.WRITE_EXTERNAL_STORAGE},123);
        }
        ClassLoader loader = getClassLoader();
        while (loader != null) {
            Log.e("classloader","loader="+loader);
            loader = loader.getParent();
        }

        findViewById(R.id.loader_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ClassLoader loader = getClassLoader();

                Log.e("classloader",loader.toString());
                try {
                   Class<?> clz =  loader.loadClass("deep.com.myapplication.classloader.Dog");
                   Dog d = (Dog)clz.newInstance();
                   d.setName("123");
                    Log.e("classloader","getname="+d.getName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

            }
        });
        findViewById(R.id.loader_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DexClassLoader dexClassLoader = new DexClassLoader("/sdcard/bbb/classes.dex",ClassLoaderActivity.this.getCacheDir().getAbsolutePath(),null,getClassLoader());

                try {
                    Class<?> cla = dexClassLoader.loadClass("deep.com.loadertest.Constants");
                    Object o = cla.newInstance();
                    Field field = cla.getField("a");
                    Log.e("classloader","getA="+field.get(o).toString());

                } catch (ClassNotFoundException e) {
                    Log.e("classloader","e1="+e.getMessage());
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    Log.e("classloader","e2="+e.getMessage());
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    Log.e("classloader","e3="+e.getMessage());
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    Log.e("classloader","e4="+e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.loader_btn3).setOnClickListener(new OnClickListener() {
            @RequiresApi(api = VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                //DexClassLoader dexClassLoader = new DexClassLoader("/sdcard/bbb/classes.dex",ClassLoaderActivity.this.getCacheDir().getAbsolutePath(),null,getClassLoader());

                try {
                    InputStream is = ClassLoaderActivity.this.getAssets().open("classes.dex");
                    int size = is.available();
                    //ByteBuffer buff = ByteBuffer.allocate(size);
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    //buff.put(buffer, 0, size);

                    ByteBuffer buf = ByteBuffer.wrap(buffer);
                    InMemoryDexClassLoader inMemoryDexClassLoader = new InMemoryDexClassLoader(buf,getClassLoader());
                    Class<?> cla = inMemoryDexClassLoader.loadClass("deep.com.loadertest.Constants");
                    Object o = cla.newInstance();
                    Field field = cla.getField("a");
                    Log.e("classloader","getA="+field.get(o).toString());

                } catch (ClassNotFoundException e) {
                    Log.e("classloader","e1="+e.getMessage());
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    Log.e("classloader","e2="+e.getMessage());
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    Log.e("classloader","e3="+e.getMessage());
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    Log.e("classloader","e4="+e.getMessage());
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

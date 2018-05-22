package deep.com.myapplication.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/16.
 */

public class ProxyActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);
        findViewById(R.id.proxy_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("proxy","--------静态代理----------------");
                Log.e("proxy","未使用代理模式");
                Book book = new Book();
                book.read();
                Log.e("proxy","使用代理模式");
                TeacherBook teacherBook = new TeacherBook();
                teacherBook.read();
                Log.e("proxy","--------------------------------");
            }
        });
        findViewById(R.id.proxy_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("proxy","--------动态代理----------------");
                Log.e("proxy","未使用代理模式");
                Book book = new Book();
                book.read();
                Log.e("proxy","使用代理模式");
                Book bookObj = new Book();
                InvocationHandler h = new TeachBookHandler(bookObj);
                IReader iReader = (IReader)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                    new Class<?>[]{IReader.class}, h);
                iReader.read();
                Log.e("proxy","--------------------------------");
            }
        });
    }
}

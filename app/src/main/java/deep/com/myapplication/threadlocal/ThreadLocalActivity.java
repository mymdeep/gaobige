package deep.com.myapplication.threadlocal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/8/1.
 */

public class ThreadLocalActivity extends Activity {
    private LocalBean localBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        localBean = new LocalBean();
        localBean.set("main");
        Log.e("threadlocal"," main thread value"+localBean.getData());
        findViewById(R.id.local_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("threadlocal","before thread1 value"+localBean.getData());
                        localBean.set("thread1");
                        Log.e("threadlocal","after thread1 value"+localBean.getData());
                    }
                }).start();

            }
        });

        findViewById(R.id.local_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("threadlocal","before thread2 value"+localBean.getData());
                        localBean.set("thread2");
                        Log.e("threadlocal","after thread2 value"+localBean.getData());
                    }
                }).start();

            }
        });

    }
}

package deep.com.myapplication.handler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/20.
 */

public class HandlerActivity extends Activity{
    private TextView tv;

    private HandlerThread mHandlerThread;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 99){
                tv.setText("收到handler发送的消息");
            }

        }
    };
    TestThread thread1;
    private Handler mHandlerT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        tv = findViewById(R.id.handler_tv4);
        thread1 = new TestThread(tv);
        thread1.start();
        mHandlerThread = new HandlerThread("deep test");
        mHandlerThread.start();
        mHandlerT = new Handler( mHandlerThread.getLooper() ){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        tv.setText("HandlerThread 收到消息");
                    }
                });

            }
        };
        findViewById(R.id.handler_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              thread1.execute("测试，测试");
            }
        });
        findViewById(R.id.handler_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             thread1.exit();
            }
        });
        findViewById(R.id.handler_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                    mHandlerT.sendEmptyMessage(98);
            }
        });
    }
}

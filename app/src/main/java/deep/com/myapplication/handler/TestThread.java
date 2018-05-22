package deep.com.myapplication.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by wangfei on 2018/5/20.
 */

public class TestThread extends Thread {
    protected static final String TAG = "WorkerThread";
    private Handler mHandler;
    private Looper mLooper;
    private Handler mMainHandler;
    TextView textView;
    public TestThread(TextView tv) {
       mMainHandler = new Handler(Looper.getMainLooper());
       textView = tv;
    }

    public void run() {
        Looper.prepare();
        mLooper = Looper.myLooper();
        Log.e("handler","Looper");
        mHandler = new Handler(mLooper) {
            @Override
            public void handleMessage(Message msg) {

                final String message = "收到的内容是："+msg+"(通过Thread中的handler传入)";
                Log.e("handler","message="+message);
                Message newMsg = Message.obtain();
                newMsg.obj = message;
                mMainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(message);
                    }
                });
            }
        };
        Looper.loop();
    }

    public void exit() {
        if (mLooper != null) {
            mLooper.quit();
            mLooper = null;
        }
    }

    // This method returns immediately, it just push an Message into Thread's MessageQueue.
    // You can also call this method continuously, the task will be executed one by one in the
    // order of which they are pushed into MessageQueue(they are called).
    public void executeTask(String text) {
        Log.e("handler","text="+text);
        Message msg = Message.obtain();
        msg.obj = text;
        mHandler.sendMessage(msg);
    }
}
package deep.com.myapplication.queues;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/4/6.
 */

public class QueueActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queue);
        findViewById(R.id.queue_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
                new Thread(new PutRnnable(queue)).start();
                new Thread(new PutRnnable(queue)).start();
                new Thread(new TakeRnnable(queue)).start();
                new Thread(new TakeRnnable(queue)).start();
            }
        });
        findViewById(R.id.queue_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(1);
                new Thread(new PutRnnable(queue)).start();
                new Thread(new PutRnnable(queue)).start();
                new Thread(new TakeRnnable(queue)).start();
                new Thread(new TakeRnnable(queue)).start();
            }
        });
    }
    class PutRnnable implements Runnable {
        private BlockingQueue<String> q;

        public PutRnnable(BlockingQueue<String> q) {
            this.q = q;
        }

        @Override
        public void run() {
            Random r = new Random();
            try {
                String re = "item num:" + r.nextInt();
                q.put(re);
                Log.e("deep", "放入：" + re);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    class TakeRnnable implements Runnable {
        private BlockingQueue<String> q;

        public TakeRnnable(BlockingQueue<String> q) {
            this.q = q;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(3000);
                String r = q.take();
                Log.e("deep", "取出：" + r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

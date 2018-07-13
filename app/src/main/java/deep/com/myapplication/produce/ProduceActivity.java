package deep.com.myapplication.produce;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/9.
 */

public class ProduceActivity extends Activity{
    Resource resource = new Resource();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce);

        findViewById(R.id.produce_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ProduceThread produceThread = new ProduceThread(resource);
                ConsumeThread consumeThread1 = new ConsumeThread(resource);
                ConsumeThread consumeThread2 = new ConsumeThread(resource);
                ConsumeThread consumeThread3 = new ConsumeThread(resource);
                produceThread.start();
                consumeThread1.start();
                consumeThread2.start();
                consumeThread3.start();
            }
        });
    }
}

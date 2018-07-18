package deep.com.myapplication.ioc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/7/16.
 */

public class IOCActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ioc);
        final PushManager manager = new PushManager(new Ipush() {
            @Override
            public void init() {
                //友盟推送的初始化代码
            }

            @Override
            public void push() {
                //友盟推送的推送调用
            }
        });
        manager.init();
        findViewById(R.id.ioc_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.push();
            }
        });

    }
}

package deep.com.myapplication.services;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/6/6.
 */

public class ServiceActivity extends Activity{
    BindService bindService;
    private ServiceConnection s = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
             bindService = ((BindService.MyBinder)service).getService();
            Log.e(Constants.TAG,"onServiceConnected :"+name);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(Constants.TAG,"onServiceDisconnected :"+name);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.service_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this,StartService.class);
                startService(intent);
            }
        });
        findViewById(R.id.service_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this,StartService.class);
                stopService(intent);
            }
        });
        findViewById(R.id.service_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this,BindService.class);
                bindService(intent, s,BIND_AUTO_CREATE);

            }
        });
        findViewById(R.id.service_btn4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               unbindService(s);

            }
        });
    }
}

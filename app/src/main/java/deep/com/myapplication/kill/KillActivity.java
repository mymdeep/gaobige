package deep.com.myapplication.kill;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.HomeActivity;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/19.
 */

public class KillActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (savedInstanceState!=null){
            Log.e("kill",savedInstanceState.getInt("key")+"");
        }
        setContentView(R.layout.activity_kill);
        findViewById(R.id.kill_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        findViewById(R.id.kill_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        findViewById(R.id.kill_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
                manager.killBackgroundProcesses(getPackageName());
            }
        });
        findViewById(R.id.kill_btn4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(KillActivity.this, HomeActivity.class);
                intent.putExtra("exit",true);
                Log.e("kill"," start"+intent.getBooleanExtra("exit",false)+"");

                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("kill","onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key",123);
        Log.e("kill","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("kill","onDestroy");

    }
}

package deep.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.callable.CallableActivity;
import deep.com.myapplication.generic.GenericActivity;
import deep.com.myapplication.lists.LActivity;
import deep.com.myapplication.queues.QueueActivity;
import deep.com.myapplication.timer.TimerActivity;

/**
 * Created by wangfei on 2018/3/31.
 */

public class HomeActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.home_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, CallableActivity.class));
            }
        });
        findViewById(R.id.home_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, GenericActivity.class));
            }
        });
        findViewById(R.id.home_btn3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LActivity.class));
            }
        });
        findViewById(R.id.home_btn4).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, QueueActivity.class));
            }
        });
        findViewById(R.id.home_btn5).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, TimerActivity.class));
            }
        });
    }
}

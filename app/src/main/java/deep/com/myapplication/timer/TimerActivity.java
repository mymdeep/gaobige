package deep.com.myapplication.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/3/31.
 */

public class TimerActivity extends Activity{
    private final long delay = 1 *  1000;
    private final long period = 1 *  1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        findViewById(R.id.time_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
                        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
                        String timestamp = formatter.format(curDate);

                        Log.e("Timer","timer time:"+timestamp);
                    }
                }, delay, period);
            }
        });
        findViewById(R.id.time_btn2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
                service.scheduleAtFixedRate(
                    new Runnable() {
                        @Override
                        public void run() {
                            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
                            Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
                            String timestamp = formatter.format(curDate);

                            Log.e("Timer","Scheduled time:"+timestamp);
                        }
                    }, 1,
                    1, TimeUnit.SECONDS);

            }
        });
        findViewById(R.id.time_btn3).setOnClickListener(new OnClickListener() {
            @RequiresApi(api = VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
              scheduleJob();
            }
        });
        findViewById(R.id.time_btn4).setOnClickListener(new OnClickListener() {
            @RequiresApi(api = VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                JobScheduler js = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                js.cancelAll();
            }
        });

    }

    public void scheduleJob() {

        JobInfo.Builder builder = new JobInfo.Builder(0,
            new ComponentName(this, DeepJobService.class));
        //设置需要的网络条件，默认为JobInfo.NETWORK_TYPE_NONE即无网络时执行
        //NETWORK_TYPE_NONE
        //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        //builder.setPersisted(true); //重启后是否还要继续执行
        builder.setRequiresCharging(true); //是否在充电时执行
        //builder.setRequiresDeviceIdle(false); //是否在空闲时执行
        //builder.setPeriodic(3); //设置时间间隔，单位毫秒 JobScheduler works with a minimum periodic of 15 mins
        //setPeriodic不能和setMinimumLatency、setOverrideDeadline这两个同时调用
        //否则会报错“java.lang.IllegalArgumentException: Can't call setMinimumLatency() on a periodic job”
        //“java.lang.IllegalArgumentException: Can't call setOverrideDeadline() on a periodic job”
        builder.setMinimumLatency(5000); //设置至少延迟多久后执行，单位毫秒
        builder.setOverrideDeadline(30000); //设置最多延迟多久后执行，单位毫秒
        JobInfo ji = builder.build();
        JobScheduler js = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if (js!=null){
            js.schedule(ji);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String timestamp = formatter.format(curDate);

        Log.e("timer","begin:"+timestamp);
    }
}

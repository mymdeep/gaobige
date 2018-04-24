package deep.com.myapplication.timer;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by wangfei on 2018/4/23.
 */

public class DeepJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String timestamp = formatter.format(curDate);
        Log.e("timer","onStartJob:"+timestamp);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss ");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String timestamp = formatter.format(curDate);
        Toast.makeText(this, "onStopJob:"+timestamp, Toast.LENGTH_LONG).show();
        Log.e("timer","onStopJob:"+timestamp);
        return false;
    }
}

package deep.com.myapplication.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by wangfei on 2018/6/6.
 */

public class StartService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(Constants.TAG, "StartService onBind");
        return null;
    }
    @Override
    public void onCreate() {
        Log.e(Constants.TAG, "StartService onCreate");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //执行文件的下载或者播放等操作
        Log.e(Constants.TAG, "StartService onStartCommand");
        for (int i = 0;i<10000000;i++){
            if (i%1000 == 0){
                Log.e(Constants.TAG,"i="+i) ;
            }

        }
        /*
         * 这里返回状态有三个值，分别是:
         * 1、START_STICKY：当服务进程在运行时被杀死，系统将会把它置为started状态，但是不保存其传递的Intent对象，之后，系统会尝试重新创建服务;
         * 2、START_NOT_STICKY：当服务进程在运行时被杀死，并且没有新的Intent对象传递过来的话，系统将会把它置为started状态，
         *   但是系统不会重新创建服务，直到startService(Intent intent)方法再次被调用;
         * 3、START_REDELIVER_INTENT：当服务进程在运行时被杀死，它将会在隔一段时间后自动创建，并且最后一个传递的Intent对象将会再次传递过来。
         */
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e(Constants.TAG, "StartService onDestroy");
        super.onDestroy();
    }
}

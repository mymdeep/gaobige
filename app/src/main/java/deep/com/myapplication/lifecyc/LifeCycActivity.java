package deep.com.myapplication.lifecyc;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import deep.com.myapplication.R;

/**
 * Created by wangfei on 2018/5/19.
 */

public class LifeCycActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life);
        findViewById(R.id.life_btn1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplication().registerActivityLifecycleCallbacks(new ActivityCallBack1());
                getApplication().registerActivityLifecycleCallbacks(new ActivityCallBack2());
                getApplication().registerComponentCallbacks(new ComponentCb());

            }
        });
    }
    private class ActivityCallBack1 implements ActivityLifecycleCallbacks{

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.e("life","ActivityCallBack1 create activity name:"+activity.getLocalClassName());
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.e("life","ActivityCallBack1 start activity name:"+activity.getLocalClassName());

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.e("life","ActivityCallBack1 resume activity name:"+activity.getLocalClassName());

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }
    private class ActivityCallBack2 implements ActivityLifecycleCallbacks{

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.e("life","ActivityCallBack2 create activity name:"+activity.getLocalClassName());
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.e("life","ActivityCallBack2 start activity name:"+activity.getLocalClassName());

        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.e("life","ActivityCallBack2 resume activity name:"+activity.getLocalClassName());

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {

        }
    }
    private class ComponentCb implements ComponentCallbacks{

        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            Log.e("life","onConfigurationChanged");
        }

        @Override
        public void onLowMemory() {
            Log.e("life","onLowMemory");
        }
    }

}

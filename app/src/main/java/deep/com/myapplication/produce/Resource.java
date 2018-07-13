package deep.com.myapplication.produce;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.util.Log;

/**
 * Created by wangfei on 2018/6/9.
 */

public class Resource {
    private BlockingQueue resourceQueue = new LinkedBlockingQueue(100);
    public void add(Object o){
        try {
            resourceQueue.put(o);
            Log.e("produce","增加一份资源   资源池中有："+resourceQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void remove(){
        try {
            resourceQueue.take();
            Log.e("produce","减少一份资源   资源池中有："+resourceQueue.size());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package deep.com.myapplication.proxy;

import android.util.Log;

/**
 * Created by wangfei on 2018/5/16.
 */

public class Book implements IReader{
    @Override
    public void read() {
        Log.e("proxy","正在读书");
    }
}

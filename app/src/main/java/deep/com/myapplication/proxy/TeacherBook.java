package deep.com.myapplication.proxy;

import android.util.Log;

/**
 * Created by wangfei on 2018/5/16.
 */

public class TeacherBook implements IReader{
    Book book = new Book();
    @Override
    public void read() {
        Log.e("proxy","读书之前，先预习");
        book.read();
        Log.e("proxy","读书之后，要温习");
    }
}

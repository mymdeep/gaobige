package deep.com.myapplication.single;

/**
 * Created by wangfei on 2018/7/18.
 */

public class InnerSingle {
    private static class SingletonHolder {
        private static final InnerSingle INSTANCE = new InnerSingle();
    }
    private InnerSingle (){}
    public static final InnerSingle getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

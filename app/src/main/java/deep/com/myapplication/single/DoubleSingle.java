package deep.com.myapplication.single;

/**
 * Created by wangfei on 2018/7/18.
 */

public class DoubleSingle {
    private volatile static DoubleSingle singleton;
    private DoubleSingle (){}
    public static DoubleSingle getSingleton() {
        if (singleton == null) {
            synchronized (DoubleSingle.class) {
                if (singleton == null) {
                    singleton = new DoubleSingle();
                }
            }
        }
        return singleton;
    }
}

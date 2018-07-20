package deep.com.myapplication.single;

/**
 * Created by wangfei on 2018/7/18.
 */

public class LazySingle {
    private static LazySingle instance;
    private LazySingle(){}

    public static synchronized LazySingle getInstance() {
        if (instance == null) {
            instance = new LazySingle();
        }
        return instance;
    }
}

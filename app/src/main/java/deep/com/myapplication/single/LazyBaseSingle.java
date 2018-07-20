package deep.com.myapplication.single;

/**
 * Created by wangfei on 2018/7/18.
 */

public class LazyBaseSingle {
    private static LazyBaseSingle instance;
    private LazyBaseSingle(){}

    public static LazyBaseSingle getInstance() {
        if (instance == null) {
            instance = new LazyBaseSingle();
        }
        return instance;
    }
}

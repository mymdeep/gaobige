package deep.com.myapplication.single;

/**
 * Created by wangfei on 2018/7/18.
 */

public class HungrySingle {
    private static HungrySingle instance = new HungrySingle();
    private HungrySingle (){}
    public static HungrySingle getInstance() {
        return instance;
    }
}

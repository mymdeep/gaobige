package deep.com.myapplication.ioc;

/**
 * Created by wangfei on 2018/7/16.
 */

public class PushManager {
    Ipush push;
    public PushManager(Ipush push){
        this.push = push;
    }
    public  void init(){
        push.init();
    }
    public  void push(){
        push.push();
    }
}

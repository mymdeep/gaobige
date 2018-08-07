package deep.com.myapplication.threadlocal;

/**
 * Created by wangfei on 2018/8/1.
 */

public class LocalBean {
    private static ThreadLocal<String> s = new ThreadLocal<>();
    public void set(String a){

        s.set(a);
    }
    public String getData(){
        return s.get();
    }
}

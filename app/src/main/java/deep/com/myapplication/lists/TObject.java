package deep.com.myapplication.lists;

/**
 * Created by wangfei on 2018/6/7.
 */

public class TObject {
    private int code;
    public TObject(int code){
        this.code = code;
    }
    @Override
    public int hashCode() {
        return code;
    }
}

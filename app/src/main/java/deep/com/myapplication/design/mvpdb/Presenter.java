package deep.com.myapplication.design.mvpdb;

import android.util.Log;


/**
 * Created by wangfei on 2018/5/18.
 */

public class Presenter {
    private IView iView;

    public Presenter( IView iView) {
        this.iView = iView;

    }
    public void save(Result r){
        Log.e("design","save Result:"+r.getR());
        iView.update();
    }
    public void download(){
        Log.e("design","download Result");
       Result r = new Result();
        r.setR("aaaa");
        save(r);
    }
}

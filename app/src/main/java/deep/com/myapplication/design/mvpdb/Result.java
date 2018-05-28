package deep.com.myapplication.design.mvpdb;

import android.databinding.BaseObservable;

/**
 * Created by wangfei on 2018/5/21.
 */

public class Result extends BaseObservable {
    String r;

    public void setR(String r) {
        this.r = r;
        notifyChange();
    }

    public String getR() {
        return r;
    }


}
